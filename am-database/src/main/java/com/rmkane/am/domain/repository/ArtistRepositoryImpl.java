package com.rmkane.am.domain.repository;

import org.springframework.transaction.annotation.Transactional;

import com.rmkane.am.domain.entity.Artist;

@Transactional
public class ArtistRepositoryImpl extends BaseRepositoryImpl<Artist>
		implements ArtistRepositoryCustom {
}