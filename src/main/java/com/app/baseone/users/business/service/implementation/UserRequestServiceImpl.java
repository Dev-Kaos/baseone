package com.app.baseone.users.business.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.baseone.users.business.service.interfaces.IUserRequestService;
import com.app.baseone.users.domain.entity.UserEntity;
import com.app.baseone.users.persistence.repository.IUserRepository;
import com.app.baseone.users.presentation.dto.UserInfoDTO;
import com.app.baseone.utilities.enums.DocTypeEnum;
import com.app.baseone.utilities.enums.GenderEnum;
import com.app.baseone.utilities.enums.StateEnum;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserRequestServiceImpl implements IUserRequestService {

    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<UserInfoDTO> verUserInfo() {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());


    }

    @Override
    public UserInfoDTO verUserInfoById(Long id) {

        Optional<UserEntity> userEntity = this.userRepository.findById(id);

        if (userEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();

            UserEntity currentUser = userEntity.get();

            return modelMapper.map(currentUser, UserInfoDTO.class);

        } else {

            return new UserInfoDTO();

        }
        
    }

    @Override
    public List<UserInfoDTO> verUserInfoByNameContaining(String name) {

        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findByNameContaining(name)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<UserInfoDTO> verUserInfoBySurnameContaining(String surname) {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findBySurnameContaining(surname)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<UserInfoDTO> verUserInfoByDocType(DocTypeEnum docType) {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findByDocType(docType)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());
        
    }

    @Override
    public List<UserInfoDTO> verUserInfoByDocNumberContaining(String docNumber) {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findByDocNumberContaining(docNumber)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserInfoDTO> verUserInfoByEmailContaining(String email) {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findByEmailContaining(email)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<UserInfoDTO> verUserInfoByPhoneContaining(String phone) {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findByPhoneContaining(phone)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<UserInfoDTO> verUserInfoByGender(GenderEnum gender) {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findByGender(gender)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<UserInfoDTO> verUserInfoByNicknameContaining(String nickname) {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findByNicknameContaining(nickname)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<UserInfoDTO> verUserInfoByState(StateEnum state) {
        
        ModelMapper modelMapper = new ModelMapper();

        return this.userRepository.findByState(state)
                .stream()
                // .filter(permission -> permission.getName().contains(name))
                .map(entity -> modelMapper.map(entity, UserInfoDTO.class))
                .collect(Collectors.toList());

    }



}
