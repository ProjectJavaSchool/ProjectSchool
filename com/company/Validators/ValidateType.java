package com.company.Validators;

public enum ValidateType {
    NO_VALIDATE_TYPE("*"),
    STUDENT_ID_VALIDATE_TYPE("^G[CT][0-9]{5}"),
    LECTURER_ID_VALIDATE_TYPE("[0-9]{8}"),
    DATE_VALIDATE_TYPE(""),
    EMAIL_VALIDATE_TYPE(""),
    PHONE_VALIDATE_TYPE("");

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
