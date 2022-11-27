// Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.

package seminar1;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        String str = "2?+?5=69";
        String[] arrStr = str.split("[+=]");
        int[][] arrInt = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arrStr[i].length(); j++) {
                if (!arrStr[i].split("")[arrStr[i].length() - j - 1].equals("?"))
                    arrInt[i][2 - j] = Integer.parseInt(arrStr[i].split("")[arrStr[i].length() - j - 1]);
                else
                    arrInt[i][2 - j] = -1;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (arrInt[0][2 - i] == -1 & arrInt[1][2 - i] == -1 & arrInt[2][2 - i] == -1) {
                arrInt[0][2 - i] = 2;
                arrInt[1][2 - i] = 3;
                arrInt[2][2 - i] = 5;
            } else if (arrInt[0][2 - i] == -1 & arrInt[1][2 - i] == -1 & arrInt[2][2 - i] != -1) {
                arrInt[0][2 - i] = 1;
                arrInt[1][2 - i] = arrInt[2][2 - i] - 1;
            } else if (arrInt[0][2 - i] == -1 & arrInt[1][2 - i] != -1 & arrInt[2][2 - i] == -1) {
                arrInt[2][2 - i] = arrInt[1][2 - i] + 1;
                arrInt[0][2 - i] = 1;
            } else if (arrInt[0][2 - i] != -1 & arrInt[1][2 - i] == -1 & arrInt[2][2 - i] == -1) {
                arrInt[2][2 - i] = arrInt[0][2 - i] + 1;
                arrInt[1][2 - i] = 1;
            } else if (arrInt[0][2 - i] == -1 & arrInt[1][2 - i] != -1 & arrInt[2][2 - i] != -1) {
                arrInt[0][2 - i] = arrInt[2][2 - i] - arrInt[1][2 - i];
            } else if (arrInt[0][2 - i] != -1 & arrInt[1][2 - i] == -1 & arrInt[2][2 - i] != -1) {
                arrInt[1][2 - i] = arrInt[2][2 - i] - arrInt[0][2 - i];
            } else if (arrInt[0][2 - i] != -1 & arrInt[1][2 - i] != -1 & arrInt[2][2 - i] == -1) {
                arrInt[2][2 - i] = arrInt[0][2 - i] + arrInt[1][2 - i];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 2; j > 0; j--) {
                if (arrInt[i][j] < 0) {
                    arrInt[i][j] += 10;
                    arrInt[i][j -1] -= 1;
                }
                if (arrInt[i][j] >= 10) {
                    arrInt[i][j] -= 10;
                    if (arrInt[0][0] != 0 | arrInt[0][0] != 0) arrInt[i][j - 1] += 1;
                }
            }
        }

        int a = Integer.parseInt(Arrays.toString(arrInt[0])
                .replaceAll("[\\[\\],\\s]", ""));
        int b = Integer.parseInt(Arrays.toString(arrInt[1])
                .replaceAll("[\\[\\],\\s]", ""));
        int c = Integer.parseInt(Arrays.toString(arrInt[2])
                .replaceAll("[\\[\\],\\s]", ""));

        System.out.println(str);
        if (a + b == c) System.out.printf("%d+%d=%d", a, b, c);
        else System.out.println("No solution");
    }
}
