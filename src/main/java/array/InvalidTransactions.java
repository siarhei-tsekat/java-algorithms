package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvalidTransactions {

    public List<String> invalidTransactions(String[] transactions) {

        List<String> res = new ArrayList<>();
        Map<String, List<Transaction>> map = groupByName(transactions);

        for (String name : map.keySet()) {
            List<Transaction> list = map.get(name);

            for (int i = 0; i < list.size(); i++) {
                if (invalid(list, list.get(i))) {
                    res.add(list.get(i).toString());
                }
            }
        }

        return res;
    }

    private boolean invalid(List<Transaction> list, Transaction t) {
        if (t.amount > 1000) {
            return true;
        }
        for (Transaction o : list) {
            if (o == t) {
                continue;
            }

            if (Math.abs(o.time - t.time) <= 60 && !o.city.equals(t.city)) {
                return true;
            }
        }
        return false;
    }

    private Map<String, List<Transaction>> groupByName(String[] transactions) {
        return Arrays.stream(transactions)
                .map(Transaction::new)
                .collect(Collectors.groupingBy(tr -> tr.name));
    }
}

class Transaction {
    String str;
    String name;
    int time;
    int amount;
    String city;

    Transaction(String str) {
        this.str = str;
        String[] t = str.split(",");
        name = t[0];
        time = Integer.parseInt(t[1]);
        amount = Integer.parseInt(t[2]);
        city = t[3];
    }

    @Override
    public String toString() {
        return str;
    }
}
