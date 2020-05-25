package com.mo.kyung.dps.openapi.application.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.mo.kyung.dps.openapi.application.core.services.ArtistServices;
import com.mo.kyung.dps.openapi.application.data.ArtistInfoValue;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("artists")
@Tag(
	name = "Artists")
public class ArtistsResource {
	private ArtistServices services = ArtistServices.INSTANCE;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(
		summary = "Find all artists",
		description = "Returns all artists",
		parameters = {},
		responses = {
			@ApiResponse(
				description = "The artists",
				content = @Content(
					array = @ArraySchema(
						schema = @Schema(
							implementation = ArtistInfoValue.class))))
		})
		@SecurityRequirement(
			name = "authorization")
		public Response getArtists(
			@HeaderParam(
				value = "Authorization") String auth) {
			if (!(auth == null || auth.isEmpty())) {
				List<
					ArtistInfoValue> artists
				= services.getAll();
			return Response.ok(artists).build();
		}
		return Response.status(403).build();
	}

	@Path("{id}")
	public ArtistResource getArtistResource(@PathParam("id") String id) {
		return new ArtistResource(id);
	}
}
