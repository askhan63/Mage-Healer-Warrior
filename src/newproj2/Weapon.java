package newproj2;



public class Weapon extends Item {
    private int damage;

    public Weapon(String weaponType, String specification, int damage, int strength, int intelligence, int agility, int spirit) {
        super(weaponType);
        this.damage = damage;
//        this.specification = specification;
        setSpecification(specification);
//        this.strength = strength;
        setStrength(strength);
//        this.intelligence = intelligence;
        setIntelligence(intelligence);
//        this.agility = agility;
        setAgility(agility);
//        this.spirit = spirit;
        setSpirit(spirit);

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
}