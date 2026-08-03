Account Transactions
--------------------
Create a solution to maintain a bank account's balance.

Implement the Account class that manages an account's balance. The class has the following constructor and methods:

1. The constructor Account(balance) where parameter balance denotes the initial balance of the account.
2. The method debit(amount) debits the amount from the account and returns true. If insufficient balance, do not debit and return false.
3. The method getBalance() returns the current balance.
4. The method creditfamount) credits the amount to the account.

NOTE: You may assume that the amount parameter passed is always positive or 0.

Validation of the correctness of Account class implementation is carried out by performing the following operations:
  - Debit amount: This operation debits the amount. If the return value is false, it prints ‘Insufficient balance’. Otherwise it prints '<amount>' debited
  - Credit amount This operation credits the amount and prints '<amount> credited'.
  - GetBalance: This operation gets the current balance and prints 'Current balance is <balance>'

Input Format For Custom Testing:
--------------------------------
The first line contains an integer that denotes the initial balance when the Account object is created. 
The second line contains an integer, n, the number of operations to be performed.
Each line i of the n subsequent lines (where 0 ≤ i < n) contains one of the three operations listed above and their parameters, if any.
