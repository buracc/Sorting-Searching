package nl.hva.ict.ss;

import java.util.LinkedList;

public class AdvancedSorts {

    /**
     * Implement quicksort using LinkedList only! Usage of anything but LinkedList will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> LinkedList<E> quickSort(LinkedList<E> unsorted) {
        return sort(unsorted, 0, unsorted.size() - 1);
    }

    public static <E extends Comparable<E>> LinkedList<E> sort(LinkedList<E> playerList, int first, int last) {
        return playerList;
    }

    /**
     * Implement quicksort using arrays only! Usage of anything but arrays will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E[] quickSort(E[] unsorted) {
        return sort(unsorted, 0, unsorted.length - 1);

    }

    public static <E extends Comparable<E>> E[] sort(E[] playerList, int left, int right) {
        int L = left;
        int R = right;

        if (playerList == null || playerList.length == 0)
            return playerList;

        if (left >= right)
            return playerList;

        E middlePlayer = playerList[left + (right - left) / 2];

        while (L <= R) {
            while (playerList[L].compareTo(middlePlayer) > 0) {
                L++;
            }

            while (middlePlayer.compareTo(playerList[R]) < 0) {
                R--;
            }

            if (L <= R) {
                E leftPlayer = playerList[L];
                playerList[L] = playerList[R];
                playerList[R] = leftPlayer;
                L++;
                R--;
            }
        }

        if (left < R) {
            sort(playerList, left, R);
        }
        if (L < right) {
            sort(playerList, L, right);
        }
        return playerList;
    }

}
