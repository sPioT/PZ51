package com.zone51.manhattan.middleware.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zone51.manhattan.core.domain.Sport;
import com.zone51.manhattan.core.service.crud.ISportService;
import com.zone51.manhattan.middleware.rest.dto.SportDTO;

@RestController
@RequestMapping("/sport")
public class SportCtrl {

	@Autowired
	private ISportService sportService;

	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SportDTO> getAll(HttpServletResponse response) {
		List<Sport> sportList = sportService.findAll();

		if (sportList == null || sportList.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}

		return SportDTO.sportsToDTO(sportList);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{sportId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SportDTO getSport(@PathVariable Long sportId, HttpServletResponse response) {
		Sport sport = sportService.findOne(sportId);

		if (sport == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

		return SportDTO.sportToDTO(sport);
	}
}
