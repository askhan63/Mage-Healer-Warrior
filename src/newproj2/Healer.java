package newproj2;


import java.util.List;

public class Healer extends Player {

    private List<Ability> abilities;

    public Healer(String name, List<Ability> abilities, List<Armor> armor, Weapon weapon, String weaponType) {
        super(name, "Healer", 9, armor, weapon, weaponType);
        strength = 3;

        intelligence = 5;
        agility = 3;
        spirit = 10;
        this.abilities = abilities;

    }

    @Override
    public void attack(Player target) {
        float k1 = 0f, k2 = 0f;

        k1 = 0.2f;
        k2 = 0.1f;
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
        double effect = spirit + ability.getHeal() + (intelligence * 0.5);
        if (target.isDead()) {
            System.out.println("Can not heal " + target.name + " Target is dead");
        } else {
            if (effect <= 0) {
                System.out.println("Player" + name + " has no spells to cast. ");
            } else {
                ability.setHeal((int)effect);

                target.health += effect;

            }
        }
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}