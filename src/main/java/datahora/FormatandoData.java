package datahora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class FormatandoData {
    public static void main(String[] args) {
        // Classes que usávamos antes: DateFormat e SimpleDateFormat


        LocalDateTime ldtNow = LocalDateTime.now();

        // DateFormatter padrão do Java

        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME; // 2021-03-17T17:45:14.026
        String formatDateTime = isoDateTime.format(ldtNow);
        System.out.println(formatDateTime);

        DateTimeFormatter isoTime = DateTimeFormatter.ISO_TIME; // 17:45:14.026
        String formatTime = isoTime.format(ldtNow);
        System.out.println(formatTime);

        DateTimeFormatter dateFormatterShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT); // 17/03/21
        String formatDateShort = dateFormatterShort.format(ldtNow);
        System.out.println(formatDateShort);

        DateTimeFormatter dateTimeFormatterShort = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); // 17/03/21 21:50
        String formatDateTimeShort = dateTimeFormatterShort.format(ldtNow);
        System.out.println(formatDateTimeShort);

//        DateTimeFormatter dateTimeFormatterLong = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG); // LONG e FULL - funciona com ZonedDateTime, pois é para aparecer o TZ
//        String formatDateTimeLong = dateTimeFormatterLong.format(ldtNow);
//        System.out.println(formatDateTimeLong);


        // O FormatStyle depende de como está configurado o Locale, então CUIDADO!

        // DateTimeFormatter com Pattern criado por nós

        DateTimeFormatter dateTimeFormatterPattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        String formatPattern = dateTimeFormatterPattern.format(ldtNow);
        String formatPatternInvertido = ldtNow.format(dateTimeFormatterPattern); // Forma invertida também funciona
        System.out.println(formatPattern);
        System.out.println(formatPatternInvertido);

        // Parse é quando o objeto está em uma String e queremos movê-lo para uma classe de Data/Hora
        TemporalAccessor parse = dateTimeFormatterPattern.parse("17-03-2021 22-06-54"); // Ele nos retorna TemporalAccessor pois não sabe ainda qual a classe que isso se encaixa, LocalDate, LocalTime, etc
        LocalDateTime from = LocalDateTime.from(parse);
        System.out.println(from);


    }



}
