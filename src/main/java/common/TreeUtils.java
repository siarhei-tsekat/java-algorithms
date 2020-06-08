package common;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    public static void print(TreeNode node) {
        List<List<Integer>> list = new ArrayList<>();

        function(node, 0, list);

        for (int i = 0, j = list.size(); i < list.size(); i++, j--) {
            printLeft(list.size() - i, j);
            printInts(list.get(i));
            newline();
        }
    }

    private static void newline() {
        System.out.println();
    }

    private static void printInts(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(" ");
            System.out.print(integer);
            System.out.print(" ");
        }
    }

    private static void printLeft(int i1, int i) {
        for (int j = 0; j < i; j++) {
            System.out.print(getValuee(i));
        }
    }

    private static String getValuee(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int j = 0; j < i/2; j++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private static void function(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) return;

        if (list.size() <=level) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);

        function(node.left, level + 1, list);
        function(node.right, level + 1, list);
    }
}
