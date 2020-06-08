package array;

/***
 * In an alien language, surprisingly they also use english
 * lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 */

public class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < words.length - 1; i++) {
            int f = order.indexOf(words[i].charAt(0));
            int s = order.indexOf(words[i + 1].charAt(0));

            if (f < s) {
                continue;
            } else if (f == s) {
                if (chechkDeeper(words[i], words[i + 1], 1, order) == false) return false;
            } else return false;
        }

        return true;
    }

    public boolean chechkDeeper(String f, String s, int index, String order) {
        int lenF = f.length() - 1;
        int lenS = s.length() - 1;


        if (index > lenF && index <= lenS) return true;
        if (index > lenS && index <= lenF) return false;
        if (index > lenF && index > lenS) return true;

        if (order.indexOf(f.charAt(index)) <= order.indexOf(s.charAt(index))) {
            return chechkDeeper(f, s, index + 1, order);
        } else return false;
    }
}
