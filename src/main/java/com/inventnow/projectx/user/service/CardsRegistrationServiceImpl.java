package com.inventnow.projectx.user.service;

import com.inventnow.projectx.user.dto.CardStatus;
import com.inventnow.projectx.user.entity.CardEntity;
import com.inventnow.projectx.user.entity.CustomerEntity;
import com.inventnow.projectx.user.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CardsRegistrationServiceImpl implements CardsRegistrationService {

    @Autowired
    private CardsRepository cardRepository;

    @Override
    public CardEntity registerNewCardToCustomer(CustomerEntity customerEntity) {

        String cardNo = buildCardNo(customerEntity.getDateOfBirth());
        CardEntity cardEntity = new CardEntity();
        cardEntity.setStatus(CardStatus.ACTIVE);
        cardEntity.setCreatedon(LocalDateTime.now());
        cardEntity.setCardNo(cardNo);
        cardEntity.setCustomer(customerEntity);
        cardRepository.save(cardEntity);

        return cardEntity;
    }

    private String buildCardNo(LocalDate dateOfBirth) {
        CardEntity cardEntity = cardRepository.findTopByOrderByIdDesc();

        StringBuilder sbCardNo = new StringBuilder();

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yy");

        String yearDob = dateOfBirth.format(formatters);

        Long cardId = null;
        if (cardEntity == null) {
            cardId = 500000L;
        } else {
            cardId = cardEntity.getId() + 1;
        }

        String timemillis = String.valueOf(System.currentTimeMillis());
        sbCardNo.append(String.valueOf(cardId) + yearDob + timemillis.substring(timemillis.length() - 4, timemillis.length()));
        return sbCardNo.toString();
    }
}
