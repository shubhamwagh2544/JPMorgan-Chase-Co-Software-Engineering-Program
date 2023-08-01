import com.jpmorgan.rewardsconvertor.RewardValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }

    @Test
    void create_with_miles_value() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue);
        assertEquals(milesValue, rewardValue.getMilesValue());
    }

    @Test
    void convert_from_cash_to_miles() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        int actual = rewardValue.cashToMiles(cashValue);
        int expected = (int) (cashValue / RewardValue.MILES_TO_CASH_CONVERSION_RATE);
        assertEquals(actual, expected);
    }

    @Test
    void convert_from_miles_to_cash() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue);
        double actual = rewardValue.milesToCash(milesValue);
        double expected = RewardValue.MILES_TO_CASH_CONVERSION_RATE * milesValue;
        assertEquals(actual, expected);
    }
}
