public class ReconciliationReports {
    MonthlyReportsManager monthlyReportsManager = new MonthlyReportsManager();
    YearlyReportManager yearlyReportManager = new YearlyReportManager();

    public void checkReports() {
        monthlyReportsManager.parsedMonthlyReportFromFile();
        yearlyReportManager.parsedYearlyReportFromFile();
        int countError = 0;
        for (int i = 1; i <= 3 ; i++) {
            int expenseInYearlyReport = yearlyReportManager.expenses.get(i - 1).amount;
            int profitInYearlyReport = yearlyReportManager.profits.get(i - 1).amount;
            if ((getMonthSumExpenses(i) != expenseInYearlyReport) || (getMonthSumProfits(i) != profitInYearlyReport)) {
                System.out.println("\nНайдено несоответствие в месяце" + i + "е!");
                countError++;
            }
        }
        if (countError == 0) {
            System.out.println("\nВсе отчёты сверены, несоответствий нет!");
        }
    }

    public int getMonthSumExpenses(int monthNumber) {
        int sumExpenses = 0;
        for (MonthlyReportRow values : monthlyReportsManager.monthlyReports.get(monthNumber)) {
            if (values.isExpense) {
                sumExpenses += (values.sumOfOne * values.quantity);
            }
        }
        return sumExpenses;
    }

    public int getMonthSumProfits(int monthNumber) {
        int sumProfits = 0;
        for (MonthlyReportRow values : monthlyReportsManager.monthlyReports.get(monthNumber)) {
            if (!values.isExpense) {
                sumProfits += (values.sumOfOne * values.quantity);
            }
        }
        return sumProfits;
    }
}
