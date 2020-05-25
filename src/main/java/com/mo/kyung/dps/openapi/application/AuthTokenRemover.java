package com.mo.kyung.dps.openapi.application;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import io.swagger.v3.core.filter.AbstractSpecFilter;
import io.swagger.v3.core.model.ApiDescription;
import io.swagger.v3.oas.models.Operation;

public class AuthTokenRemover extends AbstractSpecFilter {
	public static final String AUTHORIZATION_HEADER = "Authorization";
	@Override
	public Optional<Operation> filterOperation(
		Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies,
		Map<String, List<String>> headers) {
		System.out.println("allo");
		operation.getParameters().stream().forEach(p -> System.out.println(p.getName()));
		return Optional.empty();
	}
}
