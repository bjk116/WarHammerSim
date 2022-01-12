package gameparts;

import java.util.ArrayList;

public class Ork extends Soldier {
    public Ork(String name, ArrayList<Weapon> weapons) {
        super(name, 12, 4, 3, weapons, new Armor(5, 5));
    }
}