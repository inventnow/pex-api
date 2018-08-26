package com.inventnow.projectx.user.service;

import com.inventnow.projectx.user.dto.UserHomeLogin;
import com.inventnow.projectx.user.entity.UserEntity;

public interface UserBusinessService {

    UserEntity getUserDetails(String username);

    UserHomeLogin getUserDetailsInfo(String username);
}
