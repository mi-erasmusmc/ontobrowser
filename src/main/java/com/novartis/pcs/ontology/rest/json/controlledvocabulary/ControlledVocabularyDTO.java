package com.novartis.pcs.ontology.rest.json.controlledvocabulary;

import com.fasterxml.jackson.annotation.JsonProperty;
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

}
