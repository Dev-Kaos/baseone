package com.app.baseone.users.presentation.dto;


import com.app.baseone.utilities.enums.DocTypeEnum;
import com.app.baseone.utilities.enums.GenderEnum;
import com.app.baseone.utilities.enums.StateEnum;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    private Long id;

    private String name;

    private String surname;

    private DocTypeEnum docType;

    private String docNumber;

    private LocalDate birthDate;

    private String email;

    private String phone;

    private GenderEnum gender;

    private String profileImage;

    private String nickname;

    private StateEnum state;

}
