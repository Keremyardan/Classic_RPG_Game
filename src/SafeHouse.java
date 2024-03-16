public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "Safe house ");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safe house!");
        System.out.println("Your health has regenerated!");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        return true;
    }

}
