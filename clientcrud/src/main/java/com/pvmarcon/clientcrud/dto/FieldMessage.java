package com.pvmarcon.clientcrud.dto;

public record FieldMessage(String fieldName, String message) {
    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    @Override
    public String fieldName() {
        return fieldName;
    }

    @Override
    public String message() {
        return message;
    }
}
