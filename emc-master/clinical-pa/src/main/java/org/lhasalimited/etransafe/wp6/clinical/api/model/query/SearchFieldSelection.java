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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class SearchFieldSelection implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("dataClassFields")
	@Valid
	private List<DataClassField> dataClassFields = null;

	public SearchFieldSelection dataClassFields(List<DataClassField> dataClassFields)
	{
		this.dataClassFields = dataClassFields;
		return this;
	}

	public SearchFieldSelection addDataClassFieldsItem(DataClassField dataClassFieldsItem)
	{
		if (this.dataClassFields == null)
		{
			this.dataClassFields = new ArrayList<>();
		}
		this.dataClassFields.add(dataClassFieldsItem);
		return this;
	}

	/**
	 * Get dataClassFields
	 * 
	 * @return dataClassFields
	 */
	@ApiModelProperty(value = "")

	@Valid

	public List<DataClassField> getDataClassFields()
	{
		return dataClassFields;
	}

	public void setDataClassFields(List<DataClassField> dataClassFields)
	{
		this.dataClassFields = dataClassFields;
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
		SearchFieldSelection searchFieldSelection = (SearchFieldSelection) o;
		return Objects.equals(this.dataClassFields, searchFieldSelection.dataClassFields);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(dataClassFields);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class SearchFieldSelection {\n");

		sb.append("    dataClassFields: ").append(toIndentedString(dataClassFields)).append("\n");
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