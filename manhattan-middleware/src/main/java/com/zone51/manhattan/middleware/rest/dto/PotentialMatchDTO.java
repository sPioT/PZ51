package com.zone51.manhattan.middleware.rest.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;

import com.zone51.manhattan.core.domain.PotentialMatch;
import com.zone51.manhattan.core.domain.Request;

public class PotentialMatchDTO {

	private Long id;
	private int distance;
	private Boolean yourResponse;
	private Boolean opponentResponse;
	private RequestDTO request;

	public PotentialMatchDTO(PotentialMatch match) {
		super();
		id = match.getId();
		distance = match.getDistance();
	}

	public PotentialMatchDTO(PotentialMatch match, Request request) {
		super();

		id = match.getId();
		distance = match.getDistance();
		if (request.equals(match.getRequest1())) {
			this.request = RequestDTO.requestToDTO(match.getRequest2(), false);
			yourResponse = match.getReponse1();
			opponentResponse = match.getReponse2();
		} else {
			this.request = RequestDTO.requestToDTO(match.getRequest1(), false);
			yourResponse = match.getReponse2();
			opponentResponse = match.getReponse1();
		}
	}

	public PotentialMatchDTO() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            reponse1 = match.getReponse1(); reponse2 =
	 *            match.getReponse2(); the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Boolean getYourResponse() {
		return yourResponse;
	}

	public void setYourResponse(Boolean yourResponse) {
		this.yourResponse = yourResponse;
	}

	public Boolean getOpponentResponse() {
		return opponentResponse;
	}

	public void setOpponentResponse(Boolean opponentResponse) {
		this.opponentResponse = opponentResponse;
	}

	/**
	 * @return the request
	 */
	public RequestDTO getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(RequestDTO request) {
		this.request = request;
	}

	/* util */
	public static List<PotentialMatchDTO> PotentialMatchesToDTO(List<PotentialMatch> matchList, Request request) {
		List<PotentialMatchDTO> dtos = new ArrayList<PotentialMatchDTO>();

		if (matchList != null && !matchList.isEmpty()) {
			for (PotentialMatch match : matchList) {
				if (BooleanUtils.isNotFalse(match.getReponse1()) && BooleanUtils.isNotFalse(match.getReponse2())) {
					dtos.add(PotentialMatchToDTO(match, request));
				}
			}
		}

		return dtos;
	}

	public static PotentialMatchDTO PotentialMatchToDTO(PotentialMatch match, Request request) {
		PotentialMatchDTO dto = null;

		if (match != null) {
			if (BooleanUtils.isFalse(match.getReponse1()) || BooleanUtils.isFalse(match.getReponse2())) {
				return null;
			}
			dto = new PotentialMatchDTO(match, request);
		}

		return dto;
	}

}
