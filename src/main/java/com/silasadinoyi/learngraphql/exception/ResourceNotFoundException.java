package com.silasadinoyi.learngraphql.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceType, Object id) {
        super("Resource " + resourceType + " with id " + id + " not found");
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
