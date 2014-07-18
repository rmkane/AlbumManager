package com.rmkane.am.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmkane.am.data.dto.AlbumDto;
import com.rmkane.am.data.mapper.AlbumDtoMapper;
import com.rmkane.am.data.mapper.AlbumMapper;
import com.rmkane.am.domain.entity.Album;
import com.rmkane.am.domain.repository.AlbumRepository;

@Service
public class AlbumService implements AlbumLocal {
	@Autowired
	private AlbumRepository repo;
	@Autowired
	private AlbumMapper mapper;
	@Autowired
	private AlbumDtoMapper dtoMapper;
	
	public List<AlbumDto> retrieveAll() {
		return dtoMapper.map(repo.retrieveAllAlbums());
	}

	public AlbumDto getAlbum(long id) {
		return dtoMapper.map(repo.findOne(id));
	}
	
	public AlbumDto save(AlbumDto standalone) {
		Album entity = mapper.map(standalone);
		entity = repo.saveStandalone(entity);
		return dtoMapper.map(entity);
	}
}
