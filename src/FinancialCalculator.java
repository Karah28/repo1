import java.util.Scanner;
public class FinancialCalculator {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int[] Expensesdays = new int[30];

            while (true) {
                System.out.println("Меню:");
                System.out.println("1 - Ввести расходы на определенный день");
                System.out.println("2 - Показать расходы за месяц");
                System.out.println("3 - Показать самый большой расход за месяц");
                System.out.println("4 - Показать конвертацию расхода за каждый день");
                System.out.println("0 - Выход");
                System.out.print("Выберите опцию: ");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    Expenses(scanner, Expensesdays);
                } else if (choice == 2) {
                    Expensesmonth(Expensesdays);
                } else if (choice == 3) {
                    MaxExpense(Expensesdays);
                } else if (choice == 4) {
                    Convertexpenses(Expensesdays);
                } else if (choice == 0) {
                    System.out.println("Пока!");
                    System.exit(0);
                } else {
                    System.out.println("Неправильный выбор. Попробуйте снова!");
                }
            }
        }

        public static void Expenses(Scanner scanner, int[] expenses) {
            System.out.print("Введите день (от 1 до 31): ");
            int day = scanner.nextInt();

            if (day < 1 || day > 31) {
                System.out.println("Неверный день,попробуйте еще раз");
                return;
            }

            System.out.print("Введите расход за этот день: ");
            int amount = scanner.nextInt();

            expenses[day - 1] = amount;
            System.out.println("Расход за день " + day + "введён");
        }

        public static void Expensesmonth(int[] expenses) {
            System.out.println("Расход за месяц:");
            for (int i = 0; i < expenses.length; i++) {
                if (expenses[i] != 0) {
                    System.out.println((i + 1) + " день - " + expenses[i] + " рублей");
                }
            }
        }

        public static void MaxExpense(int[] expenses) {
            int maxExpense = 0;
            int maxDay = -1;

            for (int i = 0; i < expenses.length; i++) {
                if (expenses[i] > maxExpense) {
                    maxExpense = expenses[i];
                    maxDay = i + 1;
                }
            }

            if (maxDay != -1) {
                System.out.println("Самый высокий расход за месяц: " + maxDay + " день - " + maxExpense + " рублей");
            } else {
                System.out.println("Нет записей за этот месяц.");
            }
        }

        public static void Convertexpenses(int[] expenses) {
            double Euro = 0.0101;
            double Dollar = 0.0109;
            double Yuan = 0.079;

            System.out.println("Конвертация расхода:");
            for (int i = 0; i < expenses.length; i++) {
                if (expenses[i] != 0) {
                    double expenseEuro = expenses[i] * Euro;
                    double expenseDollar = expenses[i] * Dollar;
                    double expenseYuan = expenses[i] * Yuan;

                    System.out.println((i + 1) + " день - Евро: " + expenseEuro + ", Доллар: " + expenseDollar + ", Юани: " + expenseYuan);
                }
            }
        }
}
