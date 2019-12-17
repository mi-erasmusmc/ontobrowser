/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.lhasalimited.etransafe.wp6.clinical.api.model.DataClassKey;
import org.lhasalimited.etransafe.wp6.clinical.api.model.DataClassProperty;
import org.lhasalimited.etransafe.wp6.clinical.api.model.query.Query;
import org.lhasalimited.etransafe.wp6.clinical.api.model.result.Result;
import org.lhasalimited.etransafe.wp6.clinical.dto.Compound;
import org.lhasalimited.etransafe.wp6.clinical.dto.Finding;
import org.lhasalimited.etransafe.wp6.clinical.dto.Study;
import org.lhasalimited.etransafe.wp6.clinical.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

/**
 *
 * @author Tima Camara
 * @since 19 Aug 2019
 */
@Controller
@RequestMapping("${openapi.ClinicalPrimitiveAdapterService.base-path:/clinicaltrials-pa/v1}")
public class DataApiController implements DataApi
{

	private final HttpServletRequest request;

	private final ObjectMapper objectMapper;

	static final String QUERY_ENDPOINT = "/clinicaltrials-pa/v1/query";

	@Autowired
	public DataService dataService;

	@Autowired
	public DataApiController(final ObjectMapper objectMapper, final HttpServletRequest request)
	{
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<Integer> count(
			@NotNull @ApiParam(value = "The data class parameter", required = true, allowableValues = "COMPOUND, STUDY, FINDING") @Valid final DataClassKey dataClassKey)
	{

		int totalRows = 0;
		switch (dataClassKey)
		{
			case COMPOUND:
				totalRows = dataService.countCompounds();
				break;
			case STUDY:
				totalRows = dataService.countStudies();
				break;
			case FINDING:
				totalRows = dataService.countFindings();
				break;
		}

		return new ResponseEntity<>(totalRows, HttpStatus.valueOf(200));
	}

	@Override
	public ResponseEntity<List<String>> getUnknownTerms()
	{
		return new ResponseEntity<>(HttpStatus.valueOf(501));

	}

	@Override
	public ResponseEntity<Result> query(Query searchParameters)
	{

		return new ResponseEntity<>(null, HttpStatus.valueOf(404));

	}

	@Override
	public ResponseEntity<Object> data(@NotNull @Valid DataClassKey dataClassKey, @Valid Integer offset, @Valid Integer limit)
	{
		switch (dataClassKey)
		{
			case COMPOUND:
				List<Compound> compounds = dataService.getCompounds(offset, limit);
				return new ResponseEntity<>(compounds, HttpStatus.valueOf(200));
			case STUDY:
				List<Study> studies = dataService.getStudies(offset, limit);
				return new ResponseEntity<>(studies, HttpStatus.valueOf(200));
			case FINDING:
				List<Finding> findings = dataService.getFindings(offset, limit);
				return new ResponseEntity<>(findings, HttpStatus.valueOf(200));
			default:
				return new ResponseEntity<>(null, HttpStatus.valueOf(404));
		}
	}

	@Override
	public ResponseEntity<List<DataClassProperty>> metadata(@NotNull @Valid DataClassKey dataClassKey)
	{
		// TODO Auto-generated method stub
		return null;
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