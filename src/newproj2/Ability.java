package newproj2;

public class Ability {
    private String name;
    private String specification;
    private int damage;
    private int heal;
    private int armor;

    public Ability(String name, String specification, int amount) {
        this.name = name;
        this.specification = specification;
        if (this.specification == "Mage") {
            this.damage = amount;
            heal = armor = -1;
        } else if (this.specification == "Tank") {
            this.armor = amount;
            heal = damage = -1;
        } else if (this.specification == "Healer") {
            this.heal = amount;
            damage = armor = -1;
        } else if (this.specification == "Warrior") {
            this.damage = amount;
            heal = armor = -1;
        } else {
            System.out.println("Invalid Input!");
        }
    }

    public String getName() {
        return name;
    }

    public String getSpecification() {
        return specification;
    }

    public int getDamage() {
        return damage;
    }

    public int getHeal() {
        return heal;
    }

    public int getArmor() {
        return armor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

}