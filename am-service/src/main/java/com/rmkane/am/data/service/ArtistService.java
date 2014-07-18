package com.rmkane.am.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmkane.am.data.dto.ArtistDto;
import com.rmkane.am.data.mapper.ArtistDtoMapper;
import com.rmkane.am.data.mapper.ArtistMapper;
import com.rmkane.am.domain.entity.Artist;
import com.rmkane.am.domain.repository.ArtistRepository;

@Service
public class ArtistService implements ArtistLocal {
	@Autowired
	private ArtistRepository repo;
	@Autowired
	private ArtistMapper mapper;
	@Autowired
	private ArtistDtoMapper dtoMapper;
	
	public ArtistDto getArtist(long id) {
		return dtoMapper.map(repo.findOne(id));
	}

	public List<ArtistDto> retrieveArtists() {
		return dtoMapper.map(repo.findAll());
	}

	public ArtistDto saveArtist(ArtistDto artist) {
		Artist entity = mapper.map(artist);
		entity = repo.save(entity);
		return dtoMapper.map(entity);
	}
}
