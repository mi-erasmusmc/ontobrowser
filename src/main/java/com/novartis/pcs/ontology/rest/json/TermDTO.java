/* 

Copyright 2015 Novartis Institutes for Biomedical Research

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/
package com.novartis.pcs.ontology.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.novartis.pcs.ontology.entity.Ontology;
import com.novartis.pcs.ontology.entity.Term;
import org.apache.commons.lang.StringUtils;

import javax.naming.InitialContext;
import java.net.URL;
import java.util.List;

public class TermDTO {
	@JsonProperty("term_id")
	private String termId;
	@JsonProperty("term_name")
	private String termName;
	@JsonProperty("term_url")
	private String termUrl;
	@JsonProperty("term_status")
	private String termStatus;
	private String ontology;

	private static final URL baseURL;
	
	static {
		InitialContext context = null;
		URL url = null;
		try {
			context = new InitialContext();
			// Using the keycloak login url and will trim the 'login', not very clean, but it suffices.
			url = (URL)context.lookup("java:global/keycloak/redirect/uri");
		} catch(Exception e) {
			url = null;
		} finally {
			if(context != null) {
				try {
					context.close();
				} catch(Exception ignored) {

				}
			}
		}
		baseURL = url;
	}
	
	public TermDTO(Term term) {
		Ontology ontology = term.getOntology();
				
		this.ontology = ontology.getName();
		this.termId = term.getReferenceId();
		this.termName = term.getName();
		this.termUrl = buildTermUrl(term.getReferenceId());
		this.termStatus = term.getStatus().toString();
	}

	public String getOntology() {
		return ontology;
	}

	public String getTermId() {
		return termId;
	}

	public String getTermName() {
		return termName;
	}

	public String getTermUrl() {
		return termUrl;
	}

	public String getTermStatus() {
		return termStatus;
	}

	private String buildTermUrl(String refId) {
		if (baseURL != null) {
			String baseUrlString = baseURL.toString();
			if (!StringUtils.isEmpty(baseUrlString)) {
				return baseUrlString.substring(0, baseUrlString.length() - 5) + "index.html#" + refId;
			}
		}
		return null;
	}
}
