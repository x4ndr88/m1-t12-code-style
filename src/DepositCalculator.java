import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositYearCount) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositYearCount);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositYearCount) {
        return round(amount + amount * yearRate * depositYearCount, 2);
    }

    double round(double value, int floatPointPlace) {
        double scale = Math.pow(10, floatPointPlace);
        return Math.round(value * scale) / scale;
    }

    void runDepositCalculatePercentTask() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double calculatedPercent = 0;

        if (action == 1) {
            calculatedPercent = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            calculatedPercent = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + calculatedPercent);
    }

    public static void main(String[] args) {
        new DepositCalculator().runDepositCalculatePercentTask();
    }
}
