package com.app.baseone.security.presentation.dto;

import java.util.Set;

import com.app.baseone.utilities.enums.RoleEnum;
import com.app.baseone.utilities.enums.StateEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfoDTO {

    private Long id;

    private RoleEnum name;

    private StateEnum state;

}
