package com.embea.policyservice.service;

import com.embea.policyservice.dao.IPolicyRepository;
import com.embea.policyservice.domain.InsuredPerson;
import com.embea.policyservice.domain.Policy;
import com.embea.policyservice.domain.dto.PolicyRequest;
import com.embea.policyservice.util.PreconiditionsUtil;
import com.embea.policyservice.util.convertors.ObjectMapperUtil;
import com.embea.policyservice.service.interfaces.IPolicyService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PolicyService implements IPolicyService {
    private IPolicyRepository policyRepository;
    private static final Logger logger = LogManager.getLogger(PolicyService.class.getName());

    @Override
    public List<Policy> getAllPolicies() {
        List<Policy> policyList = policyRepository.findAll();
        return PreconiditionsUtil.getListOfSourcesIfPresentElseThrowException(policyList, "Policies");
    }

    @Override
    public Policy addPolicy(PolicyRequest newPolicyRequest) {
        logger.info("A new policy saved: {}",  newPolicyRequest);
        Policy newPolicy = ObjectMapperUtil.map(newPolicyRequest,Policy.class);
        newPolicy.setInsuredPersons(ObjectMapperUtil.mapAll(newPolicyRequest.getInsuredPersons(), InsuredPerson.class));
        newPolicy.setTotalPremium(BigDecimal.ONE);
        Policy savedPolicy = policyRepository.save(newPolicy);
        logger.info("A new policy saved: {}", savedPolicy);
        return savedPolicy;
    }

    @Override
    public Policy updatePolicy(Integer id, PolicyRequest updatedPolicyRequest) {
        Optional<Policy> optPolicy = policyRepository.findById(id);
        Policy savedPolicy = PreconiditionsUtil.getResourceIfPresentElseThrowException(optPolicy, "Policy", id);
        savedPolicy.setStartDate(updatedPolicyRequest.getStartDate());
        savedPolicy.setInsuredPersons(ObjectMapperUtil.mapAll(updatedPolicyRequest.getInsuredPersons(),InsuredPerson.class));
        policyRepository.save(savedPolicy);
        logger.info("A policy with id:{} has been updated with :{} ", id, savedPolicy);
        return savedPolicy;
    }

    @Override
    public void deletePolicy(Integer id) {
        Optional<Policy> optPolicy = policyRepository.findById(id);
        Policy savedPolicy = PreconiditionsUtil.getResourceIfPresentElseThrowException(optPolicy, "Policy", id);
        policyRepository.delete(savedPolicy);
        logger.info("A policy with Id: {} has been deleted from db", id);
    }
}
