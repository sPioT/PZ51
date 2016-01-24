package com.zone51.manhattan.middleware.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("")
public class App {

	@GET
	@Path("")
	public Response index() {
		String welcome = "Welcome to manhattan Middleware REST";
		return Response.status(200).entity(welcome).build();
	}
}
