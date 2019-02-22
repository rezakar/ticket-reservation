package com.example.easynotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.easynotes.exception.Enhancement;
import com.example.easynotes.repository.IEnhancementDAO;

@Service
@Transactional
public class EnhancementService implements IEnhancementService {
	@Autowired
	private IEnhancementDAO enhancementDAO;
	@Override
	public void addEnhancement(Enhancement enhancement) {
		enhancementDAO.addEnhancement(enhancement);
	}
}
