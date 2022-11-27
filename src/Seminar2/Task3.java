//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
//Студент [фамилия] получил [оценка] по предмету [предмет].

//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.


package Seminar2;

import java.util.ArrayList;

public class Task3 {

    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                            "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                            "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        ArrayList<String> strArr = strToArr(jsonString);

        for (String str : strArr) {
            String surname = getSurname(str);
            String assessment = getAssessment(str);
            String subject = getSubject(str);
            System.out.printf("Студент %s получил %s по предмету %s.\n", surname, assessment, subject);
        }
    }

    private static String getSubject(String str) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.delete(0, stringBuilder.indexOf(",") + 1);
        stringBuilder.delete(0, stringBuilder.indexOf(",") + 1);
        result = stringBuilder.substring(stringBuilder.indexOf(":") + 2, stringBuilder.length() - 1);
        return  result;
    }

    private static String getAssessment(String str) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.delete(0, stringBuilder.indexOf(",") + 1);
        result = stringBuilder.substring(stringBuilder.indexOf(":") + 2, stringBuilder.indexOf(",") - 1);
        return  result;
    }

    private static String getSurname(String str) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(str);
        result = stringBuilder.substring(stringBuilder.indexOf(":") + 2, stringBuilder.indexOf(",") - 1);
        return  result;
    }

    private static ArrayList<String> strToArr(String str) {
        ArrayList<String> result = new ArrayList<>();
        for (String string : str.split("[{}]")) {
            if (string.length() > 1) result.add(string);
        }
        return result;
    }
}
