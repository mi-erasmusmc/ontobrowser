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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class Query implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("searchConcept")
	private SearchConcept searchConcept = null;

	@JsonProperty("searchFilter")
	private SearchFilter searchFilter = null;

	@JsonProperty("searchFieldSelection")
	private SearchFieldSelection searchFieldSelection = null;

	@JsonProperty("searchSort")
	private SearchSort searchSort = null;

	@JsonProperty("searchOffset")
	private Integer searchOffset = 0;

	@JsonProperty("searchLimit")
	private Integer searchLimit = 100;

	public Query searchConcept(SearchConcept searchConcept)
	{
		this.searchConcept = searchConcept;
		return this;
	}

	/**
	 * Get searchConcept
	 * 
	 * @return searchConcept
	 */
	@ApiModelProperty(value = "")

	@Valid

	public SearchConcept getSearchConcept()
	{
		return searchConcept;
	}

	public void setSearchConcept(SearchConcept searchConcept)
	{
		this.searchConcept = searchConcept;
	}

	public Query searchFilter(SearchFilter searchFilter)
	{
		this.searchFilter = searchFilter;
		return this;
	}

	/**
	 * Get searchFilter
	 * 
	 * @return searchFilter
	 */
	@ApiModelProperty(value = "")

	@Valid

	public SearchFilter getSearchFilter()
	{
		return searchFilter;
	}

	public void setSearchFilter(SearchFilter searchFilter)
	{
		this.searchFilter = searchFilter;
	}

	public Query searchFieldSelection(SearchFieldSelection searchFieldSelection)
	{
		this.searchFieldSelection = searchFieldSelection;
		return this;
	}

	/**
	 * Get searchFieldSelection
	 * 
	 * @return searchFieldSelection
	 */
	@ApiModelProperty(value = "")

	@Valid

	public SearchFieldSelection getSearchFieldSelection()
	{
		return searchFieldSelection;
	}

	public void setSearchFieldSelection(SearchFieldSelection searchFieldSelection)
	{
		this.searchFieldSelection = searchFieldSelection;
	}

	public Query searchSort(SearchSort searchSort)
	{
		this.searchSort = searchSort;
		return this;
	}

	/**
	 * Get searchSort
	 * 
	 * @return searchSort
	 */
	@ApiModelProperty(value = "")

	@Valid

	public SearchSort getSearchSort()
	{
		return searchSort;
	}

	public void setSearchSort(SearchSort searchSort)
	{
		this.searchSort = searchSort;
	}

	public Query searchOffset(Integer searchOffset)
	{
		this.searchOffset = searchOffset;
		return this;
	}

	/**
	 * Get searchOffset
	 * 
	 * @return searchOffset
	 */
	@ApiModelProperty(value = "")

	public Integer getSearchOffset()
	{
		return searchOffset;
	}

	public void setSearchOffset(Integer searchOffset)
	{
		this.searchOffset = searchOffset;
	}

	public Query searchLimit(Integer searchLimit)
	{
		this.searchLimit = searchLimit;
		return this;
	}

	/**
	 * Get searchLimit
	 * 
	 * @return searchLimit
	 */
	@ApiModelProperty(value = "")

	public Integer getSearchLimit()
	{
		return searchLimit;
	}

	public void setSearchLimit(Integer searchLimit)
	{
		this.searchLimit = searchLimit;
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
		Query query = (Query) o;
		return Objects.equals(this.searchConcept, query.searchConcept) &&
				Objects.equals(this.searchFilter, query.searchFilter) &&
				Objects.equals(this.searchFieldSelection, query.searchFieldSelection) &&
				Objects.equals(this.searchSort, query.searchSort) &&
				Objects.equals(this.searchOffset, query.searchOffset) &&
				Objects.equals(this.searchLimit, query.searchLimit);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(searchConcept, searchFilter, searchFieldSelection, searchSort, searchOffset, searchLimit);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class Query {\n");

		sb.append("    searchConcept: ").append(toIndentedString(searchConcept)).append("\n");
		sb.append("    searchFilter: ").append(toIndentedString(searchFilter)).append("\n");
		sb.append("    searchFieldSelection: ").append(toIndentedString(searchFieldSelection)).append("\n");
		sb.append("    searchSort: ").append(toIndentedString(searchSort)).append("\n");
		sb.append("    searchOffset: ").append(toIndentedString(searchOffset)).append("\n");
		sb.append("    searchLimit: ").append(toIndentedString(searchLimit)).append("\n");
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
