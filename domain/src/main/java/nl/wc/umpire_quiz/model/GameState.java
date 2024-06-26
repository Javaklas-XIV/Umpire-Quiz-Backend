package nl.wc.umpire_quiz.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import nl.wc.umpire_quiz.exceptions.GameStateValidationException;

@Embeddable
public class GameState {
    private boolean runnerBase1;
    private boolean runnerBase2;
    private boolean runnerBase3;
    private boolean batterRunner;
    @Max(value = 3)
    private int outs;
    @Max(value = 3)
    private int balls;
    @Max(value = 3)
    private int strikes;

    public GameState() {
        // Empty Constructor is mandatory for JPA
    }

    public boolean isRunnerBase1() {
        return runnerBase1;
    }

    public void setRunnerBase1(boolean runnerBase1) {
        this.runnerBase1 = runnerBase1;
    }

    public boolean isRunnerBase2() {
        return runnerBase2;
    }

    public void setRunnerBase2(boolean runnerBase2) {
        this.runnerBase2 = runnerBase2;
    }

    public boolean isRunnerBase3() {
        return runnerBase3;
    }

    public void setRunnerBase3(boolean runnerBase3) {
        this.runnerBase3 = runnerBase3;
    }

    public boolean isBatterRunner() {
        return batterRunner;
    }

    public void setBatterRunner(boolean batterRunner) {
        this.batterRunner = batterRunner;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        if (outs > 3 || outs < 0) {
            throw new GameStateValidationException("outs can not be above 3 or below 0");
        }
        this.outs = outs;
    }

    public void setOuts(String outs) {
        try {
            setOuts(Integer.parseInt(outs));
        } catch (NumberFormatException e) {
            throw new GameStateValidationException("outs have to be a numeric value.");
        }
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        if (balls > 3 || balls < 0) {
            throw new GameStateValidationException("balls can not be above 3 or below 0");
        }
        this.balls = balls;
    }

    public void setBalls(String balls) {
        try {
            setBalls(Integer.parseInt(balls));
        } catch (NumberFormatException e) {
            throw new GameStateValidationException("balls have to be a numeric value.");
        }
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        if (strikes > 3 || strikes < 0) {
            throw new GameStateValidationException("strikes can not be above 3 or below 0");
        }
        this.strikes = strikes;
    }

    public void setStrikes(String strikes) {
        try {
            setStrikes(Integer.parseInt(strikes));
        } catch (NumberFormatException e) {
            throw new GameStateValidationException("strikes have to be a numeric value.");
        }
    }
}