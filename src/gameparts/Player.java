package gameparts;

import java.util.ArrayList;

public class Player {
    Faction faction;
    String name;

    public Player (String name, Faction faction) {
        this.name = name;
        this.faction = faction;
    }

    public void doTurn() {
        ArrayList<Soldier> AvailableSoldiers = faction.getAvailableSoldiers();
        //Soldier SelectedSolder = selectSolder(AvailableSoldiers);
    }

    private void selectSolder(ArrayList<Soldier> availableSoldiers) {
        System.out.println("Available soldiers are: ");
        for (Soldier s: availableSoldiers) {
            System.out.println(s.name);
        }
    }
}
