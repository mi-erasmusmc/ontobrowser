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
package com.novartis.pcs.ontology.dao;

import static com.novartis.pcs.ontology.entity.ControlledVocabulary.QUERY_BY_NAME;
import static com.novartis.pcs.ontology.entity.ControlledVocabulary.QUERY_UNMAPPED_TERMS;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.novartis.pcs.ontology.entity.ControlledVocabulary;

/**
 * Stateless session bean DAO for ControlledVocabulary entity
 */
@Stateless
@Local({ControlledVocabularyDAOLocal.class})
@Remote({ControlledVocabularyDAORemote.class})
public class ControlledVocabularyDAO extends ModifiableEntityDAO<ControlledVocabulary> 
	implements ControlledVocabularyDAOLocal, ControlledVocabularyDAORemote {
       
    public ControlledVocabularyDAO() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<ControlledVocabulary> loadByUnmappedTerms() {
        Query query = entityManager.createNamedQuery(
                QUERY_UNMAPPED_TERMS);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ControlledVocabulary loadByName(String name) {
        Query query = entityManager.createNamedQuery(QUERY_BY_NAME, ControlledVocabulary.class);
        query.setParameter("name", name);
        List<ControlledVocabulary> vocabularies = query.getResultList();
        if (vocabularies == null || vocabularies.isEmpty()) {
            return null;
        }
        return vocabularies.get(0);
    }
}
