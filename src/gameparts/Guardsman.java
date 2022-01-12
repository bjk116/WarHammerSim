package gameparts;

import java.util.ArrayList;

public class Guardsman extends Soldier {
    public Guardsman(String name, ArrayList<Weapon> weapons) {
        super(name, 7, 7, 6, weapons, new Armor(3, 5));
    }
}