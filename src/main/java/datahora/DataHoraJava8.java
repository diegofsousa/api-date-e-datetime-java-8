package datahora;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DataHoraJava8 {
    public static void main(String[] args) {
        // Classes antigas: Date e Calendar

        // Classes novas:
        // LocalDate - representa uma data, ex: 06/08/1996
        // LocalTime - representa uma hora, ex: 11:40:00
        // LocalDateTime - representa data + hora, ex: 06/08/1996 11:40:00
        // As classes LocalXXX são boas para sistemas que não se importam com fuso horário.

        // Instant - representa um instante/momento na linha do tempo
        // milissegundos a partir de 01/01/1970 00:00:00
        // Representa data/hora sempre em GMT/UTC, ou seja fuso horário 0.

        // ZonedDateTime - LocalDateTime com TimeZone

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDateContruido = LocalDate.of(1990, Month.JULY, 6);// a api antiga começava o mes com 0, foi corrigido nessa nova api
        System.out.println(localDateContruido);
        LocalDate localDatePlusWeek = localDate.plusWeeks(2).plusDays(2).minusYears(1); // deve sempre ser instanciado um novo, pois a api é imutavel
        System.out.println(localDatePlusWeek);

        System.out.println("----------------");

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalTime lt = LocalTime.of(11, 10, 01, 100000);
        System.out.println(lt);

        System.out.println("----------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime ltd = LocalDateTime.of(localDateContruido, lt);
        System.out.println(ltd);

        System.out.println("----------------");

        Instant now = Instant.now();
        System.out.println(now); // trás a data com +3h pois estou no Piauízão da massa GMT -03
        Instant instant = Instant.ofEpochMilli(1010999911999L);
        System.out.println(instant);
        Instant instantPlus = now.plus(1, ChronoUnit.DAYS); // Só funciona com dias, pois meses e anos são variaveis. instant é milisegundos a partir de 1970
        System.out.println(instantPlus);

        System.out.println("----------------");

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(ltd, ZoneId.of("America/Montevideo"));
        System.out.println(zonedDateTime1);

    }
}
