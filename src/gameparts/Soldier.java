package gameparts;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class Soldier {
    public String name;
    int activeActionPoints;
    int maxHealth;
    int health;
    int movementPoints;
    int actionPoints;
    ArrayList<Weapon> weapons;
    int defenseSkill;
    int armorSave;
    public boolean isAlive;
    boolean inCover;
    Weapon activeWeapon;
    Armor armor;

    public Soldier(String name, int health, int movementPoints, int actionPoints, ArrayList<Weapon> weapons, Armor armor) {
        this.name = name;
        this.maxHealth = health;
        this.health = health;
        this.movementPoints = movementPoints;
        this.actionPoints = actionPoints;
        this.activeActionPoints = actionPoints;
        setWeapons(weapons);
        setActiveWeapon(0);
        this.isAlive = true;
        this.inCover = false;
        this.armor = armor;
    }

    public Soldier() {

    }

    public void reviveToFullHealth() {
        this.health = this.maxHealth;
        this.isAlive = true;
    }

    public void resetActionPoints() {
        this.activeActionPoints = actionPoints;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        if (weapons.size() == 0) {
            //TODO see about the right way to handle this.
            throw new RuntimeException("Solider requires some weapons");
        } else {
            this.weapons = weapons;
        }
    }

    public void setActiveWeapon(int i) {
        // TODO implement some logic to select from a list
        this.activeWeapon = this.weapons.get(i);
    }

    public void rollAttackDie() {
        this.activeWeapon.attack();
    }

    public void rollDefendingDie() {
        this.armor.defend();
    }

    private int calculateRawDamage() {
        int criticalHitsLanded = Math.max(this.activeWeapon.criticalHitsLanded - this.armor.criticalSaves, 0);
        int normalHitsLanded = Math.max(this.activeWeapon.hitsLanded - this.armor.normalSaves, 0);
        //TODO If for example there is leftover
        int rawDamage = criticalHitsLanded * this.activeWeapon.regularDamage + normalHitsLanded * this.activeWeapon.criticalDamage;
//        System.out.println("Raw damage dealt was " + rawDamage);
        return rawDamage;
    }

    public void attack(@NotNull Soldier enemy) {
        this.rollAttackDie();
        enemy.rollDefendingDie();
//        this.printAttackingDie();
//        enemy.printDefendingDie();
        int rawDamageDealt = calculateRawDamage();
        enemy.damageDealt(rawDamageDealt);
    }

    public void damageDealt(int rawDamageDealt) {
       //TODO will need logic for extra defense rolls or whatever but for now just straight subtraction
        System.out.println(this.name + " has " + this.health + " and just suffered " + rawDamageDealt +"!");
        this.health = Math.max(this.health - rawDamageDealt,0);
        System.out.println(this.name + " has " + this.health + " health left.");
        if (this.health == 0) {
            System.out.println(this.name + "has died.");
            this.isAlive = false;
        }
    }

    private void printDefendingDie() {
        System.out.println(this.name + " defended with ");
        for (Die d: this.armor.defendingDie) {
            System.out.println(d.currentValue);
        }
    }

    private void printAttackingDie() {
        System.out.println(this.name + " attacked with ");
        for (Die d: this.activeWeapon.attackingDie) {
            System.out.println(d.currentValue);
        }
    }
}

