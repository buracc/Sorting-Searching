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
        return unsorted;
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

    public static <E extends Comparable<E>> E[] sort(E[] playerList, final int left, final int right) {
        int L = left;
        int R = right;

        if (playerList.length <= 1) {
            return playerList;
        }

        E middlePlayer = playerList[(left + right) / 2];

        do {
            while (playerList[L].compareTo(middlePlayer) > 0) {
                L++;
            }
            while (middlePlayer.compareTo(playerList[R]) < 0) {
                R--;
            }

            if (L <= R) {
                E leftPlayer = playerList[left];
                playerList[left] = playerList[right];
                playerList[right] = leftPlayer;
                L++;
                R--;
            }
        } while (L < R);

        if (left < R) {
            sort(playerList, left, R);
        }
        if (L < right) {
            sort(playerList, L, right);
        }
        return playerList;
    }

}
