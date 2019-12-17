/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.service;

import java.util.List;

import javax.validation.Valid;

import org.lhasalimited.etransafe.wp6.clinical.dto.Compound;
import org.lhasalimited.etransafe.wp6.clinical.dto.DataclassUtil;
import org.lhasalimited.etransafe.wp6.clinical.dto.Finding;
import org.lhasalimited.etransafe.wp6.clinical.dto.Study;
import org.lhasalimited.etransafe.wp6.clinical.entity.IndexCompound;
import org.lhasalimited.etransafe.wp6.clinical.entity.IndexFinding;
import org.lhasalimited.etransafe.wp6.clinical.entity.IndexStudy;
import org.lhasalimited.etransafe.wp6.clinical.mapper.CompoundMapper;
import org.lhasalimited.etransafe.wp6.clinical.mapper.FindingMapper;
import org.lhasalimited.etransafe.wp6.clinical.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tima Camara
 * @since 30 Aug 2019
 */

@Service
public class DataService
{
	@Autowired
	CompoundMapper compoundMapper;

	@Autowired
	StudyMapper studyMapper;

	@Autowired
	FindingMapper findingMapper;

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Compound> getCompounds(@Valid Integer offset, @Valid Integer limit)
	{
		List<IndexCompound> indexCompounds = compoundMapper.selectAll(offset, limit);
		return DataclassUtil.convertToDataClass(() -> indexCompounds);
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Study> getStudies(@Valid Integer offset, @Valid Integer limit)
	{
		List<IndexStudy> indexStudies = studyMapper.selectAll(offset, limit);
		return DataclassUtil.convertToDataClass(() -> indexStudies);
	}

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Finding> getFindings(@Valid Integer offset, @Valid Integer limit)
	{
		List<IndexFinding> indexFindings = findingMapper.selectAll(offset, limit);
		return DataclassUtil.convertToDataClass(() -> indexFindings);
	}

	/**
	 * @return
	 */
	public int countCompounds()
	{
		return compoundMapper.countAll();
	}

	/**
	 * @return
	 */
	public int countStudies()
	{
		return studyMapper.countAll();
	}

	/**
	 * @return
	 */
	public int countFindings()
	{
		return findingMapper.countAll();
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