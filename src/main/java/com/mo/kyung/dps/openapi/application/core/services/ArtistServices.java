package com.mo.kyung.dps.openapi.application.core.services;

import java.util.List;
import java.util.stream.Collectors;
import com.mo.kyung.dps.openapi.application.core.dao.ArtistDao;
import com.mo.kyung.dps.openapi.application.data.ArtistDetailValue;
import com.mo.kyung.dps.openapi.application.data.ArtistInfoValue;

public class ArtistServices {
	private ArtistServices() {/* hidden implicit constructor */}
	public static final ArtistServices INSTANCE = new ArtistServices();
	private static final ArtistDao DAO = ArtistDao.INSTANCE;
	public List<ArtistInfoValue> getAll() {
		return DAO.getAll().stream().map(artist -> new ArtistInfoValue(artist)).collect(Collectors.toList());
	}
	public ArtistDetailValue get(String id) {
		return new ArtistDetailValue(DAO.get(id));
	}
	public ArtistInfoValue getInfo(String id) {
		return new ArtistInfoValue(DAO.get(id));
	}
}
