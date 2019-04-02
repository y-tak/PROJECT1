package homework11;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
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
            readWriteFiles(file1, file2, true, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" --------------ЗАДАЧА 2---------------------------");
        /////Задача 2
        //Разбить/склеить файл. (имена файлов и размер куска задаются с клавиатуры)

        File file3 = new File("src/file1.txt");
        System.out.println("введите размер в байтах ");
        String size = in.nextLine();
        try {
            seperateFile(file1, file3, Integer.parseInt(size), false, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    ///---------------------скопировать файл------------------------------------------
    public static void readWriteFiles(File file1, File file2, boolean append, Charset charset) throws IOException {

        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        int kol;
        long sum = 0;
        try (FileInputStream fileInputStream = new FileInputStream(file1))
        {
            fileOutputStream = new FileOutputStream(file2, append);

            byteArrayOutputStream = new ByteArrayOutputStream();

            int len;
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            kol = 0;

            while ((len = fileInputStream.read(buf)) > 0) {
                for (int i = 0; i < buf.toString().length(); i++) {
                     kol++;
                    //  int data = fileInputStream.read();
                     sum = sum+(byte)buf[i];
                }

                byteArrayOutputStream.write(buf, 0, len);


            }
        }
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        //            ///----------вывод
        System.out.println("количество скопированных байт " + kol+" cсумма "+sum);///+" сумма "+ sum);
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


        try (FileInputStream fileInputStream = new FileInputStream(file1)) {
            fileOutputStream = new FileOutputStream(file2, append);
            InputStreamReader reader = new InputStreamReader(fileInputStream);

            int len;

            int sum=0;
            StringBuilder sb = new StringBuilder();

            //char[] buf = new char[20000];
            byte[] buf = new byte[1024];
            byte[] buf1 = new byte[1024];
//            while ((len = fileInputStream.read(buf)) > 0)  {
//                kolByte = len;
//                for (int j=0;j<buf.length;j++)
//                {
//                    sum = sum + buf[j];
//                    if (sum <= size) ///sb.append("" + buf[j], 0, len);
//                        fileOutputStream.write((char)buf[j]);
//                    else return;
//
//                }
//            }

            while ((len = fileInputStream.read(buf)) > 0)
            {
                for (int i = 0; i < buf.toString().length(); i++)
                {
                                     //  int data = fileInputStream.read();
                    sum = sum+(byte)buf[i];
                    if (sum<=size) buf1[i]=buf[i];
                }
                fileOutputStream.write(buf1, 0, len);



            }

        }

///----------------------------------------------------------------------------------


    }

}