/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author Tima Camara
 * @since 19 Aug 2019
 */
@Validated
@Api(value = "KhrMetadataApi")
public interface KhrMetadataApi
{

	@ApiOperation(value = "Returns YAML specification of this Clinical Primitive Adapter API.", nickname = "api",
			notes = "Returns YAML specification of this Clinical Primitive Adapter API.", response = Object.class, tags = { "KHR metadata", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "YAML specification of the eTOXSys PA API", response = Object.class),
			@ApiResponse(code = 404, message = "Resource not_found", response = String.class) })
	@RequestMapping(value = "/api", produces = { "text/yaml", "text/plain" }, method = RequestMethod.GET)
	ResponseEntity<Object> api();

	@ApiOperation(value = "Performs a health check of the service", nickname = "alive", notes = "Reports the health status (leaviness) of the service.", response = String.class, tags = {
			"KHR metadata", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Service passes the internal tests and works", response = String.class),
			@ApiResponse(code = 503, message = "Service is not operational", response = String.class) })
	@RequestMapping(value = "/alive", produces = { "text/plain" }, method = RequestMethod.GET)
	ResponseEntity<String> alive();

	@ApiOperation(value = "Returns the online status of the service", nickname = "ready", notes = "Reports the online status (readiness) of the service.", response = String.class, tags = {
			"KHR metadata", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Service is up and operational", response = String.class),
			@ApiResponse(code = 503, message = "Service is not operational", response = String.class) })
	@RequestMapping(value = "/ready", produces = { "text/plain" }, method = RequestMethod.GET)
	ResponseEntity<String> ready();

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