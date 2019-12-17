/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api.exception;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.ForbiddenException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Tima Camara
 * @since 19 Aug 2019
 */
@ControllerAdvice
public class ControllerExceptionHandler
{
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<ErrorDetail> handleMissingArgumentConstraintViolation(final ConstraintViolationException ex)
	{
		final List<String> errors = new ArrayList<>();
		for (final ConstraintViolation<?> violation : ex.getConstraintViolations())
		{
			errors.add(violation.getRootBeanClass().getSimpleName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
		}

		final ErrorDetail errorDetail = new ErrorDetail(HttpStatus.BAD_REQUEST, "Constraint violation", errors);
		return new ResponseEntity<>(errorDetail, new HttpHeaders(), errorDetail.getStatus());
	}

	@ExceptionHandler({ ForbiddenException.class })
	public ResponseEntity<ErrorDetail> handleForbiddenException(ForbiddenException ex)
	{
		ErrorDetail errorDetail = new ErrorDetail(HttpStatus.FORBIDDEN, ex.getLocalizedMessage(), new ArrayList<>());
		return new ResponseEntity<>(
				errorDetail, new HttpHeaders(), errorDetail.getStatus());
	}

	// Implemented as per: https://stackoverflow.com/a/42674808/5074540
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorDetail> handleAccessDeniedException(HttpMessageNotReadableException ex) throws Exception
	{
		Throwable cause = ex.getCause();
		if (cause != null)
		{
			Throwable nestedCause = cause.getCause();
			if (AccessDeniedException.class.isAssignableFrom(nestedCause.getClass()))
			{
				ErrorDetail errorDetail = new ErrorDetail(HttpStatus.NOT_FOUND, "Unable to find the ressource", new ArrayList<>());
				return new ResponseEntity<>(
						errorDetail, new HttpHeaders(), errorDetail.getStatus());
			}
		}
		throw ex;
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