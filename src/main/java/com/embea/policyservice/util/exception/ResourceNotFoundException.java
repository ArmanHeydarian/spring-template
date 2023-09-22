package com.embea.policyservice.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{

    public ResourceNotFoundException(String resourceName) {
        super(String.format("resourceName: %s ",resourceName));
    }

    public ResourceNotFoundException(String resourceName, Integer resourceId) {
        super(String.format("resourceName: %s , resourceId: %d",resourceName, resourceId));
    }

    public ResourceNotFoundException(String resourceName, int[] resourceIds) {
        super(String.format("resourceName: %s , resourceIdList: %s",resourceName, Arrays.toString(resourceIds)));
    }
}