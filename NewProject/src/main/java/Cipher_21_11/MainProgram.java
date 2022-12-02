package Cipher_21_11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) throws IOException {
        System.out.println("Доброе времени суток!");
        System.out.println("Вы решили воспользоваться программой Шифрования/Дешифрования текста.");
        System.out.println("CipherMashine_v2.0");
        System.out.println("Для продолжения работы программы необходимо указать несколько параметров.");
        System.out.println("Пожалуйста, укажите путь на компьютере к Текстовому файлу. Пример:  C:\\Users\\Admin\\Desktop\\Text.txt или C:\\Users\\Admin\\Desktop\\CipherFile.txt");

        Scanner scannerFile = new Scanner(System.in);
        String stringFile = scannerFile.nextLine();
        try {
            BufferedReader buffFile1 = new  BufferedReader(new FileReader(stringFile));
            buffFile1.close();
            System.out.println("Файл найден.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка!!! Файл не найден!");
            System.out.println("Пожалуйста, перезапустите программу и укажите верный путь к Файлу.");
            throw new RuntimeException(e);
        }
        BufferedReader buffFile2 = new  BufferedReader(new FileReader(stringFile));
        String dataFile;
        List<String> listFile = new ArrayList<>();
        while ((dataFile=buffFile2.readLine())!=null){
            listFile.add(dataFile);
        }
        buffFile2.close();
        String stringCipher = listFile.toString(); // Перевод Листа в строку


        // Ввод и проверка пароля.
        System.out.println("Пожалуйста, укажите PIN-Код (Внимание! PIN-Код может содержать только цифры!!!)");
        System.out.println("Пожалуйста, укажите Пароль");
        Scanner scannerPin = new Scanner(System.in);
        while (!scannerPin.hasNextLong()){
            System.out.println("Ошибка! Вы ввели неверное значение!");
            System.out.println("Пожалуйста, укажите PIN-Код (Внимание! PIN-Код может содержать только цифры!!!)");
            scannerPin.next();
        }
        long pin = scannerPin.nextLong();
        System.out.println("PIN-Код принят");



        // Шифровка Дешифровка.
        LiarClass newLiar = new LiarClass();
        newLiar.liarMethod();
        long meaning = newLiar.getMeaning();
        System.out.println(meaning);
        long ciph = newLiar.getMeaning();
        switch((int) ciph){
            case 0:
                //Шифрование
                //Шифр Вернама. Бинарный оператор XOR копирует бит, если он установлен в одном операнде, но не в обоих.
                char[] achText = stringCipher.toCharArray();
                char[] achResult = new char[achText.length];
                for (int i = 0; i < achText.length; i++) {
                    achResult[i] = (char) (achText[i] ^ pin);
                }
                FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\CipherFile.txt");
                fileWriter.write(String.valueOf(achResult));
                fileWriter.close();

                System.out.println("Зашифровано");
                System.out.println("Файл на рабочем столе: CipherFile.txt");
                break;
            case 1:
                //Дешифрование
                char[] achTextOne = stringCipher.toCharArray();
                char[] achDecrypt = new char[achTextOne.length];
                for (int i = 0; i < achTextOne.length; i++) {
                    achDecrypt[i] = (char) (achTextOne[i] ^ pin);
                }
                FileWriter fileWriterOne = new FileWriter("C:\\Users\\Admin\\Desktop\\DecryptedFile.txt");
                fileWriterOne.write(String.valueOf(achDecrypt));
                fileWriterOne.close();

                System.out.println("Расшифровано");
                System.out.println("Файл на рабочем столе: DecryptedFile.txt");
                break;
        }

        System.out.println("Программа выполнена");

    }
}
class LiarClass {


    long c;

    public long getMeaning(){
        long h = c;
        return h;
    }
    public void liarMethod(){

        System.out.println("Пожалуйста, укажите Вы хотите зашифровать или расшифровать текст?");
        System.out.println("Если Зашифровать  укажите 0");
        System.out.println("Если Расшифровать укажите 1");
        Scanner scannerValue = new Scanner(System.in);
        boolean a = scannerValue.hasNextLong();
        if (a){
            long b = scannerValue.nextLong();
            if (b <= 1){
                System.out.println("Принято");
                c = b;
            }else{
                liarMethod();
            }
        }else{
            liarMethod();
        }
    }
}
