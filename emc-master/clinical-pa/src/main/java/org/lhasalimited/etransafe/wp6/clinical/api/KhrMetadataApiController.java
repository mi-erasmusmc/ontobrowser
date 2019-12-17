/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Tima Camara
 * @since 19 Aug 2019
 */
@Controller
@RequestMapping("${openapi.ClinicalPrimitiveAdapterService.base-path:/clinicaltirals-pa/v1}")
public class KhrMetadataApiController implements KhrMetadataApi
{

	private final HttpServletRequest request;

	private final ObjectMapper objectMapper;

	private static final Logger log = LoggerFactory.getLogger(KhrMetadataApiController.class);

	@Autowired
	public KhrMetadataApiController(ObjectMapper objectMapper, HttpServletRequest request)
	{
		this.objectMapper = objectMapper;
		this.request = request;
	}

	static final String FILENAME = "/etoxsys-pa.yaml";

	@Override
	public ResponseEntity<Object> api()
	{
		try
		{
			URL yamlUrl = getClass().getResource(FILENAME);
			if (yamlUrl != null)
			{
				byte[] yamlContent = IOUtils.toByteArray(yamlUrl);
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.parseMediaType("text/yaml"));
				return new ResponseEntity<>(yamlContent, headers, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public ResponseEntity<String> alive()
	{
		return new ResponseEntity<>(HttpStatus.valueOf(200));

	}

	@Override
	public ResponseEntity<String> ready()
	{
		return new ResponseEntity<>(HttpStatus.valueOf(200));

	}
}
/* ---------------------------------------------------------------------*
 * This software is the confidential and proprietary
 * information of Lhasa Limited
 * Granary Wharf House, 2 Canal Wharf, Leeds, LS11 5PS
 * ---
 * No part of this confidential information shall be disclosed
 * and it shall be used only in accordance with the terms of a
 * written license agreement entered into by holder of the information
 * with LHASA Ltd.
 * --------------------------------------------------------------------- */