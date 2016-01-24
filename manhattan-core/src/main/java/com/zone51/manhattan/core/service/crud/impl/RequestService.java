package com.zone51.manhattan.core.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zone51.manhattan.core.domain.Request;
import com.zone51.manhattan.core.repository.IRequestRepository;
import com.zone51.manhattan.core.service.crud.IRequestService;

@Service
public class RequestService implements IRequestService {

	@Autowired
	private IRequestRepository requestRepository;

	@Override
	public List<Request> findAll() {
		return requestRepository.findAll();
	}

	@Override
	public Request findOne(Long id) {
		return requestRepository.findOne(id);
	}

	@Override
	public List<Request> findAllByUser(Long userId) {
		return requestRepository.findAllByUser(userId);
	}

	@Override
	public Request save(Request request) {

		return requestRepository.saveAndFlush(request);

	}

}
