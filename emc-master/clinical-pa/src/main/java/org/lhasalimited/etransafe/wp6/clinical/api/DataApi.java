/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.lhasalimited.etransafe.wp6.clinical.api.model.DataClassKey;
import org.lhasalimited.etransafe.wp6.clinical.api.model.DataClassProperty;
import org.lhasalimited.etransafe.wp6.clinical.api.model.query.Query;
import org.lhasalimited.etransafe.wp6.clinical.api.model.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 *
 * @author Tima Camara
 * @since 19 Aug 2019
 */
@Validated
@Api(value = "DataApi")
public interface DataApi
{

	default Optional<NativeWebRequest> getRequest()
	{
		return Optional.empty();
	}

	@ApiOperation(value = "Returns the number of records corresponding to the supplied data class.", nickname = "count", notes = "Returns the number of records corresponding to the supplied data class.", response = Integer.class, authorizations = {
			@Authorization(value = "bearerAuth")
	}, tags = { "Data", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns the count of a Data class", response = Integer.class),
			@ApiResponse(code = 400, message = "Data Class key is missing or invalid", response = String.class),
			@ApiResponse(code = 401, message = "Access token is missing or invalid", response = String.class) })
	@RequestMapping(value = "/count", produces = { "application/json", "text/plain" }, method = RequestMethod.GET)
	ResponseEntity<Integer> count(
			@NotNull @ApiParam(value = "The data class parameter", required = true, allowableValues = "COMPOUND, STUDY, FINDING") @Valid DataClassKey dataClassKey);

	@ApiOperation(value = "Returns the records of the requested data class.", nickname = "data", notes = "Returns the records of the requested data class.", response = Object.class, authorizations = {
			@Authorization(value = "bearerAuth")
	}, tags = { "Data", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Query result.", response = Object.class),
			@ApiResponse(code = 401, message = "Access token is missing or invalid", response = String.class) })
	@RequestMapping(value = "/data", produces = { "application/json", "text/plain" }, method = RequestMethod.GET)
	ResponseEntity<Object> data(
			@NotNull @ApiParam(value = "The data class parameter", required = true, allowableValues = "COMPOUND, STUDY, FINDING") @Valid DataClassKey dataClassKey,
			@ApiParam(value = "The number of records to skip before starting to collect the result set. Default to 0.") @Valid @RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset,
			@ApiParam(value = "The numbers of records to return. Default to 100.") @Valid @RequestParam(value = "limit", defaultValue = "100", required = false) Integer limit);

	@ApiOperation(value = "Returns a list of terms that have not yet been matched with a preferred term. This will be used by the WP9 Semantic service.", nickname = "getUnknownTerms", notes = "Returns a list of terms that have not yet been matched with a preferred term. This will be used by the WP9 Semantic service.", response = String.class, responseContainer = "List", authorizations = {
			@Authorization(value = "bearerAuth")
	}, tags = { "Data", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of unknown synonyms.", response = String.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Access token is missing or invalid", response = String.class) })
	@RequestMapping(value = "/unknownTerms", produces = { "application/json", "text/plain" }, method = RequestMethod.GET)
	ResponseEntity<List<String>> getUnknownTerms();

	@ApiOperation(value = "Returns the properties of the requested data class.", nickname = "metadata", notes = "Returns the properties of the requested data class.", response = DataClassProperty.class, responseContainer = "List", authorizations = {
			@Authorization(value = "bearerAuth")
	}, tags = { "Data", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The properties of the requested data class.", response = DataClassProperty.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Access token is missing or invalid", response = String.class) })
	@RequestMapping(value = "/metadata", produces = { "application/json", "text/plain" }, method = RequestMethod.GET)
	ResponseEntity<List<DataClassProperty>> metadata(
			@NotNull @ApiParam(value = "The data class parameter", required = true, allowableValues = "COMPOUND, STUDY, FINDING") @Valid DataClassKey dataClassKey);

	@ApiOperation(value = "Query endpoint to access the Clinical data.", nickname = "query", notes = "", response = Result.class, authorizations = {
			@Authorization(value = "bearerAuth")
	}, tags = { "Data", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Query result.", response = Result.class),
			@ApiResponse(code = 401, message = "Access token is missing or invalid", response = String.class) })
	@RequestMapping(value = "/query", produces = { "application/json", "text/plain" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Result> query(@ApiParam(value = "Query endpoint to access the Clinical data.", required = true) @Valid @RequestBody Query query);

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