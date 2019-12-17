/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api.model.query;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.Valid;

import org.lhasalimited.etransafe.wp6.clinical.api.model.DataClassKey;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class Link implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("field")
	private String field;

	@JsonProperty("dataClassKey")
	private DataClassKey dataClassKey;

	@JsonProperty("dataClassKeyField")
	private String dataClassKeyField;

	public Link field(String field)
	{
		this.field = field;
		return this;
	}

	/**
	 * Get field
	 * 
	 * @return field
	 */
	@ApiModelProperty(value = "")

	public String getField()
	{
		return field;
	}

	public void setField(String field)
	{
		this.field = field;
	}

	public Link dataClassKey(DataClassKey dataClassKey)
	{
		this.dataClassKey = dataClassKey;
		return this;
	}

	/**
	 * Get dataClassKey
	 * 
	 * @return dataClassKey
	 */
	@ApiModelProperty(value = "")

	@Valid

	public DataClassKey getDataClassKey()
	{
		return dataClassKey;
	}

	public void setDataClassKey(DataClassKey dataClassKey)
	{
		this.dataClassKey = dataClassKey;
	}

	public Link dataClassKeyField(String dataClassKeyField)
	{
		this.dataClassKeyField = dataClassKeyField;
		return this;
	}

	/**
	 * Get dataClassKeyField
	 * 
	 * @return dataClassKeyField
	 */
	@ApiModelProperty(value = "")

	public String getDataClassKeyField()
	{
		return dataClassKeyField;
	}

	public void setDataClassKeyField(String dataClassKeyField)
	{
		this.dataClassKeyField = dataClassKeyField;
	}

	@Override
	public boolean equals(java.lang.Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Link link = (Link) o;
		return Objects.equals(this.field, link.field) &&
				Objects.equals(this.dataClassKey, link.dataClassKey) &&
				Objects.equals(this.dataClassKeyField, link.dataClassKeyField);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(field, dataClassKey, dataClassKeyField);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class Link {\n");

		sb.append("    field: ").append(toIndentedString(field)).append("\n");
		sb.append("    dataClassKey: ").append(toIndentedString(dataClassKey)).append("\n");
		sb.append("    dataClassKeyField: ").append(toIndentedString(dataClassKeyField)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o)
	{
		if (o == null)
		{
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
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