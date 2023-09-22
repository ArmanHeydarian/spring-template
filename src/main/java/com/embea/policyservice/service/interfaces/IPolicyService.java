package com.embea.policyservice.service.interfaces;

import com.embea.policyservice.domain.Policy;
import com.embea.policyservice.domain.dto.PolicyRequest;

import java.util.List;

public interface IPolicyService {

     /** Get all Policies from db
      * @return List of Saved Policies
      */
     List<Policy> getAllPolicies();

     /** Adds a new Policy to db by Admin
      * @param newPolicyRequest - A PolicyRequest DTO to be saved into db
      * @return Saved Policy
      */
     Policy addPolicy(PolicyRequest newPolicyRequest);


     /** Updates a Policy with new information based a given id
      * @param id - Policy's id on which the update would be done
      * @param newPolicy - Policy Request DTO to be updated
      * @return - Updated Policy
      */
     Policy updatePolicy(Integer id, PolicyRequest newPolicy);


     /** Deletes a Policy based a given id, if exist
      * @param id - Policy's id which should be deleted from db
      */
     void deletePolicy(Integer id);
}
