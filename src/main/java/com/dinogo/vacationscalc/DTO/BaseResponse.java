package com.dinogo.vacationscalc.DTO;

import com.dinogo.vacationscalc.exceptionhandling.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private boolean status;
    private T body;
    private Error error;
}
