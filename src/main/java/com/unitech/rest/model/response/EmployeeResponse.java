package com.unitech.rest.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.unitech.rest.model.dto.EmployeeDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

    private List<EmployeeDto> employees;
}
