package com.dinogo.vacationscalc.controller;

import com.dinogo.vacationscalc.DTO.CalcRs;
import com.dinogo.vacationscalc.service.CalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CalcController {
    private final CalcService calcService;

    @GetMapping("/calculate")
    public CalcRs getCompensationSum (@RequestParam @NotNull BigDecimal averageSalary,
                                      @RequestParam @NotNull Integer vacationDays,
                                      @RequestParam(required = false) LocalDate from,
                                      @RequestParam(required = false) LocalDate to) {
        return calcService.getCompensationSum(averageSalary, vacationDays, from, to);
    }
}
