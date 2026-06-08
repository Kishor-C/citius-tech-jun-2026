public class TestLoops {
    public static void main(String[] args) {
        int[] marks = {60, 70, 40, 50, 95};
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        for(int i = 0; i < marks.length; i++) {
            System.out.println("marks[i] = "+marks[i]);
        }
        // do while loop
        int counter = 0;
        do {
            System.out.println("do while counter = "+counter);
            counter++;
        } while(counter <= 0);
        // while loop
        while(counter <= 0) {
            System.out.println("while counter = "+counter);
        }
    }
}
