package com.dinogo.vacationscalc;

import com.dinogo.vacationscalc.DTO.CalcRs;
import com.dinogo.vacationscalc.exceptionhandling.CalcException;
import com.dinogo.vacationscalc.service.CalcService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class CalculateTest {

    @Autowired
    private CalcService service;

    private BigDecimal salary;

    @BeforeEach
    public void startUp() {
        salary = BigDecimal.valueOf(Math.random());
    }

    @Test
    public void shouldCalculateCorrectlyWithoutDates() {
        BigDecimal expected = salary.divide(BigDecimal.valueOf(29.3), RoundingMode.FLOOR);

        CalcRs compensation = service.getCompensationSum(
                salary, 1, null, null);
        Assertions.assertNotNull(compensation);
        Assertions.assertNotNull(compensation.getCompensationSum());
        Assertions.assertEquals(expected, compensation.getCompensationSum());
    }

    @Test
    public void shouldCalculateCorrectlyWithDates() {
        BigDecimal expected = salary.divide(BigDecimal.valueOf(29.3), RoundingMode.FLOOR).multiply(BigDecimal.valueOf(3));

        CalcRs compensation = service.getCompensationSum(
                salary, 10,
                LocalDate.of(2024, Month.JANUARY, 1),
                LocalDate.of(2024, Month.JANUARY, 10));
        Assertions.assertNotNull(compensation);
        Assertions.assertNotNull(compensation.getCompensationSum());
        Assertions.assertEquals(expected, compensation.getCompensationSum());
    }

    @Test
    public void shouldThrowErrorForBiggerVacation() {
        Assertions.assertThrows(CalcException.class, () -> service.getCompensationSum(salary, 100,
                LocalDate.of(2024, Month.JANUARY, 1),
                LocalDate.of(2024, Month.JANUARY, 31)));
    }

    @Test
    public void shouldThrowErrorForIllegalArguments() {
        Assertions.assertThrows(CalcException.class, () -> service.getCompensationSum(salary, 1,
                LocalDate.of(2024, Month.JANUARY, 31),
                LocalDate.of(2024, Month.DECEMBER, 31)));
    }
}
