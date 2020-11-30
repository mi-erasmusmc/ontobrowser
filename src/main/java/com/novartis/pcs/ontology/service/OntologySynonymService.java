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
package com.novartis.pcs.ontology.service;

import java.util.Collection;

import com.novartis.pcs.ontology.entity.ControlledVocabulary;
import com.novartis.pcs.ontology.entity.ControlledVocabularyContext;
import com.novartis.pcs.ontology.entity.ControlledVocabularyDomain;
import com.novartis.pcs.ontology.entity.ControlledVocabularyTerm;
import com.novartis.pcs.ontology.entity.ControlledVocabularyTermLink;
import com.novartis.pcs.ontology.entity.Curator;
import com.novartis.pcs.ontology.entity.Datasource;
import com.novartis.pcs.ontology.entity.InvalidEntityException;
import com.novartis.pcs.ontology.entity.Synonym;

public interface OntologySynonymService {
	
	public Collection<Synonym> loadSynonyms(String termRefId);
	
	public Collection<Datasource> loadPublicDatasources();
	
	public Collection<ControlledVocabulary> loadControlledVocabulariesWithUnmappedTerms();
	
	public Collection<ControlledVocabularyTerm> loadUnmappedControlledVocabularyTerms(ControlledVocabularyDomain domain);
	
	public Collection<ControlledVocabularyTerm> loadUnmappedControlledVocabularyTerms(ControlledVocabularyDomain domain,
			ControlledVocabularyContext context);
	
	public Collection<ControlledVocabularyTerm> loadUnmappedControlledVocabularyTerms(ControlledVocabularyDomain domain,
			Datasource datasource);
	
	public Collection<ControlledVocabularyTerm> loadUnmappedControlledVocabularyTerms(ControlledVocabularyDomain domain,
			ControlledVocabularyContext context, Datasource datasource);
	
	public void excludeUnmappedControlledVocabularyTerms(Collection<ControlledVocabularyTerm> terms, 
			Curator curator) throws InvalidEntityException;
	
	public Collection<ControlledVocabularyTermLink> loadControlledVocabularyTermLinks(ControlledVocabularyTerm term);
}
