
package newproj2;

public class Armor extends Item {
    private int amountOfArmor;
    public Armor(String armorType, String specification, int amountOfArmor, int strength, int intelligence, int agility, int spirit){
        super(armorType);
        this.amountOfArmor=amountOfArmor;
        setSpecification(specification);
        setStrength(strength);
        setIntelligence(intelligence);
        setAgility(agility);
        setSpirit(spirit);
    }

    public int getAmountOfArmor() {
        return amountOfArmor;
    }


    public void setAmountOfArmor(int amountOfArmor) {
        this.amountOfArmor = amountOfArmor;
    }
}