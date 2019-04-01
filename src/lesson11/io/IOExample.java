package lesson11.io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class IOExample {
    public static void main(String[] args) {

//        File file=new File("file.txt");
//       try {
//           file.createNewFile();
//       }catch (IOException e){};
//

        try {
            writeToFile("src/file.txt", true, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

        File file = new File("src/ttt.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        ;

        try {
            readByteArray(file, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;

        try
        {
            readFromFile(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        File[] files=new File[2];
        files[0]=new File("src/ttt.txt");
        files[1]=new File("src/file.txt");

        try {
            readFromSeveralFiles(files,Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ;
        ///IO API | NIO API

        //IO API
        ///--работают с байтами
        //InputStream  //когда получаем данные в программу
        // OutoutStream  //когда передаем данные из программы


        //работают с char

        // Reader
        //Writer
    }

    ////-----------------------------------------------------------------------
    public static void writeToFile(String fileName, boolean append, Charset charset)
            throws IOException //имя..перезаписывать//дозаписывать (true).кодировка
    {
        //FileOutPutStream

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName, append)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++)
                sb.append("line").append(i).append("\n");


            byte[] bytes = sb.toString().getBytes(charset);
            fileOutputStream.write(bytes);


        }

    }


//    ///-------------------------------------------------------------------
    public static long readFromFile(File file) throws IOException
    {
        //FileInputString
        long sum = 0;///количество считанных байтов
        try (FileInputStream inputStream = new FileInputStream(file))
        {
            System.out.println("inputStream.available() = " + inputStream.available());
            while (inputStream.available() > 0)
            {
                int data = inputStream.read();
                sum += data;
                System.out.println((char) data);
            }
            return sum;

        }

    }


    public static void readByteArray(File file, Charset charset) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) > 0) {
                System.out.println("Arrays.toString() = " + Arrays.toString(buf));
                byteArrayInputStream.write(buf, 0, len);
            }
            System.out.println("Arrays.toString(byteArrayInputStream) = " + Arrays.toString(byteArrayInputStream.toByteArray()));
            System.out.println(new String( byteArrayInputStream.toByteArray(),charset));
        }

    }

    public void writeWithBuffer(File file) throws IOException
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)
        )
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++)
                sb.append("line").append(i).append("\n");

            byte[] buffer = sb.toString().getBytes();
            outputStream.write(buffer,0,buffer.length);
        }
    }
////последователььное чтение
    public static void readFromSeveralFiles(File[] files,Charset charset)throws IOException
    {
        try (FileInputStream inputStrem1 =new FileInputStream(files[0]);
             FileInputStream inputStrem2 =new FileInputStream(files[1]) ;
             ByteArrayOutputStream bout = new ByteArrayOutputStream())
        {
            SequenceInputStream sequenceInputStream= new SequenceInputStream(inputStrem1,inputStrem2);
            byte [] buf=new byte[1024];
            int len;
            while ((len=sequenceInputStream.read(buf))>0)
            {bout.write(buf,0,len);}
            System.out.println( new String(bout.toByteArray(),charset));
        }
    }

    
    public static String readChar (InputStream in, Charset charset) throws IOException
    {

        String o = null;
        return o;
    }

}






