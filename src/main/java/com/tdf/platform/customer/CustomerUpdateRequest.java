package com.tdf.platform.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerUpdateRequest(
        String name,
        
        @JsonProperty("last_name")
        String lastName
) {
}
