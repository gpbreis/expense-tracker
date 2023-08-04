package com.expensetracker.service.imp;

import com.expensetracker.dto.CardDto;
import com.expensetracker.model.Card;
import com.expensetracker.repository.CardRepository;
import com.expensetracker.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<CardDto> findAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cards.stream().map((card) -> mapToCardDto(card)).collect(Collectors.toList());
    }

    @Override
    public Card createCard(CardDto cardDto) {
        Card card = mapToCard(cardDto);
        return cardRepository.save(card);
    }

    private Card mapToCard(CardDto cardDto) {
        return new Card(cardDto.getId(),
                cardDto.getLastFourDigits(),
                cardDto.getExpirationDate(),
                cardDto.getClosingDate(),
                cardDto.getDueDate(),
                cardDto.getCardLimit(),
                cardDto.getBrand(),
                cardDto.getOwnerId());
    }

    private CardDto mapToCardDto(Card card) {
        CardDto cardDto = new CardDto(card.getId(),
                                        card.getLastFourDigits(),
                                        card.getExpirationDate(),
                                        card.getClosingDate(),
                                        card.getDueDate(),
                                        card.getCardLimit(),
                                        card.getBrand(),
                                        card.getOwnerId());
        return cardDto;
    }
}
