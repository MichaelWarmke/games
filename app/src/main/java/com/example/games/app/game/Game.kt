package com.example.games.app.game

import com.example.games.app.card.Card
import com.example.games.app.card.Deck

class Game(
    private val playerCount: Int,
    private val players: MutableList<Player> = mutableListOf(),
    private var deck: Deck = Deck.default(),
    private var playedCards: MutableList<Card> = mutableListOf()
) {

    init {
        if (players.isEmpty()) {
            repeat(playerCount) {
                players.add(Player("Player$it"))
            }
        }
    }

    fun deal() {
        val decks = deck.shuffle().deal(playerCount, deck.size() / playerCount)
        decks.forEachIndexed { i, v -> players[i].hand = v }
    }

    fun start(): Player {
        deal()
        var loser: Player? = null

        do {
            loser = playTurn()
        } while (loser == null)

        players.remove(loser)
        return players.first()
    }

    fun playTurn(): Player? {
        players.forEach {
            if (it.hand.cards.isEmpty()) {
                it.recycleDiscards()
            }
            if (it.hand.cards.isEmpty()) {
                return it
            }
        }

        playCard()
        return null
    }

    fun playCard() {
        players.forEachIndexed { i,v -> playedCards.add(i, v.hand.first()) }

        if (playedCards[0].weight > playedCards[1].weight) {
            players[0].discard.addAll(playedCards)
            playedCards.clear()
        } else {
            players[1].discard.addAll(playedCards)
            playedCards.clear()
        }
    }

}