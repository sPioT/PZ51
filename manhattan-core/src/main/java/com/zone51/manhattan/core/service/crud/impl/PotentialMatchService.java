package com.zone51.manhattan.core.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zone51.manhattan.core.domain.PotentialMatch;
import com.zone51.manhattan.core.repository.IPotentialMatchRepository;
import com.zone51.manhattan.core.service.crud.IPotentialMatchService;

@Service
public class PotentialMatchService implements IPotentialMatchService {

	@Autowired
	private IPotentialMatchRepository potentialMatchRepository;

	@Override
	public PotentialMatch findOne(Long id) {
		return potentialMatchRepository.findOne(id);
	}

	@Override
	public void save(PotentialMatch potential) {
		potentialMatchRepository.saveAndFlush(potential);
	}

}
