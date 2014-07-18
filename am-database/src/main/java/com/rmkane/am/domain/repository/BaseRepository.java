package com.rmkane.am.domain.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.rmkane.am.domain.entity.BaseEntity;

public interface BaseRepository<T extends BaseEntity> extends
		CrudRepository<T, Long>, Serializable {
}
