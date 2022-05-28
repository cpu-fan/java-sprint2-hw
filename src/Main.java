import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReportsManager monthlyReportsManager = new MonthlyReportsManager();
        YearlyReportManager yearlyReportManager = new YearlyReportManager();
        ReconciliationReports reconciliation = new ReconciliationReports();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReportsManager.parsedMonthlyReportFromFile();
                System.out.println("\nМесячные отчеты считаны!");
            } else if (command == 2) {
                yearlyReportManager.parsedYearlyReportFromFile();
                System.out.println("\nГодовой отчет считан!");
            } else if (command == 3) {
                if (monthlyReportsManager.monthlyReports.size() != 0 && yearlyReportManager.yearlyReportProfits.size() != 0 && yearlyReportManager.yearlyReportExpenses.size() != 0 ) {
                    reconciliation.checkReports(monthlyReportsManager, yearlyReportManager);
                } else {
                    System.out.println("\nПожалуйста, сначала считайте все месячные и годовой отчеты.");
                }
            } else if (command == 4) {
                if (monthlyReportsManager.monthlyReports.size() != 0 && yearlyReportManager.yearlyReportProfits.size() != 0 && yearlyReportManager.yearlyReportExpenses.size() != 0 ) {
                    monthlyReportsManager.printMonthlyReportsInfo();
                } else {
                    System.out.println("\nПожалуйста, сначала считайте все месячные отчеты.");
                }
            } else if (command == 5) {
                if (monthlyReportsManager.monthlyReports.size() != 0 && yearlyReportManager.yearlyReportProfits.size() != 0 && yearlyReportManager.yearlyReportExpenses.size() != 0 ) {
                    yearlyReportManager.printYearlyReportsInfo();
                } else {
                    System.out.println("\nПожалуйста, сначала считайте годовой отчет.");
                }
            } else if (command == 0) {
                System.out.println("\nПрограмма завершена. До встречи!");
                break;
            } else {
                System.out.println("\nКоманды под номером \"" + command + "\" еще не существует.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nЧто хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход из программы");
        System.out.print("Для выбора введите номер команды: ");
    }
}

