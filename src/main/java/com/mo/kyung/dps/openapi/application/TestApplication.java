package com.mo.kyung.dps.openapi.application;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletConfig;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import com.mo.kyung.dps.openapi.application.resources.ArtistsResource;
import io.swagger.v3.core.filter.SpecFilter;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;

public class TestApplication extends Application {

	public TestApplication(
		@Context ServletConfig servletConfig) {
		super();
		OpenAPI oas = new OpenAPI();
		Info info = new Info()
			.title("Swagger Sample App bootstrap code")
			.version(
				"0.0.1.-alpha")
			.description(
				"This is a sample server Petstore server.")
			.termsOfService("http://swagger.io/terms/")
			.contact(new Contact()
				.email("apiteam@swagger.io"))
			.license(new License()
				.name("Apache 2.0")
				.url("http://www.apache.org/licenses/LICENSE-2.0.html"));
		Server server = prepareServer();
		SecurityScheme authorization = new SecurityScheme().name("Authorization").type(Type.APIKEY).in(In.HEADER);
		oas.info(info).schemaRequirement("authorization", authorization).servers(Arrays.asList(server));
		SwaggerConfiguration oasConfig = new SwaggerConfiguration()
			.openAPI(new SpecFilter().filter(oas, new AuthTokenRemover(), null, null,
				null))
			.prettyPrint(true)
			.resourcePackages(Stream.of("io.swagger.sample.resource").collect(Collectors.toSet()));

		try {
			new JaxrsOpenApiContextBuilder<>()
				.servletConfig(servletConfig)
				.application(this)
				.openApiConfiguration(oasConfig)
				.buildContext(true);
		} catch (OpenApiConfigurationException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private Server prepareServer() {
		ServerVariables serverVariables = new ServerVariables();
		serverVariables.addServerVariable("host",
			new ServerVariable()._default("localhost").description("IP address or name of the server"));
		serverVariables.addServerVariable("port",
			new ServerVariable()._default("8080").description("port on the server where the api is deployed"));
		serverVariables.addServerVariable("basePath", new ServerVariable()._default(
			"openapi3Gen/api")
			.description("base path where the API is hosted in ther server"));
		return new Server().url("http://{host}:{port}/{basePath}").variables(serverVariables);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return Stream.of(
			ArtistsResource.class,
			OpenApiResource.class)
			.collect(Collectors.toSet());
	}
}
