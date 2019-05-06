package logging;
///логирование сообщений
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

public class LoggedExample {
    private static  final Logger LOGGER=Logger.getLogger(LoggedExample.class.getName());

    static {
       // LOGGER.setLevel(Level.SEVERE);//фатальные ошибки логируются
        //LOGGER.setLevel(Level.WARNING);//предупреждени
        //LOGGER.setLevel(Level.INFO);//сообщений
        LOGGER.setLevel(Level.ALL);//все


//        LOGGER.setLevel(Level.CONFIG);//все
//        LOGGER.setLevel(Level.FINE);//все
//        LOGGER.setLevel(Level.FINER);//все
//        LOGGER.setLevel(Level.FINEST);//все


        //-/--записать в файл в формате XML
        try {
            ///логирование
            LOGGER.addHandler(new FileHandler("loggerExample.log.xml"));

            ///вывод в виде простого текста
            FileHandler fileHandler=new FileHandler("loggerExample.log");
          //  fileHandler.setFormatter( new SimpleFormatter());
            fileHandler.setFormatter( new CustomFormatter());

            LOGGER.addHandler(fileHandler);

        } catch (IOException e)
        {LOGGER.warning("FileHandler не доступен");}

        }




    public static void main(String[] args) {
        LOGGER.info("программа запущена "+ Arrays.toString(args));


        try{int res=2/0;} catch (Exception e)
        {LOGGER.severe("fatal error "+e.getMessage());}

    }

}


class CustomFormatter extends Formatter
{
    private final static  ThreadLocal<DateFormat> dateFormat =new ThreadLocal<DateFormat>()
    {
        protected DateFormat initialValue()
        {
          return  new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

        }

    };

    private String formatDate (long millis){
        return dateFormat.get().format(new Date(millis));}

    @Override
    public String format(LogRecord record) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append('['+formatDate(record.getMillis())).append(']');
        stringBuilder.append('[').append(record.getLevel()).append(']');
        stringBuilder.append('[').append(record.getSourceClassName())
                .append('.').append(record.getSourceMethodName()).append(']');
        stringBuilder.append('-').append(record.getMessage()).append(' ');
        return  stringBuilder.toString();
    }


}