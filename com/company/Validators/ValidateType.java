package com.company.Validators;

public enum ValidateType {
    STUDENT_ID_VALIDATE_TYPE("^G[CT][0-9]{5}"),
    LECTURER_ID_VALIDATE_TYPE("[0-9]{8}");

    private String validateValue;

    ValidateType(String validateValue) {
        this.validateValue = validateValue;
    }

    public String getValidateValue() {
        return validateValue;
    }

    public void setValidateValue(String validateValue) {
        this.validateValue = validateValue;
    }
}
