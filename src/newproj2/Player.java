package newproj2;


import java.util.List;

public abstract class Player implements Interactions {
    protected String name;
    protected String specification;
    protected int amountOfArmor;
    protected String weaponType;
    protected int strength;
    protected int intelligence;
    protected int agility;
    protected int spirit;
    protected double health;
    protected int level;
    protected Armor helmet;
    protected Armor chest;
    protected Armor hands;
    protected Armor legs;
    protected Armor boots;
    protected Weapon weapon;
    protected List<Armor> armor;


    protected Player(String name, String specification, int amountOfArmor,
                     List<Armor> armor, Weapon weapon, String weaponType) {
        this.name = name;
        this.specification = specification;
        this.amountOfArmor = amountOfArmor;
        this.weaponType = weaponType;

        if (weapon.getType() == this.weaponType) {
            this.weapon = weapon;
        }

        level = 1;

        health = 200;
        this.armor = armor;

        equipItems();

    }

    protected boolean isDead() {
        return health <= 0;
    }

    protected void equipItems() {

        for (int i = 0; i < armor.size(); i++) {
            Armor temp = armor.get(i);
            if (temp.getType() == "helmet") {
                helmet = temp;
              //  amountOfArmor++;
              helmet.setAmountOfArmor(amountOfArmor++);
              helmet.equipped=true;

            } else if (temp.getType() == "chest") {
                chest = temp;
                chest.setAmountOfArmor(amountOfArmor++);
                chest.equipped=true;


                //amountOfArmor++;

            } else if (temp.getType() == "hands") {

                hands = temp;
                             hands.setAmountOfArmor(amountOfArmor++);
                             hands.equipped=true;

// amountOfArmor++;

            } else if (temp.getType() == "legs") {
                legs = temp;
                              legs.setAmountOfArmor(amountOfArmor++);
              legs.equipped=true;

               // amountOfArmor++;
            } else if (temp.getType() == "boots") {
                boots = temp;
                              boots.setAmountOfArmor(amountOfArmor++);
              boots.equipped=true;

               // amountOfArmor++;
            }

        }


    }

    @Override
    public abstract void attack(Player target);

    @Override
    public abstract void useAbility(Player target);

}

