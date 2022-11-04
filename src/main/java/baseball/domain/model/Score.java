package baseball.domain.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Score {
    private final Map<BallCount, Integer> score;

    public Score() {
        this.score = intiScoreMap();
    }

    public Score(final Map<BallCount, Integer> score) {
        this.score = score;
    }

    public Score(final Computer computer, final User user) {
        this.score = calculateBallCountScore(computer, user);
    }

    private Map<BallCount, Integer> intiScoreMap() {
        return Arrays.stream(BallCount.values())
                .collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b,
                        () -> new EnumMap<>(BallCount.class)));
    }

    private Map<BallCount, Integer> calculateBallCountScore(final Computer computer, final User user) {
        return user.compareWithComputerBalls(computer, intiScoreMap());
    }

    public Map<String, Integer> getResult() {
        return score.keySet().stream()
                .collect(Collectors.toMap(BallCount::getValue, score::get, (a, b) -> b, LinkedHashMap::new));
    }

    public Boolean getIsThreeStrike() {
        if (score.get(BallCount.STRIKE) == 3) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score1 = (Score) o;
        return Objects.equals(score, score1.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                '}';
    }


}
