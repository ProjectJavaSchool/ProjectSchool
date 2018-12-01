package com.company.Utils;

import com.company.Command;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    static DateFormat dateFormat = new SimpleDateFormat(Command.DATEFORMAT);

    public static String parseString(Date date){
        return dateFormat.format(date);
    }

    public static Date parseDate(String string) throws ParseException {
        return dateFormat.parse(string);
    }
}
