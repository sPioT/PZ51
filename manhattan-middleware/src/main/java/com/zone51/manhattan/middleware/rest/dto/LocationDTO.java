package com.zone51.manhattan.middleware.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zone51.manhattan.core.domain.UsersLocation;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDTO {

	private Long id;
	private String name;
	private Double latitude;
	private Double longitude;
	private Boolean default_;

	public LocationDTO(UsersLocation location) {
		super();
		id = location.getId();
		name = location.getName();
		latitude = location.getLatitude();
		longitude = location.getLongitude();
		default_ = location.isDefault();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Boolean isDefault_() {
		return default_;
	}

	public void setDefault_(Boolean default_) {
		this.default_ = default_;
	}

	public static List<LocationDTO> locationsToDTO(List<UsersLocation> usersLocations) {
		List<LocationDTO> dtos = new ArrayList<LocationDTO>();

		if (usersLocations != null && !usersLocations.isEmpty()) {
			for (UsersLocation location : usersLocations) {
				dtos.add(locationToDTO(location));
			}
		}

		return dtos;
	}

	public static LocationDTO locationToDTO(UsersLocation location) {
		LocationDTO dto = null;

		if (location != null) {
			dto = new LocationDTO(location);
		}

		return dto;
	}

}
