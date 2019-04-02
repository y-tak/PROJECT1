package homework11;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class homework11 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println(" имя файла ");
        String fileName=in.nextLine();
        File file2=new File("src/"+fileName+".txt");
        File file1=new File("src/file.txt");

        try {
            readWriteFiles(file1,file2,true,Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    ///---------------------скопировать файл
public static void readWriteFiles(File file1, File file2, boolean append ,Charset charset) throws IOException
        {
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2,append);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int len;
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[1024];
            int kol=0;
            long sum=0;
            while ((len = fileInputStream.read(buf)) > 0)
            {
                for(int i=0;i<Arrays.toString(buf).length();i++)
                {
                    kol++;
                  //  int data = fileInputStream.read();
                   // sum += data;
                }

                byteArrayOutputStream.write(buf, 0,len);

                
            }
            fileOutputStream .write(byteArrayOutputStream.toByteArray());
            //            ///----------вывод
            System.out.println("количество скопированных байт " + kol);///+" сумма "+ sum);
            ///массив байт--
            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
            //вывод как в файле--
            System.out.println(new String(byteArrayOutputStream.toByteArray(), charset));
}


}

