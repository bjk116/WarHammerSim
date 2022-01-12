package simulations;

import gameparts.RangedWeapon;
import gameparts.Weapon;

public class WeaponSims {
    Weapon weapon;
    int simulations;

    public WeaponSims(Weapon weapon) {
        this.weapon = weapon;
    }

    public void runRawDamageSimulation(int simulations) {
        int totalDamage = 0;
        ////Just calculates raw damage done by a weapon based on X simulations, this doesn't include saving throws of the defense
        for(int i = 0; i < simulations; i++) {
            this.weapon.attack();
            totalDamage = totalDamage + this.weapon.getDamage();
        }
        System.out.println("Total damage done over " + simulations + " was " + totalDamage);
        float averageDamagePerTurn = ((float) totalDamage) / ((float) simulations);
        System.out.println("Avreage raw damage per turn before defense  with weapon is " + averageDamagePerTurn);
    }

    public static void main(String args[]) {
        RangedWeapon lasergun = new RangedWeapon(4,3,2,3);
        WeaponSims testSim = new WeaponSims(lasergun);
        testSim.runRawDamageSimulation(10000);
    }
}
