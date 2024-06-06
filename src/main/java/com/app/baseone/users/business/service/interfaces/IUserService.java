package com.app.baseone.users.business.service.interfaces;

import org.springframework.stereotype.Service;

import com.app.baseone.users.presentation.dto.SaveUserDTO;

@Service
public interface IUserService {

    // CRUD

    SaveUserDTO saveUser(SaveUserDTO saveUserDTO);

    SaveUserDTO updateUser(Long id, SaveUserDTO SaveUserDTO);

    String deleteUser(Long id);

}
