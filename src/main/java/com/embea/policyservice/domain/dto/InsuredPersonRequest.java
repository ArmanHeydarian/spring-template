package com.embea.policyservice.domain.dto;

import lombok.Data;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class InsuredPersonRequest {

    @NotEmpty(message = "firstName must not be empty")
    @NotNull(message = "firstName must be provided")
    @NotBlank(message = "firstName must contain some valid string")
    private String firstName;

    @NotEmpty(message = "lastName must not be empty")
    @NotNull(message = "lastName must be provided")
    @NotBlank(message = "lastName must contain some valid string")
    private String lastName;

    @NotNull
    @DecimalMin(value = "0.0")
    private BigDecimal premium;
}
