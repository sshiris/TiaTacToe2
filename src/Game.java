import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // initialize board and print
        GameBoard board = new GameBoard();
        board.printGameBoard();
        // initialize two players
        User player = new User("player");
        User cpu = new User("cpu");

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your placement(1-9):");
            int playerPos = scan.nextInt();

            // ask player to keep entering a position until it is not taken
            while (player.positions.contains(playerPos) || cpu.positions.contains(playerPos)) {
                System.out.println("Position taken! Enter a correct Position");
                playerPos = scan.nextInt();
            }
            board.placePiece(playerPos, player);
            board.printGameBoard();
            // check results after the player place a piece
            String result = player.checkWinner(cpu);
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            // ask computer to keep entering a position until it is not taken
            while (cpu.positions.contains(cpuPos) || player.positions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }

            board.placePiece(cpuPos, cpu);
            board.printGameBoard();
            // check results after the computer place a piece
            result = cpu.checkWinner(player);
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

        }
        scan.close();
    }
}