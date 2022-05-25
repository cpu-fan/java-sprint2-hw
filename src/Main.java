import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReportsManager monthlyReportsManager = new MonthlyReportsManager();
        YearlyReportManager yearlyReportManager = new YearlyReportManager();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReportsManager.parsedMonthlyReportFromFile();
            } else if (command == 2) {
                yearlyReportManager.parsedYearlyReportFromFile();
            } else if (command == 3) {
                // Сверить отчёты
                System.out.println("\nЗдесь будет команда " + command);
            } else if (command == 4) {
                try {
                    monthlyReportsManager.printMonthlyReportsInfo();
                } catch (Exception e) {
                    System.out.println("\nПожалуйста, сначала считайте все месячные отчеты.");
                }
            } else if (command == 5) {
                // Вывести информацию о годовом отчёте
                yearlyReportManager.printProfitPerMonth();
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

