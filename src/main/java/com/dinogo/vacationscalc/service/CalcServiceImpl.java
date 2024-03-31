package com.dinogo.vacationscalc.service;

import com.dinogo.vacationscalc.DTO.CalcRs;
import com.dinogo.vacationscalc.common.DateUtils;
import com.dinogo.vacationscalc.exceptionhandling.CalcException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class CalcServiceImpl implements CalcService{

    @Override
    public CalcRs getCompensationSum(BigDecimal averageSalary,
                                     Integer vacationDays, LocalDate from,
                                     LocalDate to) {
        if(vacationDays > 28) {
            throw new CalcException("Невозможно взять отпуск больше 28 дней");
        }
        if (from != null && to != null) {
            if (from.minusDays(1).datesUntil(to).count() != vacationDays) {
                throw new CalcException("Неверное кол-во дней");
            }
            vacationDays = countBusinessDaysBetween(from, to).intValue();
        }

        BigDecimal compensationSum = averageSalary
                .divide(BigDecimal.valueOf(29.3), RoundingMode.FLOOR)
                .multiply(BigDecimal.valueOf(vacationDays));

        return new CalcRs(compensationSum);
    }

    private Long countBusinessDaysBetween(LocalDate fromDate, LocalDate toDate) {
        return fromDate.minusDays(1).datesUntil(toDate)
                .filter(date -> (date.getDayOfWeek() != DayOfWeek.SATURDAY
                        && date.getDayOfWeek() != DayOfWeek.SUNDAY)
                        && !DateUtils.holidays.contains(date))
                .count() + 1;
    }
}
