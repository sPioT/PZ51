package com.zone51.manhattan.middleware.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zone51.manhattan.core.domain.Sport;
import com.zone51.manhattan.core.service.crud.ISportService;
import com.zone51.manhattan.middleware.rest.dto.SportDTO;

@Component
@Path("/sport")
public class SportCtrl {

	@Autowired
	private ISportService sportService;

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Sport> sportList = sportService.findAll();

		return Response.status(200).entity(SportDTO.sportsToDTO(sportList)).build();
	}

	@GET
	@Path("/{sportId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSport(@PathParam("sportId") Long sportId) {
		Sport sport = sportService.findOne(sportId);

		return Response.status(200).entity(SportDTO.sportToDTO(sport)).build();
	}
}
