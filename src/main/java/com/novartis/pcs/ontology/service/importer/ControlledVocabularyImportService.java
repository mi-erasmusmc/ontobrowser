
package com.novartis.pcs.ontology.service.importer;

import com.novartis.pcs.ontology.entity.Curator;
import com.novartis.pcs.ontology.entity.InvalidEntityException;
import com.novartis.pcs.ontology.rest.json.controlledvocabulary.ControlledVocabularyDTO;

public interface ControlledVocabularyImportService {
    void importControlledVocabulary(ControlledVocabularyDTO dto, Curator creator) throws InvalidEntityException;

}
