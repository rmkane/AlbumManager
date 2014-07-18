package com.rmkane.am.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rmkane.am.data.dto.AlbumDto;
import com.rmkane.am.data.dto.ArtistDto;

/**
 * Handles requests for the Album service.
 */
@Controller
public class AlbumController {
	private static final Logger LOG = LoggerFactory.getLogger(AlbumController.class);

	// Map to store Albums, ideally we should use database
	Map<Long, AlbumDto> albumCache = new HashMap<Long, AlbumDto>();

	@RequestMapping(value = AlbumRestURIConstants.DUMMY_ALBUM, method = RequestMethod.GET)
	public @ResponseBody
	AlbumDto getDummyAlbum() {
		LOG.info("Start getDummyAlbum");
		ArtistDto artist = new ArtistDto();
		artist.setId(777);
		artist.setName("Queen");
		
		AlbumDto album = new AlbumDto();
		album.setId(9999);
		album.setTitle("A Night at the Opera");
		album.setArtist(artist);
		album.setReleaseYear(1975);
		
		albumCache.put(9999L, album);
		return album;
	}

	@RequestMapping(value = AlbumRestURIConstants.GET_ALBUM, method = RequestMethod.GET)
	public @ResponseBody
	AlbumDto getAlbum(@PathVariable("id") long albumId) {
		LOG.info("Start getAlbum. ID=" + albumId);

		return albumCache.get(albumId);
	}

	@RequestMapping(value = AlbumRestURIConstants.GET_ALL_ALBUMS, method = RequestMethod.GET)
	public @ResponseBody
	List<AlbumDto> getAllAlbums() {
		LOG.info("Start getAllAlbums.");
		List<AlbumDto> albums = new ArrayList<AlbumDto>();
		Set<Long> albumIdKeys = albumCache.keySet();
		
		for (Long i : albumIdKeys) {
			albums.add(albumCache.get(i));
		}
		
		return albums;
	}

	@RequestMapping(value = AlbumRestURIConstants.CREATE_ALBUM, method = RequestMethod.POST)
	public @ResponseBody
	AlbumDto createAlbum(@RequestBody AlbumDto album) {
		LOG.info("Start createAlbum.");
		albumCache.put(album.getId(), album);
		return album;
	}

	@RequestMapping(value = AlbumRestURIConstants.DELETE_ALBUM, method = RequestMethod.PUT)
	public @ResponseBody
	AlbumDto deleteAlbum(@PathVariable("id") long albumId) {
		LOG.info("Start deleteAlbum.");
		AlbumDto album = albumCache.get(albumId);
		albumCache.remove(albumId);
		return album;
	}
}