
import java.time.LocalDate;
import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    int[][] storage = new int[12][31];
    public int defaultStepGoal = 10000;

    public int stepGoal() {
        return defaultStepGoal;
    }

    public void updateGoalSteps() {
        System.out.println("Введите целевое кол-во шагов в день, которое вы хотите задать: ");
        int goal = scanner.nextInt();
        if (goal > 0) {
            defaultStepGoal = goal;
            System.out.println("Целевое кол-во шагов в день изменено и составляет: " + defaultStepGoal);
        } else
            System.out.println("Целевое кол-во шагов не может быть отрицательным или нулевым ");

    }

    void saveCountSteps(int numberDay, int month, int quantityStep) {
        if (quantityStep > 0) {
            storage[month - 1][numberDay - 1] = quantityStep;
            System.out.println("Шаги записаны.");
            System.out.println("Кол-во пройденных шагов за " + numberDay + "-й " + "день"
                    + " в месяце " + getMonth(month) + ": " + quantityStep);
        } else
            System.out.println("Кол-во шагов не должно быть отрицательным.");
    }

    public void sumStepsOfMonth(int month) {

        int stepsPerMonth = 0;

        for (int i = month - 1; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                stepsPerMonth += storage[i][j];
            }
        }

        System.out.println("Общее кол-во шагов за " + getMonth(month) + " составило - " + stepsPerMonth);
    }

    public void maxStepsOfMonth(int month) {
        int maxStep = 0;
        for (int i = month - 1; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                if (storage[i][j] > maxStep) {
                    maxStep = storage[i][j];
                }
            }
        }
        System.out.println("Максимальное пройденное кол-во шагов за " + getMonth(month) + " составило - " + maxStep);

    }

    public void averageStepsOfMonth(int month) {

        int stepsPerMonth = 0;

        for (int i = month - 1; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                stepsPerMonth += storage[i][j];
            }
        }

        System.out.println("Среднее кол-во шагов за " + getMonth(month) + " составило - "
                + (stepsPerMonth / inputUserDay(month)));
    }

    public void bestSeriesOfMonth(int stepGoal, int month) {
        int seriesDay = 0;
        int flag = 0;
        for (int i = month - 1; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                if (storage[i][j] >= stepGoal) {
                    flag++;
                    if (flag > seriesDay) {
                        seriesDay = flag;
                    }
                } else flag = 0;
            }
        }
        System.out.println("Лучшая серия: максимальное кол-во подряд идущих дней, в течение которых кол-во шагов " +
                "за день было равно или выше целевого за " + getMonth(month) + " составило: " + seriesDay);
    }

    public void distanceOfMonth(int month) {
        int stepsPerMonth = 0;
        for (int i = month - 1; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                stepsPerMonth += storage[i][j];
            }
        }
        System.out.println("Пройденная дистанция за " + getMonth(month) + " составила - "
                + converter.distanceInKilometres(stepsPerMonth) + " км");
    }

    public void energySpentOfMonth(int month) {
        int stepsPerMonth = 0;
        for (int i = month - 1; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                stepsPerMonth += storage[i][j];
            }
        }
        System.out.println("Кол-во сожжённых килокалорий за " + getMonth(month) + " составило - "
                + converter.cCal(stepsPerMonth) + " килокалорий");
    }

    private String getMonth(int month) {

        return Validation.months[month - 1];
    }

    private float inputUserDay(int month) {

        short x = 0;

        Converter converter = new Converter();

        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {

            x = 31;
        }

        if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {

            x = 30;
        }

        if (month == 2) {

            if (converter.isLeapYear(LocalDate.now().getYear())) {

                x = 28;
            }
        } else {

            x = 29;
        }
        return x;
    }
}
