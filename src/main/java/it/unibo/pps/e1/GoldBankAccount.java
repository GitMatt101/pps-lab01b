package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {

    private final BankAccount base;

    public GoldBankAccount(BankAccount bankAccount) {
        this.base = bankAccount;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() - amount < -500) {
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
