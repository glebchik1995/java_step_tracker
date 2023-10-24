public class Converter {
    public double distanceInKilometres(int sumStepMonth) {
        double distanceOneStep = 0.00075;
        return sumStepMonth * distanceOneStep;
    }

    public double cCal(int sumStepMonth) {
        double oneStep = 0.05;
        return sumStepMonth * oneStep;
    }

    public boolean isLeapYear(int year) {

        boolean is_leap_year;

        if (year % 4 == 0) {

            is_leap_year = true;

            if (year % 100 == 0) {

                is_leap_year = year % 400 == 0;
            }
        } else
            is_leap_year = false;

        return !is_leap_year;
    }
}
