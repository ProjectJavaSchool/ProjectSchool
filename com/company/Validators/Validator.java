package com.company.Validators;

import com.company.Command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isSuccessfullyValidated(String validatedString, ValidateType type) {
        Pattern pattern = Pattern.compile(type.getValidateValue());
        Matcher matcher = pattern.matcher(validatedString);
        if(!matcher.matches()) Command.writeln(Command.NOT_VALID_NUMBER_INPUT);
        return matcher.matches();
    }
}
