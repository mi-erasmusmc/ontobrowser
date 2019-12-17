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
 * DataClassFieldCriteria
 */

public class DataClassFieldCriteria implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("field")
	private String field;

	@JsonProperty("comparisonOperator")
	private ComparisonOperator comparisonOperator;

	@JsonProperty("primitiveType")
	private PrimitiveType primitiveType;

	@JsonProperty("values")
	@Valid
	private List<String> values = null;

	public DataClassFieldCriteria field(String field)
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

	public DataClassFieldCriteria comparisonOperator(ComparisonOperator comparisonOperator)
	{
		this.comparisonOperator = comparisonOperator;
		return this;
	}

	/**
	 * Get comparisonOperator
	 * 
	 * @return comparisonOperator
	 */
	@ApiModelProperty(value = "")

	@Valid

	public ComparisonOperator getComparisonOperator()
	{
		return comparisonOperator;
	}

	public void setComparisonOperator(ComparisonOperator comparisonOperator)
	{
		this.comparisonOperator = comparisonOperator;
	}

	public DataClassFieldCriteria primitiveType(PrimitiveType primitiveType)
	{
		this.primitiveType = primitiveType;
		return this;
	}

	/**
	 * Get primitiveType
	 * 
	 * @return primitiveType
	 */
	@ApiModelProperty(value = "")

	@Valid

	public PrimitiveType getPrimitiveType()
	{
		return primitiveType;
	}

	public void setPrimitiveType(PrimitiveType primitiveType)
	{
		this.primitiveType = primitiveType;
	}

	public DataClassFieldCriteria values(List<String> values)
	{
		this.values = values;
		return this;
	}

	public DataClassFieldCriteria addValuesItem(String valuesItem)
	{
		if (this.values == null)
		{
			this.values = new ArrayList<>();
		}
		this.values.add(valuesItem);
		return this;
	}

	/**
	 * Get values
	 * 
	 * @return values
	 */
	@ApiModelProperty(value = "")

	public List<String> getValues()
	{
		return values;
	}

	public void setValues(List<String> values)
	{
		this.values = values;
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
		DataClassFieldCriteria dataClassFieldCriteria = (DataClassFieldCriteria) o;
		return Objects.equals(this.field, dataClassFieldCriteria.field) &&
				Objects.equals(this.comparisonOperator, dataClassFieldCriteria.comparisonOperator) &&
				Objects.equals(this.primitiveType, dataClassFieldCriteria.primitiveType) &&
				Objects.equals(this.values, dataClassFieldCriteria.values);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(field, comparisonOperator, primitiveType, values);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class DataClassFieldCriteria {\n");

		sb.append("    field: ").append(toIndentedString(field)).append("\n");
		sb.append("    comparisonOperator: ").append(toIndentedString(comparisonOperator)).append("\n");
		sb.append("    primitiveType: ").append(toIndentedString(primitiveType)).append("\n");
		sb.append("    values: ").append(toIndentedString(values)).append("\n");
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