
import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);

    Converter converter = new Converter();
    int[] days_in_a_month = new int[30];

    int newGoalSteps() {
        System.out.println("Введите целевое кол-во шагов в день, которое вы хотите задать: ");
        return scanner.nextInt();
    }

    void addSteps(String month, int numberDay, int quantityStep) {
        if (quantityStep >= 0) {
            days_in_a_month[numberDay] = quantityStep;
            System.out.println("Шаги записаны.");
            System.out.println("Кол-во пройденных шагов за " + numberDay + "-й " + "день" + " в месяце " + month + ": " + quantityStep);
        } else
            System.out.println("Кол-во шагов не должно быть отрицательным.");
    }

    void sumStepInMonth(String month) {
        int stepsPerMonth = 0;
        for (int i = 0; i < days_in_a_month.length; i++) {
            stepsPerMonth += days_in_a_month[i];
        }
        System.out.println("Общее кол-во шагов за " + month + " составило - " + stepsPerMonth);
    }

    void maxStep(String month) {
        int maxStep = 0;
        for (int i = 0; i < days_in_a_month.length; i++) {
            if (days_in_a_month[i] > maxStep) {
                maxStep = days_in_a_month[i];
            }
        }
        System.out.println("Максимальное пройденное кол-во шагов за " + month + " составило - " + maxStep);
    }

    void averageStep(String month) {
        int stepsPerMonth = 0;
        int day = 30;
        for (int i = 0; i < days_in_a_month.length; i++) {

            stepsPerMonth += days_in_a_month[i];
        }
        System.out.println("Среднее кол-во шагов за " + month + " составило - " + (stepsPerMonth / day));
    }

    void bestSeries(int stepGoal, String month) {
        int SeriesDay = 0;
        int flag = 0;
        for (int i = 0; i < days_in_a_month.length; i++) {
            if (days_in_a_month[i] >= stepGoal) {
                flag++;
                if (flag > SeriesDay) {
                    SeriesDay = flag;
                }
            } else flag = 0;
        }
        System.out.println("Лучшая серия: максимальное кол-во подряд идущих дней, в течение которых кол-во шагов за день было равно или выше целевого за " + month + " составило - " + SeriesDay);
    }

    void distance(String month) {
        int stepsPerMonth = 0;
        for (int i = 0; i < days_in_a_month.length; i++) {
            stepsPerMonth += days_in_a_month[i];
        }
        System.out.println("Пройденная дистанция за " + month + " составила - " + converter.distanceInKilometres(stepsPerMonth) + " км");
    }

    void energySpent(String month) {
        int stepsPerMonth = 0;
        for (int i = 0; i < days_in_a_month.length; i++) {
            stepsPerMonth += days_in_a_month[i];
        }
        System.out.println("Кол-во сожжённых килокалорий за " + month + " составило - " + converter.cCal(stepsPerMonth) + " килокаллорий");
    }
}
