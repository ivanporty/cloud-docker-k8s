# Первая ступень на основе стандартного образа Gradle
FROM gradle:6.9-jdk11 as builder

# Директория для файлов проекта
WORKDIR weekend-service/

# Копируем файл сборки и исходный код
COPY build.gradle ./
COPY src/ ./src/

# Сборка
RUN gradle build

# Вторая ступень для окончательной сборки
# Минимальная версия JRE, версия 11, открытая версия OpenJDK
FROM openjdk:11-jre-slim

# Такая же директория
WORKDIR weekend-service/
# Скопируем архив JAR из первой ступени
COPY --from=builder home/gradle/weekend-service/build/libs/weekend-service-0.1.0-SNAPSHOT.jar .
 
# Объявим свой порт
EXPOSE 5678

CMD ["java", "-jar", "/weekend-service/weekend-service-0.1.0-SNAPSHOT.jar"]
