package fox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tmp {
    public static void main(String[] args) {
        List<BankTranS> dataTableRows = new ArrayList<>();

        List<Obligation> allObligations = new ArrayList<>();

        List<Obligation> collect = allObligations.stream()
                .filter(obl -> reasonIsEqual(dataTableRows, obl))
                .filter(obl -> amountIsEqual(dataTableRows, obl))
                .collect(Collectors.toList());
    }

    private static boolean amountIsEqual(List<BankTranS> dataTableRows, Obligation obl) {
        return dataTableRows.stream().anyMatch(d -> d.journalEntries.stream().anyMatch(j -> j.getMappedAmount().toString().equals(obl.getAmount())));
    }

    private static boolean reasonIsEqual(List<BankTranS> dataTableRows, Obligation obl) {
        return dataTableRows.stream().anyMatch(b -> b.journalEntries.stream().anyMatch(j -> j.getReason().equals(obl.getReason())));
    }
}

class BankTranS {
    class JournalEntries {
        public String getReason() {
            return "";
        }

        public Double getMappedAmount() {
            return 0.0;
        }
    }

    List<JournalEntries> journalEntries = new ArrayList<>();
}

class Obligation {




    public String getReason() {
        return "";
    }

    public String getAmount() {
        return "0.0";
    }
}
