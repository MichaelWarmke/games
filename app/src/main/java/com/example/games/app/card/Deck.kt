package com.example.games.app.card

class Deck(var cards: MutableList<Card>) {

    companion object {
        public fun default(): Deck {
            return Deck(defaultDeck.toMutableList())
        }

        public fun empty(): Deck {
            return Deck(mutableListOf())
        }
    }

    public fun first(): Card {
        return cards.removeFirst()
    }

    public fun size(): Int {
        return cards.size
    }

    public fun addAll(list: List<Card>) {
        cards.addAll(list)
    }

    public fun deal(players: Int, num: Int): List<Deck> {
        val cardsToDeal = players * num
        if (cardsToDeal > cards.size)
            throw IllegalArgumentException("Can not deal $cardsToDeal cards from a deck of ${cards.size}")
        return cards.asSequence().take(cardsToDeal).chunked(players).map { Deck(it.toMutableList()) }.toList()
    }

    public fun shuffle(): Deck {
        val mut = cards.toMutableList()
        val result = mutableListOf<Card>()
        while (mut.isNotEmpty()) {
            val random = mut.random()
            mut.remove(random)
            result.add(random)
        }
        cards = result
        return this
    }
}