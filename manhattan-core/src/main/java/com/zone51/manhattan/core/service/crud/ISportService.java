package com.zone51.manhattan.core.service.crud;

import java.util.List;

import com.zone51.manhattan.core.domain.Sport;

public interface ISportService {

	List<Sport> findAll();

	Sport findOne(Long id);

}
