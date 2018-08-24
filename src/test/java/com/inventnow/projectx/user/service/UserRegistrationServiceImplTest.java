package com.inventnow.projectx.user.service;

import com.google.common.collect.Lists;
import com.inventnow.projectx.security.RoleEnum;
import com.inventnow.projectx.user.dto.User;
import com.inventnow.projectx.user.entity.UserEntity;
import com.inventnow.projectx.user.exception.UserAlreadyRegisteredException;
import com.inventnow.projectx.user.repository.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserRegistrationServiceImpl userRegistrationService;

    @Captor
    private ArgumentCaptor<UserEntity> userEntityArgumentCaptor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void registerUser() {
        //given
        User user = new User();
        user.setEmail("abc@gmail.com");
        user.setFirstName("Bedhesh");
        user.setLastName("User");
        user.setRoles(Lists.newArrayList(RoleEnum.MERCHANT_CASHIER, RoleEnum.MERCHANT_SUPERVISOR));

        //when
        userRegistrationService.registerUser(user);

        //then
        verify(userRepository).save(userEntityArgumentCaptor.capture());
        UserEntity userEntity = userEntityArgumentCaptor.getValue();
        assertThat(userEntity.getUsername(), is("abc@gmail.com"));
        assertThat(userEntity.getFirstName(), is("Bedhesh"));
        assertThat(userEntity.getLastName(), is("User"));

        assertThat(userEntity.getRoles(), is("MERCHANT_CASHIER,MERCHANT_SUPERVISOR"));

    }

    @Test
    public void registerUser_AlreadyExistEmail() {
        //given
        User user = new User();
        user.setEmail("abc@gmail.com");
        user.setFirstName("Bedhesh");
        user.setLastName("User");

        when(userRepository.findByUsername(user.getEmail())).thenThrow(new UserAlreadyRegisteredException("Email : abc@gmail.com already registered"));

        //then
        expectedException.expect(UserAlreadyRegisteredException.class);
        expectedException.expectMessage("Email : abc@gmail.com already registered");
        //when
        userRegistrationService.registerUser(user);

    }
}