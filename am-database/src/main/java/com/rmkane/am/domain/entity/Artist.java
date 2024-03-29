package com.rmkane.am.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name="artist_id")
	private long id;
	
	@Column(name="artist_name")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}