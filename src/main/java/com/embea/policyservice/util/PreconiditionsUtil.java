package com.embea.policyservice.util;

import com.embea.policyservice.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * preconditions.
 */
public class PreconiditionsUtil {

    /**
     * Throws a {@link ResourceNotFoundException} when the target arugment is null.
     * The resource id is a string to support compound primary keys in cassandra.
     *
     * @param obj object to check
     * @param resourceName resource name
     * @param resourceId source's id
     */
    public static void checkNotNull(Object obj, String resourceName, Integer resourceId) {
        if (obj == null) {
            throw new ResourceNotFoundException(resourceName, resourceId);
        }
    }

    public static  <T> T  getResourceIfPresentElseThrowException(Optional<T> object, String resourceName, Integer resourceId) {
        if (object.isPresent()) {
            return object.get();
        } else {
            throw new ResourceNotFoundException(resourceName , resourceId);
        }
    }

    public static <T> List<T> getListOfSourcesIfPresentElseThrowException(List<T> objectList, String resourceName, int [] resourceId) {
        if (objectList!= null && !objectList.isEmpty() && (resourceId == null || objectList.size()==resourceId.length)) {
            return objectList;
        } else {
            throw new ResourceNotFoundException(resourceName , resourceId);
        }
    }
    public static <T> List<T> getListOfSourcesIfPresentElseThrowException(List<T> objectList, String resourceName) {
        if (objectList!= null && !objectList.isEmpty()) {
            return objectList;
        } else {
            throw new ResourceNotFoundException(resourceName);
        }
    }
}
