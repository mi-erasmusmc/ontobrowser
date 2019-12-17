/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.dto;

import java.io.Serializable;

/**
 *
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class Finding extends DataClass implements Serializable
{
	private static final long serialVersionUID = -414893924505927638L;

	private int id;
	private String findingIdentifier;
	private String specimenOrgan;
	private String finding;
	private String severity;
	private String observation;
	private String frequency;
	private String dose;
	private int studyDay;
	private Boolean treatmentRelated;
	private int compoundId;
	private int studyId;

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
	public void setId(int id)
	{
		this.id = id;
	}
	/**
	 * @return the findingIdentifier
	 */
	public String getFindingIdentifier()
	{
		return findingIdentifier;
	}
	/**
	 * @param findingIdentifier the findingIdentifier to set
	 */
	public void setFindingIdentifier(String findingIdentifier)
	{
		this.findingIdentifier = findingIdentifier;
	}
	/**
	 * @return the specimenOrgan
	 */
	public String getSpecimenOrgan()
	{
		return specimenOrgan;
	}
	/**
	 * @param specimenOrgan the specimenOrgan to set
	 */
	public void setSpecimenOrgan(String specimenOrgan)
	{
		this.specimenOrgan = specimenOrgan;
	}
	/**
	 * @return the finding
	 */
	public String getFinding()
	{
		return finding;
	}
	/**
	 * @param finding the finding to set
	 */
	public void setFinding(String finding)
	{
		this.finding = finding;
	}
	/**
	 * @return the severity
	 */
	public String getSeverity()
	{
		return severity;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity)
	{
		this.severity = severity;
	}
	/**
	 * @return the observation
	 */
	public String getObservation()
	{
		return observation;
	}
	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation)
	{
		this.observation = observation;
	}
	/**
	 * @return the frequency
	 */
	public String getFrequency()
	{
		return frequency;
	}
	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency)
	{
		this.frequency = frequency;
	}
	/**
	 * @return the dose
	 */
	public String getDose()
	{
		return dose;
	}
	/**
	 * @param dose the dose to set
	 */
	public void setDose(String dose)
	{
		this.dose = dose;
	}
	/**
	 * @return the studyDay
	 */
	public int getStudyDay()
	{
		return studyDay;
	}
	/**
	 * @param studyDay the studyDay to set
	 */
	public void setStudyDay(int studyDay)
	{
		this.studyDay = studyDay;
	}
	/**
	 * @return the treatmentRelated
	 */
	public Boolean getTreatmentRelated()
	{
		return treatmentRelated;
	}
	/**
	 * @param treatmentRelated the treatmentRelated to set
	 */
	public void setTreatmentRelated(Boolean treatmentRelated)
	{
		this.treatmentRelated = treatmentRelated;
	}

	/**
	 * @return the compoundId
	 */
	public int getCompoundId()
	{
		return compoundId;
	}
	/**
	 * @param compoundId the compoundId to set
	 */
	public void setCompoundId(int compoundId)
	{
		this.compoundId = compoundId;
	}
	/**
	 * @return the studyId
	 */
	public int getStudyId()
	{
		return studyId;
	}
	/**
	 * @param studyId the studyId to set
	 */
	public void setStudyId(int studyId)
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
