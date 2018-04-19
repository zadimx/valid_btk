import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class btk {
    static int count = 0; // Счетчик валидности

    public static void main(String[] args) {
        while (true) { // Бесконецный ввод и вывод
            Scanner in = new Scanner(System.in); // Запускаем поток ввода

            ArrayList<String> listBtk = new ArrayList<>(); // Создаем колекцию для символов
            String str = in.nextLine(); // Читаем введенную строку с потока ввода
            char[] arrayStr = str.toCharArray(); // Преобразовуем введенную строку в массив символов

            for (char x : arrayStr
                    ) {
                listBtk.add(String.valueOf(x)); // Добавляем в колекцию символы (мне так удобнее)
            }

            System.out.println(check(listBtk)); // Выводим проверку на валидность строки
            count = 0; // Обнуляем счетчик валидности
            listBtk.clear(); // Чистим колецию
        }

    }

    static String check(ArrayList<String> list) { // Создаем метод проверки на валидность
        String result = "Empty string";
        String bkt1 = new String("(");
        String bkt2 = new String(")");

        boolean val;
        if (list.size() != 0) {
            for (String x : list
                    ) {
                val = !x.equals(bkt1) && !x.equals(bkt2);
                if (val) {
                    count += 10;
                    result = "Enter only ) or (";
                    break;
                } else if (x.equals("(")) {
                    result = "No valid";
                    count++;
                } else
                    count--;
                if (count < 0) {
                    result = "No valid";
                    break;
                }
            }
            if (count == 0) {
                result = "Valid";
            }
        }
        return result;
    }
}
