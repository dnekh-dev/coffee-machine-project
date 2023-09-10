import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int result = 0;
        int num;
        boolean isZero = false;
        while (!isZero) {
            num = scanner.nextInt();
            if (num != 0) {
                result += num;
            } else {
                isZero = true;
            }
        }
        System.out.println(result);
    }
}
