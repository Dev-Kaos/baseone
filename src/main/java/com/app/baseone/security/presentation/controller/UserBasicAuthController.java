package com.app.baseone.security.presentation.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.app.baseone.security.business.service.interfaces.IUserBasicAuthService;
import com.app.baseone.security.presentation.dto.PermissionInfoDTO;
import com.app.baseone.security.presentation.dto.RoleInfoDTO;
import com.app.baseone.utilities.enums.RoleEnum;
import com.app.baseone.utilities.enums.StateEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/seguridad")
@PreAuthorize("denyAll()")
public class UserBasicAuthController {

    @Autowired
    private IUserBasicAuthService userBasicAuthService;
    // fauth
    // @GetMapping("/info")
    // @PreAuthorize("hasAuthority('LEER')")
    // public ResponseEntity<LoginRequestDTO> authenticateUser(@RequestBody
    // LoginRequestDTO loginRequestDTO) {

    // return new
    // ResponseEntity<>(this.userBasicAuthService.authenticateUser(loginRequestDTO),
    // HttpStatus.OK);

    // }

    // TODO: PERMISOS
    // find all permisos info

    @GetMapping("/permisos/info")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<PermissionInfoDTO>> verPermissionInfo() {

        return new ResponseEntity<>(this.userBasicAuthService.verPermissionInfo(), HttpStatus.OK);

    }

    // find all permisos info by id
    @GetMapping("/permisos/verId/{id}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<PermissionInfoDTO> verPermissionInfoById(@PathVariable Long id) {

        return new ResponseEntity<>(this.userBasicAuthService.verPermissionInfoById(id), HttpStatus.OK);

    }

    // find all permisos info by name containing
    @GetMapping("/permisos/verNombre/{name}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<PermissionInfoDTO>> verPermissionInfoByName(@PathVariable String name) {

        return new ResponseEntity<>(this.userBasicAuthService.verPermissionInfoByName(name), HttpStatus.OK);

    }

    // find all permisos info by name containing
    @GetMapping("/permisos/verEstado/{state}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<PermissionInfoDTO>> verPermissionInfoByState(@PathVariable String state) {

        StateEnum[] states = StateEnum.values();
        for (StateEnum state1 : states) {
            if (state1.name().equals(state)) {

                StateEnum stateEnum = StateEnum.valueOf(state);

                return new ResponseEntity<>(this.userBasicAuthService.verPermissionInfoByState(stateEnum),
                        HttpStatus.OK);

            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // TODO: ROLES

    // find all roles info
    @GetMapping("/roles/info")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<RoleInfoDTO>> verRoleInfo() {

        return new ResponseEntity<>(this.userBasicAuthService.verRoleInfo(), HttpStatus.OK);

    }

    // find all roles info by id
    @GetMapping("/roles/verId/{id}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<RoleInfoDTO> verRoleInfoById(@PathVariable Long id) {

        return new ResponseEntity<>(this.userBasicAuthService.verRoleInfoById(id), HttpStatus.OK);

    }

    // find all roles info by name containing
    @GetMapping("/roles/verNombre/{role}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<RoleInfoDTO>> verRoleByRoleName(@PathVariable String role) {

        RoleEnum[] roles = RoleEnum.values();
        for (RoleEnum role1 : roles) {
            if (role1.name().equals(role)) {

                RoleEnum roleEnum = RoleEnum.valueOf(role);

                return new ResponseEntity<>(this.userBasicAuthService.findByRoleNameContaining(roleEnum),
                        HttpStatus.OK);

            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // find all permisos info by name containing
    @GetMapping("/roles/verEstado/{state}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<RoleInfoDTO>> verRoleByState(@PathVariable String state) {

        StateEnum[] states = StateEnum.values();
        for (StateEnum state1 : states) {
            if (state1.name().equals(state)) {

                StateEnum stateEnum = StateEnum.valueOf(state);

                return new ResponseEntity<>(this.userBasicAuthService.findByState(stateEnum),
                        HttpStatus.OK);

            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
