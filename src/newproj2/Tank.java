package newproj2;


import java.util.List;

public class Tank extends Player {
    private List<Ability> abilities;
    private Armor shield;

    public Tank(String name, List<Ability> abilities, List<Armor> armor, Weapon weapon, String weaponType, Armor shield) {
        super(name, "Tank", 30, armor, weapon, weaponType);
        strength = 15;
        intelligence = 4;
        agility = 6;
        spirit = 2;
        this.abilities = abilities;
        this.shield = shield;
        abilities.add((Ability)(Object)this.shield);
    }
  public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public void attack(Player target) {
        float k1 = 0f, k2 = 0f;

        k1 = 0.7f;
        k2 = 0.6f;

        if (weapon != null) {
            float damage = (strength * k1) + weapon.getDamage() + (agility * k2) - target.amountOfArmor;
            if (damage <= 0) {
                System.out.println("Target " + target.name + " did not receive any damage");
            } else {
                                weapon.setDamage((int)damage);
                target.health -= damage;
                
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
        if (abilities == null) {
            System.out.println(name + " has no skills to use");
        } else {
            int index = (int) (Math.random() * abilities.size());
            Ability ability = abilities.get(index);

            ability.setArmor(ability.getArmor() + 1);
            System.out.println("Hey you ! I am here, attack me!");
        }
    }
}