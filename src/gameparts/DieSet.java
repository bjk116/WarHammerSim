package gameparts;

import java.sql.Array;
import java.util.ArrayList;

public class DieSet extends ArrayList<Die>{

    public DieSet(int maxValue, int dieCount) {
        for (int i = 0; i < dieCount; i ++) {
            this.add(new Die(maxValue));
        }
    }

    public void rollDice() {
        for(int i = 0; i < this.size(); i++) {
            this.get(i).rollDie();
        }
    }
}