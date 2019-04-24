package dateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DateTimeExample {
    public static void main(String[] args) {
        //класс Date

        Date date=new Date();
        Date other=new Date();
        date.after(other);
        date.before(other);
        date.compareTo(other);

        System.out.println("date= " + date);
        System.out.println("other = " + other);

        SimpleDateFormat dateFormat=new SimpleDateFormat("День dd Месяц MM Год yyyy hh:mm");
        System.out.println(" " + dateFormat.format(date));

        Calendar calendar=new GregorianCalendar();
        Calendar calendar1=new GregorianCalendar(2019,Calendar.APRIL,24);
        calendar1.add(Calendar.DAY_OF_MONTH,2);

        System.out.println("calendar1 = дата " + calendar1.get(Calendar.DATE)+ " месяц"+calendar1.get(Calendar.MONTH));

        calendar1.add(Calendar.MONTH,-2);
        System.out.println("calendar1 = " + calendar1.get(Calendar.MONTH));


        ///Java 8 Date Time API
        //    LocalDate --///только с датой
        ///   LocalTime --//только время
        ///   LocalDateTime --//только время
        //    Period  --- временные промежутки дат
        //    Duration--временные промеждутки времени

        //текущая дата
        ///DateExeption если не существующая дата
        System.out.println("-------Java 8 Date Time API----------- " );
        LocalDate localDateNow=LocalDate.now();
        System.out.println("localDateNow = " + localDateNow);


        LocalDate someDate=LocalDate.of(2019, Month.APRIL,28);
        System.out.println("someDate = " + someDate);

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("d/MM/yyyy");
        String srtDate="14/04/2019";
        
        LocalDate parseDate=LocalDate.parse(srtDate,dateTimeFormatter);
        System.out.println("srtDate  "  +srtDate+"--->parseDate = " + parseDate);

        
        LocalDate tommorow= localDateNow.plusDays(1);
        System.out.println("tommorow = " + tommorow);
        LocalDate tommorow2= localDateNow.plusYears(5);
        System.out.println("tommorow2 = " + tommorow2);

        System.out.println("уменьшим дату = " + localDateNow.minusYears(5));
        System.out.println("уменьшим дату = " + localDateNow.minus(4, ChronoUnit.DAYS));
        
        DayOfWeek dayOfWeek=LocalDate.parse("2018-07-12").getDayOfWeek();//вернет день неделт
        System.out.println("dayOfWeek = " + dayOfWeek);
        
        
        int dayOfMounf=LocalDate.parse("2019-05-18").getDayOfMonth();
        System.out.println("высокосный " + LocalDate.now().isLeapYear());

        //boolean isAfter=LocalDate.parse("2018-07-12").isAfter(LocalDate.parse("2019-07-12=3"));
        //---
        //посчитать все даты внутри списка
        LocalTime timeNow= LocalTime.now();
        System.out.println("timeNow = " + timeNow);
        
        LocalTime setTime=LocalTime.of(6,39);
        System.out.println("setTime = " + setTime);
        
        LocalTime settime1=LocalTime.parse("12:10");
        System.out.println("settime1 = " + settime1);


        System.out.println(timeNow.plusSeconds(78));
        System.out.println(timeNow.plusMinutes(28));
        System.out.println(timeNow.plusHours(8));

        System.out.println(timeNow.minus(23,ChronoUnit.MINUTES));

        int hour=LocalTime.parse("04:45").getHour();
        System.out.println("hour = " + hour);


        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        System.out.println("localDateTime = " + localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.US));

        LocalDate startdate=LocalDate.parse("2006-04-15");
        System.out.println("startdate = " + startdate);
        LocalDate finaldate=startdate.plus(Period.ofDays(67));
        System.out.println("finaldate = " + finaldate);

        int betwween =Period.between(startdate,finaldate).getDays();
        System.out.println("betwween = " + betwween);
       
        long between1=ChronoUnit.DAYS.between(startdate,finaldate);
        System.out.println("between1 = " + between1);

      ///  Long timeB=Duration.between(LocalTime.of(7,10),LocalTime.of(8,12));

        Set<String>allZone=ZoneId.getAvailableZoneIds();
        System.out.println("allZone = " + allZone);
        ZoneId zoneId=ZoneId.of("America/Cuiaba");

//        List<LocalDate> dates =LocalDate.now().datesUntil(LocalDate.parse("2025-06-12")).collect(Collectors.toList());
//        System.out.println("dates = " + dates);


    }
}
