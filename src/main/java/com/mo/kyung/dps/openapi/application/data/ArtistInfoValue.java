package com.mo.kyung.dps.openapi.application.data;

import java.util.Calendar;
import com.mo.kyung.dps.openapi.application.core.data.Artist;

public class ArtistInfoValue {
	private String id;
	private String name;
	private boolean group;
	private Calendar debutDate;
	private int songNumber;

	public ArtistInfoValue(Artist artist) {
		this.id = "Info-" + artist.getId();
		this.name = artist.getName();
		this.group = artist.isGroup();
		this.debutDate = artist.getDebutDate();
		this.songNumber = artist.getSongs().size();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGroup() {
		return group;
	}
	public void setGroup(boolean group) {
		this.group = group;
	}
	public Calendar getDebutDate() {
		return debutDate;
	}
	public void setDebutDate(Calendar debutDate) {
		this.debutDate = debutDate;
	}
	public int getSongNumber() {
		return songNumber;
	}
	public void setSongs(int songNumber) {
		this.songNumber = songNumber;
	}
}
