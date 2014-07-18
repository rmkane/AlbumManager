package com.rmkane.am.domain.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rmkane.am.domain.entity.Album;

public class AlbumRepositoryImpl extends BaseRepositoryImpl<Album>
		implements AlbumRepositoryCustom {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Album> retrieveAllAlbums() {
		Query query = getSession().createQuery("from Album");
		List<Album> rs = query.list();
		return rs;
	}

	@Transactional(rollbackFor=Exception.class)
	public Album saveStandalone(Album album) {
		getSession().save(album);
		return album;
	}
}