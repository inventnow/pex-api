package com.inventnow.projectx.user.service;

import com.inventnow.projectx.user.dto.CardStatus;
import com.inventnow.projectx.user.entity.CardEntity;
import com.inventnow.projectx.user.entity.CustomerEntity;
import com.inventnow.projectx.user.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CardsRegistrationServiceImpl implements CardsRegistrationService {

    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public CardEntity registerNewCardToCustomer(CustomerEntity customerEntity) {

        String cardNo = buildCardNo(customerEntity.getDateOfBirth());
        CardEntity cardEntity = new CardEntity();
        cardEntity.setStatus(CardStatus.ACTIVE);
        cardEntity.setCreatedon(new Date());
        cardEntity.setCardNo(cardNo);
        cardEntity.setCustomer(customerEntity);
        cardsRepository.save(cardEntity);

        return cardEntity;
    }

    private String buildCardNo(Date dateOfBirth) {
        CardEntity cardEntity = cardsRepository.findTopByOrderByIdDesc();

        StringBuilder sbCardNo = new StringBuilder();
        String pattern = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(dateOfBirth);

        Long cardId = null;
        if (cardEntity == null) {
            cardId = 500000L;
        } else {
            cardId = cardEntity.getId() + 1;
        }

        String timemillis = String.valueOf(System.currentTimeMillis());
        sbCardNo.append(String.valueOf(cardId) + date + timemillis.substring(timemillis.length() - 4, timemillis.length()));
        return sbCardNo.toString();
    }
}
