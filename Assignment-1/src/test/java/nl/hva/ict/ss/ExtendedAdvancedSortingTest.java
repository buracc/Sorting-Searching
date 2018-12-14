package nl.hva.ict.ss;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Put your tests that show you implemented the code correctly in this class.
 * Any test placed at a different class will be ignored!
 * Failing to add tests here will result in failing the assignment!
 */
public class ExtendedAdvancedSortingTest extends AdvancedSortingTest {

    @Test
    public void testEmptyArray() {
        Player[] playerArray = new Player[0];
        Player[] originalArrayCopy = playerArray.clone();

        AdvancedSorts.quickSort(playerArray);

        assertTrue(Arrays.equals(originalArrayCopy, playerArray));
    }

    @Test
    public void testEmptyLinkedList() {
        LinkedList<Player> playerLinkedList = new LinkedList<>();
        LinkedList<Player> originalLinkedListCopy = (LinkedList<Player>) playerLinkedList.clone();

        AdvancedSorts.quickSort(playerLinkedList);

        assertTrue(Arrays.equals(playerLinkedList.toArray(), originalLinkedListCopy.toArray()));
    }

    @Test
    public void testArrayWith5() {
        Player player1 = new Player("Daniel", "Apenburg", 1200);
        Player player2 = new Player("Ferry", "Beestenboel", 900);
        Player player3 = new Player("Maarten", "van Gorgelsten", 1400);
        Player player4 = new Player("Peter", "de Vries", 300);
        Player player5 = new Player("Menza", "Clojenzar", 1200);
        Player[] playerArray = new Player[] {player1, player2, player3, player4, player5};
        Player[] correctPlayerArray = new Player[] {player4, player2, player1, player5, player3};

        AdvancedSorts.quickSort(playerArray);

        assertTrue(Arrays.equals(correctPlayerArray, playerArray));
    }

    @Test
    public void testLinkedListWith5() {
        Player player1 = new Player("Daniel", "Apenburg", 1200);
        Player player2 = new Player("Ferry", "Beestenboel", 900);
        Player player3 = new Player("Maarten", "van Gorgelsten", 1400);
        Player player4 = new Player("Peter", "de Vries", 300);
        Player player5 = new Player("Menza", "Clojenzar", 1200);

        LinkedList<Player> playerLinkedList = new LinkedList<>();
        playerLinkedList.add(player1);
        playerLinkedList.add(player2);
        playerLinkedList.add(player3);
        playerLinkedList.add(player4);
        playerLinkedList.add(player5);

        LinkedList<Player> correctLinkedList = new LinkedList<>();
        correctLinkedList.add(player4);
        correctLinkedList.add(player2);
        correctLinkedList.add(player1);
        correctLinkedList.add(player5);
        correctLinkedList.add(player3);

        AdvancedSorts.quickSort(playerLinkedList);

        assertTrue(Arrays.equals(playerLinkedList.toArray(), correctLinkedList.toArray()));
    }

    @Test
    public void test5SameNameArray() {
        Player player1 = new Player("Henk", "Beestenboel", 1200);
        Player player2 = new Player("Ferry", "Beestenboel", 1000);
        Player player3 = new Player("Maarten", "Beestenboel", 1000);
        Player player4 = new Player("Peter", "Beestenboel", 1200);
        Player player5 = new Player("Menza", "Beestenboel", 1200);
        Player[] playerArray = new Player[] {player1, player2, player3, player4, player5};
        Player[] correctPlayerArray = new Player[] {player2, player3, player1, player5, player4};

        AdvancedSorts.quickSort(playerArray);

        assertTrue(Arrays.equals(correctPlayerArray, playerArray));
    }

    @Test
    public void measureEfficiencyArrayList() {
        System.out.printf("ArrayList implementation%n");
        long timeNeeded = 0;
        for (int numberOfPlayers = 100; numberOfPlayers < UPPER_LIMIT && timeNeeded < TWENTY_SECONDS; numberOfPlayers *= 2) {
            ArrayList<Player> players = getSubListArrayList(unsortedPlayersArrayList, numberOfPlayers);
            System.gc();

            long start = System.nanoTime();
            AdvancedSorts.quickSort(players);
            long finish = System.nanoTime();

            // Try to keep measurements steady
            players.clear();
            System.gc();

            timeNeeded = TimeUnit.NANOSECONDS.toMillis(finish - start);

            System.out.printf("%d;%d%n", numberOfPlayers, timeNeeded);
            System.out.flush();
        }
    }

    ArrayList<Player> getSubListArrayList(ArrayList<Player> players, int numberOfPlayers) {
        ArrayList<Player> unsortedPlayers = new ArrayList<>();
        int i = 0;
        for (Player player : players) {
            unsortedPlayers.add(player);
            if (++i == numberOfPlayers) break;
        }
        return unsortedPlayers;
    }


}
