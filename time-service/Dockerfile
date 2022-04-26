# Собирает образ для контейнера с сервисом получения времени.
FROM golang:1.18 as builder

# Изменим рабочую директорию
WORKDIR /opt/time-service

# Скопируем код программы в файловую систему контейнера
COPY main.go .

# Соберем программу из исходного кода, в файл time-service
# Необходимо указать дополнительные флаги сборки Go
RUN CGO_ENABLED=0 GOOS=linux go build -a -o time-service main.go

# вторая ступень - спартанская версия Linux Alpine
FROM alpine:3.10

# номер порта, используемого контейнером
EXPOSE 8080
# Используем такую же рабочую директорию
WORKDIR /opt/time-service

# Скопируем собранный бинарный код из первой ступени
COPY --from=builder /opt/time-service/time-service .

CMD [ "/opt/time-service/time-service" ]