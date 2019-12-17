/**
 * Copyright © 2019 Lhasa Limited
 * File created: 10 Sep 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.entity;

/**
*
* @author Tima Camara
* @since 10 Sep 2019
*/
public class IndexFinding
{
	private Integer id;

	private String findingIdentifier;

	private String specimenOrgan;

	private String specimenOrganCode;

	private String specimenOrganVocabulary;

	private String finding;

	private String findingCode;

	private String findingVocabulary;

	private String severity;

	private String observation;

	private String frequency;

	private String dose;

	private Integer studyDay;

	private Boolean treatmentRelated;

	private Integer compoundId;

	private Integer studyId;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFindingIdentifier()
	{
		return findingIdentifier;
	}

	public void setFindingIdentifier(String findingIdentifier)
	{
		this.findingIdentifier = findingIdentifier == null ? null : findingIdentifier.trim();
	}

	public String getSpecimenOrgan()
	{
		return specimenOrgan;
	}

	public void setSpecimenOrgan(String specimenOrgan)
	{
		this.specimenOrgan = specimenOrgan == null ? null : specimenOrgan.trim();
	}

	public String getSpecimenOrganCode()
	{
		return specimenOrganCode;
	}

	public void setSpecimenOrganCode(String specimenOrganCode)
	{
		this.specimenOrganCode = specimenOrganCode == null ? null : specimenOrganCode.trim();
	}

	public String getSpecimenOrganVocabulary()
	{
		return specimenOrganVocabulary;
	}

	public void setSpecimenOrganVocabulary(String specimenOrganVocabulary)
	{
		this.specimenOrganVocabulary = specimenOrganVocabulary == null ? null : specimenOrganVocabulary.trim();
	}

	public String getFinding()
	{
		return finding;
	}

	public void setFinding(String finding)
	{
		this.finding = finding == null ? null : finding.trim();
	}

	public String getFindingCode()
	{
		return findingCode;
	}

	public void setFindingCode(String findingCode)
	{
		this.findingCode = findingCode == null ? null : findingCode.trim();
	}

	public String getFindingVocabulary()
	{
		return findingVocabulary;
	}

	public void setFindingVocabulary(String findingVocabulary)
	{
		this.findingVocabulary = findingVocabulary == null ? null : findingVocabulary.trim();
	}

	public String getSeverity()
	{
		return severity;
	}

	public void setSeverity(String severity)
	{
		this.severity = severity == null ? null : severity.trim();
	}

	public String getObservation()
	{
		return observation;
	}

	public void setObservation(String observation)
	{
		this.observation = observation == null ? null : observation.trim();
	}

	public String getFrequency()
	{
		return frequency;
	}

	public void setFrequency(String frequency)
	{
		this.frequency = frequency == null ? null : frequency.trim();
	}

	public String getDose()
	{
		return dose;
	}

	public void setDose(String dose)
	{
		this.dose = dose == null ? null : dose.trim();
	}

	public Integer getStudyDay()
	{
		return studyDay;
	}

	public void setStudyDay(Integer studyDay)
	{
		this.studyDay = studyDay;
	}

	public Boolean getTreatmentRelated()
	{
		return treatmentRelated;
	}

	public void setTreatmentRelated(Boolean treatmentRelated)
	{
		this.treatmentRelated = treatmentRelated;
	}

	public Integer getCompoundId()
	{
		return compoundId;
	}

	public void setCompoundId(Integer compoundId)
	{
		this.compoundId = compoundId;
	}

	/**
	 * @return the studyId
	 */
	public Integer getStudyId()
	{
		return studyId;
	}

	/**
	 * @param studyId the studyId to set
	 */
	public void setStudyId(Integer studyId)
	{
		this.studyId = studyId;
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
