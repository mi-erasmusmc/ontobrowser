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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class DataClassResult implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("dataClassKey")
	private DataClassKey dataClassKey;

	@JsonProperty("total")
	private Integer total;

	@JsonProperty("fields")
	@Valid
	private List<String> fields = null;

	@JsonProperty("data")
	@Valid
	private List<List<String>> data = null;

	public DataClassResult dataClassKey(DataClassKey dataClassKey)
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

	public DataClassResult total(Integer total)
	{
		this.total = total;
		return this;
	}

	/**
	 * Get total
	 * 
	 * @return total
	 */
	@ApiModelProperty(value = "")

	public Integer getTotal()
	{
		return total;
	}

	public void setTotal(Integer total)
	{
		this.total = total;
	}

	public DataClassResult fields(List<String> fields)
	{
		this.fields = fields;
		return this;
	}

	public DataClassResult addFieldsItem(String fieldsItem)
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

	public DataClassResult data(List<List<String>> data)
	{
		this.data = data;
		return this;
	}

	public DataClassResult addDataItem(List<String> dataItem)
	{
		if (this.data == null)
		{
			this.data = new ArrayList<>();
		}
		this.data.add(dataItem);
		return this;
	}

	/**
	 * Get data
	 * 
	 * @return data
	 */
	@ApiModelProperty(value = "")

	@Valid

	public List<List<String>> getData()
	{
		return data;
	}

	public void setData(List<List<String>> data)
	{
		this.data = data;
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
		DataClassResult dataClassResult = (DataClassResult) o;
		return Objects.equals(this.dataClassKey, dataClassResult.dataClassKey) &&
				Objects.equals(this.total, dataClassResult.total) &&
				Objects.equals(this.fields, dataClassResult.fields) &&
				Objects.equals(this.data, dataClassResult.data);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(dataClassKey, total, fields, data);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class DataClassResult {\n");

		sb.append("    dataClassKey: ").append(toIndentedString(dataClassKey)).append("\n");
		sb.append("    total: ").append(toIndentedString(total)).append("\n");
		sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");
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