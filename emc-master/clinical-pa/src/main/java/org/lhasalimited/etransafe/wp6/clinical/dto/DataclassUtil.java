/**
 * Copyright © 2019 Lhasa Limited
 * File created: 2 Sep 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.lhasalimited.etransafe.wp6.clinical.entity.IndexCompound;
import org.lhasalimited.etransafe.wp6.clinical.entity.IndexFinding;
import org.lhasalimited.etransafe.wp6.clinical.entity.IndexStudy;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

/**
 * @author Tima Camara
 * @since 2 Sep 2019
 */
public class DataclassUtil
{
	private static ObjectMapper mapper = new ObjectMapper();

	public static <T> String convertToJson(final Class<T> clazz)
	{
		try
		{
			JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
			JsonSchema jsonSchema = schemaGen.generateSchema(clazz);
			jsonSchema.setId(null);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static <T> void generateJsonSchemaFile(final Class<T> clazz, String name)
	{
		String path = name + ".json";
		try
		{
			Files.writeString(Paths.get(path), DataclassUtil.convertToJson(clazz));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public interface ListIndexCompoundRef extends Supplier<List<IndexCompound>>
	{
	}

	public interface ListIndexStudyRef extends Supplier<List<IndexStudy>>
	{
	}

	public interface ListIndexFindingRef extends Supplier<List<IndexFinding>>
	{
	}

	public static List<Compound> convertToDataClass(ListIndexCompoundRef indexCompounds)
	{
		List<Compound> compounds = new ArrayList<Compound>();
		indexCompounds.get().forEach(ic -> {
			compounds.add(convertToDataClass(ic));
		});
		return compounds;
	}

	public static Compound convertToDataClass(IndexCompound indexCompound)
	{
		Compound c = new Compound();
		BeanUtils.copyProperties(indexCompound, c);
		return c;
	}

	public static List<Study> convertToDataClass(ListIndexStudyRef indexStudys)
	{
		List<Study> studies = new ArrayList<Study>();
		indexStudys.get().forEach(is -> {
			studies.add(convertToDataClass(is));
		});
		return studies;
	}

	public static Study convertToDataClass(IndexStudy indexStudy)
	{
		Study s = new Study();
		BeanUtils.copyProperties(indexStudy, s);
		return s;
	}

	public static List<Finding> convertToDataClass(ListIndexFindingRef indexFindings)
	{
		List<Finding> findings = new ArrayList<Finding>();
		indexFindings.get().forEach(iff -> {
			findings.add(convertToDataClass(iff));
		});
		return findings;
	}

	public static Finding convertToDataClass(IndexFinding indexFinding)
	{
		Finding f = new Finding();
		try
		{
			BeanUtils.copyProperties(indexFinding, f);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return f;
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