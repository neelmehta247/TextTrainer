import java.util.Scanner;

/**
 * Created by neel on 02/12/15 at 9:44 AM.
 */
public class Run {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Train\n2. Generate\n3. Exit");
            choice = Integer.parseInt(s.next());
            if (choice > 3 || choice < 1) {
                continue;
            }

            if (choice == 1) {
                s.nextLine().trim();
                System.out.println("Enter the training string");
                Trainer.train(s.nextLine());
                System.out.println("Trained");
            } else if (choice == 2) {
                System.out.println("How many words?");
                System.out.println(Trainer.generate(Integer.parseInt(s.next())));
            }
        } while (choice != 3);
    }
}
