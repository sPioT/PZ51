package com.zone51.manhattan.middleware.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zone51.manhattan.core.domain.Sport;
import com.zone51.manhattan.core.domain.UsersSport;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SportDTO {

	private Long id;
	private String name;
	private Integer skill;

	public SportDTO(Sport sport) {
		super();
		id = sport.getId();
		name = sport.getSportname();
	}

	public SportDTO(UsersSport sport) {
		super();
		id = sport.getSport().getId();
		skill = sport.getSkill();
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

	public Integer getSkill() {
		return skill;
	}

	public void setSkill(Integer skill) {
		this.skill = skill;
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

	public static List<SportDTO> usersportsToDTO(List<UsersSport> usersSports) {
		List<SportDTO> dtos = new ArrayList<SportDTO>();

		if (usersSports != null && !usersSports.isEmpty()) {
			for (UsersSport sport : usersSports) {
				dtos.add(usersportToDTO(sport));
			}
		}

		return dtos;
	}

	public static SportDTO usersportToDTO(UsersSport sport) {
		SportDTO dto = null;

		if (sport != null) {
			dto = new SportDTO(sport);
		}

		return dto;
	}
}
