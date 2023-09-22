package com.embea.policyservice.domain.dto;

import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class PolicyRequest {

        @FutureOrPresent
        @NotNull(message = "startDate must be provided")
        private LocalDate startDate;

        @NotNull(message = "InsuredPersonRequest must be provided")
        @Valid
        List<InsuredPersonRequest> insuredPersons;
}
