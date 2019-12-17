/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api.model.query;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public enum ComparisonOperator
{

	EQUALS("EQUALS"),

	NOT_EQUAL_("NOT_EQUAL,"),

	IN("IN"),

	NOT("NOT"),

	NOT_IN("NOT_IN"),

	LESS_THAN("LESS_THAN"),

	LESS_THAN_OR_EQUAL("LESS_THAN_OR_EQUAL"),

	GREATER_THAN("GREATER_THAN"),

	GREATER_THAN_OR_EQUAL("GREATER_THAN_OR_EQUAL"),

	CONTAINS("CONTAINS"),

	LIKE("LIKE"),

	IS_NULL("IS_NULL"),

	NOT_NULL("NOT_NULL");

	private String value;

	ComparisonOperator(String value)
	{
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString()
	{
		return String.valueOf(value);
	}

	@JsonCreator
	public static ComparisonOperator fromValue(String value)
	{
		for (ComparisonOperator b : ComparisonOperator.values())
		{
			if (b.value.equals(value))
			{
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
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