package com.example.games.app.card


val clubAcesHigh = cardsForSuite(Suite.CLUB, true)
val clubAcesLow = cardsForSuite(Suite.CLUB, false)
val heartAcesHigh = cardsForSuite(Suite.HEART, true)
val heartAcesLow = cardsForSuite(Suite.HEART, false)
val diamondAcesHigh = cardsForSuite(Suite.DIAMOND, true)
val diamondAcesLow = cardsForSuite(Suite.DIAMOND, false)
val spadeAcesHigh = cardsForSuite(Suite.SPADE, true)
val spadeAcesLow = cardsForSuite(Suite.SPADE, false)

val defaultDeck = listOf(
    clubAcesHigh,
    heartAcesHigh,
    diamondAcesHigh,
    spadeAcesHigh
).flatten()

val acesLow = listOf(
    clubAcesLow,
    heartAcesLow,
    diamondAcesLow,
    spadeAcesLow
).flatten()

fun cardsForSuite(suite: Suite, acesHigh: Boolean): List<Card> {
    return listOf(
        Card(suite, Value.ACE, if (acesHigh) 14 else 0),
        Card(suite, Value.ONE, 1),
        Card(suite, Value.TWO, 2),
        Card(suite, Value.THREE, 3),
        Card(suite, Value.FOUR, 4),
        Card(suite, Value.FIVE, 5),
        Card(suite, Value.SIX, 6),
        Card(suite, Value.SEVEN, 7),
        Card(suite, Value.EIGHT, 8),
        Card(suite, Value.NINE, 9),
        Card(suite, Value.TEN, 10),
        Card(suite, Value.JACK, 11),
        Card(suite, Value.QUEEN, 12),
        Card(suite, Value.KING, 13)
    )
}