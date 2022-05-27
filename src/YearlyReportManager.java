import java.util.HashMap;

public class YearlyReportManager {
    HashMap<Integer, YearlyReportRow> yearlyReportExpenses = new HashMap<>();
    HashMap<Integer, YearlyReportRow> yearlyReportProfits = new HashMap<>();

    public void printYearlyReportsInfo() {
        System.out.println("\nИНФОРМАЦИЯ ЗА 2021 ГОД");

        int monthlyProfit;
        double avgExpense = 0;
        double avgProfit = 0;
        for (int i = 1; i <= 3; i++) {
            monthlyProfit = yearlyReportProfits.get(i).amount - yearlyReportExpenses.get(i).amount;
            avgExpense += yearlyReportExpenses.get(i).amount;
            avgProfit += yearlyReportProfits.get(i).amount;
            System.out.println("Прибыль за месяц " + i + " - " + monthlyProfit);
        }
        avgExpense = avgExpense / 3;
        avgProfit = avgProfit / 3;
        System.out.println("Средний расход за все месяцы в году - " + String.format("%.2f", avgExpense));
        System.out.println("Средний доход за все месяцы в году - " + String.format("%.2f", avgProfit));
    }

    public void parsedYearlyReportFromFile() {
        FileReader reader = new FileReader();
        yearlyReportExpenses = new HashMap<>();
        yearlyReportProfits = new HashMap<>();

        for (int i = 1; i <= 1; i++) {
            YearlyReportRow oneParsedRow;
            String[] rawRow = reader.readFile("resources/y.202" + i + ".csv").split(System.lineSeparator());

            for (int j = 1; j < rawRow.length; j++) {
                String[] parts = rawRow[j].split(",");
                int month = Integer.parseInt(parts[0]);
                int amount = Integer.parseInt(parts[1]);
                boolean isExpense = Boolean.parseBoolean(parts[2]);
                if (isExpense) {
                    oneParsedRow = new YearlyReportRow(month, amount, true);
                    yearlyReportExpenses.put(month, oneParsedRow);
                } else {
                    oneParsedRow = new YearlyReportRow(month, amount, false);
                    yearlyReportProfits.put(month, oneParsedRow);
                }
            }
        }
    }
}
