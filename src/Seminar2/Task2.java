//Реализуйте алгоритм сортировки пузырьком числового массива,
//результат после каждой итерации запишите в лог-файл.


package Seminar2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) throws IOException {
        int[] array = new int[] {1, 3, 5, 9, -5, 2, 0, 2, 1, 7};
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fileHandler = new FileHandler("src\\Seminar2\\task2log.txt");
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        logger.addHandler(fileHandler);
        fileHandler.setFormatter(simpleFormatter);

        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
                logger.info(Arrays.toString(array));
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
