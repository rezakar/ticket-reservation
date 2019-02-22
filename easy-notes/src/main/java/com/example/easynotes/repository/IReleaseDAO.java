package com.example.easynotes.repository;

import com.example.easynotes.model.Release;

public interface IReleaseDAO {

	void addRelease(Release release);

	void addApplication(Integer appId, Integer releaseId);

	Release getReleaseById(int releaseId);

}
