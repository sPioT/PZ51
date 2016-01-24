package com.zone51.manhattan.core.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zone51.manhattan.core.domain.Sport;
import com.zone51.manhattan.core.repository.ISportRepository;
import com.zone51.manhattan.core.service.crud.ISportService;

@Service
public class SportService implements ISportService {

	@Autowired
	private ISportRepository sportRepository;

	@Override
	public List<Sport> findAll() {
		return sportRepository.findAll();
	}

	@Override
	public Sport findOne(Long id) {
		return sportRepository.findOne(id);
	}

}
