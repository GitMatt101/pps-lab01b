package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoreBankAccountTest {

    protected BankAccount account;

    @BeforeEach
    public void init() {
        this.account = new CoreBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int amount = 1000;
        this.account.deposit(amount);
        assertEquals(amount, this.account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 200, 800"
    })
    public void testCanWithdraw(int deposit, int withdraw, int expectedBalance) {
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(expectedBalance, this.account.getBalance());
    }
}
