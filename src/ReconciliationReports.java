public class ReconciliationReports {

    public void checkReports(MonthlyReportsManager monthlyReportsManager, YearlyReportManager yearlyReportManager) {
        int countError = 0;
        for (int i = 1; i <= 3 ; i++) {
            int expenseInYearlyReport = yearlyReportManager.yearlyReportExpenses.get(i).amount;
            int profitInYearlyReport = yearlyReportManager.yearlyReportProfits.get(i).amount;
            int expenseInMonthlyReport = monthlyReportsManager.getMonthSumExpenses(i, monthlyReportsManager);
            int profitInMonthlyReport = monthlyReportsManager.getMonthSumProfits(i, monthlyReportsManager);

            if ((expenseInMonthlyReport != expenseInYearlyReport) || (profitInMonthlyReport != profitInYearlyReport)) {
                System.out.println("\nНайдено несоответствие в месяце" + i);
                countError++;
            }
        }
        if (countError == 0) {
            System.out.println("\nВсе отчёты сверены, несоответствий нет!");
        }
    }
}
