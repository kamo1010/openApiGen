package com.mo.kyung.dps.openapi.application.core.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Artist {
	private String id;
	private String name;
	private boolean group;
	private Calendar debutDate;
	private List<Song> songs = new ArrayList<>();

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean isGroup() {
		return group;
	}
	public Calendar getDebutDate() {
		return debutDate;
	}
	public List<Song> getSongs() {
		return songs;
	}

	public static ArtistBuilder instanciate(String id) {
		return new ArtistBuilder(id);
	}

	public static class ArtistBuilder {
		private ArtistBuilder() {}
		private ArtistBuilder(String id) {
			model.id = id;
		}
		private Artist model = new Artist();

		public Artist build() {
			Artist result = new Artist();
			result.id = model.id;
			result.name = model.name;
			result.group = model.group;
			result.debutDate = model.debutDate;
			result.songs = model.songs;
			model = new Artist();
			return result;
		}
		public ArtistBuilder name(String name) {
			model.name = name;
			return this;
		}
	}
}
