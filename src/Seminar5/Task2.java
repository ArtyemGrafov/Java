//Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

package Seminar5;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>(List.of(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
                "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова",
                "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин",
                "Иван Ежов"));

        HashMap<String, Integer> result = new HashMap<>();
        int max = 0;
        LinkedHashMap<String, Integer> sortedResult = new LinkedHashMap<>();

        for (String men : linkedList) {
            String name = men.split(" ")[0];
            if (result.containsKey(name)) {
                int count = result.get(name);
                result.put(name, ++count);
                if (count > max) max = count;
            } else {
                result.put(name, 1);
            }
        }

        System.out.println(result);

        while (max != 0) {
            if (result.containsValue(max)) {
                for (String key : result.keySet()) {
                    if (result.get(key) == max) {
                        sortedResult.put(key, result.get(key));
                    }
                }
                max--;
            }
        }
        System.out.println(sortedResult);
    }
}
