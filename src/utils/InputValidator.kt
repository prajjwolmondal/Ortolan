package utils

fun getValidString(userQuestion: String, specialResponse: String = ""): String {
    var valid = false
    var specialResponseCounter = 0
    println(userQuestion)
    var input: String? = readLine()
    while (!valid){
        if (input != null && input.isNotEmpty()) valid = true else {
            if (specialResponseCounter >= 5){
                println("Sigh...it cannot be this complicated can it? ")
                if (specialResponse.isNotBlank()) println(specialResponse)
            } else {
                print("Invalid string. Please try again. ")
                println(userQuestion)
            }
            input = readLine()
        }
        specialResponseCounter += 1
    }
    return input.toString()
}

fun getValidInt(userQuestion: String, validValueRange: Int, specialResponse: String = ""): Int{
    var valid = false
    var specialResponseCounter = 0
    println(userQuestion)
    var input: String? = readLine()
    while (!valid){
        if (input != null && input.isNotEmpty()) {
            if (validValueRange==-1){
                valid = true
            } else {
                if (input.toInt() in 0..validValueRange) {
                    valid = true
                } else{
                    print("Invalid number given. Please try again. ")
                    println(userQuestion)
                }
            }
        } else {
            if (specialResponseCounter >= 5){
                println("Sigh...it cannot be this complicated can it? ")
                if (specialResponse.isNotBlank()) println(specialResponse)
            } else {
                print("Invalid number given. Please try again. ")
                println(userQuestion)
            }
        }
        input = readLine()
        specialResponseCounter += 1
    }
    return input!!.toInt()
}

fun getValidYesOrNo(userQuestion: String, specialResponse: String): String{
    var valid = false
    var specialResponseCounter = 0
    println(userQuestion)
    var input: String? = readLine()
    while (!valid){
        if (input != null && input.isNotEmpty() &&
                (input.toLowerCase().equals("n") or input.toLowerCase().equals("y"))) valid = true else {
            if (specialResponseCounter >= 3){
                println("Sigh...it cannot be this complicated can it? ")
                if (specialResponse.isNotBlank()) println(specialResponse)
            } else {
                print("Invalid response, needs to be \"y\" or \"n\". Please try again. ")
                println(userQuestion)
            }
            input = readLine()
        }
        specialResponseCounter += 1
    }
    return input.toString()
}