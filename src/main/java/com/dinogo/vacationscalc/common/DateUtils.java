package com.dinogo.vacationscalc.common;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.List;

public class DateUtils {

    private static final Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);

    // Может быть расширено в зависимости от региона
    public static final List<LocalDate> holidays = List.of(
            LocalDate.of(currentYear, Month.DECEMBER, 31),
            LocalDate.of(currentYear, Month.JANUARY, 1),
            LocalDate.of(currentYear, Month.JANUARY, 2),
            LocalDate.of(currentYear, Month.JANUARY, 3),
            LocalDate.of(currentYear, Month.JANUARY, 4),
            LocalDate.of(currentYear, Month.JANUARY, 5),
            LocalDate.of(currentYear, Month.JANUARY, 6),
            LocalDate.of(currentYear, Month.JANUARY, 7),
            LocalDate.of(currentYear, Month.FEBRUARY, 23),
            LocalDate.of(currentYear, Month.MARCH, 8)
    );
}
