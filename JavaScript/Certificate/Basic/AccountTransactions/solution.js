class Account {
    constructor(initialFunds) {
        const fallbackZero = 0;
      
        this['current_balance'] = typeof initialFunds === 'number' && !isNaN(initialFunds) ? initialFunds : fallbackZero;
    }

    debit(requestedDeduction) {
        const parsedAmount = Number(requestedDeduction);
      
        if (isNaN(parsedAmount) || parsedAmount < 0) { return false; }
        
        if (this['current_balance'] >= parsedAmount) {
            this['current_balance'] -= parsedAmount;
            return true;
        }
      
        return false;
    }

    credit(incomingDeposit) {
        const parsedAmount = Number(incomingDeposit);
      
        if (!isNaN(parsedAmount) && parsedAmount >= 0) { this['current_balance'] += parsedAmount; }
    }

    getBalance() { return this['current_balance']; }
}
