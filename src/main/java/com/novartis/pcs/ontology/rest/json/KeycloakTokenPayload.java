package com.novartis.pcs.ontology.rest.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenPayload {

    @JsonProperty("preferred_username")
    private String username;
    @JsonProperty("realm_access")
    private RealmAccess realmAccess;


    public boolean containsCuratorRole() {
        return realmAccess.getRoles().contains("ontobrowser-curator");
    }

}
