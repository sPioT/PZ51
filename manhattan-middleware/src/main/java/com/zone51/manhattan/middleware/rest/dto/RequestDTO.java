package com.zone51.manhattan.middleware.rest.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zone51.manhattan.core.domain.Request;
import com.zone51.manhattan.core.domain.User;

public class RequestDTO {

	private Long id;
	private Long sportId;
	private int skill;
	private Date date;
	private short dateRange;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private int maxDistance;
	private int maxSkillGap;
	private List<PotentialMatchDTO> potentialMatches;
	private UserDTO user;

	public RequestDTO(Request request, boolean deep) {
		super();

		id = request.getId();
		sportId = request.getSportId();
		skill = request.getSkill();
		date = request.getDate();
		dateRange = request.getDateRange();
		latitude = request.getLatitude();
		longitude = request.getLongitude();
		maxDistance = request.getMaxDistance();
		maxSkillGap = request.getMaxSkillGap();
		if (deep) {
			potentialMatches = PotentialMatchDTO.PotentialMatchesToDTO(request.getPotentialMatches());
		}
		user = UserDTO.userToDTO(request.getUser());
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
	 * @return the sportId
	 */
	public Long getSportId() {
		return sportId;
	}

	/**
	 * @param sportId
	 *            the sportId to set
	 */
	public void setSportId(Long sportId) {
		this.sportId = sportId;
	}

	/**
	 * @return the skill
	 */
	public int getSkill() {
		return skill;
	}

	/**
	 * @param skill
	 *            the skill to set
	 */
	public void setSkill(int skill) {
		this.skill = skill;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the dateRange
	 */
	public short getDateRange() {
		return dateRange;
	}

	/**
	 * @param dateRange
	 *            the dateRange to set
	 */
	public void setDateRange(short dateRange) {
		this.dateRange = dateRange;
	}

	/**
	 * @return the latitude
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the maxDistance
	 */
	public int getMaxDistance() {
		return maxDistance;
	}

	/**
	 * @param maxDistance
	 *            the maxDistance to set
	 */
	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

	/**
	 * @return the maxSkillGap
	 */
	public int getMaxSkillGap() {
		return maxSkillGap;
	}

	/**
	 * @param maxSkillGap
	 *            the maxSkillGap to set
	 */
	public void setMaxSkillGap(int maxSkillGap) {
		this.maxSkillGap = maxSkillGap;
	}

	/**
	 * @return the potentialMatches
	 */
	public List<PotentialMatchDTO> getPotentialMatches() {
		return potentialMatches;
	}

	/**
	 * @param potentialMatches
	 *            the potentialMatches to set
	 */
	public void setPotentialMatches(List<PotentialMatchDTO> potentialMatches) {
		this.potentialMatches = potentialMatches;
	}

	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}

	/* util */
	public static List<RequestDTO> requestsToDTO(List<Request> requestList) {
		List<RequestDTO> dtos = new ArrayList<RequestDTO>();

		if (requestList != null && !requestList.isEmpty()) {
			for (Request request : requestList) {
				dtos.add(requestToDTO(request, true));
			}
		}

		return dtos;
	}

	public static RequestDTO requestToDTO(Request request, boolean deep) {
		RequestDTO dto = null;

		if (request != null) {
			dto = new RequestDTO(request, deep);
		}

		return dto;
	}

	public static Request dtoToRequest(RequestDTO dto) {
		Request request = new Request();

		request.setId(dto.getId());
		request.setSportId(dto.getSportId());
		request.setSkill(dto.getSkill());
		request.setDate(dto.getDate());
		request.setDateRange(dto.getDateRange());
		request.setLatitude(dto.getLatitude());
		request.setLongitude(dto.getLongitude());
		request.setMaxDistance(dto.getMaxDistance());
		request.setMaxSkillGap(dto.getMaxSkillGap());
		request.setUser(new User(dto.getUser().getId()));

		return request;
	}

}
