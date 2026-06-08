import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // next(), nextLine(), nextInt(), nextDouble(), nextLong() and so on
        System.out.println("Enter name:-");
        // for a single word - next
        String name = scan.next();
        scan.nextLine();
        System.out.println("Enter profession:-");
        String profession = scan.nextLine();
        System.out.println("Enter expected salary:-");
        double salary = scan.nextDouble();
        System.out.println("Enter your experience:-");
        int years = scan.nextInt();
        System.out.println("Name="+name+", Profession="+profession);
        System.out.println("Experience="+years);
        System.out.println("Expected CTC: "+salary);
        scan.close();
    }
}
