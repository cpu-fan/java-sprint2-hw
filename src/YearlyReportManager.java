import java.util.ArrayList;

public class YearlyReportManager {
    ArrayList<YearlyReportRow> expenses;
    ArrayList<YearlyReportRow> profits;

    public void printYearlyReportsInfo() {
        System.out.println("\nИНФОРМАЦИЯ ЗА 2021 ГОД");

        int monthlyProfit;
        double avgExpense = 0;
        double avgProfit = 0;
        for (int i = 0; i < 3; i++) {
            monthlyProfit = profits.get(i).amount - expenses.get(i).amount;
            avgExpense += expenses.get(i).amount;
            avgProfit += profits.get(i).amount;
            System.out.println("Прибыль за месяц " + (i + 1) + " - " + monthlyProfit);
        }
        avgExpense = avgExpense / 3;
        avgProfit = avgProfit / 3;
        System.out.println("Средний расход за все месяцы в году - " + String.format("%.2f", avgExpense));
        System.out.println("Средний доход за все месяцы в году - " + String.format("%.2f", avgProfit));
    }

    public void parsedYearlyReportFromFile() {
        FileReader reader = new FileReader();
        expenses = new ArrayList<>();
        profits = new ArrayList<>();

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
                    expenses.add(oneParsedRow);
                } else {
                    oneParsedRow = new YearlyReportRow(month, amount, false);
                    profits.add(oneParsedRow);
                }
            }
        }
    }
}
