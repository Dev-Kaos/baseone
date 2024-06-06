package com.app.baseone.users.business.service.interfaces;

import org.springframework.stereotype.Service;

import com.app.baseone.users.presentation.dto.SaveUserDTO;
import com.app.baseone.users.presentation.dto.SaveUserRequestDTO;
import com.app.baseone.users.presentation.dto.UpdateUserDTO;

@Service
public interface IUserService {

    // CRUD

    SaveUserRequestDTO saveUser(SaveUserDTO saveUserDTO);

    String updateUser(Long id, UpdateUserDTO UpdateUserDTO);

    String deleteUser(Long id);

}
