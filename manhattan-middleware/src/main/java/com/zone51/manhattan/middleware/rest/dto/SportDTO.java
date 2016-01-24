package com.zone51.manhattan.middleware.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.zone51.manhattan.core.domain.Sport;

public class SportDTO {

	private Long id;
	private String name;

	public SportDTO(Sport sport) {
		super();
		id = sport.getId();
		name = sport.getSportname();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* util */
	public static List<SportDTO> sportsToDTO(List<Sport> sportList) {
		List<SportDTO> dtos = new ArrayList<SportDTO>();

		if (sportList != null && !sportList.isEmpty()) {
			for (Sport sport : sportList) {
				dtos.add(sportToDTO(sport));
			}
		}

		return dtos;
	}

	public static SportDTO sportToDTO(Sport sport) {
		SportDTO dto = null;

		if (sport != null) {
			dto = new SportDTO(sport);
		}

		return dto;
	}
}
