package baseball.infrastructure.numberGenerator;

import baseball.domain.model.BaseballNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private final int count;
    private final int startInclusive;
    private final int endInclusive;
//3,1,9
    public RandomNumberGenerator(int count, int startInclusive, int endInclusive) {
        this.count = count;
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public BaseballNumbers generateUniqueNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return BaseballNumbers.of(randomNumbers);
    }
}