package com.zone51.manhattan.middleware.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.zone51.manhattan.core.domain.PotentialMatch;

public class PotentialMatchDTO {

	private Long id;
	private int distance;
	private Boolean reponse1;
	private Boolean reponse2;
	private RequestDTO request1;
	private RequestDTO request2;

	public PotentialMatchDTO(PotentialMatch match) {
		super();
		id = match.getId();
		distance = match.getDistance();
		reponse1 = match.getReponse1();
		reponse2 = match.getReponse2();
		request1 = RequestDTO.requestToDTO(match.getRequest1(), false);
		request2 = RequestDTO.requestToDTO(match.getRequest2(), false);
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
	 *            the id to set
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

	/**
	 * @return the reponse1
	 */
	public Boolean getReponse1() {
		return reponse1;
	}

	/**
	 * @param reponse1
	 *            the reponse1 to set
	 */
	public void setReponse1(Boolean reponse1) {
		this.reponse1 = reponse1;
	}

	/**
	 * @return the reponse2
	 */
	public Boolean getReponse2() {
		return reponse2;
	}

	/**
	 * @param reponse2
	 *            the reponse2 to set
	 */
	public void setReponse2(Boolean reponse2) {
		this.reponse2 = reponse2;
	}

	/**
	 * @return the request1
	 */
	public RequestDTO getRequest1() {
		return request1;
	}

	/**
	 * @param request1
	 *            the request1 to set
	 */
	public void setRequest1(RequestDTO request1) {
		this.request1 = request1;
	}

	/**
	 * @return the request2
	 */
	public RequestDTO getRequest2() {
		return request2;
	}

	/**
	 * @param request2
	 *            the request2 to set
	 */
	public void setRequest2(RequestDTO request2) {
		this.request2 = request2;
	}

	/* util */
	public static List<PotentialMatchDTO> PotentialMatchesToDTO(List<PotentialMatch> matchList) {
		List<PotentialMatchDTO> dtos = new ArrayList<PotentialMatchDTO>();

		if (matchList != null && !matchList.isEmpty()) {
			for (PotentialMatch match : matchList) {
				dtos.add(PotentialMatchToDTO(match));
			}
		}

		return dtos;
	}

	public static PotentialMatchDTO PotentialMatchToDTO(PotentialMatch match) {
		PotentialMatchDTO dto = null;

		if (match != null) {
			dto = new PotentialMatchDTO(match);
		}

		return dto;
	}

}
