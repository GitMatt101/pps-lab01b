package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest {

    private GoldBankAccount account;

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawUpTo500NegativeBalance(){
        this.account.deposit(1000);
        this.account.withdraw(1500);
        assertEquals(-500, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawOver500NegativeBalance() {
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1501));
    }

}
