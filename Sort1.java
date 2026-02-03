import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sort1 {
    public static void main(String[] args) {

        List<int[]> frame = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of frames:");
        int n = sc.nextInt();

        Random random = new Random(); // create once

        for (int i = 0; i < n; i++) {
            int seqNum = random.nextInt(1000) + 1;
            System.out.printf("Enter data for %dth frame>> ", i + 1);
            int data = sc.nextInt();
            frame.add(new int[]{seqNum, data});
        }

        System.out.println("\nBefore Sorting>>");
        for (int[] i : frame) {
            System.out.printf("seqNum->%d, Data->%d\n", i[0], i[1]);
        }

        sortFrame(frame);

        System.out.println("\nAfter Sorting>>");
        for (int[] i : frame) {
            System.out.printf("seqNum->%d, Data->%d\n", i[0], i[1]);
        }

        sc.close();
    }

    public static void sortFrame(List<int[]> frame) {
        Collections.sort(frame, (a, b) -> Integer.compare(a[0], b[0]));
    }
}
