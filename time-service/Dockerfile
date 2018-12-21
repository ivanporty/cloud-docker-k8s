# Собирает образ для контейнера с сервисом получения времени.
FROM golang:1.9

WORKDIR /opt/go/time-service

EXPOSE 8080
COPY *.go .

RUN go build

ENTRYPOINT [ "/opt/go/time-service/time-service" ]