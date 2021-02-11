import java.util.Scanner;

public class PhoneBill {

    static  Scanner console = new Scanner(System.in);
    public static void main(String []args ) {


        final double Minutes_FeeR = 0.20;
      final double Monthly_FeeR = 10.00;

        final double MonthlyFEEP = 25.00;
        final double DayTimeFeeP = 0.10;
        final double NightFEEP = 0.05;
        final double maxDayMin = 75.00;
        final double maxNightMin = 100.00;

        double amountDueR;
        double amountDueP;
        int acct=0;
        char ServiceType;
        double minutes;
        double DayMinutesUsed;
        double NightMinutesUsed;
        double dayChargeP;
        double NightChargeP;


        System.out.println("Welcome to TelTech Wireless");
        System.out.println("Please enter the account number");
        if (console.hasNext())
        {
            acct = console.nextInt();
            System.out.println();
        }
        else
        {
         System.out.println("Incorrect Data: Enter Proper account Number");
         System.exit(0);

        }

        System.out.print("Please enter the service type: "
                        + " A or a (Regular), "
                        + "B or b (Premium):  ");
        ServiceType=console.next().charAt(0);
        System.out.println();


        switch (ServiceType) {
            case 'A', 'a' -> {
                System.out.print(" Enter the number of minutes used ");
                minutes = console.nextDouble();
                System.out.println();

                if (minutes <= 50) {

                    amountDueR = (Monthly_FeeR);
                } else
                    {

                    amountDueR = Monthly_FeeR + (minutes - 50) * Minutes_FeeR;
                }
                System.out.println("Account Number : " + acct);
                System.out.println("Type of Service: " + ServiceType);
                System.out.print(" Minutes used: " + minutes);
                System.out.print("Amount Due:" + amountDueR);

            }
            case 'B', 'b' -> {
                System.out.print("Enter minutes used from 6am to 6pm: ");
                DayMinutesUsed = console.nextDouble();
                System.out.println();

                if (DayMinutesUsed > maxDayMin)
                    dayChargeP = ((DayMinutesUsed - maxDayMin) * DayTimeFeeP);

                else
                    dayChargeP = 0.0;

                System.out.print("Enter minutes used from 6pm to 6am: ");
                NightMinutesUsed = console.nextDouble();
                System.out.println();

                if (NightMinutesUsed > maxNightMin)
                    NightChargeP = ((NightMinutesUsed - maxNightMin) * NightFEEP);

                else
                    NightChargeP = 0.0;


                amountDueP = MonthlyFEEP + NightChargeP + dayChargeP;

                System.out.println("Type of service:" + ServiceType);
                System.out.print("Day minutes used: " + DayMinutesUsed);
                System.out.print("Night minutes used: "+ NightMinutesUsed);
                System.out.print("Amount Due: " + amountDueP);
                System.out.println();
            }
            default -> {
                System.out.println("Wrong Customer Type");
            }
        }

    }

}
