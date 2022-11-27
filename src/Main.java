import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Приветствую, дорогой пользователь! Счастье рядом — просто открой глаза и сделай шаг навстречу.");

        int stepGoal = 10000;

        System.out.println("Цель шагов на день: " + stepGoal);

        String[] months = {"Январь","Февраль","Март","Апрель","Май", "Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};

        StepTracker stepTracker = new StepTracker();

        printMenu();

        while (true) {

            int userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("Введите месяц за какой вы хотите ввести шаги: ");

                for (int i = 0; i < months.length; i++) {
                    System.out.println((i + 1) + " - " + months[i]);
                }
                int numberMonth = scanner.nextInt();

                String month = months[numberMonth - 1];
                if(numberMonth >= 1 && numberMonth <=12){
                    System.out.println("Выбран: " + month);}
                System.out.println("Выберете число от 1 до 30 за которое хотите ввести шаги");
                int numberDay = scanner.nextInt();
                System.out.println("Введите кол-во пройденных шагов за " + numberDay + "-й" + " день месяца " + month + ":");
                int quantityStep = scanner.nextInt();
                stepTracker.addSteps(month,numberDay,quantityStep);

            } else if (userInput == 2) {
                System.out.println("Укажите за какой месяц вы хотите получить статистику: ");
                for(int i = 0; i < months.length; i++) {
                    System.out.println((i + 1) + " - " + months[i]);
                }
                int monthNumber = scanner.nextInt();
                String month = months[monthNumber - 1];

                stepTracker.sumStepInMonth(month);
                stepTracker.maxStep(month);
                stepTracker.averageStep(month);
                stepTracker.bestSeries(stepGoal,month);
                stepTracker.distance(month);
                stepTracker.energySpent(month);

            } else if (userInput == 3) {
                stepGoal = stepTracker.newGoalSteps();
                if(stepGoal >= 0) {
                    System.out.println("Целевое кол-во шагов в день изменено и составляет: " + stepGoal);
                } else
                    System.out.println("Целевое кол-во шагов не может быть отрицательным");

            } else if (userInput == 4) {
                System.out.println("Программа завершена");
                break;

            } else{
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu();
        }
    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести кол-во шагов за указанный день");
        System.out.println("2 - Вывести статистику за указанный месяц");
        System.out.println("3 - Измененить целевое кол-во шагов");
        System.out.println("4 - Выйти из приложения");

    }
}

