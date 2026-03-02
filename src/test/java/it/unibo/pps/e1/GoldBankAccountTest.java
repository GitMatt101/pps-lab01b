package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends CoreBankAccountTest {

    private static final int GOLD_ACCOUNT_LIMIT = 500;

    @BeforeEach
    @Override
    public void init() {
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdrawUpTo500NegativeBalance() {
        int depositAmount = 1000;
        this.account.deposit(depositAmount);
        this.account.withdraw(depositAmount + GOLD_ACCOUNT_LIMIT);
        assertEquals(-GOLD_ACCOUNT_LIMIT, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawOver500NegativeBalance() {
        int depositAmount = 1000;
        this.account.deposit(depositAmount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(depositAmount + GOLD_ACCOUNT_LIMIT + 1));
    }

}
