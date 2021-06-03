/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Edmund Johnson V
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/*
You don’t always need a complex control structure to solve simple problems. Sometimes a program requires an extra step in one case, but in all other cases there’s nothing to do.

Write a simple program to compute the tax on an order amount. The program should prompt for the order amount and the state. If the state is “WI,” then the order must be charged 5.5% tax. The program should display the subtotal, tax, and total for Wisconsin residents but display just the total for non-residents.

Example Output
What is the order amount? 10
What is the state? WI
The subtotal is $10.00.
The tax is $0.55.
The total is $10.55.
Or

What is the order amount? 10
What is the state? MN
The total is $10.00

Constraints
Implement this program using only a simple if statement—don’t use an else clause.
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
 */
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] arg){
        float amount = getAmount();
        int state = getState();
        if(state == 1){
            System.out.println(residents(amount));
        }
        else{
            System.out.println(nonResidents(amount));
        }
    }

    private static float getAmount(){
        System.out.print("What is the order amount? ");
        String x = in.nextLine();
        return Float.parseFloat(x.replace(" ", ""));
    }

    private static int getState(){
        System.out.print("What is the state? ");
        String x = in.nextLine();
        if(x.equals("WI")){
            return 1;
        }
        else{
            return 0;
        }
    }

    private static String residents(float amount){
        DecimalFormat d = new DecimalFormat("0.00");
        float tax = amount * (float)0.055;
        return "The subtotal is $" + d.format(amount) + ".\nThe tax is $" + d.format(tax) + ".\nThe total is $" + (amount + tax) + ".";
    }

    private static String nonResidents(float amount){
        DecimalFormat d = new DecimalFormat("0.00");
        return "The total is $" + d.format(amount);
    }
}
