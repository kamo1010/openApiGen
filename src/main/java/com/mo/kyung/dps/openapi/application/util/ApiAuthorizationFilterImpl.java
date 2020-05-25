package com.mo.kyung.dps.openapi.application.util;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.core.filter.AbstractSpecFilter;
import io.swagger.v3.core.model.ApiDescription;
import io.swagger.v3.oas.models.Operation;

public class ApiAuthorizationFilterImpl extends AbstractSpecFilter {
	static Logger logger = LoggerFactory.getLogger(ApiAuthorizationFilterImpl.class);

	public boolean checkKey(Map<String, List<String>> params, Map<String, List<String>> headers) {
		String keyValue = null;
		if (params.containsKey("api_key"))
			keyValue = params.get("api_key").get(0);
		else {
			if (headers.containsKey("api_key"))
				keyValue = headers.get("api_key").get(0);
		}
		if ("special-key".equals(keyValue))
			return true;
		else
			return false;
	}

	@Override
	public Optional<Operation> filterOperation(
		Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies,
		Map<String, List<String>> headers) {
		if (!api.getMethod().equals("get") || api.getPath().startsWith("/store"))
			return checkKey(params, headers) ? Optional.of(operation) : Optional.empty();
		return Optional.empty();
	}

	@Override
	public boolean isRemovingUnreferencedDefinitions() {
		return true;
	}
}
