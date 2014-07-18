package com.rmkane.am.data.service;

import java.util.List;

import com.rmkane.am.data.dto.ArtistDto;

public interface ArtistLocal {
	ArtistDto getArtist(long id);
	List<ArtistDto> retrieveArtists();
	ArtistDto saveArtist(ArtistDto artist);
}
