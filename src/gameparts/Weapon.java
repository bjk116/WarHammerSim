package gameparts;

public abstract class Weapon {
    DieSet attackingDie;
    int hitCriteria;
    int regularDamage;
    int criticalDamage;
    int hitsLanded;
    int criticalHitsLanded;
    int damage;

    public Weapon(int numberOfDie, int hitCriteria, int regularDamage, int criticalDamage) {
        this.attackingDie = new DieSet(6, numberOfDie);
        this.hitCriteria = hitCriteria;
        this.regularDamage = regularDamage;
        this.criticalDamage = criticalDamage;
        this.damage = 0;
    }

    private void rollDice() {
        this.attackingDie.rollDice();
    }

    public void attack() {
        rollDice();
        calculateNewStats();
    }

    private void calculateNewStats() {
        calculateHitCount();
        calculateDamage();
    }

    private void calculateDamage() {
        this.damage = this.hitsLanded * this.regularDamage + this.criticalHitsLanded * this.criticalDamage;
    }

    private void calculateHitCount() {
        int criticalHits = 0;
        int normalHits = 0;
        for (Die d: this.attackingDie) {
            if (d.currentValue == d.maxValue) {
                criticalHits = criticalHits + 1;
            } else if (d.currentValue >= this.hitCriteria) {
                normalHits = normalHits + 1;
            }
        }
        this.hitsLanded = normalHits;
        this.criticalHitsLanded = criticalHits;
    }

    public int getDamage() {
        return this.damage;
    }

    public static void main(String args[]) {
        RangedWeapon lasergun = new RangedWeapon(4,4,2,3);
    }
}

