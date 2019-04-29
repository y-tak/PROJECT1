package streanApi;

import homework10.Homework10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class WarStream {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = Homework10.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());

        ///--посчитать топ 10
        Map<String, Long> map =
                ///получаем stream из файла
                Files.lines(file.toPath())
                        ////указываем что stream должен был параллельным
                        .parallel()
                        .map(line -> line.toLowerCase().replaceAll("\\pP", " "))
                        ////убрали пунктцацию
                        .flatMap(line -> Arrays.stream(line.split(" ")))
                        //разделили по пробелам
                        .map(String::trim)
                        .filter(word -> !"".equals(word))
                        ///отфильтровали
                        .collect(groupingBy(Function.identity(), counting()))
                        .entrySet()
                        .parallelStream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                        .limit(10)
                        .collect(toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println("map = " + map);




    }



}
