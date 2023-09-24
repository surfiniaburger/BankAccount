fun main(args: Array<String>) {
    // Step 1: Start the bank system interface
    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    //Step 2 solution: Create variables for the bank account type and user input
    var accountType = ""
    var userChoice = 0

    // Step 3: Create a bank account based on user input
    while (accountType == "") {
        println("Choose an option (1, 2 or 3)")
        userChoice = (1..5).random() //  simulate the user input use IntRange.random()  function to generate a random number between 1 and 5
        println("The selected option is ${userChoice}.")

        accountType = when (userChoice) {
            1 -> "debit"
            2 -> "credit"
            3 -> "checking"
            else -> continue
        }
    }


}