fun main() {

    var balance = 0.0
    var programIsRunning = true
    var userChoice: Int

    while (programIsRunning) {
        println("***************")
        println("BANKING PROGRAM")
        println("***************")

        println("1. Show Balance")
        println("2. Deposit")
        println("3. Withdraw")
        println("4. Exit")

        println("***************")

        while (true) {
            try {
                print("Enter your choice (1-4): ")
                userChoice = readln().toInt()
            } catch (e: NumberFormatException) {
                println("Please enter a valid number")
                continue
            }
            break
        }

        when (userChoice) {
            1 -> println("Balance: ${showBalance(balance)}")
            2 -> balance += deposit()
            3 -> balance -= withdraw(balance)
            4 -> {
                println("Good Bye!")
                programIsRunning = false
            }
            else -> println("Please enter a valid choice")
        }
    }
}

fun showBalance(balance: Double): String {
    return "%.2f".format(balance)
}

fun deposit(): Double {
    print("Enter the # to deposit: ₱")
    val amount = readln().toDouble()

    if (amount < 0) {
        println("Amount can't be negative.")
        return 0.0
    } else {
        return amount
    }
}

fun withdraw(balance: Double): Double {
    print("Enter the # to withdraw: ₱")
    val amount = readln().toDouble()

    if (amount > balance) {
        println("Insufficient funds.")
        return 0.0
    } else if (amount < 0) {
        println("Amount can't be negative.")
        return 0.0
    } else {
        return amount
    }
}