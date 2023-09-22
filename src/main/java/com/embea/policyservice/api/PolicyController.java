package com.embea.policyservice.api;

import com.embea.policyservice.domain.Policy;
import com.embea.policyservice.domain.dto.PolicyRequest;
import com.embea.policyservice.service.interfaces.IPolicyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/policy")
public class PolicyController {
    private IPolicyService policyService;

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies()
    {
        return new ResponseEntity<>(policyService.getAllPolicies(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Policy> addPolicy(@RequestBody @Valid PolicyRequest newPolicy)
    {
        return new ResponseEntity<>(policyService.addPolicy(newPolicy), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable("id") Integer id,  @RequestBody @Valid PolicyRequest newPolicy)
    {
        return ResponseEntity.ok(policyService.updatePolicy(id, newPolicy));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePolicy(@PathVariable("id")  Integer id) {
        policyService.deletePolicy(id);
    }
}
