package gameparts;

public class Armor {

    DieSet defendingDie;
    int saveCriteria;
    int criticalSaves;
    int normalSaves;

    public Armor (int numberOfDie, int saveCriteria) {
        this.defendingDie = new DieSet(6, numberOfDie);
        this.saveCriteria = saveCriteria;
    }

    private void rollDice() {
        this.defendingDie.rollDice();
    }

    public void defend() {
        rollDice();
        calculateNewStats();
    }

    public void defend(boolean cover) {
        rollDice();
        if (cover) {
            //Change the dice according to some logic
        }
        calculateNewStats();
    }

    private void calculateNewStats() {
        int criticalSaves = 0;
        int normalSaves = 0;

        for (Die d: this.defendingDie) {
            if (d.currentValue == d.maxValue) {
                criticalSaves = criticalSaves + 1;
            } else if (d.currentValue >= this.saveCriteria) {
                normalSaves = normalSaves + 1;
            }
        }
        this.criticalSaves = criticalSaves;
        this.normalSaves = normalSaves;
    }

}
