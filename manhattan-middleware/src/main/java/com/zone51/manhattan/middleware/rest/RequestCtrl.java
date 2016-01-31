package com.zone51.manhattan.middleware.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zone51.manhattan.core.domain.Request;
import com.zone51.manhattan.core.service.crud.IRequestService;
import com.zone51.manhattan.middleware.rest.dto.RequestDTO;

@RestController
@RequestMapping("/request")
public class RequestCtrl {

	@Autowired
	private IRequestService requestService;

	@RequestMapping(method = RequestMethod.GET, value = "/all/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RequestDTO> getAll(@PathVariable Long userId) {
		List<Request> requestList = requestService.findAllByUser(userId);

		return RequestDTO.requestsToDTO(requestList);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{requestId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RequestDTO getRequest(@PathVariable Long requestId) {
		Request request = requestService.findOne(requestId);

		return RequestDTO.requestToDTO(request, true);
	}

	@RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RequestDTO saveRequest(@RequestBody RequestDTO dto) {
		Request request = RequestDTO.dtoToRequest(dto);
		request = requestService.save(request);

		return RequestDTO.requestToDTO(request, true);
	}
}
