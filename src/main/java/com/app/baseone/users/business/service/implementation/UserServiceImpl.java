package com.app.baseone.users.business.service.implementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.baseone.security.domain.entity.PermissionEntity;
import com.app.baseone.security.domain.entity.RoleEntity;
import com.app.baseone.security.domain.entity.UserBasicAuthEntity;
import com.app.baseone.security.persistence.repository.IRoleRepository;
import com.app.baseone.security.persistence.repository.IUserBasicAuthRepository;
import com.app.baseone.security.presentation.dto.PermissionInfoDTO;
import com.app.baseone.users.business.service.interfaces.IUserRequestService;
import com.app.baseone.users.business.service.interfaces.IUserService;
import com.app.baseone.users.domain.entity.UserEntity;
import com.app.baseone.users.persistence.repository.IUserRepository;
import com.app.baseone.users.presentation.dto.SaveUserDTO;
import com.app.baseone.users.presentation.dto.SaveUserRequestDTO;
import com.app.baseone.users.presentation.dto.UpdateUserDTO;
import com.app.baseone.users.presentation.dto.UserInfoDTO;
import com.app.baseone.utilities.enums.DocTypeEnum;
import com.app.baseone.utilities.enums.GenderEnum;
import com.app.baseone.utilities.enums.RoleEnum;
import com.app.baseone.utilities.enums.StateEnum;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserBasicAuthRepository userBasicAuthRepository;

    @Autowired
    private IRoleRepository roleRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public SaveUserRequestDTO saveUser(SaveUserDTO saveUserDTO) {

        try {

            // TODO: date formatter
            // String strDate = "2024-05-24"; // String representation of date
            // DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; // ISO-8601 date
            // format
            // Parse the String into a LocalDate object
            // LocalDate localDate = LocalDate.parse(strDate, formatter);

            // method
            String strDate = saveUserDTO.getBirthDate();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
            LocalDate localDate = LocalDate.parse(strDate, formatter);

            UserEntity userToSave = new UserEntity();

            String rol = saveUserDTO.getRol();
            List<RoleEntity> roles = roleRepository.findByNameContaining(RoleEnum.valueOf(rol));

            Set<RoleEntity> rolesSet = new HashSet<>();
            rolesSet.addAll(roles);

            userToSave.setName(saveUserDTO.getName());
            userToSave.setSurname(saveUserDTO.getSurname());
            userToSave.setDocType(DocTypeEnum.valueOf(saveUserDTO.getDocType().name()));
            userToSave.setDocNumber(saveUserDTO.getDocNumber());
            userToSave.setBirthDate(localDate);
            userToSave.setEmail(saveUserDTO.getEmail());
            userToSave.setPhone(saveUserDTO.getPhone());
            userToSave.setGender(GenderEnum.valueOf(saveUserDTO.getGender().name()));
            userToSave.setProfileImage(saveUserDTO.getProfileImage());
            userToSave.setNickname(saveUserDTO.getNickname());
            userToSave.setState(StateEnum.ACTIVO);
            userToSave.setUsername(saveUserDTO.getUsername());
            userToSave.setPassword(saveUserDTO.getPassword());
            userToSave.setEnabled(true);
            userToSave.setAccountNoExpired(true);
            userToSave.setAccountNoLocked(true);
            userToSave.setCredentialNoExpired(true);
            userToSave.setRoles(rolesSet);

            userRepository.save(userToSave);

            SaveUserRequestDTO responseDTO = new SaveUserRequestDTO();
            responseDTO.setName(userToSave.getName());
            responseDTO.setSurname(userToSave.getSurname());
            responseDTO.setRol(rol);

            modelMapper.map(responseDTO, SaveUserDTO.class);

            return responseDTO;
            // method
            // String strDate = saveUserDTO.getBirthDate();
            // DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
            // LocalDate localDate = LocalDate.parse(strDate, formatter);

            // UserEntity savedUser = new UserEntity();
            // UserBasicAuthEntity savedUserAuth = new UserBasicAuthEntity();

            // String rol = saveUserDTO.getRol();
            // List<RoleEntity> roles =
            // roleRepository.findByNameContaining(RoleEnum.valueOf(rol));

            // Set<RoleEntity> rolesSet = new HashSet<>();
            // rolesSet.addAll(roles);

            // savedUser.setName(saveUserDTO.getName());
            // savedUser.setSurname(saveUserDTO.getSurname());
            // savedUser.setDocType(DocTypeEnum.valueOf(saveUserDTO.getDocType().name()));
            // savedUser.setDocNumber(saveUserDTO.getDocNumber());
            // savedUser.setBirthDate(localDate);
            // savedUser.setEmail(saveUserDTO.getEmail());
            // savedUser.setPhone(saveUserDTO.getPhone());
            // savedUser.setGender(GenderEnum.valueOf(saveUserDTO.getGender().name()));
            // savedUser.setProfileImage(saveUserDTO.getProfileImage());
            // savedUser.setNickname(saveUserDTO.getNickname());
            // savedUser.setState(StateEnum.ACTIVO);
            // savedUserAuth.setUsername(saveUserDTO.getUsername());
            // savedUserAuth.setPassword(saveUserDTO.getPassword());
            // savedUserAuth.setEnabled(true);
            // savedUserAuth.setAccountNoExpired(true);
            // savedUserAuth.setAccountNoLocked(true);
            // savedUserAuth.setCredentialNoExpired(true);
            // savedUserAuth.setRoles(rolesSet);

            // savedUser.setUserAuth(savedUserAuth);
            // savedUserAuth.setUser(savedUser);
            // userRepository.save(savedUser);

            // SaveUserRequestDTO responseDTO = new SaveUserRequestDTO();
            // responseDTO.setName(savedUser.getName());
            // responseDTO.setSurname(savedUser.getSurname());
            // responseDTO.setRol(rol);

            // modelMapper.map(responseDTO, SaveUserDTO.class);

        } catch (Exception e) {

            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
    }

    @Override
    public String updateUser(Long id, UpdateUserDTO updateUserDTO) {

        Optional<UserEntity> updateUserEntity = userRepository.findById(id);

        if (updateUserEntity.isPresent()) {

            String strDate = updateUserDTO.getBirthDate();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
            LocalDate localDate = LocalDate.parse(strDate, formatter);

            UserEntity updatedUser = updateUserEntity.get();
            Optional<UserBasicAuthEntity> savedUserAuth = userBasicAuthRepository.findById(id);

            updatedUser.setName(updateUserDTO.getName());
            updatedUser.setSurname(updateUserDTO.getSurname());
            updatedUser.setDocType(DocTypeEnum.valueOf(updateUserDTO.getDocType().name()));
            updatedUser.setDocNumber(updateUserDTO.getDocNumber());
            updatedUser.setBirthDate(localDate);
            updatedUser.setEmail(updateUserDTO.getEmail());
            updatedUser.setPhone(updateUserDTO.getPhone());
            updatedUser.setGender(GenderEnum.valueOf(updateUserDTO.getGender().name()));
            updatedUser.setProfileImage(updateUserDTO.getProfileImage());
            updatedUser.setNickname(updateUserDTO.getNickname());
            updatedUser.setState(StateEnum.valueOf(updateUserDTO.getState().name()));

            userRepository.save(updatedUser);

            // Update using Setters (if values are allowed to be updated)
            // if (permissionInfoDTO.getName() != null) { // Check if name update is allowed
            // throw new IllegalArgumentException("Name cannot be updated"); // Since name
            // is updatable=false
            // }
            // permissionEntity.setState(StateEnum.valueOf(permissionInfoDTO.getState().name()));
            String userInfo = updatedUser.getName() + " " + updatedUser.getSurname();
            String responseString = "El usuario : " + userInfo + ". ha sido Modificado";

            return responseString;
        } else {
            throw new IllegalArgumentException("No se pudo moficar el Usuario");
        }

    }

    @Override
    public String deleteUser(Long id) {

        Optional<UserEntity> deleteUserEntity = userRepository.findById(id);

        if (deleteUserEntity.isPresent()) {

            UserEntity entityToDelete = deleteUserEntity.get();
            

            this.userRepository.delete(entityToDelete);

            return "El usuario ha sido borrado.";

        } else {

            return "No se encontro el usuario que deseas borrar.";

        }

    }

}
