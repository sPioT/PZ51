package com.zone51.manhattan.middleware.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.zone51.manhattan.core.domain.Request;
import com.zone51.manhattan.core.service.crud.IRequestService;
import com.zone51.manhattan.middleware.rest.dto.RequestDTO;

@Component
@Path("/request")
public class RequestCtrl {

	@Autowired
	private IRequestService requestService;

	@GET
	@Path("/all/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@PathParam("userId") Long userId) {
		List<Request> requestList = requestService.findAllByUser(userId);

		return Response.status(200).entity(RequestDTO.requestsToDTO(requestList)).build();
	}

	@GET
	@Path("/{requestId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRequest(@PathParam("requestId") Long requestId) {
		Request request = requestService.findOne(requestId);

		return Response.status(200).entity(RequestDTO.requestToDTO(request, true)).build();
	}

	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRequest(@RequestBody RequestDTO dto) {
		Request request = RequestDTO.dtoToRequest(dto);
		request = requestService.save(request);

		return Response.status(200).entity(RequestDTO.requestToDTO(request, true)).build();
	}
}
