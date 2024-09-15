enum class Difficulty(val level: Int) {
    EASY(1),
    MEDIUM(2),
    HARD(3);
}
var difficulty: Difficulty = Difficulty.EASY

    fun setDifficulty() {
        println("Пожалуйста,выберите сложность: \"легко\", \"средне\", или \"сложно\"")
        while (true) {
            val choose = readlnOrNull()?.toLowerCase()

            difficulty = when (choose) {
                "легко" -> Difficulty.EASY
                "средне" -> Difficulty.MEDIUM
                "сложно" -> Difficulty.HARD
                else -> {
                    println("Не правильный ввод. Пожалуйста, введите:  \"легко\", \"средне\", или \"сложно\".")
                    continue
                }
            }
            break
        }
}