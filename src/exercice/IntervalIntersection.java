/**
 * Un intervalle est représenté comme une combinaison de l'heure de début et de l'heure de fin. Étant donné un ensemble d'intervalles, vérifiez si deux intervalles se croisent.
 *
 * Exemples:
 *
 * JAVA
 * Input:  arr[] = {{1, 3}, {5, 7}, {2, 4}, {6, 8}}
 * Output: true
 * The intervals {1, 3} and {2, 4} overlap
 *
 *
 * JAVA
 * Input:  arr[] = {{1, 3}, {7, 9}, {4, 6}, {10, 13}}
 * Output: false
 * No pair of intervals overlap.
 *
 *
 * La complexité temporelle attendue est O(nLogn) où n est le nombre d'intervalles.
 * Nous vous recommandons fortement de minimiser votre navigateur et d'essayer vous-même d'abord.
 * Une solution simple consiste à considérer chaque paire d'intervalles et à vérifier si la paire se croise ou non.
 * La complexité temporelle de cette solution est O(n2)
 *
 * Une meilleure solution consiste à utiliser le tri. Voici l'algorithme complet.
 *
 * Triez tous les intervalles dans l'ordre croissant de l'heure de début. Cette étape prend un temps O(nLogn).
 * Dans le tableau trié, si l'heure de début d'un intervalle est inférieure à la fin de l'intervalle précédent,
 * il y a un chevauchement. Cette étape prend un temps O(n).
 *
 *
 * La complexité temporelle globale de l'algorithme est donc O(nLogn) + O(n) qui est O(nLogn).
 */


package exercice;

import java.util.*;

public class IntervalIntersection {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean intervalsOverlap(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return false;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Interval[] intervals1 = {new Interval(1, 3), new Interval(5, 7), new Interval(2, 4), new Interval(6, 8)};
        System.out.println(intervalsOverlap(intervals1)); // Expected output: false

        Interval[] intervals2 = {new Interval(1, 3), new Interval(7, 9), new Interval(4, 6), new Interval(10, 13)};
        System.out.println(intervalsOverlap(intervals2)); // Expected output: true
    }
}
