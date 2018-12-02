package com.company.Validators;

public enum ValidateType {
    NO_VALIDATE_TYPE("*"),
    STUDENT_ID_VALIDATE_TYPE("^G[CT][0-9]{5}"),
    LECTURER_ID_VALIDATE_TYPE("^[0-9]{8}"),
    NAME_VALIDATE_TYPE("^([A-Z][a-z]* )*[A-Z][a-z]*"),
    DATE_VALIDATE_TYPE("^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$"),
    EMAIL_VALIDATE_TYPE("^(\\w+[\\.\\-\\_]?)+(\\w+)@([A-Za-z]+[\\-]*)+([A-Za-z]+)(\\.([A-Za-z]+[\\-]*)+([A-Za-z]+))+$"),
    PHONE_VALIDATE_TYPE("^0[1-9][0-9]{7}");

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
