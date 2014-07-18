package com.rmkane.am.domain.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	public abstract long getId();
}
