package com.app.baseone.users.business.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.baseone.users.presentation.dto.UserInfoDTO;
import com.app.baseone.utilities.enums.DocTypeEnum;
import com.app.baseone.utilities.enums.GenderEnum;
import com.app.baseone.utilities.enums.StateEnum;

@Service
public interface IUserRequestService {

    List<UserInfoDTO> verUserInfo();

    UserInfoDTO verUserInfoById(Long id);

    List<UserInfoDTO> verUserInfoByNameContaining(String name);

    List<UserInfoDTO> verUserInfoBySurnameContaining(String surname);

    List<UserInfoDTO> verUserInfoByDocType(DocTypeEnum docType);

    List<UserInfoDTO> verUserInfoByDocNumberContaining(String docNumber);

    List<UserInfoDTO> verUserInfoByEmailContaining(String email);

    List<UserInfoDTO> verUserInfoByPhoneContaining(String phone);

    List<UserInfoDTO> verUserInfoByGender(GenderEnum gender);

    List<UserInfoDTO> verUserInfoByNicknameContaining(String nickname);

    // TODO: hacer el metodo para fecha de nacimiento

    List<UserInfoDTO> verUserInfoByState(StateEnum state);
}
