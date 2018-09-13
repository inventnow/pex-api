package com.inventnow.projectx.user.service;

import com.inventnow.projectx.user.entity.CardEntity;
import com.inventnow.projectx.customer.entity.CustomerEntity;
import com.inventnow.projectx.user.repository.CardsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CardsRegistrationServiceImplUnitTest {

    @Mock
    private CardsRepository cardRepository;

    @InjectMocks
    private CardsRegistrationServiceImpl cardRegistrationService;

    @Test
    public void registerNewCardToCustomer() {
        CustomerEntity customerEntity = new CustomerEntity();
        LocalDate dob = LocalDate.of(1982, 11, 20);
        customerEntity.setId(1L);
        customerEntity.setDateOfBirth(dob);

        CardEntity cardEntity = new CardEntity();
        cardEntity.setId(50000L);
        when(cardRepository.findTopByOrderByIdDesc()).thenReturn(cardEntity);

        CardEntity savedCardEntity = cardRegistrationService.registerNewCardToCustomer(customerEntity);

        assertThat(savedCardEntity.getCardNo().substring(0, 7), is("5000182"));
    }
}