package com.rmkane.am.domain.repository;

import java.util.List;

import com.rmkane.am.domain.entity.Album;

public interface AlbumRepositoryCustom {
	List<Album> retrieveAllAlbums();
	Album saveStandalone(Album album);
}
