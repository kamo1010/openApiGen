package com.mo.kyung.dps.openapi.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.mo.kyung.dps.openapi.application.core.data.Artist;
import com.mo.kyung.dps.openapi.application.core.data.Song;

public class FakeData {
	private static final Set<Artist> ARTISTS = new HashSet<>(
		Arrays.asList(
			Artist.instanciate("000").build(),
			Artist.instanciate("001").build(),
			Artist.instanciate("010").build(),
			Artist.instanciate("011").build(),
			Artist.instanciate("100").build()));
	private static final Set<Song> SONGS = new HashSet<>();

	public static List<Artist> getArtists() {
		return Collections.unmodifiableList(new ArrayList<>(ARTISTS));
	}
	public static List<Song> getSongs() {
		return Collections.unmodifiableList(new ArrayList<>(SONGS));
	}
	public static boolean addArtist(Artist artist) {
		return ARTISTS.add(artist);
	}
	public static boolean addSong(Song song) {
		return SONGS.add(song);
	}
}
