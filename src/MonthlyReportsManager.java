import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReportsManager {
    ArrayList<MonthlyReportRow> listMonthlyReportRows;
    HashMap<Integer, ArrayList<MonthlyReportRow>> monthlyReports;

    public void printMonthlyReportsInfo() {
        for (int i = 1; i <= 3; i++) {
            printMaxItemsInMonth(i);
        }
    }

    public void printMaxItemsInMonth(int monthNumber) {
        int maxExpense = 0;
        int maxProfit = 0;
        String nameMaxExpense = "";
        String nameMaxProfit = "";
        for (MonthlyReportRow values : monthlyReports.get(monthNumber)) {
            if (values.isExpense && (values.quantity * values.sumOfOne > maxExpense)) {
                maxExpense = values.quantity * values.sumOfOne;
                nameMaxExpense = values.itemName;
            }
            if (!values.isExpense && (values.quantity * values.sumOfOne > maxProfit)) {
                maxProfit = values.quantity * values.sumOfOne;
                nameMaxProfit = values.itemName;
            }
        }
        System.out.println("\nИНФОРМАЦИЯ ЗА МЕСЯЦ " + monthNumber);
        System.out.println("\tСамый прибыльный товар: \n\t\t" + nameMaxProfit + " - " + maxProfit);
        System.out.println("\tСамая большая трата: \n\t\t" + nameMaxExpense + " - " + maxExpense);
    }

    public void parsedMonthlyReportFromFile() {
        FileReader reader = new FileReader();
        monthlyReports = new HashMap<>();

        for (int i = 1; i <= 3; i++) {
            MonthlyReportRow oneParsedRow;
            listMonthlyReportRows = new ArrayList<>();
            String[] rawRow = reader.readFile("resources/m.20210" + i + ".csv").split(System.lineSeparator());

            for (int j = 1; j < rawRow.length; j++) {
                String[] parts = rawRow[j].split(",");
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int sumOfOne = Integer.parseInt(parts[3]);
                oneParsedRow = new MonthlyReportRow(itemName, isExpense, quantity, sumOfOne);
                listMonthlyReportRows.add(oneParsedRow);
            }
            monthlyReports.put(i, listMonthlyReportRows);
        }
    }
}
