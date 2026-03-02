package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    private static final int FEE = 1;
    private final BankAccount base;

    public SilverBankAccount(BankAccount bankAccount) {
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
        if (this.getBalance() < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + FEE);
    }
}
