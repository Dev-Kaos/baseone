package com.app.baseone.security.presentation.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.app.baseone.security.business.service.interfaces.IUserBasicAuthService;
import com.app.baseone.security.presentation.dto.LoginRequestDTO;
import com.app.baseone.security.presentation.dto.PermissionInfoDTO;
import com.app.baseone.utilities.enums.StateEnum;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

        //TODO: REQUEST
    // find all permisos info

    @GetMapping("/info")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<PermissionInfoDTO>> verPermissionInfo() {

        return new ResponseEntity<>(this.userBasicAuthService.verPermissionInfo(), HttpStatus.OK);

    }

    // find all permisos info by id
    @GetMapping("/verId/{id}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<PermissionInfoDTO> verPermissionInfoById(@PathVariable Long id) {

        return new ResponseEntity<>(this.userBasicAuthService.verPermissionInfoById(id), HttpStatus.OK);

    }

    // find all permisos info by name containing
    @GetMapping("/verNombre/{name}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<PermissionInfoDTO>> verPermissionInfoByName(@PathVariable String name) {

        return new ResponseEntity<>(this.userBasicAuthService.verPermissionInfoByName(name), HttpStatus.OK);

    }

    // find all permisos info by name containing
    @GetMapping("/verEstado/{state}")
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

}
