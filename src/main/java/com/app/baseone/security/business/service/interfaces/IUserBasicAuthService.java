package com.app.baseone.security.business.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.baseone.security.presentation.dto.LoginRequestDTO;
import com.app.baseone.security.presentation.dto.PermissionInfoDTO;
import com.app.baseone.security.presentation.dto.RoleInfoDTO;
import com.app.baseone.utilities.enums.RoleEnum;
import com.app.baseone.utilities.enums.StateEnum;

@Service
public interface IUserBasicAuthService {

    LoginRequestDTO authenticateUser(LoginRequestDTO loginRequestDTO);

    // permission

    List<PermissionInfoDTO> verPermissionInfo();

    PermissionInfoDTO verPermissionInfoById(Long id);

    List<PermissionInfoDTO> verPermissionInfoByName(String name);

    List<PermissionInfoDTO> verPermissionInfoByState(StateEnum state);

    // Roles

    List<RoleInfoDTO> verRoleInfo();

    RoleInfoDTO verRoleInfoById(Long id);

    List<RoleInfoDTO> findByRoleNameContaining(RoleEnum role);

    List<RoleInfoDTO> findByState(StateEnum state);

}
