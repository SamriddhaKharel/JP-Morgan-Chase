import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue(), 0.01);
        assertEquals(cashValue / 0.0035, rewardValue.getMilesValue(), 0.01);
    }

    @Test
    void create_with_miles_value() {
        double milesValue = 10000;
        var rewardValue = new RewardValue(milesValue);
        assertEquals(milesValue, rewardValue.getMilesValue(), 0.01);
        assertEquals(milesValue * 0.0035, rewardValue.getCashValue(), 0.01);
    }

    @Test
    void convert_from_cash_to_miles() {
        double cashValue = 200;
        var rewardValue = new RewardValue(cashValue);
        double expectedMiles = cashValue / 0.0035;
        assertEquals(expectedMiles, rewardValue.getMilesValue(), 0.01);
    }

    @Test
    void convert_from_miles_to_cash() {
        double milesValue = 5000;
        var rewardValue = new RewardValue(milesValue);
        double expectedCash = milesValue * 0.0035;
        assertEquals(expectedCash, rewardValue.getCashValue(), 0.01);
    }
}
