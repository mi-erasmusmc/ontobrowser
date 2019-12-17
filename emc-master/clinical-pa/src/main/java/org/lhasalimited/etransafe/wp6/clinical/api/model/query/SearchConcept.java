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
public class SearchConcept implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("concepts")
	@Valid
	private List<Concept> concepts = null;

	@JsonProperty("targetConceptGroups")
	@Valid
	private List<TargetConceptGroup> targetConceptGroups = null;

	public SearchConcept concepts(List<Concept> concepts)
	{
		this.concepts = concepts;
		return this;
	}

	public SearchConcept addConceptsItem(Concept conceptsItem)
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

	public SearchConcept targetConceptGroups(List<TargetConceptGroup> targetConceptGroups)
	{
		this.targetConceptGroups = targetConceptGroups;
		return this;
	}

	public SearchConcept addTargetConceptGroupsItem(TargetConceptGroup targetConceptGroupsItem)
	{
		if (this.targetConceptGroups == null)
		{
			this.targetConceptGroups = new ArrayList<>();
		}
		this.targetConceptGroups.add(targetConceptGroupsItem);
		return this;
	}

	/**
	 * Get targetConceptGroups
	 * 
	 * @return targetConceptGroups
	 */
	@ApiModelProperty(value = "")

	@Valid

	public List<TargetConceptGroup> getTargetConceptGroups()
	{
		return targetConceptGroups;
	}

	public void setTargetConceptGroups(List<TargetConceptGroup> targetConceptGroups)
	{
		this.targetConceptGroups = targetConceptGroups;
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
		SearchConcept searchConcept = (SearchConcept) o;
		return Objects.equals(this.concepts, searchConcept.concepts) &&
				Objects.equals(this.targetConceptGroups, searchConcept.targetConceptGroups);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(concepts, targetConceptGroups);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class SearchConcept {\n");

		sb.append("    concepts: ").append(toIndentedString(concepts)).append("\n");
		sb.append("    targetConceptGroups: ").append(toIndentedString(targetConceptGroups)).append("\n");
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
