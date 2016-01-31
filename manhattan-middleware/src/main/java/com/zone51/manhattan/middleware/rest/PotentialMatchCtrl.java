package com.zone51.manhattan.middleware.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zone51.manhattan.core.domain.PotentialMatch;
import com.zone51.manhattan.core.service.crud.IPotentialMatchService;
import com.zone51.manhattan.middleware.rest.dto.PotentialMatchDTO;

@RestController
@RequestMapping("/potentialMatch")
public class PotentialMatchCtrl {

	@Autowired
	private IPotentialMatchService potentialMatchService;

	@RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void saveRequest(@RequestBody PotentialMatchDTO dto, HttpServletResponse response) {
		PotentialMatch potential = potentialMatchService.findOne(dto.getId());

		if (potential == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

		if (potential.getRequest1().getId().equals(dto.getRequest().getId())) {
			potential.setReponse1(dto.getYourResponse());
		} else if (potential.getRequest2().getId().equals(dto.getRequest().getId())) {
			potential.setReponse2(dto.getYourResponse());
		}

		try {
			potentialMatchService.save(potential);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
