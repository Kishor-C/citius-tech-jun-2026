import java.util.Scanner;

public class TestConditions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter total marks:-");
        double total = scan.nextDouble();
        System.out.println("Your grade is:-");
        if(total >= 80) 
            System.out.println("A+");
        else if(total < 80 && total >= 70) 
            System.out.println("A");
        else if(total < 70 && total >= 60) 
            System.out.println("B");
        else
            System.out.println("B-");
        int option = 0;
        System.out.println("1: Print out 2: Convert to PDF 3: Exit");
        option = scan.nextInt();
        switch(option) {
            case 1 : {
                System.out.println("Printing request sent");
                break;
            }
            case 2: {
                System.out.println("Converting to pdf");
                break;
            }
            case 3: System.out.println("Exit");
            default: System.out.println("Wrong option");
        }

        scan.close();
    }
}
