import java.util.Random;

public abstract class BattleLocation extends Location {

    private Obstacle obstacle;
    String award;

    private int maxObstacle;

    public BattleLocation(Player player, String name,Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award=award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Your current location: " + this.getName());
        System.out.println("Be aware!" + obsNumber + getObstacle().getName() + " lives here!");
        System.out.println("You have two options. (R)un or (S)tand your ground! ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();

        if (selectCase.equals("S") && combat(obsNumber)){

                System.out.println(this.getName() + "All enemies defeated!");
                return true;


        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Dude... You are DEAD!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i=1; i <= obsNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());
            playerStats();
            obstacleStats( i );
            while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth() > 0) {
                System.out.println("(S)trike or (F)lee");
                String selectCombat = input.nextLine().toUpperCase();
                if(selectCombat.equals("S")) {
                    System.out.println("Your damage value: ");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth()>0) {
                        System.out.println(" ");
                        System.out.println("Enemy damage value: " );
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmors().getBlock();
                        if (obstacleDamage<0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage );
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Victory! But not so fast boy! You've just killed a monster. You may die anytime HA-HA-HA");
                System.out.println(this.obstacle.getAward() + "Coins Looted!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.obstacle.getAward());
                System.out.println("Your current currency" + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Player health: " + this.getPlayer().getHealth());
        System.out.println("Enemy Name" + this.getObstacle().getName() +"Enemy health: " + this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats() {
        System.out.println("Player stats ");
        System.out.println("------------------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmors().getName());
        System.out.println("Dodge: " + this.getPlayer().getInventory().getArmors().getBlock());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Money : " + this.getPlayer().getMoney());
            System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
        System.out.println();

    }
    public void obstacleStats(int i) {
        System.out.println(i + ". " + "Obstacle stats: " + this.getObstacle().getName());
        System.out.println("------------------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Loot: " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
