package com.zone51.manhattan.middleware.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.zone51.manhattan.core.domain.PotentialMatch;
import com.zone51.manhattan.core.service.crud.IPotentialMatchService;
import com.zone51.manhattan.middleware.rest.dto.PotentialMatchDTO;

@Component
@Path("/potentialMatch")
public class PotentialMatchCtrl {

	@Autowired
	private IPotentialMatchService potentialMatchService;

	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRequest(@RequestBody PotentialMatchDTO dto) {
		PotentialMatch potential = potentialMatchService.findOne(dto.getId());

		if (potential.getRequest1().getId().equals(dto.getRequest().getId())) {
			potential.setReponse1(dto.getYourResponse());
		} else if (potential.getRequest2().getId().equals(dto.getRequest().getId())) {
			potential.setReponse2(dto.getYourResponse());
		}

		potentialMatchService.save(potential);

		return Response.status(200).build();
	}

}
