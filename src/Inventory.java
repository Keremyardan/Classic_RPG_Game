public class Inventory {
   private Weapons weapons;

   public Inventory(){
       this.weapons = new Weapons("Fist", 0,0,0);
   }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }
}
