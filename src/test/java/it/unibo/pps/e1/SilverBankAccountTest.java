package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest {

    @BeforeEach
    @Override
    public void init() {
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource({
            "1000, 200, 799"
    })
    @Override
    public void testCanWithdraw(int deposit, int withdraw, int expectedBalance) {
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(expectedBalance, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int depositAmount = 1000;
        int withdrawAmount = depositAmount + 200;
        this.account.deposit(depositAmount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }

}
