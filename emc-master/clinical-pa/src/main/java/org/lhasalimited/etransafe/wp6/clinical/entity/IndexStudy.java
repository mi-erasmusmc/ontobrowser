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
public class IndexStudy
{
	private Integer id;

	private String studyIdentifier;

	private String studyType;

	private String species;

	private String speciesCode;

	private String speciesVocabulary;

	private String age;

	private String strain;

	private String strainCode;

	private String strainVocabulary;

	private String route;

	private String routeCode;

	private String routeVocabulary;

	private Short duration;

	private String durationCode;

	private String phase;

	private String organisation;

	private String confidentiality;

	private List<Integer> compoundIds;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getStudyIdentifier()
	{
		return studyIdentifier;
	}

	public void setStudyIdentifier(String studyIdentifier)
	{
		this.studyIdentifier = studyIdentifier == null ? null : studyIdentifier.trim();
	}

	public String getStudyType()
	{
		return studyType;
	}

	public void setStudyType(String studyType)
	{
		this.studyType = studyType == null ? null : studyType.trim();
	}

	public String getSpecies()
	{
		return species;
	}

	public void setSpecies(String species)
	{
		this.species = species == null ? null : species.trim();
	}

	public String getSpeciesCode()
	{
		return speciesCode;
	}

	public void setSpeciesCode(String speciesCode)
	{
		this.speciesCode = speciesCode == null ? null : speciesCode.trim();
	}

	public String getSpeciesVocabulary()
	{
		return speciesVocabulary;
	}

	public void setSpeciesVocabulary(String speciesVocabulary)
	{
		this.speciesVocabulary = speciesVocabulary == null ? null : speciesVocabulary.trim();
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age == null ? null : age.trim();
	}

	public String getStrain()
	{
		return strain;
	}

	public void setStrain(String strain)
	{
		this.strain = strain == null ? null : strain.trim();
	}

	public String getStrainCode()
	{
		return strainCode;
	}

	public void setStrainCode(String strainCode)
	{
		this.strainCode = strainCode == null ? null : strainCode.trim();
	}

	public String getStrainVocabulary()
	{
		return strainVocabulary;
	}

	public void setStrainVocabulary(String strainVocabulary)
	{
		this.strainVocabulary = strainVocabulary == null ? null : strainVocabulary.trim();
	}

	public String getRoute()
	{
		return route;
	}

	public void setRoute(String route)
	{
		this.route = route == null ? null : route.trim();
	}

	public String getRouteCode()
	{
		return routeCode;
	}

	public void setRouteCode(String routeCode)
	{
		this.routeCode = routeCode == null ? null : routeCode.trim();
	}

	public String getRouteVocabulary()
	{
		return routeVocabulary;
	}

	public void setRouteVocabulary(String routeVocabulary)
	{
		this.routeVocabulary = routeVocabulary == null ? null : routeVocabulary.trim();
	}

	public Short getDuration()
	{
		return duration;
	}

	public void setDuration(Short duration)
	{
		this.duration = duration;
	}

	public String getDurationCode()
	{
		return durationCode;
	}

	public void setDurationCode(String durationCode)
	{
		this.durationCode = durationCode == null ? null : durationCode.trim();
	}

	public String getPhase()
	{
		return phase;
	}

	public void setPhase(String phase)
	{
		this.phase = phase == null ? null : phase.trim();
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
