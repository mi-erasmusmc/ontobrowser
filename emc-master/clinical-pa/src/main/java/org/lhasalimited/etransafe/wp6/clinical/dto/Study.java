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
public class Study extends DataClass implements Serializable
{
	private static final long serialVersionUID = 5348125634015030818L;

	private int id;
	private String studyIdentifier;
	private String studyType;
	private String species;
	private String age;
	private String strain;
	private String route;
	private Short duration;
	private String phase;
	private String confidentiality;
	private String organisation;
	private List<Integer> compoundIds;

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
	 * @return the studyIdentifier
	 */
	public String getStudyIdentifier()
	{
		return studyIdentifier;
	}

	/**
	 * @param studyIdentifier the studyIdentifier to set
	 */
	public void setStudyIdentifier(final String studyIdentifier)
	{
		this.studyIdentifier = studyIdentifier;
	}

	/**
	 * @return the studyType
	 */
	public String getStudyType()
	{
		return studyType;
	}

	/**
	 * @param studyType the studyType to set
	 */
	public void setStudyType(final String studyType)
	{
		this.studyType = studyType;
	}

	/**
	 * @return the species
	 */
	public String getSpecies()
	{
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(final String species)
	{
		this.species = species;
	}

	/**
	 * @return the age
	 */
	public String getAge()
	{
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(final String age)
	{
		this.age = age;
	}

	/**
	 * @return the strain
	 */
	public String getStrain()
	{
		return strain;
	}

	/**
	 * @param strain the strain to set
	 */
	public void setStrain(final String strain)
	{
		this.strain = strain;
	}

	/**
	 * @return the route
	 */
	public String getRoute()
	{
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(final String route)
	{
		this.route = route;
	}

	/**
	 * @return the duration
	 */
	public Short getDuration()
	{
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(final Short duration)
	{
		this.duration = duration;
	}

	/**
	 * @return the phase
	 */
	public String getPhase()
	{
		return phase;
	}

	/**
	 * @param phase the phase to set
	 */
	public void setPhase(String phase)
	{
		this.phase = phase;
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

	/**
	 * @return the organisation
	 */
	public String getOrganisation()
	{
		return organisation;
	}

	public void setOrganisation(final String organisation)
	{
		this.organisation = organisation;
	}

	public List<Integer> getCompoundIds()
	{
		return compoundIds;
	}

	public void setCompoundIds(List<Integer> compoundIds)
	{
		this.compoundIds = compoundIds;
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
