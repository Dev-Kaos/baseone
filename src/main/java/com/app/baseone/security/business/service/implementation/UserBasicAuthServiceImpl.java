package com.app.baseone.security.business.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.baseone.security.business.service.interfaces.IUserBasicAuthService;
import com.app.baseone.security.domain.entity.PermissionEntity;
import com.app.baseone.security.domain.entity.RoleEntity;
import com.app.baseone.security.domain.entity.UserBasicAuthEntity;
import com.app.baseone.security.persistence.repository.IPermissionRepository;
import com.app.baseone.security.persistence.repository.IRoleRepository;
import com.app.baseone.security.persistence.repository.IUserBasicAuthRepository;
import com.app.baseone.security.presentation.dto.LoginRequestDTO;
import com.app.baseone.security.presentation.dto.PermissionInfoDTO;
import com.app.baseone.security.presentation.dto.RoleInfoDTO;
import com.app.baseone.utilities.enums.RoleEnum;
import com.app.baseone.utilities.enums.StateEnum;

@Service
public class UserBasicAuthServiceImpl implements IUserBasicAuthService {

    @Autowired
    private IUserBasicAuthRepository basicAuthRepository;

    @Autowired
    private IPermissionRepository permissionRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public LoginRequestDTO authenticateUser(LoginRequestDTO loginRequestDTO) {

        String username;
        String password;
        username = loginRequestDTO.getUsername();
        password = loginRequestDTO.getPassword();

        Optional<UserBasicAuthEntity> userEntity = this.basicAuthRepository.findByUsername(username);
        if (userEntity.isPresent()) {

            // TODO: Agregar el metoho de encriptacion y coomprobacion de la encriptacion

            if (userEntity.get().getPassword().equals(password)) {

                

            }

        }

        return null;

    }

    // TODO: PERMISOS

    @Override
    public List<PermissionInfoDTO> verPermissionInfo() {

        ModelMapper modelMapper = new ModelMapper();
        return this.permissionRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, PermissionInfoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public PermissionInfoDTO verPermissionInfoById(Long id) {

        Optional<PermissionEntity> permissionEntity = this.permissionRepository.findById(id);

        if (permissionEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            PermissionEntity currentPermissionEntity = permissionEntity.get();

            return modelMapper.map(currentPermissionEntity, PermissionInfoDTO.class);

        } else {

            return new PermissionInfoDTO();

        }

    }

    @Override
    public List<PermissionInfoDTO> verPermissionInfoByName(String name) {

        ModelMapper modelMapper = new ModelMapper();

        return this.permissionRepository.findByNameContaining(name)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, PermissionInfoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PermissionInfoDTO> verPermissionInfoByState(StateEnum state) {

        ModelMapper modelMapper = new ModelMapper();

        return this.permissionRepository.findByState(state)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, PermissionInfoDTO.class))
                .collect(Collectors.toList());

    }

    // TODO: ROLES

    @Override
    public List<RoleInfoDTO> verRoleInfo() {

        ModelMapper modelMapper = new ModelMapper();
        return this.roleRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, RoleInfoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleInfoDTO verRoleInfoById(Long id) {

        Optional<RoleEntity> roleEntity = this.roleRepository.findById(id);

        if (roleEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            RoleEntity currentRoleEntity = roleEntity.get();

            return modelMapper.map(currentRoleEntity, RoleInfoDTO.class);

        } else {

            return new RoleInfoDTO();

        }
    }

    @Override
    public List<RoleInfoDTO> findByRoleNameContaining(RoleEnum role) {

        ModelMapper modelMapper = new ModelMapper();

        return this.roleRepository.findByNameContaining(role)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, RoleInfoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoleInfoDTO> findByState(StateEnum state) {

        ModelMapper modelMapper = new ModelMapper();

        return this.roleRepository.findByState(state)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, RoleInfoDTO.class))
                .collect(Collectors.toList());
    }

}
