package com.mo.kyung.dps.openapi.application.core.dao;

import java.util.List;
import com.mo.kyung.dps.openapi.application.FakeData;
import com.mo.kyung.dps.openapi.application.core.data.Artist;

public class ArtistDao implements Dao<Artist> {
	private ArtistDao() {/* hidden implicit constructor */}
	public static final ArtistDao INSTANCE = new ArtistDao();

	@Override
	public List<Artist> getAll() {
		return FakeData.getArtists();
	}

	public Artist get(String id) {
		return FakeData.getArtists().stream().filter(artist -> id.equals(artist.getId())).findAny()
			.orElseThrow(() -> new RuntimeException());
	}
}
