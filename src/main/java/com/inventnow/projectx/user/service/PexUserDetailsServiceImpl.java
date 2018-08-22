package com.inventnow.projectx.user.service;

import com.inventnow.projectx.security.RoleEnum;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

@Service("userDetailsService")
public class PexUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        return new User(username, userEntity.getPassword(), createAuthorityList(RoleEnum.CUSTOMER_READ.name(), RoleEnum.CUSTOMER_UPDATE.name()));
    }
}
