// Вывести все простые числа от 1 до 1000

package seminar1;

public class Task2 {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }
    static boolean isPrime(int num) {
        if (num <= 3)
            return true;
        if (num <= 1 || num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i * i <= num ; i += 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }
}
