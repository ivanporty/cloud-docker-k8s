# Используем полную версию Ubuntu как базовый образ
FROM ubuntu

# Поменяем рабочую директорию на более удобную
WORKDIR /opt/helloworld

# Скопируем нужные нам для работы контейнера файлы в образ
COPY hello_world ./
COPY print_loop.sh ./

# Команда CMD или ENTRYPOINT исполняется при запуске контейнера
CMD ["/opt/helloworld/print_loop.sh", "2"]