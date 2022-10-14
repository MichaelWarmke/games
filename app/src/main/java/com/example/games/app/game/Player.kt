package com.example.games.app.game

import com.example.games.app.card.Deck

class Player(val name: String, var hand: Deck = Deck.empty(), var discard: Deck = Deck.empty()) {

    fun recycleDiscards() {
        hand.addAll(discard.cards)
        discard = Deck.empty()
    }
}