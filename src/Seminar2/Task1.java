//Дана строка sql-запроса "select * from students where ".
//Сформируйте часть WHERE этого запроса, используя StringBuilder.
//Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//то есть должно получиться что-то вроде:
//... where name = Ivanov and country = Russia and city = Moscow

package Seminar2;

public class Task1 {

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Drefff\", " +
                            "\"country\":\"null\", " +
                            "\"city\":\"Moscow\", " +
                            "\"age\":\"45\"}";
        StringBuilder stringBuilder = new StringBuilder(jsonString);

        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '\"') stringBuilder.deleteCharAt(i);
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == ' ') stringBuilder.deleteCharAt(i);
        }

        while (stringBuilder.indexOf("null") != -1) {
            int size = stringBuilder.length();
            int index = stringBuilder.indexOf("null");
            if (index + 4 == size) {
                stringBuilder.delete(stringBuilder.lastIndexOf(","), size);
            } else if (index < stringBuilder.indexOf(",")){
                stringBuilder.delete(0, stringBuilder.indexOf(",") + 1);
            } else {
                stringBuilder.delete(stringBuilder.indexOf(",", index - 10), index + 4);
            }
        }

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == ':') stringBuilder.replace(i, i+1, "=");
            if (stringBuilder.charAt(i) == ',') stringBuilder.replace(i, i+1, " and ");
        }
        System.out.println(stringBuilder);
    }
}
