package graph.dynamicConnecctivity;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        QuickFind quickFind = new QuickFind(n);

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!quickFind.connected(p, q)) {
                quickFind.unit(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
