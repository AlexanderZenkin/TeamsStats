package com.example.teamsstats.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormater {

    public static String dateTimeFormatter(long timeEpochSecond, String patternFormat) {

        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(timeEpochSecond), ZoneId.of("Europe/Moscow")).format(DateTimeFormatter.ofPattern(patternFormat));
    }
}
