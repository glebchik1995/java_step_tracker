public class Converter {
    double distanceInKilometres(int sumStepMonth){
        double distanceOneStep = 0.00075;
        return sumStepMonth * distanceOneStep;
    }
    double cCal(int sumStepMonth){
        double oneStep = 0.05;
        return  sumStepMonth * oneStep;
    }
}
