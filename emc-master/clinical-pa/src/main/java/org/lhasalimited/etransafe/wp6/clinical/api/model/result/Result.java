/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api.model.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.lhasalimited.etransafe.wp6.clinical.api.model.DataClassKey;
import org.lhasalimited.etransafe.wp6.clinical.api.model.query.DataType;
import org.lhasalimited.etransafe.wp6.clinical.api.model.query.SearchFilter;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class Result implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("origin")
	private String origin;

	@JsonProperty("dataType")
	private DataType dataType;

	@JsonProperty("dataClassKey")
	private DataClassKey dataClassKey;

	@JsonProperty("querySearchFilter")
	private SearchFilter querySearchFilter = null;

	@JsonProperty("fields")
	@Valid
	private List<DataClassResult> fields = null;

	public Result origin(String origin)
	{
		this.origin = origin;
		return this;
	}

	/**
	 * Get origin
	 * 
	 * @return origin
	 */
	@ApiModelProperty(value = "")

	public String getOrigin()
	{
		return origin;
	}

	public void setOrigin(String origin)
	{
		this.origin = origin;
	}

	public Result dataType(DataType dataType)
	{
		this.dataType = dataType;
		return this;
	}

	/**
	 * Get dataType
	 * 
	 * @return dataType
	 */
	@ApiModelProperty(value = "")

	@Valid

	public DataType getDataType()
	{
		return dataType;
	}

	public void setDataType(DataType dataType)
	{
		this.dataType = dataType;
	}

	public Result dataClassKey(DataClassKey dataClassKey)
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

	public Result querySearchFilter(SearchFilter querySearchFilter)
	{
		this.querySearchFilter = querySearchFilter;
		return this;
	}

	/**
	 * Get querySearchFilter
	 * 
	 * @return querySearchFilter
	 */
	@ApiModelProperty(value = "")

	@Valid

	public SearchFilter getQuerySearchFilter()
	{
		return querySearchFilter;
	}

	public void setQuerySearchFilter(SearchFilter querySearchFilter)
	{
		this.querySearchFilter = querySearchFilter;
	}

	public Result fields(List<DataClassResult> fields)
	{
		this.fields = fields;
		return this;
	}

	public Result addFieldsItem(DataClassResult fieldsItem)
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

	@Valid

	public List<DataClassResult> getFields()
	{
		return fields;
	}

	public void setFields(List<DataClassResult> fields)
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
		Result result = (Result) o;
		return Objects.equals(this.origin, result.origin) &&
				Objects.equals(this.dataType, result.dataType) &&
				Objects.equals(this.dataClassKey, result.dataClassKey) &&
				Objects.equals(this.querySearchFilter, result.querySearchFilter) &&
				Objects.equals(this.fields, result.fields);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(origin, dataType, dataClassKey, querySearchFilter, fields);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class Result {\n");

		sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
		sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
		sb.append("    dataClassKey: ").append(toIndentedString(dataClassKey)).append("\n");
		sb.append("    querySearchFilter: ").append(toIndentedString(querySearchFilter)).append("\n");
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