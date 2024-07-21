package baseball.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public final class BaseballNumbers {
    private final List<Integer> numbers;

    private BaseballNumbers(List<Integer> numbers) {
        if (numbers.size() != GameConstants.THREE || hasDuplicates(numbers) || !isValidRange(numbers)) {
            throw new IllegalArgumentException("Invalid baseball number");
        }
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static BaseballNumbers of(List<Integer> numbers) {
        return new BaseballNumbers(numbers);
    }

    private boolean hasDuplicates(List<Integer> digits) {
        return digits.size() != digits.stream().distinct().count();
    }

    private boolean isValidRange(List<Integer> digits) {
        return digits.stream().allMatch(d -> d >= GameConstants.ONE && d <= GameConstants.THREE * GameConstants.THREE);
    }

    public int countMatchingPositions(BaseballNumbers other) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> numbers.get(i).equals(other.numbers.get(i)))
                .count();
    }

    public int countMatchingNumbers(BaseballNumbers other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    public List<Integer> numbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (BaseballNumbers) obj;
        return Objects.equals(this.numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "BaseballNumbers[" +
                "numbers=" + numbers + ']';
    }

}
