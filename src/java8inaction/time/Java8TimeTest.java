package java8inaction.time;

import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.time.zone.ZoneRules;
import java.util.Date;
import java.util.Locale;

/**
 * @author KangShan
 * @date 2019/12/18 21:05
 */
public class Java8TimeTest {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2019, 12, 23,
                22, 42, 42);

        Instant       instant = Instant.ofEpochSecond(1, 3_000_000_000L);
        System.out.println(instant);
        Duration duration = Duration.of(3_000_000_000L, ChronoUnit.SECONDS);
        System.out.println(duration.addTo(instant));
        System.out.println(instant);
        System.out.println(duration.addTo(time));

        System.out.println(time);
        System.out.println(time.with(ChronoField.DAY_OF_YEAR, 2));
        //the great TemporalAdjuster
        System.out.println(time.with(
                TemporalAdjusters.ofDateAdjuster(d -> d.plus(3, ChronoUnit.DAYS))));

        //format & parse
        System.out.println(time.format(
                DateTimeFormatter.ofPattern("d. MMMM yyyy H:m", Locale.ENGLISH)));

        ZoneRules rules = ZoneId.of("Europe/Rome").getRules();
        LocalDate of    = LocalDate.of(2019, Month.APRIL, 2);

        //ZoneId instead of TimeZone
        System.out.println(ZoneId.systemDefault());
        LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        Date from = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        //different chronology
        HijrahDate hijrahDate = HijrahDate.now().with(ChronoField.MONTH_OF_YEAR, 3)
                .with(ChronoField.DAY_OF_MONTH, 23);

        System.out.println(IsoChronology.INSTANCE.date(hijrahDate));
    }
}
