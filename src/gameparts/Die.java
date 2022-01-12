package gameparts;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//A die should just be able to be set, to be rolled, to be set to max as it would by  a card
//And just for fun lets track each value in a history so at the end of the game we could see how well some die performed
public class Die {
    int minValue = 1;
    int maxValue;
    int currentValue;
    ArrayList<Integer> history = new ArrayList<Integer>();

    public Die(int maxValue) {
        this.maxValue = maxValue;
    }

    public Die(int maxVaue, int minValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    private void setDieValue(int value, boolean saveHistory) {
        if (saveHistory) {
            this.history.add(value);
        }
        this.currentValue = value;
    }

    public void setDieValue(int value) {
        setDieValue(value, true);
    }

    public void rollDie() {
        int newRoll = ThreadLocalRandom.current().nextInt(this.minValue, this.maxValue+1);
        setDieValue(newRoll, true);
    }

    public void setMaxValue() {
        // Don't save history as this ins't actually a rollw
        setDieValue(this.maxValue, false);
    }
}
