package graph;

import common.SerialGraph;
import common.SerialNode;

public class ByteMasking {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = true;
        boolean c = false;
        boolean d = true;
        boolean f = false;
        boolean g = true;
        int result = 0;
        result |= (1 << 1);
        result &=~ (1 << 2);
        result |= (1 << 3);
        result &=~ (1 << 4);
        result &=~ (1 << 5);
        result &=~(1 << 6);

        System.out.println(result & (1 << 1));
        System.out.println(result & (1 << 2));
        System.out.println(result & (1 << 3));
        System.out.println(result & (1 << 4));
        System.out.println(result & (1 << 5));
        System.out.println(result & (1 << 6));

    }
}


