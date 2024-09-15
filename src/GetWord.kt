import java.io.File
import kotlin.random.Random

class GetWord() {
    private val filePath = "ListWords.txt"
    var words: List<String> = emptyList()
    var word: String = ""  // Инициализировано как пустая строка
    var maskedWord: String = ""  // Инициализировано как пустая строка
    private var wordsByDifficulty: Map<String, List<String>> = emptyMap()

    fun loadWordsInList() {
        words = try {
            File(filePath).readLines()
        } catch (e: Exception) {
            println("Файл не найден: ${e.message}")
            emptyList()
        }
    }

    fun splitWordsByLength() {
        wordsByDifficulty = mapOf(
            "EASY" to words.filter { it.length <= 4 },
            "MEDIUM" to words.filter { it.length in 5..7 },
            "HARD" to words.filter { it.length > 7 }
        )
    }

    fun getRandomWord() {
        val wordList = wordsByDifficulty[difficulty.name]

        word = if (wordList != null && wordList.isNotEmpty()) {
            wordList[Random.nextInt(wordList.size)]
        } else {
            "No words available"
        }
        maskedWord = "*".repeat(word.length)
    }
}
