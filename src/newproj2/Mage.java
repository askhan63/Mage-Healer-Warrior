package newproj2;


import java.util.List;


public class Mage extends Player {
    private List<Ability> abilities;

    public Mage(String name, List<Ability> abilities, List<Armor> armor, Weapon weapon, String weaponType) {
        super(name, "Mage", 5, armor, weapon, weaponType);
        strength = 5;
        intelligence = 10;
        agility = 4;
        spirit = 6;
        this.abilities = abilities;

    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public void attack(Player target) {
        float k1 = 0f, k2 = 0f;

        k1 = k2 = 0.4f;
        if (weapon != null) {
            float damage = (strength * k1) + weapon.getDamage() + (agility * k2) - target.amountOfArmor;
            if (damage <= 0) {
                System.out.println("Target " + target.name + " did not receive any damage");
            } else {
                target.health -= damage;
                weapon.setDamage((int)damage);

                if (target.health > 0) {
                    System.out.println("Target " + target.name + " received damage " + damage + " from Player " + name);

                } else {
                    System.out.println("Player " + name + " killed Target " + target.name);
                    level++;
                }
            }
        } else {
            System.out.println("You don't have any Weapon!");
        }

    }

    @Override
    public void useAbility(Player target) {
        int index = (int) (Math.random() * abilities.size());
        Ability ability = abilities.get(index);
        double effect = intelligence + ability.getDamage() + (spirit * 0.5) - target.amountOfArmor;

        if (effect <= 0) {
            // System.out.println("Player"+name +" has no spells to cast. ");
            System.out.println("Target " + target.name + " did not received any damage");

        } else {
            target.health -= effect;
            ability.setDamage((int)effect);

            if (target.health <= 0) {
                System.out.println("Player " + name + " killed Target " + target.name);
                level++;
            } else {
                System.out.println("Target " + target.name + " received damage " + effect + " from Player " + name);

            }
        }
    }
}