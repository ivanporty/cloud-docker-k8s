package com.porty.k8s;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.net.URI;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.util.EnumSet;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Простой сервис на основе Spark/Java, запрашивающий время у микросервиса time-service
 * и возвращающий результат - выходной ли день в указанной временной зоне,
 * и какой именно это выходной.
 */
public class WeekendService {
    private static Logger logger = LoggerFactory.getLogger(WeekendService.class);

    public static void main(String[] args) {
        port(5678);

        Gson gson = new Gson();

        // страна и город для выяснения выходного дня кодируется прямо в пути запроса HTTP
        // пример: /weekend/Europe/Moscow
        get("/weekend/:country/:city", (req, res) -> {
            ZoneId timeZoneId = ZoneId.of(req.params("country") + "/" + req.params("city"));
            logger.info("Запрошен статус выходного дня для зоны {}", timeZoneId);

            // запрашиваем время от вспомогательного сервиса и преобразуем его в объект c данными
            TimeServiceResponse timeServiceResponse = gson.fromJson(
                    new InputStreamReader(
                            URI.create("http://time-service:8080/nanotime").toURL().openStream()),
                    TimeServiceResponse.class);
            // используем пакет java.time для получения данных о текущем дне
            Instant millisTime = Instant.ofEpochMilli(
                    Long.parseLong(timeServiceResponse.getNanoTime()) / 1000000);
            DayOfWeek dayOfWeek = millisTime.atZone(timeZoneId).getDayOfWeek();
            boolean isWeekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)
                    .contains(dayOfWeek);

            return new TimeZoneReply(isWeekend, dayOfWeek.name());
        }, gson::toJson);
    }

    // стандартный класс с данными для преобразования результата сервиса в JSON
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

    // стандартный класс с данными для получения данных JSON от сервиса time-service
    static class TimeServiceResponse {
        private String time;
        private String nanoTime;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getNanoTime() {
            return nanoTime;
        }

        public void setNanoTime(String nanoTime) {
            this.nanoTime = nanoTime;
        }
    }
}
