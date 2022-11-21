
// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

package seminar1;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n :");
        int n = scanner.nextInt();
        int triangular = n * (n + 1) / 2;
        int factorial = factorial(n);
        System.out.printf("Triangular = %d\nFactorial = %d", triangular, factorial);
    }
    static int factorial(int num) {
        if (num == 2) return 2;
        return num * factorial(--num);
    }
}
