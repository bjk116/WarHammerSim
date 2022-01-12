package gameparts;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;

public class Faction extends ArrayList<Soldier> {
    public Faction(ArrayList<Soldier> soldiers) {
        //TODO Somehow don't think this is the right way to instanitate this.  Look it up.
        for (Soldier s: soldiers) {
            this.add(s);
        }
    }

    public Faction() {

    }

    public static Faction getGuardsMen() {
        Faction f = new Faction();
        RangedWeapon lasergun = new RangedWeapon(3,3,2,3);
        RangedWeapon sniperRifle = new RangedWeapon(2,2,4,5);
        RangedWeapon mortar = new RangedWeapon(4,3,3,4);
        MeleeWeapon sword = new MeleeWeapon(3,3,4,5);
        ArrayList<Weapon> weaponsLayout1 = new ArrayList<Weapon>();
        weaponsLayout1.add(sword);
        weaponsLayout1.add(lasergun);
        ArrayList<Weapon> weaponsLayout2 = new ArrayList<Weapon>();
        weaponsLayout2.add(mortar);
        weaponsLayout2.add(lasergun);
        ArrayList<Weapon> weaponsLayout3 = new ArrayList<Weapon>();
        weaponsLayout3.add(sniperRifle);
        weaponsLayout3.add(lasergun);
        Guardsman veteranGuardsman = new Guardsman("Veteran Guardsman",weaponsLayout1);
        Guardsman veteranSniper = new Guardsman("Veteran Sniper",weaponsLayout2);
        Guardsman veteranMortar = new Guardsman("Veteran Mortar Guy",weaponsLayout3);
        f.add(veteranGuardsman);
        f.add(veteranSniper);
        f.add(veteranMortar);
        return f;
    }

    public static Faction getOrks() {
        Faction f = new Faction();
        RangedWeapon boltPistol = new RangedWeapon(2,3,2,3);
        MeleeWeapon massiveSword = new MeleeWeapon(4,3,5,6);
        RangedWeapon rifle = new RangedWeapon(3,3,4,5);
        RangedWeapon magneticRifle = new RangedWeapon(5,3,3,4);
        MeleeWeapon blade = new MeleeWeapon(3,4,3,4);
        ArrayList<Weapon> weaponsLayout1 = new ArrayList<Weapon>();
        weaponsLayout1.add(boltPistol);
        weaponsLayout1.add(massiveSword);
        ArrayList<Weapon> weaponsLayout2 = new ArrayList<Weapon>();
        weaponsLayout2.add(rifle);
        ArrayList<Weapon> weaponsLayout3 = new ArrayList<Weapon>();
        weaponsLayout3.add(magneticRifle);
        weaponsLayout3.add(blade);
        Ork orkCaptain = new Ork("Ork Captain",weaponsLayout1);
        Ork orkSoldier = new Ork("Ork Soldier",weaponsLayout2);
        Ork orkSniper = new Ork("Ork Sniper",weaponsLayout3);
        f.add(orkCaptain);
        f.add(orkSoldier);
        f.add(orkSniper);
        return f;
    }

    public ArrayList<Soldier> getAvailableSoldiers() {
        ArrayList<Soldier> returnList = new ArrayList<Soldier>();
        for(Soldier s: this) {
           if (s.activeActionPoints > 0) {
               returnList.add(s);
           }
        }
        return returnList;
    }
}
