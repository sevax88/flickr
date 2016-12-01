package com.example.sebas.flickr.Utils;

import java.text.DateFormatSymbols;

/**
 * Created by Sebas on 22/11/2016.
 */

public class Utils {

    public static String changeDateformat(String datetaken) {
        if (datetaken!=null) {
            String[] fromSpace = datetaken.split("\\s+");
            String[] parts = fromSpace[0].split("-");
            Integer month = Integer.valueOf(parts[1]);
            String monthString = new DateFormatSymbols().getMonths()[month - 1].substring(0, 3);
            String fulldate = monthString + " ," + parts[1];
            return fulldate;
        }
        else
            return "";
    }

 }
