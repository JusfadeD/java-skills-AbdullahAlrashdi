import java.util.Locale;

public class PayrollCalculator {
    public static double calculateWeeklyPay(String employeetype, double hoursWorked, double hourlyRate){
        if(hoursWorked < 0 || hourlyRate < 0){
            System.out.println("Invalid input: negative values. ");
            return 0.0;}

            switch (employeetype.toUpperCase()){
                case "FULL_TIME":
                    if (hoursWorked <= 40){
                        return hoursWorked * hourlyRate;
                    } else {
                        double overtime = (hoursWorked - 40) * hourlyRate * 1.5;
                        return 40 * hourlyRate + overtime;
                    }
                case "PART_TIME":
                    if (hoursWorked > 25) hoursWorked=25;
                    return hoursWorked * hourlyRate;

                case "CONTRACTOR":
                    return hoursWorked * hourlyRate;
                case "INTERN":
                    if (hoursWorked > 20) hoursWorked = 20;
                    double discountedRate = hourlyRate * 0.8;
                    return hoursWorked * discountedRate;
                default:
                    System.out.println("Invalid employee type: " + employeetype);
                    return 0.0;
            }

    }
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance){
        double tax;

        if (grossPay <= 500){
            tax =  grossPay * 0.10;
        }
        else if (grossPay <= 1000){
            tax = grossPay * 0.15;
        }
        else if (grossPay <= 2000){
            tax = grossPay * 0.2;
        }
        else{
            tax = grossPay * 0.25;
        }
        if (hasHealthInsurance){
            tax -= 50;
        }
        return Math.max(tax, 0);
    }
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names){
        int n = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));
        double totalPay = 0;
        int overtimeCount = 0;

        double maxPay = Double.MIN_VALUE;
        double minPay = Double.MAX_VALUE;
        String maxName = "";
        String minName = "";

        System.out.println("Name    Type    Hours    Gross     Net");

        for (int i = 0; i < n; i++) {
            double gross = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(gross, true);
            double net = gross - tax;

            System.out.println(names[i] + " " +  employeeTypes[i]+" "   + hours[i]+" "  + gross+" " + net);

            totalPay += gross;
            if (hours[i] > 40) overtimeCount++;

            if (gross > maxPay) {
                maxPay = gross;
                maxName = names[i];
            }

            if (gross < minPay) {
                minPay = gross;
                minName = names[i];
            }
        }
        System.out.println("\nHighest Paid: " + maxName + " ($" + maxPay + ")");
        System.out.println("Lowest Paid : " + minName + " ($" + minPay + ")");
        System.out.println("Average Pay : " + totalPay / n);
        System.out.println("Employees with overtime: " + overtimeCount);
    }
    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Abdullah", "Muhammed", "Daniyel", "Ahmed", "Sami"};

        System.out.println("Sample Pay Test:");
        System.out.println("Abdullah Pay: $" + calculateWeeklyPay("FULL_TIME", 45, 25.0));
        System.out.println("Abdullah Tax: $" + calculateTaxDeduction(1187.5, true));

        System.out.println("\n    Payroll Summary    ");
        processPayroll(types, hours, rates, names);
    }
}
