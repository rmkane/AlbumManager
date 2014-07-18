package com.rmkane.am.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import com.rmkane.am.domain.entity.BaseEntity;

public abstract class BaseRepositoryImpl <T extends BaseEntity> {
	protected EntityManager em;
	
	@PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
	
	protected EntityManager getEntityManager() {
		return em;
	}
	
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
}