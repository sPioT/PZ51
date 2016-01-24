package com.zone51.manhattan.front.servlet.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

public class ResourceHandler extends ResourceHttpRequestHandler {

	@Value("${root.file.path}")
	private String filePath;

	@Override
	protected Resource getResource(HttpServletRequest request) {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		return new FileSystemResource(filePath + "/" + path);
	}

}
