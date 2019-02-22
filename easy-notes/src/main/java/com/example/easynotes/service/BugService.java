package com.example.easynotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.easynotes.exception.Bug;
import com.example.easynotes.repository.IBugDAO;

@Service
@Transactional
public class BugService implements IBugService{
	@Autowired
	private IBugDAO bugDAO;
	@Override
	public void addBug(Bug bug) {
		bugDAO.addBug(bug);
	}
}
