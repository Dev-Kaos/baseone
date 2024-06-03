package com.app.baseone.security.business.service.implementation;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.baseone.security.domain.entity.UserBasicAuthEntity;
import com.app.baseone.security.persistence.repository.IUserBasicAuthRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
        private IUserBasicAuthRepository userBasicAuthRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserBasicAuthEntity userBasicAuthEntity = userBasicAuthRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException("no encontrado"));

                List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

                userBasicAuthEntity.getRoles()
                                .forEach(role -> authorityList
                                                .add(new SimpleGrantedAuthority(
                                                                "ROLE_".concat(role.getName().name()))));

                userBasicAuthEntity.getRoles().stream()
                                .flatMap(role -> role.getPermissionList().stream())
                                .forEach(permission -> authorityList
                                                .add(new SimpleGrantedAuthority(permission.getName())));

                return new User(userBasicAuthEntity.getUsername(),
                                userBasicAuthEntity.getPassword(),
                                userBasicAuthEntity.isEnabled(),
                                userBasicAuthEntity.isAccountNoExpired(),
                                userBasicAuthEntity.isCredentialNoExpired(),
                                userBasicAuthEntity.isAccountNoLocked(),
                                authorityList);

    }

}
