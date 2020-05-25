package com.mo.kyung.dps.openapi.application.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.mo.kyung.dps.openapi.application.core.data.Artist;
import com.mo.kyung.dps.openapi.application.core.data.Song;

public class ArtistDetailValue {
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

	public ArtistDetailValue(
		Artist artist) {
		this.id = artist.getId();
		this.name = artist.getName();
		this.group = artist.isGroup();
		this.debutDate = artist.getDebutDate();
		this.songs = artist.getSongs();
	}

}
