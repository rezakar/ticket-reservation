package com.example.easynotes.service;

import com.example.easynotes.model.Release;

public interface IReleaseService {

	void addRelease(Release release);

	void addApplication(Integer appId, Integer releaseId);

}
