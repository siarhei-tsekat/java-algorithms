package graph;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class AccountsMerge {
    List<List<String>> acc;

    private class Account {
        public String name;
        public Integer idInAccList;
        public List<String> emails = new ArrayList<>();

        public Account(String name, Integer idInAccList) {
            this.name = name;
            this.idInAccList = idInAccList;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> acc) {
        this.acc = acc;
        HashMap<String, List<Account>> emailAccountsMap = new HashMap<>();

        for (int account = 0; account < acc.size(); account++) {
            for (int email = 1; email < acc.get(account).size(); email++) {
                List<Account> orDefault = emailAccountsMap.getOrDefault(acc.get(account).get(email), new ArrayList<>());
                orDefault.add(new Account(acc.get(account).get(0), account));
                emailAccountsMap.put(acc.get(account).get(email), orDefault);
            }
        }

        int[] parents = new int[acc.size()];
        for (int i = 0; i < parents.length; i++) parents[i] = i;

        for (Map.Entry<String, List<Account>> entry : emailAccountsMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                List<Account> connections = entry.getValue();
                for (int i = 0; i < connections.size(); i++) {
                    for (int j = i + 1; j < connections.size(); j++) {
                        int f = find(connections.get(i).idInAccList, parents);
                        int s = find(connections.get(j).idInAccList, parents);

                        if (f != s) parents[f] = s;
                    }
                }
            }
        }
        HashMap<Integer, List<Integer>> all = new HashMap<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < parents.length; i++) {
            int parent = find(i, parents);
            List<Integer> orDefault = all.getOrDefault(parent, new ArrayList<>());
            orDefault.add(i);
            all.put(parent, orDefault);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : all.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(merge(entry.getValue()));
            } else res.add(getAsIs(entry.getValue().get(0)));
        }
        return res;
    }

    private List<String> getAsIs(int i) {
        HashSet<String> set = new HashSet<>(acc.get(i));
        List<String> list = set.stream().collect(Collectors.toList());
        Collections.sort(list);
        return list;
    }

    private List<String> merge(List<Integer> list) {
        HashSet<String> set = new HashSet<>();
        list.forEach(id -> set.addAll(acc.get(id)));
        List<String> collect = set.stream().collect(Collectors.toList());
        Collections.sort(collect);
        return collect;
    }

    public int find(int accountId, int[] parents) {
        if (parents[accountId] == accountId) return accountId;
        else {
            parents[accountId] = parents[parents[accountId]];
            return find(parents[accountId], parents);
        }
    }
}

class Runner__ {
    public static void main(String[] args) {
        List<List<String>> var = new ArrayList<>(asList(
                new ArrayList<>(asList("John", "johnsmith@mail.com", "john_newyork@mail.com")),
                new ArrayList<>(asList("John", "johnsmith@mail.com", "john00@mail.com")),
                new ArrayList<>(asList("Mary", "mary@mail.com")),
                new ArrayList<>(asList("John", "johnnybravo@mail.com"))));
        AccountsMerge accountsMerge = new AccountsMerge();
        for (List<String> list : accountsMerge.accountsMerge(var)) {
            System.out.println(list);
        }
    }
}