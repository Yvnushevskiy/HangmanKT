fun main() {
    setDifficulty()
    val getWord = GetWord()
    val gameLogic = GameLogic(getWord)
    getWord.loadWordsInList()
    getWord.splitWordsByLength()
    getWord.getRandomWord()
    println("Игра началась!")
    println("Слово для отгадывания: ${getWord.maskedWord}")
    gameLogic.gameState.ShowState()

    while (gameLogic.IsWePlay()) {
        gameLogic.makeTurn()
        gameLogic.gameState.ShowState()
        println("Текущее состояние слова: ${getWord.maskedWord.toUpperCase()}")
        println("Введенные буквы: ${gameLogic.GuessedLetters}")
        if (getWord.maskedWord.contains("*").not()) {
            println("Поздравляем! Вы отгадали слово!")
            break
        }
    }

    println("Игра окончена! Слово было: ${getWord.word}")
}
