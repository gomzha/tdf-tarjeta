package com.tdf.platform.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CustomerDTO(
        Long id,
        String name,

        @JsonProperty("last_name")
        String lastName,
        String email,

        @JsonFormat(pattern = "yyyy-MM-dd")
        @JsonProperty("birth_date")
        LocalDate birthDate
) {
}
