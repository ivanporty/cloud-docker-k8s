package com.porty.k8s;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.EnumSet;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Простой сервис на основе Spark/Java, запрашивающий время у сервиса time-service и возвращающий результат - выходной
 * ли день в указанной временной зоне, и какой именно это выходной.
 */
public class WeekdayService {
    private static Logger logger = LoggerFactory.getLogger(WeekdayService.class);

    public static void main(String[] args) {
        port(5678);

        Gson gson = new Gson();

        // страна и город для выяснения выходного дня кодируется прямо в пути запроса HTTP
        // пример: /weekday/Europe/Moscow
        get("/weekday/:country/:city", (req, res) -> {
            ZoneId timeZoneId = ZoneId.of(req.params("country") + "/" + req.params("city"));
            logger.info("Запрошен статус выходного дня для зоны {}", timeZoneId);

            DayOfWeek dayOfWeek = LocalDate.now(timeZoneId).getDayOfWeek();
            boolean isWeekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)
                    .contains(dayOfWeek);

            return new TimeZoneReply(isWeekend, dayOfWeek.name());
        }, gson::toJson);
    }

    // стандартный класс с данными для преобразования в JSON
    static class TimeZoneReply {
        private boolean weekend;
        private String day;

        TimeZoneReply(boolean weekend, String day) {
            this.weekend = weekend;
            this.day = day;
        }

        public boolean isWeekend() {
            return weekend;
        }

        public String getDay() {
            return day;
        }
    }
}
