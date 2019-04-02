package homework11;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
        File file1 = new File("src/file.txt");
        File file2 = new File("src/" + fileName + ".txt");

        try {
            readWriteFiles(file1, file2, false,Charset.forName("UTF-8"));
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
///---------------------шифрование
       ///a) кодировака слова XOR
        byte[] bytePas=encodeParol("program", "pas");
        System.out.println("program - это слово"+ "pas -это  ключ "+ "==> " + bytePas.toString());
        String decod= decode(bytePas, "pas");
        System.out.println( bytePas.toString()+" с ключom  pas ==>"+decod);

    //////////b)
        System.out.println("зашифруем весь файл и поместим в другой.. ");
        File file4;
        file4 = new File("src/file4.txt");//закодированный файл
        System.out.println(" ключ к паролю ");
        String password = in.nextLine();
        try {
            encodeFileByKey(file1, file4, password, false, Charset.forName("UTF-8"));
            System.out.println(" зашифрованный файл в src/file4.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
///------------------bp fil4 - закодированный в раскодирвоанный file5
        System.out.println("расшифруем файл и поместим в другой.. ");
        File file5 = new File("src/file5.txt");///раскодированный файл
        try {
            decodeFileByKey(file4, file5, password, false,Charset.forName("UTF-8"));
            System.out.println("  файл  src/file4.txt расшифрован в src/file5.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
//////--------------------------------------------------------------------------------
        try {
            searchBird(file1,Charset.forName("UTF-8"));
        } catch (IOException e) {

        }
    }

////-//Метода
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

////------------------разбить файл по объему---------------------------------------

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


        ///-------------закодировать файл--------------------------------------------------
    public static void encodeFileByKey(File file1, File file2, String pKey, boolean append, Charset charset) throws IOException
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file2)) {
            FileInputStream fileInputStream = new FileInputStream(file1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len;

            ///-------------------получили массив байтов-----------------------
            byte[] buf = new byte[1024];
            while ((len = fileInputStream.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }

            byte[] txt = byteArrayOutputStream.toByteArray();
            byte[] key = pKey.getBytes();
            byte[] res = new byte[byteArrayOutputStream.toString().length()];

            for (int i = 0; i < txt.length; i++) {
                res[i] = (byte) (txt[i] ^ key[i % key.length]);
            }

            fileOutputStream.write(res);
        }


    }
////-----------------------------раскодирование файла------------------------------
    public static void decodeFileByKey(File file1, File file2, String pKey, boolean append, Charset charset) throws IOException
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file2)) {
            FileInputStream fileInputStream = new FileInputStream(file1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len;

            ///-------------------получили массив байтов-----------------------
            byte[] buf = new byte[1024];
            while ((len = fileInputStream.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }

            byte[] txt = byteArrayOutputStream.toByteArray();
            byte[] key = pKey.getBytes();
            byte[] res = new byte[byteArrayOutputStream.toString().length()];

            for (int i = 0; i < byteArrayOutputStream.toByteArray().length; i++) {
                res[i] = (byte) (byteArrayOutputStream.toByteArray()[i] ^ key[i % key.length]);
            }
            fileOutputStream.write(res);
        }


    }

        ///---------------------------Шифрование-------------------------------------------------------
        public static byte[] encodeParol(String pText, String pKey)
        {


            byte[] txt = pText.getBytes();
            byte[] key = pKey.getBytes();
            byte[] res = new byte[pText.length()];

            for (int i = 0; i < txt.length; i++) {
                res[i] = (byte) (txt[i] ^ key[i % key.length]);
            }

            return res;
        }
    ///------------------------дешифрование-------------------
    public static String decode(byte[] pText, String pKey) {
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }

        return new String(res);
    }
///-------------------------------------------поиск запятой----------------
    public static void searchBird(File file,Charset charset) throws IOException
    {
        ////не с помощю метода  List<String> lines = Files.readAllLines(file.toPath());-
        ////это NIO
        FileInputStream fileInputStream=new FileInputStream(file);
       
        InputStreamReader reader = new InputStreamReader(fileInputStream);

        StringBuilder sb = new StringBuilder();

        char[] buf = new char[20];
        int len;
        while ((len = reader.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }

        System.out.println("sb.toString() = " + sb.toString());

    }

    



}