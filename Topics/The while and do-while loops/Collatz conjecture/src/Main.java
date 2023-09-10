import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int givenNumber = scanner.nextInt();
        int[] sequence = new int[givenNumber * 5];
        int i = 0;
        sequence[i] = givenNumber;

        while (sequence[i] != 1) {
            if (sequence[i] % 2 == 0) {
                sequence[i + 1] = sequence[i] / 2;
            } else {
                sequence[i + 1] = sequence[i] * 3 + 1;
            }
            i++;
        }
        printResult(sequence);
    }

    public static void printResult(int[] sequence) {
        int i = 0;
        while (sequence[i] != 0) {
            System.out.print(sequence[i] + " ");
            i++;
        }
    }
}