package com.example.easynotes.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.easynotes.exception.Enhancement;

@Transactional
@Repository
public class EnhancementDAO implements IEnhancementDAO{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void addEnhancement(Enhancement enhancement) {
		entityManager.persist(enhancement);
	}
}
