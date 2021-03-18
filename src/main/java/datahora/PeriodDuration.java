package datahora;

import java.time.*;

public class PeriodDuration {
    // Period e Duration server para armazenar um período de tempo.
    // Period trabalha com datas
    // Duration trabalha com tempo

    public static void main(String[] args) {

        System.out.println("Period");

        Period of = Period.of(1, 5, 3);// 1 ano, 5 meses e 3 dias
        System.out.println(of); // imprime P1Y5M3D

        Period ofDays = Period.ofDays(5);
        System.out.println(ofDays); //P5D

        Period periodWeek = Period.ofWeeks(5);
        System.out.println(periodWeek); // P35D - 35 dias

        // subtraindo lecal dates e recuperando um periodo

        LocalDate ld = LocalDate.of(1990, Month.AUGUST, 6);
        LocalDate ld2 = ld.plusWeeks(2).plusDays(1).plusMonths(1);
        Period between = Period.between(ld, ld2);
        System.out.println(between);

        Period between2 = between.plusDays(10);
        System.out.println(between2);

        // Outra forma de calcular o Period
        Period until = ld.until(ld2);
        System.out.println(until);

        // Adicionando um periodo a um local date
        Period cincoAnos = Period.ofYears(5);
        LocalDate plus = ld.plus(cincoAnos);
        System.out.println(plus);

        System.out.println("--------------\nDuration");

        Duration ofDays1 = Duration.ofDays(1);
        System.out.println(ofDays1); // vai exibir 24h, pois duraation é tempo

        Duration ofHours = Duration.ofHours(1);
        System.out.println(ofHours);

        Duration ofMinutes = Duration.ofMinutes(500);
        System.out.println(ofMinutes); // PT8H20M

        Duration ofSeconds = Duration.ofSeconds(10, 5000);
        System.out.println(ofSeconds);

        LocalTime ltNow = LocalTime.now();
        LocalTime lt = LocalTime.of(11, 10, 1);
        Duration between1 = Duration.between(ltNow, lt);
        System.out.println(between1); // PT-1H-18M-53.06S

        Duration plusMillis = between1.plusMillis(500);
        System.out.println(plusMillis);

        LocalDate nascimento = LocalDate.of(1996, Month.APRIL, 23);
        LocalDate hoje = LocalDate.now();
        Period between3 = Period.between(nascimento, hoje);
        System.out.println(between3);


    }
}
