package graph;

public class FindTheTownJudge_v2 {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }


    public static int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            return 1;
        }
        int[] iHaveRelationWith = new int[N + 1];
        int[] theyHaveRelationWith = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            addToMyRelation(trust[i], iHaveRelationWith);
            addMeToRelation(trust[i], theyHaveRelationWith, N);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < theyHaveRelationWith.length; i++) {
            if (theyHaveRelationWith[i] == N - 1) {
                res = i;
            }
        }

        if (iHaveRelationWith.length-1 >= res && iHaveRelationWith[res] == 0){
            return res;
        } else{
            return -1;
        }
    }

    private static void addMeToRelation(int[] data, int[] theyHaveRelationWith, int N) {
        int val = -1;
        if ((val = theyHaveRelationWith[data[1]]) != 0) {
            theyHaveRelationWith[data[1]] = val + 1;
        } else {
            theyHaveRelationWith[data[1]] = 1;
        }

    }

    private static void addToMyRelation(int[] data, int[] iHaveRelationWith) {
        iHaveRelationWith[data[0]] = 1;
    }
}
