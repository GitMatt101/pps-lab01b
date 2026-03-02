package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {

    private static final int FEE = 1;
    private final BankAccount base;

    public BronzeBankAccount(BankAccount bankAccount) {
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
        amount = amount > 100 ? amount + FEE : amount;
        if (this.getBalance() < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
