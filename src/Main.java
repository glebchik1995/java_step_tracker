public class Main {

    public static void main(String[] args) {

        printStart();

        StepTracker stepTracker = new StepTracker();

        Validation validation = new Validation();

        System.out.println("Цель шагов на день: " + stepTracker.stepGoal());


        printMenu();

        while (true) {

            int userInput = Validation.scanner.nextInt();

            if (userInput == Constant.COMMAND_1) {

                int month = validation.inputUserMonth();

                int day = validation.inputUserDay(month);

                int step = validation.inputUserStep();

                stepTracker.saveCountSteps(day, month, step);

            } else if (userInput == Constant.COMMAND_2) {

                int month = validation.inputUserMonth();

                stepTracker.sumStepsOfMonth(month);

                stepTracker.maxStepsOfMonth(month);

                stepTracker.averageStepsOfMonth(month);

                stepTracker.bestSeriesOfMonth(stepTracker.stepGoal(), month);

                stepTracker.distanceOfMonth(month);

                stepTracker.energySpentOfMonth(month);

            } else if (userInput == Constant.COMMAND_3) {

                stepTracker.updateGoalSteps();

            } else if (userInput == Constant.COMMAND_4) {

                System.out.println("Программа завершена");

                break;

            } else {

                System.out.println("Извините, такой команды пока нет. Начните сначала.");

            }

            printMenu();
        }
    }

    public static void printMenu() {

        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести кол-во шагов за указанный день");
        System.out.println("2 - Вывести статистику за указанный месяц");
        System.out.println("3 - Изменить целевое кол-во шагов");
        System.out.println("4 - Выйти из приложения");

    }

    public static void printStart(){

        System.out.println(Constant.APPLICATION);

        System.out.println(Constant.GREETING_MESSAGE);
    }
}

