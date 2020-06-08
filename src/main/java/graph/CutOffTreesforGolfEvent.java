package graph;

import java.util.ArrayList;
import java.util.List;

public class CutOffTreesforGolfEvent {

    private static final int OBST = 0;

    public int cutOffTree(List<List<Integer>> list) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) != OBST)
                    dfs(i, j, list, 0, res);
            }
        }
        return res.size();
    }

    private void dfs(int row, int column, List<List<Integer>> list, int previousV, List<Integer> res) {
        boolean endOfArray = row < 0 || row >= list.size() || column < 0 || column > list.get(row).size();
        if (endOfArray) return;

        Integer currentV = list.get(row).get(column);

        if (previousV >= currentV) return;

        res.add(1);
        dfs(row + 1, column, list, currentV, res);
        dfs(row - 1, column, list, currentV, res);
        dfs(row, column + 1, list, currentV, res);
        dfs(row, column - 1, list, currentV, res);
    }
}
