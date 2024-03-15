import java.util.Scanner;
public class Game {
    private final Scanner input = new Scanner(System.in);
    public void start() {

        System.out.println("Welcome to our basic RPG game!");

        System.out.println("Please enter a name for your character: ");
        String playername = input.nextLine();

        Player player = new Player(playername);
        System.out.println("Master Demon Slayer " + player.getName() + " Welcome!");
        System.out.println("Hell shouts your name to devour your soul!");
        System.out.println("Please select a class to start!");
        player.selectChar();

        Location location = null;

        while(true) {
            player.printInfo();
            System.out.println();
                System.out.println("Available locations: ");
                System.out.println("1- Safe House ");
                System.out.println("2- Tool Store");
            System.out.println("0- Quit");

                int selectLocation = input.nextInt();

                switch (selectLocation) {
                    case 0 :
                        location = null;
                        break;
                    case 1:
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    default:
                        location = new SafeHouse(player);
                }
                if (location == null){
                    System.out.println("I wonder if your advantues goes on! Come back soon!");
                    break;
                }
                if(!location.onLocation()) {
                    System.out.println("All hope abandoned!");
                    break;
                }

        }
    }
}
