package com.example.easynotes.service;

import com.example.easynotes.model.Application;

public interface IApplicationService {

	boolean addApplication(Application application);

	Application getApplicationByID(int applicationId);

	void updateApplication(Application application);

	void deleteApplication(int applicationId);

}
