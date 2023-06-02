package br.com.payments.models.client;

import br.com.payments.models.enums.ContractTypeEnum;

import java.util.List;

public interface Assignment {
    List<Double> getFees(ContractTypeEnum contract);
}
