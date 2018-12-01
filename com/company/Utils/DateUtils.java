package com.company.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String parseString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String string = dateFormat.format(date);
        return string;
    }

    public static Date parseDate(String string) throws ParseException {
        Date date = new SimpleDateFormat("dd/mm/yyyy").parse(string);
        return date;
    }
}
