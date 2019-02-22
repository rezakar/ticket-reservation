package com.example.easynotes.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.easynotes.exception.Bug;

@Transactional
@Repository
public class BugDAO implements IBugDAO {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void addBug(Bug bug) {
		entityManager.persist(bug);
	}
}
