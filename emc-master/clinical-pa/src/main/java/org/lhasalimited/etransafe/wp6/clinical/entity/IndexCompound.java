/**
 * Copyright © 2019 Lhasa Limited
 * File created: 10 Sep 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.entity;

import java.util.List;

/**
*
* @author Tima Camara
* @since 10 Sep 2019
*/
public class IndexCompound
{
	private Integer id;

	private String compoundIdentifier;

	private String name;

	private String inchi;

	private String inchiKey;

	private String smiles;

	private String organisation;

	private String confidentiality;

	private List<Integer> studyIds;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getCompoundIdentifier()
	{
		return compoundIdentifier;
	}

	public void setCompoundIdentifier(String compoundIdentifier)
	{
		this.compoundIdentifier = compoundIdentifier == null ? null : compoundIdentifier.trim();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name == null ? null : name.trim();
	}

	public String getInchi()
	{
		return inchi;
	}

	public void setInchi(String inchi)
	{
		this.inchi = inchi == null ? null : inchi.trim();
	}

	public String getInchiKey()
	{
		return inchiKey;
	}

	public void setInchiKey(String inchiKey)
	{
		this.inchiKey = inchiKey == null ? null : inchiKey.trim();
	}

	public String getSmiles()
	{
		return smiles;
	}

	public void setSmiles(String smiles)
	{
		this.smiles = smiles == null ? null : smiles.trim();
	}

	public String getOrganisation()
	{
		return organisation;
	}

	public void setOrganisation(String organisation)
	{
		this.organisation = organisation == null ? null : organisation.trim();
	}

	public String getConfidentiality()
	{
		return confidentiality;
	}

	public void setConfidentiality(String confidentiality)
	{
		this.confidentiality = confidentiality == null ? null : confidentiality.trim();
	}

	/**
	 * @return the studyIds
	 */
	public List<Integer> getStudyIds()
	{
		return studyIds;
	}

	/**
	 * @param studyIds the studyIds to set
	 */
	public void setStudyIds(List<Integer> studyIds)
	{
		this.studyIds = studyIds;
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
