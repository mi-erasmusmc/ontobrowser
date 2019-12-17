/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class Compound extends DataClass implements Serializable
{
	private static final long serialVersionUID = -7540783073933474722L;

	private int id;
	private String compoundIdentifier;
	private String name;
	private String inchi;
	private String inchiKey;
	private String smiles;
	private String organisation;
	private List<Integer> studyIds;
	private String confidentiality;

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final int id)
	{
		this.id = id;
	}

	/**
	 * @return the compoundIdentifier
	 */
	public String getCompoundIdentifier()
	{
		return compoundIdentifier;
	}

	/**
	 * @param compoundIdentifier the compoundIdentifier to set
	 */
	public void setCompoundIdentifier(final String compoundIdentifier)
	{
		this.compoundIdentifier = compoundIdentifier;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the inchi
	 */
	public String getInchi()
	{
		return inchi;
	}

	/**
	 * @param inchi the inchi to set
	 */
	public void setInchi(final String inchi)
	{
		this.inchi = inchi;
	}

	/**
	 * @return the inchiKey
	 */
	public String getInchiKey()
	{
		return inchiKey;
	}

	/**
	 * @param inchiKey the inchiKey to set
	 */
	public void setInchiKey(final String inchiKey)
	{
		this.inchiKey = inchiKey;
	}

	/**
	 * @return the smiles
	 */
	public String getSmiles()
	{
		return smiles;
	}

	/**
	 * @param smiles the smiles to set
	 */
	public void setSmiles(final String smiles)
	{
		this.smiles = smiles;
	}

	/**
	 * @return the organisation
	 */
	public String getOrganisation()
	{
		return organisation;
	}

	/**
	 * @param organisation the organisation to set
	 */
	public void setOrganisation(final String organisation)
	{
		this.organisation = organisation;
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
	public void setStudyIds(final List<Integer> studyIds)
	{
		this.studyIds = studyIds;
	}

	/**
	 * @return the confidentiality
	 */
	public String getConfidentiality()
	{
		return confidentiality;
	}

	/**
	 * @param confidentiality the confidentiality to set
	 */
	public void setConfidentiality(final String confidentiality)
	{
		this.confidentiality = confidentiality;
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