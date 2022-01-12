package gameparts;

import java.util.ArrayList;

public class GameEvent {
    String description;
    Soldier ActingSoldier;
    Soldier ActedUponSoldier;
    ArrayList<Soldier> ActedUponSoldiers;

    public GameEvent(String description, Soldier ActingSoldier) {
        this.description = description;
        this.ActingSoldier = ActingSoldier;
        this.ActedUponSoldier = null;
        this.ActedUponSoldiers = null;
    }

    public GameEvent(String description, Soldier ActingSoldier, Soldier ActedUponSoldier) {
        this.description = description;
        this.ActingSoldier = ActingSoldier;
        this.ActedUponSoldier = ActedUponSoldier;
        this.ActedUponSoldiers = null;
    }

    public GameEvent(String description, Soldier ActingSoldier, ArrayList<Soldier> ActedUponSoldiers) {
        this.description = description;
        this.ActingSoldier = ActingSoldier;
        this.ActedUponSoldier = null;
        this.ActedUponSoldiers = ActedUponSoldiers;

    }
}
