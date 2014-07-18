package com.rmkane.am.data.service;

import java.util.List;

import com.rmkane.am.data.dto.AlbumDto;

public interface AlbumLocal {
	List<AlbumDto> retrieveAll();
	AlbumDto getAlbum(long id);
	AlbumDto save(AlbumDto standalone);
}
