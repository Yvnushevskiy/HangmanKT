enum class GameState(val lives: Int, val IsGameOver: Boolean) {
    Start(6,false){
        override fun ShowState(){
            println(".___.   \n" +
                    "|   |   \n" +
                    "|       \n" +
                    "|       \n" +
                    "|       \n"+
                    "|_____  \n")
        }
    },
    Live5(5,false){
        override fun ShowState(){
            println(".___.   \n" +
                    "|   |   \n" +
                    "|   o   \n" +
                    "|       \n" +
                    "|       \n"+
                    "|_____  \n")
        }
    },
    Live4(4,false){
        override fun ShowState(){
            println(".___.   \n" +
                    "|   |   \n" +
                    "|   o   \n" +
                    "|   0   \n" +
                    "|       \n"+
                    "|_____  \n")
        }
    },
    Live3(3,false){
        override fun ShowState(){
            println(".___.   \n" +
                    "|   |   \n" +
                    "|   o   \n" +
                    "|   0\\  \n" +
                    "|       \n"+
                    "|_____  \n")
        }
    },
    Live2(2,false){
        override fun ShowState(){
            println(".___.   \n" +
                    "|   |   \n" +
                    "|   o   \n" +
                    "|  /0\\  \n" +
                    "|       \n" +
                    "|_____  \n")
        }
    },
    Live1(1,false){
        override fun ShowState(){
            println(".___.   \n" +
                    "|   |   \n" +
                    "|   o   \n" +
                    "|  /0\\  \n" +
                    "|  /    \n" +
                    "|_____  \n")
        }
    },
    GameOver(0,true){
        override fun ShowState(){
             println(".___.   \n" +
                     "|   |   \n" +
                     "|   o   \n" +
                     "|  /0\\  \n" +
                     "|  / \\  \n" +
                     "|_____  \n")
            println("Вы проиграли")
        }
    };
    abstract fun ShowState()

    fun ReduceLive(): GameState{
        val nextLive = values().find{ it.lives == this.lives -1}?: GameOver
        ShowState()
        return nextLive
    }

}
