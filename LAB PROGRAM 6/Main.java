import SEE.Externals;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = s.nextInt();

        Externals arr[] = new Externals[n];

        for(int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details of Student " + (i+1) + " ---");
            arr[i] = new Externals();
            arr[i].inputStudentDetails();
            arr[i].inputCIEmarks();
            arr[i].inputSEEmarks();
            arr[i].calculateFinalMarks();
        }

        System.out.println("\n============== FINAL MARKS ==============");
        for(int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i+1) + " ---");
            arr[i].displayFinalMarks();
        }
    }
    
}
