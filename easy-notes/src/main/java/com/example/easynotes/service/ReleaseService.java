package com.example.easynotes.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.easynotes.model.Release;
import com.example.easynotes.repository.IReleaseDAO;

@Service
@Transactional
public class ReleaseService implements IReleaseService{
	@Autowired
	private IReleaseDAO releaseDAO;
	@Override
	public void addRelease(Release release) {
		releaseDAO.addRelease(release);
	}
	@Override
	public void addApplication(Integer appId, Integer releaseId) {
		releaseDAO.addApplication(appId, releaseId);
	}
}
