//Реализовать алгоритм сортировки слиянием

package Seminar3;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) array[i] = random.nextInt();

        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] arr) {
        int[] buffer1 = Arrays.copyOf(arr, arr.length);
        int[] buffer2 = new int[arr.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, arr.length);
        return result;
    }

    public static int[] mergesortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) return buffer1;

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex)
            result[destIndex++] = sorted1[index1] < sorted2[index2] ? sorted1[index1++] : sorted2[index2++];

        while (index1 < middle)
            result[destIndex++] = sorted1[index1++];

        while (index2 < endIndex)
            result[destIndex++] = sorted2[index2++];

        return result;
    }
}
