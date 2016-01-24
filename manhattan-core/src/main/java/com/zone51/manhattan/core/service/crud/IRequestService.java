package com.zone51.manhattan.core.service.crud;

import java.util.List;

import com.zone51.manhattan.core.domain.Request;

public interface IRequestService {

	List<Request> findAll();

	List<Request> findAllByUser(Long userId);

	Request findOne(Long id);

	Request save(Request request);

}
