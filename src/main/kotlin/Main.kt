fun main(args: Array<String>) {
    // Step 1: Start the bank system interface
    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    //Step 2: Create variables for the bank account type and user input
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
            else -> continue // Add a continue statement to move to the next iteration of the loop without doing anything else. This means that no bank account is created because the user’s input is invalid.
        }
    }
    println("You have created a $accountType account.")

    // Step 4: Create constants and variables for the account balance and amount of money to transfer
    var accountBalance = (0..1000).random()
    println("The current balance is $accountBalance dollars.")

    val money = (0..1000).random()
    println("The amount you transferred is $money dollars.")

    //Step 5: Create a test variable for the output of the bank account operations
    var output = 0

    //Step 6: Implement the function that handles the logic of the withdrawal operation for generic and credit bank accounts.
    fun withdraw(amount: Int): Int {
        accountBalance -= amount
        println("You successfully withdrew $amount dollars. The current balance is $accountBalance dollars.")
        return amount
    }

    // Step 7: Now test the function that handles the logic of the withdrawal operation for generic and credit bank accounts.
    output = withdraw(money)
    println("The amount you withdrew is $output dollars.")

    // Step 8: Implement the function that handles the logic of the withdrawal operation for debit bank accounts.
    fun debitWithdraw(amount: Int): Int {
        return if (accountBalance == 0) {
            println("Can't withdraw, no money on this account!")
            accountBalance // formerly, return accountBalance
        } else if (amount > accountBalance) {
            println("Not enough money on this account! The current balance is $accountBalance dollars.")
            0  // formerly, return 0
        } else {
            withdraw(amount)
        }
    }

    //Step 9: Test the function that handles the logic of the withdrawal operation for debit bank accounts.
    output = debitWithdraw(money)
    println("The amount you withdrew is $output dollars.")

    //Step 10: Implement the function that handles the logic of the deposit operation for generic and debit bank accounts.
    fun deposit(amount: Int): Int {
        accountBalance += amount
        println("You successfully deposited $amount dollars. The current balance is $accountBalance dollars.")
        return amount
    }

    //Step 11: Test the function that handles the logic of the deposit operation for generic and debit bank accounts.
    output = deposit(money)
    println("The amount you deposited is $output dollars.")

    // Step 12: Implement the function that handles the logic of the deposit operation for credit bank accounts.
    fun creditDeposit(amount: Int): Int {
        return if (accountBalance == 0) {
            println("This account is completely paid off! Do not deposit money!")
            accountBalance
        } else if (accountBalance + amount > 0) {
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The current balance is ${accountBalance} dollars.")
            0
        } else if (amount == -accountBalance) {
            accountBalance = 0
            println("You have paid off this account!")
            amount
        } else {
            deposit(amount)
        }
    }

    // Step 13:  test the function that handles the logic of the deposit operation for credit bank accounts.
    output = creditDeposit(money)
    println("The amount you deposited is $output dollars.")

    // Step 14: Implementing a function to handle the transfer logic of withdrawals and deposits for checking, debit and credit accounts.
    fun transfer(mode: String) {
        val transferAmount: Int

        when (mode) {
            "withdraw" -> {
                transferAmount = if (accountType == "debit") {
                    debitWithdraw(money)
                } else {
                    withdraw(money)
                }
                println("The amount you withdrew is $transferAmount dollars.")
            }
            "deposit" -> {
                transferAmount = if (accountType == "credit") {
                    creditDeposit(money)
                } else {
                    deposit(money)
                }
                println("The amount you deposited is $transferAmount dollars.")
            }

            // The else case handles all values of the mode parameter that other cases don’t handle.
            else -> return // This means that no account transfer happens because the mode of the account transfer isn’t valid, it is neither deposit nor withdrawal.
        }
    }

    // Step 15: This step created variables that store the bank system interface’s status and the option that the user selects from the console
    var isSystemOpen= true
    var option = 0

    // Step 16: Next, manage the bank account and the specific operations based on the user’s input.
    while (isSystemOpen) {
        println("What would you like to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the system")
        println("Which option do you choose? (1, 2, 3 or 4)")

        option = (1..5).random()
        println("The selected option is ${option}.")

        when (option) {
            1 -> println("The current balance is $accountBalance dollars.")
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen = false
                println("The system is closed")
            }

            // The else case handles all values of the option variable that other cases don’t handle.
            else -> continue
        }
    }






}