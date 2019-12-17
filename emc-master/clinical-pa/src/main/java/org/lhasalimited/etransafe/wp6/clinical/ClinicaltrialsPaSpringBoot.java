/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.Module;

/**
 *
 * @author Tima Camara
 * @since 19 Aug 2019
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.lhasalimited.etransafe.wp6.clinical", "org.lhasalimited.etransafe.wp6.clinical.api",
		"org.lhasalimited.etransafe.wp6.clinical.config" })
@MapperScan("org.lhasalimited.etransafe.wp6.clinical.mapper")
public class ClinicaltrialsPaSpringBoot implements CommandLineRunner
{

	@Override
	public void run(final String... arg0) throws Exception
	{
		if (arg0.length > 0 && arg0[0].equals("exitcode"))
		{
			throw new ExitException();
		}
	}

	public static void main(final String[] args) throws Exception
	{
		new SpringApplication(ClinicaltrialsPaSpringBoot.class).run(args);
	}

	static class ExitException extends RuntimeException implements ExitCodeGenerator
	{
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode()
		{
			return 10;
		}

	}

	@Bean
	public WebMvcConfigurer webConfigurer()
	{
		return new WebMvcConfigurer()
		{
			/* @Override
			 * public void addCorsMappings(CorsRegistry registry) {
			 * registry.addMapping("/**")
			 * .allowedOrigins("*")
			 * .allowedMethods("*")
			 * .allowedHeaders("Content-Type");
			 * } */
		};
	}

	@Bean
	public Module jsonNullableModule()
	{
		return new JsonNullableModule();
	}

	@PostConstruct
	public void init()
	{
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
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