package com.app.baseone.security.presentation.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

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

    
    @GetMapping("/funciona")
    @PreAuthorize("permitAll()")
    public String funciona() {
        return "funciona";
    }
    
    @GetMapping("/seguridad")
    @PreAuthorize("hasAuthority('CREAR')")
    public String seguridad() {
        return "seguridad";
    }

}
