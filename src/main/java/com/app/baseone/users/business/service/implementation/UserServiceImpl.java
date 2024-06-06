package com.app.baseone.users.business.service.implementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.baseone.security.domain.entity.RoleEntity;
import com.app.baseone.security.domain.entity.UserBasicAuthEntity;
import com.app.baseone.security.persistence.repository.IRoleRepository;
import com.app.baseone.security.persistence.repository.IUserBasicAuthRepository;
import com.app.baseone.users.business.service.interfaces.IUserRequestService;
import com.app.baseone.users.business.service.interfaces.IUserService;
import com.app.baseone.users.domain.entity.UserEntity;
import com.app.baseone.users.persistence.repository.IUserRepository;
import com.app.baseone.users.presentation.dto.SaveUserDTO;
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
    private  IUserBasicAuthRepository userBasicAuthRepository;

    @Autowired
    private IRoleRepository roleRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public SaveUserDTO saveUser(SaveUserDTO saveUserDTO) {
        
        try {

            // TODO: date formatter
			// String strDate = "2024-05-24"; // String representation of date
			// DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; // ISO-8601 date format

			// // Parse the String into a LocalDate object
			// LocalDate localDate = LocalDate.parse(strDate, formatter);
             String strDate = saveUserDTO.getBirthDate();
             DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
             LocalDate localDate = LocalDate.parse(strDate, formatter);

            UserEntity savedUser = new UserEntity();
            UserBasicAuthEntity savedUserAuth = new UserBasicAuthEntity();
            
            String rol = saveUserDTO.getRol();
            List<RoleEntity> roles = roleRepository.findByNameContaining(RoleEnum.valueOf(rol));

            Set<RoleEntity> rolesSet = new HashSet<>();
            rolesSet.addAll(roles);
            

            savedUser.setName(saveUserDTO.getName());
            savedUser.setSurname(saveUserDTO.getSurname());
            savedUser.setDocType(DocTypeEnum.valueOf(saveUserDTO.getDocType().name()));
            savedUser.setDocNumber(saveUserDTO.getDocNumber());
            savedUser.setBirthDate(localDate);
            savedUser.setEmail(saveUserDTO.getEmail());
            savedUser.setPhone(saveUserDTO.getPhone());
            savedUser.setGender(GenderEnum.valueOf(saveUserDTO.getGender().name()));
            savedUser.setProfileImage(saveUserDTO.getProfileImage());
            savedUser.setNickname(saveUserDTO.getNickname());
            savedUser.setState(StateEnum.ACTIVO);
            savedUserAuth.setUsername(saveUserDTO.getUsername());
            savedUserAuth.setPassword(saveUserDTO.getPassword());
            savedUserAuth.setEnabled(true);
            savedUserAuth.setAccountNoExpired(true);
            savedUserAuth.setAccountNoLocked(true);
            savedUserAuth.setCredentialNoExpired(true);
            savedUserAuth.setRoles(rolesSet);

            savedUser.setUserAuth(savedUserAuth);
            savedUserAuth.setUser(savedUser);
            userRepository.save(savedUser);




            // UserEntity userManuel = new UserEntity();
			// userManuel.setName("manuel");
			// userManuel.setSurname("vela");
			// userManuel.setDocType(DocTypeEnum.CEDULA_CIUDADANIA);
			// userManuel.setDocNumber("12345678");
			// userManuel.setBirthDate(localDate);
			// userManuel.setEmail("email@gmail.com");
			// userManuel.setPhone("3452345235");
			// userManuel.setGender(GenderEnum.MASCULINO);
			// userManuel.setProfileImage("urldelaImagen");
			// userManuel.setNickname("kaos");
			// userManuel.setState(StateEnum.ACTIVO);

			// UserBasicAuthEntity userAuthManuel = new UserBasicAuthEntity();
			// userAuthManuel.setUsername("manuel");
			// userAuthManuel.setPassword("1234");
			// userAuthManuel.setEnabled(true);
			// userAuthManuel.setAccountNoExpired(true);
			// userAuthManuel.setAccountNoLocked(true);
			// userAuthManuel.setCredentialNoExpired(true);
			// // userAuthManuel.setRoles(Set.of(rolDesarrollador, rolAdministrador));

			// userManuel.setUserAuth(userAuthManuel);
			// userAuthManuel.setUser(userManuel);
			// // userRepository.save(userManuel);

           
        
            

            return saveUserDTO;

        } catch (Exception e) {

            throw new UnsupportedOperationException("Error al guardar el usuario");
        }
    }

    @Override
    public SaveUserDTO updateUser(Long id, SaveUserDTO SaveUserDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public String deleteUser(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }



    

}
