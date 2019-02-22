package com.example.easynotes.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Application;

@Transactional
@Repository
public class AplicationDAO implements IApplicationDAO{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void addApplication(Application application) {
		entityManager.persist(application);
	}
	@Override 
	public boolean applicationExists(String name, String owner) {
		String jpql = "from Application as a WHERE a.name = ?1 and a.owner = ?1";
		int count = entityManager.createQuery(jpql).setParameter(0, name).
				setParameter(1, owner).getResultList().size();
		return count > 0;
	}
	@Override
	public Application getApplicationById(int applicationId) {
		return entityManager.find(Application.class, applicationId);
	}
	@Override
	public void updateApplication(Application application) {
		Application app = getApplicationById(application.getId());
		app.setName(application.getName());
		app.setDescription(application.getDescription());
		app.setOwner(application.getOwner());
		entityManager.flush();
	}
	@Override
	public void deleteApplication(int applicationId) {
		entityManager.remove(applicationId);
	}
}
