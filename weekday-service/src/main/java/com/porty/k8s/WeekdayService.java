package com.porty.k8s;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.EnumSet;

import static spark.Spark.get;
import static spark.Spark.port;

public class WeekdayService {
    public static void main(String[] args) {
        port(5678);

        get("/weekday/:country/:city", (req, res) -> {
            ZoneId timeZoneId = ZoneId.of(req.params("country") + "/" + req.params("city"));
            DayOfWeek dayOfWeek = LocalDate.now(timeZoneId).getDayOfWeek();
            boolean isWeekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)
                    .contains(dayOfWeek);
            return "" + isWeekend + ", day: " + dayOfWeek;
        });
    }
}
