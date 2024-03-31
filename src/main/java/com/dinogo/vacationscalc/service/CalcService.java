package com.dinogo.vacationscalc.service;

import com.dinogo.vacationscalc.DTO.CalcRs;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CalcService {
    CalcRs getCompensationSum(BigDecimal averageSalary,
                              Integer vacationDays,
                              LocalDate from,
                              LocalDate to);
}
