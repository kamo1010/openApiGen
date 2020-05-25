package com.mo.kyung.dps.openapi.application.core.dao;

import java.util.List;

public interface Dao<T> {
	abstract List<T> getAll();
}
