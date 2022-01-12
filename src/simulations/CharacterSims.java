package simulations;

import gameparts.*;

import java.util.ArrayList;

public class CharacterSims {
    private Soldier one;
    private Soldier two;

    public CharacterSims(Soldier one, Soldier two) {
        this.one = one;
        this.two = two;
    }

    public void fightToDeath(int simulations) {
        int turnsToKill;
        int oneWins = 0;
        int twoWins = 0;
        for (int i = 0; i < simulations; i++) {
            turnsToKill = 0;
            while (one.isAlive && two.isAlive) {
                turnsToKill = turnsToKill + 1;
                one.attack(two);
                //in case it's over already, we can't have a dead man shoot back
                if (!two.isAlive) {
                    break;
                }
                two.attack(one);
            }
            if (two.isAlive) {
                System.out.println("Ork thing killed veteran guardsman in " + turnsToKill + " turns");
                twoWins = twoWins + 1;
            } else if (one.isAlive) {
                System.out.println("Veteran guardsman kill ork thing in " + turnsToKill + " turns");
                oneWins = oneWins + 1;
            }
            one.reviveToFullHealth();
            two.reviveToFullHealth();
        }
        System.out.println(one.name + " won " + oneWins + " times.");
        System.out.println(two.name + " won " + twoWins + " times.");
    }

    public static void main(String args[]) {
        Faction Guardsmen = Faction.getGuardsMen();
        Faction Orks = Faction.getOrks();
        Orks.get(0).setActiveWeapon(1);
        CharacterSims characterSims = new CharacterSims(Guardsmen.get(0), Orks.get(0));
        int simulations = 10000;
        characterSims.fightToDeath(simulations);
    }

}
