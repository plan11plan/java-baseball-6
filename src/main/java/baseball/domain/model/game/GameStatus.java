package baseball.domain.model.game;

import baseball.domain.model.gameResult.GameResult;

public enum GameStatus {
    IN_PROGRESS {
        @Override
        public GameStatus nextStatus(GameResult result) {
            return result.isGameOver() ? FINISHED : this;
        }

        @Override
        public boolean isFinished() {
            return false;
        }
    },
    FINISHED {
        @Override
        public GameStatus nextStatus(GameResult result) {
            return this;
        }

        @Override
        public boolean isFinished() {
            return true;
        }
    };

    public abstract GameStatus nextStatus(GameResult result);
    public abstract boolean isFinished();
}