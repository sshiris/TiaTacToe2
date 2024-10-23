import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    String competitor;
    ArrayList<Integer> positions;

    public User(String competitor) {
        this.competitor = competitor;
        this.positions = new ArrayList<>();
    }

    public String checkWinner(User otherUser) {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> lefCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        List<List<Integer>> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(lefCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List<Integer> l : winning) {
            if (positions.containsAll(l)) {
                return "Congrats! " + this.competitor + " won";
            } else if (this.positions.size() + otherUser.positions.size() == 9) {
                return "It is a tie!";
            }
        }
        // no winner yet
        return "";
    }

}
