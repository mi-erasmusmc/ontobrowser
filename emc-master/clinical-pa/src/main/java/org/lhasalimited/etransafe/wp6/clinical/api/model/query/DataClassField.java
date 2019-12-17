/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api.model.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class DataClassField implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("dataClassKey")
	private DataClassKey dataClassKey;

	@JsonProperty("fields")
	@Valid
	private List<String> fields = null;

	public DataClassField dataClassKey(DataClassKey dataClassKey)
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

	public DataClassField fields(List<String> fields)
	{
		this.fields = fields;
		return this;
	}

	public DataClassField addFieldsItem(String fieldsItem)
	{
		if (this.fields == null)
		{
			this.fields = new ArrayList<>();
		}
		this.fields.add(fieldsItem);
		return this;
	}

	/**
	 * Get fields
	 * 
	 * @return fields
	 */
	@ApiModelProperty(value = "")

	public List<String> getFields()
	{
		return fields;
	}

	public void setFields(List<String> fields)
	{
		this.fields = fields;
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
		DataClassField dataClassField = (DataClassField) o;
		return Objects.equals(this.dataClassKey, dataClassField.dataClassKey) &&
				Objects.equals(this.fields, dataClassField.fields);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(dataClassKey, fields);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class DataClassField {\n");

		sb.append("    dataClassKey: ").append(toIndentedString(dataClassKey)).append("\n");
		sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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