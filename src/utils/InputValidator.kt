package utils

fun getValidString(userQuestion: String): String {
    var valid = false
    var specialResponseCounter = 0
    println(userQuestion)
    var input: String? = readLine()
    while (!valid){
        if (input != null && input.isNotEmpty()){
            valid = true
        } else {
            if (specialResponseCounter >= 5){
                println("Sigh...it cannot be this complicated can it? ")
                println("Enter a name that's not blank. If you can't think of one, use \"dummy\". " +
                        "I think it fits your real life character :)")
            } else {
                print("Invalid response. Please try again. ")
                println(userQuestion)
            }
            input = readLine()
        }
        specialResponseCounter += 1
    }
    return input.toString()
}

fun getValidInt(userQuestion: String): Int{
    var valid = false
    var specialResponseCounter = 0
    println(userQuestion)
    var input: String? = readLine()
    while (!valid){
        if (input != null && input.isNotEmpty()){
            valid = true
        } else {
            if (specialResponseCounter >= 5){
                println("Sigh...it cannot be this complicated can it? ")
                println("Enter a name that's not blank. If you can't think of one, use \"dummy\". " +
                        "I think it fits your real life character :)")
            } else {
                print("Invalid response. Please try again. ")
                println(userQuestion)
            }
            input = readLine()
        }
        specialResponseCounter += 1
    }
    return input!!.toInt()
}