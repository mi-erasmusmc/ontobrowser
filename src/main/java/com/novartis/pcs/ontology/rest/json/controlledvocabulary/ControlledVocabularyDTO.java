package com.novartis.pcs.ontology.rest.json.controlledvocabulary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.novartis.pcs.ontology.entity.ControlledVocabulary;
import lombok.Data;

import java.util.List;

@Data
public class ControlledVocabularyDTO {

    private String name;
    @JsonProperty("reference_id")
    private String referenceId;
    @JsonProperty("data_source_acronym")
    private String dataSourceAcronym;
    private String context;
    private DomainDTO domain;
    private List<TermDTO> terms;
    private List<TermDTO> mappedTerms;
    private List<TermDTO> unmappedTerms;

    private ControlledVocabularyDTO(String name, String referenceId) {
        this.name = name;
        this.referenceId = referenceId;
    }


    public static ControlledVocabularyDTO mapNameAndReferenceFromEntity(ControlledVocabulary entity) {
        return new ControlledVocabularyDTO(entity.getName(), entity.getReferenceId());
    }

}
