package com.zone51.manhattan.core.service.crud;

import com.zone51.manhattan.core.domain.PotentialMatch;

public interface IPotentialMatchService {

	PotentialMatch findOne(Long id);

	void save(PotentialMatch potential);

}
