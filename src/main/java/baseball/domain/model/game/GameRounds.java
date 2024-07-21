package baseball.domain.model.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRounds {
    private final List<GameRound> rounds;

    private GameRounds(List<GameRound> rounds) {
        this.rounds = Collections.unmodifiableList(new ArrayList<>(rounds));
    }

    public static GameRounds empty() {
        return new GameRounds(Collections.emptyList());
    }

    public GameRounds addRound(GameRound round) {
        List<GameRound> newRounds = new ArrayList<>(this.rounds);
        newRounds.add(round);
        return new GameRounds(newRounds);
    }

    public List<GameRound> getRounds() {
        return rounds;
    }

    public int size() {
        return rounds.size();
    }
}
