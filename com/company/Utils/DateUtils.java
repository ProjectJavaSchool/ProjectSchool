package com.company.Utils;

import com.company.Command;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String parseString(Date date){
        DateFormat dateFormat = new SimpleDateFormat(Command.DATEFORMAT);
        String string = dateFormat.format(date);
        return string;
    }

    public static Date parseDate(String string) throws ParseException {
        Date date = new SimpleDateFormat(Command.DATEFORMAT).parse(string);
        return date;
    }
}
