package org.lhasalimited.etransafe.wp6.clinical.api.exception;

/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class ErrorDetail
{

	private HttpStatus status;
	private String message;
	private List<String> errors;

	ErrorDetail()
	{
	}

	public ErrorDetail(HttpStatus status, String message, List<String> errors)
	{
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public HttpStatus getStatus()
	{
		return status;
	}

	public String getMessage()
	{
		return message;
	}

	public List<String> getErrors()
	{
		return errors;
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