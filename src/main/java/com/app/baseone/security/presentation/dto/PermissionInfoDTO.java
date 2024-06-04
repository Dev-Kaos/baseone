package com.app.baseone.security.presentation.dto;

import com.app.baseone.utilities.enums.StateEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionInfoDTO {

    private Long id;

    private String name;

    private StateEnum state;
}
