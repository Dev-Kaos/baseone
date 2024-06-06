package com.app.baseone.users.presentation.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.app.baseone.security.presentation.dto.PermissionInfoDTO;
import com.app.baseone.users.business.service.interfaces.IUserRequestService;
import com.app.baseone.users.business.service.interfaces.IUserService;
import com.app.baseone.users.presentation.dto.SaveUserDTO;
import com.app.baseone.users.presentation.dto.SaveUserRequestDTO;
import com.app.baseone.users.presentation.dto.UpdateUserDTO;
import com.app.baseone.users.presentation.dto.UserInfoDTO;
import com.app.baseone.utilities.enums.DocTypeEnum;
import com.app.baseone.utilities.enums.GenderEnum;
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
@RequestMapping("/usuarios")
@PreAuthorize("denyAll()")
public class UserController {

    @Autowired
    private IUserRequestService userRequestService;

    @Autowired
    private IUserService userService;

    // find all
    @GetMapping("/verInfo")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUsuarios() {

        return new ResponseEntity<>(this.userRequestService.verUserInfo(), HttpStatus.OK);

    }

    // find by id
    @PreAuthorize("hasAuthority('LEER')")
    @GetMapping("/verId/{id}")
    public ResponseEntity<UserInfoDTO> verUserInfoById(@PathVariable Long id) {

        return new ResponseEntity<>(this.userRequestService.verUserInfoById(id), HttpStatus.OK);

    }

    // find all user info by name containing
    @GetMapping("/verNombre/{name}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoByNameContaining(@PathVariable String name) {

        return new ResponseEntity<>(this.userRequestService.verUserInfoByNameContaining(name), HttpStatus.OK);

    }

    // find all user info by surname containing
    @GetMapping("/verApellido/{surname}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoBySurnameContaining(@PathVariable String surname) {

        return new ResponseEntity<>(this.userRequestService.verUserInfoBySurnameContaining(surname), HttpStatus.OK);

    }

    // find all users by docType
    @GetMapping("/verTipoDocumento/{docType}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoByDocType(@PathVariable String docType) {

        DocTypeEnum[] doctypes = DocTypeEnum.values();

        for (DocTypeEnum doctype1 : doctypes) {
            if (doctype1.name().equals(docType)) {

                DocTypeEnum docTypeEnum = DocTypeEnum.valueOf(docType);

                return new ResponseEntity<>(this.userRequestService.verUserInfoByDocType(docTypeEnum),
                        HttpStatus.OK);

            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // find all user info by doc Number
    @GetMapping("/verDocumento/{docNumber}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoByDocNumberContaining(@PathVariable String docNumber) {

        return new ResponseEntity<>(this.userRequestService.verUserInfoByDocNumberContaining(docNumber), HttpStatus.OK);

    }

    // find all user info by email
    @GetMapping("/verEmail/{email}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoByEmailContaining(@PathVariable String email) {

        return new ResponseEntity<>(this.userRequestService.verUserInfoByEmailContaining(email), HttpStatus.OK);

    }

    // find all user info by phone
    @GetMapping("/verTelefono/{phone}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoByPhoneContaining(@PathVariable String phone) {

        return new ResponseEntity<>(this.userRequestService.verUserInfoByPhoneContaining(phone), HttpStatus.OK);

    }

    // find all users by gender
    @GetMapping("/verGenero/{gender}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoByGender(@PathVariable String gender) {

        GenderEnum[] genders = GenderEnum.values();

        for (GenderEnum gender1 : genders) {
            if (gender1.name().equals(gender)) {

                GenderEnum genderEnum = GenderEnum.valueOf(gender);

                return new ResponseEntity<>(this.userRequestService.verUserInfoByGender(genderEnum),
                        HttpStatus.OK);

            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // find all user info by nickname
    @GetMapping("/verApodo/{nickname}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoByNicknameContaining(@PathVariable String nickname) {

        return new ResponseEntity<>(this.userRequestService.verUserInfoByNicknameContaining(nickname), HttpStatus.OK);

    }

    // find all users by estado
    @GetMapping("/verEstado/{state}")
    @PreAuthorize("hasAuthority('LEER')")
    public ResponseEntity<List<UserInfoDTO>> verUserInfoByState(@PathVariable String state) {

        StateEnum[] states = StateEnum.values();

        for (StateEnum state1 : states) {
            if (state1.name().equals(state)) {

                StateEnum stateEnum = StateEnum.valueOf(state);

                return new ResponseEntity<>(this.userRequestService.verUserInfoByState(stateEnum),
                        HttpStatus.OK);

            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // create user
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('CREAR')")
    public ResponseEntity<SaveUserRequestDTO> save(@RequestBody SaveUserDTO saveUserDTO) {

        return new ResponseEntity<>(this.userService.saveUser(saveUserDTO), HttpStatus.CREATED);

    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('ACTUALIZAR')")
    public ResponseEntity<String> update(@RequestBody UpdateUserDTO updateUserDTO, @PathVariable Long id) {

        return new ResponseEntity<>(this.userService.updateUser(id, updateUserDTO), HttpStatus.OK);

    }

    // @DeleteMapping("/borrar/{id}")
    // @PreAuthorize("hasAuthority('DELETE')")
    // public ResponseEntity<String> delete(@PathVariable Long id) {
    // return new ResponseEntity<>(this.userService.delete(id),
    // HttpStatus.NO_CONTENT);
    // }

}
