/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api.model.query;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class Concept implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private String id;

	@JsonProperty("code")
	private String code;

	@JsonProperty("preferredTerm")
	private String preferredTerm;

	@JsonProperty("vocabularyId")
	private String vocabularyId;

	public Concept id(String id)
	{
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 */
	@ApiModelProperty(value = "")

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Concept code(String code)
	{
		this.code = code;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 */
	@ApiModelProperty(value = "")

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public Concept preferredTerm(String preferredTerm)
	{
		this.preferredTerm = preferredTerm;
		return this;
	}

	/**
	 * Get preferredTerm
	 * 
	 * @return preferredTerm
	 */
	@ApiModelProperty(value = "")

	public String getPreferredTerm()
	{
		return preferredTerm;
	}

	public void setPreferredTerm(String preferredTerm)
	{
		this.preferredTerm = preferredTerm;
	}

	public Concept vocabularyId(String vocabularyId)
	{
		this.vocabularyId = vocabularyId;
		return this;
	}

	/**
	 * Get vocabularyId
	 * 
	 * @return vocabularyId
	 */
	@ApiModelProperty(value = "")

	public String getVocabularyId()
	{
		return vocabularyId;
	}

	public void setVocabularyId(String vocabularyId)
	{
		this.vocabularyId = vocabularyId;
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
		Concept concept = (Concept) o;
		return Objects.equals(this.id, concept.id) &&
				Objects.equals(this.code, concept.code) &&
				Objects.equals(this.preferredTerm, concept.preferredTerm) &&
				Objects.equals(this.vocabularyId, concept.vocabularyId);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, code, preferredTerm, vocabularyId);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class Concept {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    preferredTerm: ").append(toIndentedString(preferredTerm)).append("\n");
		sb.append("    vocabularyId: ").append(toIndentedString(vocabularyId)).append("\n");
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