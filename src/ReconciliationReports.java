public class ReconciliationReports {

    public void checkReports(MonthlyReportsManager monthlyReportsManager, YearlyReportManager yearlyReportManager) {
        int countError = 0;
        for (int i = 1; i <= 3 ; i++) {
            int expenseInYearlyReport = yearlyReportManager.yearlyReportExpenses.get(i).amount;
            int profitInYearlyReport = yearlyReportManager.yearlyReportProfits.get(i).amount;
            if ((getMonthSumExpenses(i, monthlyReportsManager) != expenseInYearlyReport) || (getMonthSumProfits(i, monthlyReportsManager) != profitInYearlyReport)) {
                System.out.println("\nНайдено несоответствие в месяце" + i);
                countError++;
            }
        }
        if (countError == 0) {
            System.out.println("\nВсе отчёты сверены, несоответствий нет!");
        }
    }

    public int getMonthSumExpenses(int monthNumber, MonthlyReportsManager monthlyReportsManager) {
        int sumExpenses = 0;
        for (MonthlyReportRow values : monthlyReportsManager.monthlyReports.get(monthNumber)) {
            if (values.isExpense) {
                sumExpenses += (values.sumOfOne * values.quantity);
            }
        }
        return sumExpenses;
    }

    public int getMonthSumProfits(int monthNumber, MonthlyReportsManager monthlyReportsManager) {
        int sumProfits = 0;
        for (MonthlyReportRow values : monthlyReportsManager.monthlyReports.get(monthNumber)) {
            if (!values.isExpense) {
                sumProfits += (values.sumOfOne * values.quantity);
            }
        }
        return sumProfits;
    }
}
