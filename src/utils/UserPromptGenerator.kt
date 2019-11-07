package utils

/**
 * Given a list of prompt(s), prints the prompt(s) and returns a list of response(s) from the user
 *
 * Response = Player is making their choice
 * Input = We're asking for the player to provide a string input
 *
 * @param
 */
class UserPromptGenerator {

    private val defaultUserQuestion = "What do you do?"
    private val defaultSpecialResponse = ""

    fun getStringInput(userQuestion: String = defaultUserQuestion, specialResponse: String = defaultSpecialResponse): String{
        return getValidString(userQuestion, specialResponse)
    }

    fun getStringInput(inputs: Array<String>, userQuestion: String = defaultUserQuestion, specialResponse: String = defaultSpecialResponse): String{
        printOptions(inputs)
        return getValidString(userQuestion, specialResponse)
    }

    fun getIntResponse(userQuestion: String = defaultUserQuestion, specialResponse: String = defaultSpecialResponse): Int{
        return getValidInt(userQuestion, specialResponse)
    }

    fun getIntResponse(inputs: Array<String>, userQuestion: String = defaultUserQuestion, specialResponse: String = defaultSpecialResponse): Int{
        printOptions(inputs)
        return getValidInt(userQuestion, specialResponse)
    }

    fun printText(input: String){
        println(input)
    }

    fun printText(inputs: Array<String>){
        for (i in inputs.indices){
            println(inputs[i])
        }
    }

    private fun printOptions(inputs: Array<String>){
        for (i in inputs.indices){
            print(i)
            print(". ")
            println(inputs[i])
        }
    }

}