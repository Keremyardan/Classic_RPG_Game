
public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {

        super(player, "Tool shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the bloodiest shop ever!");
        boolean showMenu= true;
       while(showMenu) {
           System.out.println("What you'd like to buy to crush your enemies?");
           System.out.println("1- Weapons");
           System.out.println("2- Armours");
           System.out.println("3- Quit");

           int selectCase=input.nextInt();

           while(selectCase <1 || selectCase>3) {
               System.out.println(" Invalid value. Are you gonna kill monsters or not?");
               selectCase=input.nextInt();
           }
           switch (selectCase) {
               case 1:
                   printWeapons();
                   buyWeapon();
                   break;
               case 2:
                   printArmors();
                   buyArmors();
                   break;
               case 3:
                   System.out.println(" You are always welcome as long as you have coins HA-HA-Ha");
                   showMenu = false;
                   break;

           }
       }
            return true;
    }
    public void printWeapons(){
        System.out.println(" Weapons: ");
        for(Weapons w : Weapons.weapons()){
            System.out.println(w.getId()
                    +" - "+ w.getName()
                    + " Price: " + w.getPrice()
                    + " Damage: " + w.getDamage());
        }
        System.out.println("0 - Quit");
    }

    public void buyWeapon() {

        System.out.println(" Choose a value: ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID <0 || selectWeaponID>Weapons.weapons().length) {
            System.out.println(" Invalid value. Are you gonna kill monsters or not?");
            selectWeaponID=input.nextInt();
        }

        if ( selectWeaponID != 0) {

            Weapons selectedWeapon = Weapons.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice()>this.getPlayer().getMoney()) {
                    System.out.println("Insufficient funds! ");
                }else {
                    System.out.println(selectedWeapon.getName() + " Purchased! ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Current balance: " + this.getPlayer().getMoney());
                    System.out.println("Previous Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                    this.getPlayer().getInventory().setWeapons(selectedWeapon);
                    System.out.println("New Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                }

            }
        }



    }

    public void printArmors(){

        System.out.println(" Armors: ");
        for(Armors a : Armors.armors()){
            System.out.println(a.getId()
                    +" - "+ a.getName()
                    + " Price: " + a.getPrice()
                    + " Block: " + a.getBlock());
        }
        System.out.println("0 - Quit");
    }
    public void buyArmors() {
        System.out.println(" Choose a value: ");
        int selectArmorsID = input.nextInt();
        while(selectArmorsID <0 || selectArmorsID>Armors.armors().length) {
            System.out.println(" Invalid value. Are you gonna kill monsters or not?");
            selectArmorsID=input.nextInt();
        }
        if (selectArmorsID != 0) {
            Armors selectedArmors = Armors.getArmorsObjByID(selectArmorsID);
            if(selectedArmors != null){
                if(selectedArmors.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Insufficient funds!");
                }else {
                    System.out.println(selectedArmors.getName() + "Purchased!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmors.getPrice());
                    this.getPlayer().getInventory().setArmors(selectedArmors);
                    System.out.println("Current balance: " + this.getPlayer().getMoney());
                    System.out.println("Previous Armour: " + this.getPlayer().getInventory().getArmors().getName());
                }
            }
        }
    }
}
