package com.embea.policyservice.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Policy {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer policyId;

        @NotNull
        private LocalDate startDate;

        @NotNull
        @Valid
        @OneToMany(mappedBy = "policy", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private List<InsuredPerson> insuredPersons;

        @NotNull
        @DecimalMin(value = "0.0")
        private BigDecimal totalPremium;
}
