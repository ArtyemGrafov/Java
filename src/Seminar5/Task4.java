//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package Seminar5;

public class Task4 {
    public static void main(String[] args) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tryFill(i, j) == 8) {
                    System.out.println("done");
                    System.out.println("start point i = " + i + " j = " + j);
                    break;
                }
            }
        }

    }

    private static int tryFill(int i, int j) {
        int[][] field = new int[8][8];
        int count = 0;
        int[] emptyPoint = new int[]{i, j};
        while (emptyPoint[0] != -1) {
            fillField(emptyPoint[0], emptyPoint[1], field);
            emptyPoint = getNextEmpty(field);
            count++;
            if (count == 8) printField(field);
        }
        return count;
    }

    private static int[] getNextEmpty(int[][] field) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < field.length; i++) {
            int j;
            for (j = 0; j < field.length; j++) {
                if (field[i][j] == 0) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    static void printField(int[][] field) {
        System.out.println("Result field : ");
        for (int[] ints : field) {
            for (int anInt : ints) {
                System.out.printf(" %s ", anInt);
            }
            System.out.println();
        }
        System.out.println("1 - queen, 7 - queen attack");
    }

    static void fillField(int ii, int jj, int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i == ii || j == jj || (j - i == jj - ii) || (i + j == ii + jj)) field[i][j] = 7;
            }
        }
        field[ii][jj] = 1;
    }
}
