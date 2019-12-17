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
public class TargetConceptGroup implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("concepts")
	@Valid
	private List<Concept> concepts = null;

	public TargetConceptGroup concepts(List<Concept> concepts)
	{
		this.concepts = concepts;
		return this;
	}

	public TargetConceptGroup addConceptsItem(Concept conceptsItem)
	{
		if (this.concepts == null)
		{
			this.concepts = new ArrayList<>();
		}
		this.concepts.add(conceptsItem);
		return this;
	}

	/**
	 * Get concepts
	 * 
	 * @return concepts
	 */
	@ApiModelProperty(value = "")

	@Valid

	public List<Concept> getConcepts()
	{
		return concepts;
	}

	public void setConcepts(List<Concept> concepts)
	{
		this.concepts = concepts;
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
		TargetConceptGroup targetConceptGroup = (TargetConceptGroup) o;
		return Objects.equals(this.concepts, targetConceptGroup.concepts);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(concepts);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class TargetConceptGroup {\n");

		sb.append("    concepts: ").append(toIndentedString(concepts)).append("\n");
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