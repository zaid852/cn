import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int bucket_remaining = 0, sent, received;
        System.out.println("Enter the bucket capacity");
        int bucket_capacity = in.nextInt();
        System.out.println("Enter the bucket rate (Rate at which the bucket sends the packets)");
        int bucket_rate = in.nextInt();
        System.out.println("Enter the number of packets to be sent");
        int n = in.nextInt();
        int[] buf = new int[30]; 
        System.out.println("Enter the packets sizes one by one");
        for (int i = 0; i < n; i++) {
            buf[i] = in.nextInt();
        }

        System.out.println(String.format("%s\t\t%s\t\t%s\t%s\t%s","Time_t","P_size","accepted","sent","remaining"));

        for (int i = 0; i < n; i++) {
            if (buf[i] != 0) {
                if (bucket_remaining + buf[i] > bucket_capacity) {
                    received = -1;
                } else {
                    received = buf[i];
                    bucket_remaining += buf[i];
                }
            } else {
                received = 0;
            }

            if (bucket_remaining != 0) {
                if (bucket_remaining < bucket_rate) {
                    sent = bucket_remaining;
                    bucket_remaining = 0;
                } else {
                    sent = bucket_rate;
                    bucket_remaining = bucket_remaining - bucket_rate;
                }
            } else {
                sent = 0;
            }

            if (received == -1) {
                System.out.println(String.format("%d\t\t%d\t\t%s\t\t%d\t\t%d", i + 1, buf[i], "dropped", sent, bucket_remaining));
            } else {
                System.out.println(String.format("%d\t\t%d\t\t%d\t\t%d\t\t%d", i + 1, buf[i], received, sent, bucket_remaining));
            }
        }
    }
}
