/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
@Configuration
@EnableSwagger2
public class ClinicaltrialsPaAPIDocumentationConfig
{

	ApiInfo apiInfo()
	{
		return new ApiInfoBuilder()
				.title("Clinicaltrials Primitive Adapter Service")
				.description("Clinicaltrials Primitive Adapter component to test registration and Clinical searchable data (index) query ")
				.license("Apache 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
				.termsOfServiceUrl("https://www.lhasalimited.org/")
				.version("1.0.0")
				.contact(new Contact("", "", "tima.camara@lhasalimited.org"))
				.build();
	}

	@Bean
	public Docket customImplementation(ServletContext servletContext,
			@Value("${openapi.ClinicalPrimitiveAdapterService.base-path:/clinicaltrials-pa/v1}") String basePath)
	{
		return new Docket(DocumentationType.SPRING_WEB)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.lhasalimited.etransafe.wp6.clinical.api"))
				.build()
				.pathProvider(new BasePathAwareRelativePathProvider(servletContext, basePath))
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
				.apiInfo(apiInfo());
	}

	class BasePathAwareRelativePathProvider extends RelativePathProvider
	{
		private String basePath;

		public BasePathAwareRelativePathProvider(ServletContext servletContext, String basePath)
		{
			super(servletContext);
			this.basePath = basePath;
		}

		@Override
		protected String applicationPath()
		{
			return Paths.removeAdjacentForwardSlashes(UriComponentsBuilder.fromPath(super.applicationPath()).path(basePath).build().toString());
		}

		@Override
		public String getOperationPath(String operationPath)
		{
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
			return Paths.removeAdjacentForwardSlashes(
					uriComponentsBuilder.path(operationPath.replaceFirst("^" + basePath, "")).build().toString());
		}
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