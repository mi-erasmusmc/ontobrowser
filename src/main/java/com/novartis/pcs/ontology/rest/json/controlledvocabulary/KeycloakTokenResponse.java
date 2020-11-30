package com.novartis.pcs.ontology.rest.json.controlledvocabulary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeycloakTokenResponse {

    @JsonProperty("access_token")
    String accessToken;

}
