class GameLogic (private val getWord: GetWord) {
    var GuessedLetters: MutableList<Char> = mutableListOf()
    var gameState : GameState = GameState.Start
    fun IsWePlay(): Boolean{
        return !gameState.IsGameOver
    }
    fun validateLetterInput(): Char {
        val russianLetterRegex = Regex("^[а-яА-Я]$")
        while (true) {
            println("Напишите одну русскую букву")
            val input = readlnOrNull()?.trim()?.toLowerCase()
            if (input != null && input.length == 1 && input[0].isLetter()&&russianLetterRegex.matches(input)) {

            } else {
                println("Ошибка: Введите одну русскую букву")
                continue
            }
            if (GuessedLetters.contains(input[0])) {
                println("Такая буква уже была, введите другую букву")
                continue
            } else {
                GuessedLetters.add(input[0])
                return input[0]
            }
        }
    }

    fun isWordHasLetter(letter: Char): Boolean {
        return if (getWord.word.contains(letter)) {
            true
        } else {
            println("Буквы'$letter' нет в слове .")
            false
        }
    }

    fun updateMaskedWord(letter: Char) {
        val maskedArray = getWord.maskedWord.toCharArray()
        val wordArray = getWord.word.toCharArray()

        for (i in wordArray.indices) {
            if (wordArray[i].equals(letter, ignoreCase = true)) {
                maskedArray[i] = letter
            }
        }
        getWord.maskedWord = maskedArray.joinToString("")
    }
        fun makeTurn() {
            val letter = validateLetterInput()
            if (isWordHasLetter(letter)) {
                updateMaskedWord(letter)
            } else {
                gameState = gameState.ReduceLive()
            }
        }
    }

