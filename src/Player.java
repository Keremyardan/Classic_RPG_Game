import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private final Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private int defaultHealth;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Paladin()};

        System.out.println("/////////////////////////////");
        System.out.println("Available classes: ");
        for (GameChar gameChar : charList) {

            System.out.println("ID: " + gameChar.getId() +
                    "\t Classes: " + gameChar.getName() +
                    "\t Damage :" + gameChar.getDamage() +
                    "\t Health :" + gameChar.getHealth() +
                    "\t Money :" + gameChar.getMoney());

        }
        System.out.println("/////////////////////////////");

        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Paladin());
                break;
            default:
                initPlayer(new Samurai());
        }

    }


    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setDefaultHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println(
                "Your weapon: " + this.getInventory().getWeapons().getName() +
                "Your Armor: " + this.getInventory().getArmors().getName() +
                        "Block Amount: " + this.getInventory().getArmors().getBlock() +
                "Your damage: " + this.getTotalDamage() +
                        "Health: " + this.getHealth() +
                        "Currency: " + this.getMoney());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapons().getDamage();
    }

    public int getDamage() {
        return damage;

    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapons getWeapon(){
        return this. getInventory().getWeapons();
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public Scanner getInput() {
        return input;
    }
}
