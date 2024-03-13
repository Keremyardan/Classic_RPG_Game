import java.util.Scanner;
public class Game {
    private Scanner input = new Scanner(System.in);
    public void start() {

        System.out.println("Welcome to our basic RPG game!");

        System.out.println("Please enter a name for your character: ");
        String playername = input.nextLine();

        Player player = new Player(playername);
        System.out.println("Master Demon Slayer " + player.getName() + " Welcome!");
        System.out.println("Hell shouts your name to devour your soul!");
        System.out.println("Please select a class to start!");
        player.selectChar();
    }
}
