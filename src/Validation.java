import java.time.LocalDate;
import java.util.Scanner;

public class Validation {

    public static Scanner scanner = new Scanner(System.in);

    public static final String[] months =

            {
                    "Январь", "Февраль", "Март",
                    "Апрель", "Май", "Июнь",
                    "Июль", "Август", "Сентябрь",
                    "Октябрь", "Ноябрь", "Декабрь"
            };

    public int year = LocalDate.now().getYear();

    public int inputUserMonth() {

        while (true) {
            System.out.println("Введите номер месяца в году за который вы хотите ввести шаги: ");
            printMonth();
            int month = scanner.nextInt();

            if ((month < 1) || (month > 12)) {
                System.out.println("Введено некорректное значение месяца. Начните сначала.");
            } else {

                String nameMonth = months[month - 1];
                System.out.println("Выбран: " + nameMonth);
                return month;
            }
        }
    }

    public int inputUserDay(int month) {

        Converter converter = new Converter();

        String message = "Введена некорректная дата. Начните сначала.";

        while (true) {

            System.out.println("Введите дату: ");

            int day = scanner.nextInt();

            if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {

                if ((day < 1) || (day > 31)) {
                    System.out.println(message);
                } else {
                    return day;
                }
            }

            if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {

                if ((day < 1) || (day > 30)) {
                    System.out.println(message);
                } else {
                    return day;
                }
            }

            if (month == 2) {

                if (converter.isLeapYear(year)) {

                    System.out.println("На дворе " + year + " год (не високосный)");

                    if ((day < 1) || (day > 28)) {
                        System.out.println(message);

                    } else {
                        return day;
                    }
                } else {
                    System.out.println("На дворе " + year + " год (високосный)");
                    if ((day < 1) || (day > 29)) {
                        System.out.println(message);
                    } else {
                        return day;
                    }
                }
            }
        }
    }

    public int inputUserStep() {
        while (true) {
            System.out.println("Введите количество пройденных шагов за выбранную дату: ");
            int step = scanner.nextInt();
            if (step < 0) {
                System.out.println("Количество шагов не должно быть отрицательным. Начните сначала.");
            } else {
                return step;
            }
        }
    }

    private void printMonth() {

        for (int i = 0; i < months.length; i++) {

            System.out.println((i + 1) + " - " + months[i]);
        }
    }
}
