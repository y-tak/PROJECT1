package homework11;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class homework11 {

    private static InputStream in;

    public static void main(String[] args) {


        System.out.println(" --------------ЗАДАЧА 1---------------------------");
        /////Задача 1
        //Скопировать файл (имена файлов задаются с клавиатуры).
        //////Программа должна выводить количество скопированных байт

        Scanner in = new Scanner(System.in);
        System.out.println(" имя файла ");
        String fileName = in.nextLine();
        File file2 = new File("src/" + fileName + ".txt");
        File file1 = new File("src/file.txt");

        try {
            readWriteFiles(file1, file2, false, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" --------------ЗАДАЧА 2---------------------------");
        /////Задача 2
        //Разбить файл. (имена файлов и размер куска задаются с клавиатуры)

        File file3 = new File("src/file1.txt");
        System.out.println("введите размер в байтах ");
        String size = in.nextLine();
        try {
            seperateFile(file1, file3, Integer.parseInt(size), false, Charset.forName("UTF-8"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(" --------------ЗАДАЧА 3---------------------------");
        /////Задача 3
      ///  a) Зашифровать/ дешифровать файл паролем (XOR) (посмотреть в интернете)
       /// b) Зашифровать/ дешифровать файл другим файлом


    }


    ///---------------------скопировать файл------------------------------------------
    public static void readWriteFiles(File file1, File file2, boolean append, Charset charset) throws IOException {

        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;

        long sum = 0;
        try (FileInputStream fileInputStream = new FileInputStream(file1))
        {
            fileOutputStream = new FileOutputStream(file2, append);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len;
            ///--------получить массив байтов---------------
            byte[] buf = new byte[1024];
            while ((len = fileInputStream.read(buf)) > 0) {
                 byteArrayOutputStream.write(buf, 0, len);
           }
        }
            ///-------------Скопировать---------------------
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        for (int i=0;i<byteArrayOutputStream.toByteArray().length;i++)
        {
            sum=sum+byteArrayOutputStream.toByteArray()[i];
        }

        //            ///----------вывод
        System.out.println("количество скопированных байт "+sum);///+" сумма "+ sum);
        ////////для проверки----массив байт--
        // System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
        //////вывод как в файле--
        // System.out.println(new String(byteArrayOutputStream.toByteArray(), charset));
    }

////---------------------------------------------------------

    public static void seperateFile(File file1, File file2, int size, boolean append, Charset charset) throws IOException {
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String[] in;

        int kol;
        long sum = 0;

        try (FileInputStream fileInputStream = new FileInputStream(file1)) {
            fileOutputStream = new FileOutputStream(file2, append);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len;

            ///-------------------получили массив байтов-----------------------
            byte[] buf = new byte[1024];
            while ((len = fileInputStream.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }

            ///---------------перебор по байтам
            StringBuilder spp = new StringBuilder();
            for (int i = 0; i < byteArrayOutputStream.toByteArray().length; i++)
            {
                sum = sum + byteArrayOutputStream.toByteArray()[i];
                if (sum <= size) spp.append((char) byteArrayOutputStream.toByteArray()[i]);
            }

            ///---------------записали в новый файл.. конкретного размера-----------------------
            byte[] buffer = spp.toString().getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
              }
        finally {
            System.out.println("файл file1.txt записан");
        }

        }


        ///----------------------------------------------------------------------------------




}