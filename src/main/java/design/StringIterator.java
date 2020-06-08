package design;

/***
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
 *
 * The given compressed string will be in the form of each letter followed by
 * a positive integer representing the number of this letter existing in the original uncompressed string.
 *
 * next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 *
 */

class StringIterator {
    String str;
    int nextletter = 0;
    int repeat = 0;
    int lenghtOfDigit = 0;
    private Holder queue = new Holder();

    public StringIterator(String compressedString) {
        this.str = compressedString;
    }

    public char next() {

        if (!queue.isEmpty()) return queue.poll();

        if (nextletter >= str.length()) return ' ';

        char n = str.charAt(nextletter);
        int [] sb = new int[1];
        getInt(nextletter + 1, sb);
        repeat = sb[0];

        queue.add(n, repeat-1);

        repeat = 0;
        nextletter += lenghtOfDigit + 1;
        lenghtOfDigit = 0;
        return n;
    }

    public boolean hasNext() {
        if (queue.isEmpty()) {
            return nextletter < str.length();
        } else return true;
    }

    private void getInt(int startFrom, int []sb) {
        if (startFrom < str.length() && Character.isDigit(str.charAt(startFrom))) {
            lenghtOfDigit++;
            sb[0] = sb[0] * 10 + str.charAt(startFrom) - '0';
            getInt(startFrom + 1, sb);
        }
    }

    private class Holder {
        int i = 0;
        char current = ' ';

        public boolean isEmpty() {
            return i == 0;
        }

        public char poll() {
            i--;
            return current;
        }

        public void add(char n, int repeat) {
            i = repeat;
            current = n;
        }
    }
}

class Runne_r {
    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t10C1o1d1e1");
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
