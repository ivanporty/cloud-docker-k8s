## Примеры Dockerfile, Jib, код микросервисов на Go и Java, манифесты Kubernetes для книги "Программирование Cloud Native. Микросервисы, Docker и Kubernetes"

В этом репозитории содержится код примеров книги, манифесты Kubernetes, команды Dockerfile. Команды, запускаемые в консоли (такие как вызовы `kubectl`), сохранены как часть системы непрерывной сборки GitHub Actions (конфигурация находится в `.github/workflows`, посмотреть запуски тестов - вкладка `Actions`)

### Непрерывная сборка (CI) кода и скриптов книги

Все команды, вызовы `kubectl`, проверка результатов работы, код микросервисов, и упаковка в контейнеры запускаются ежедневно как часть непрерывной сборки (continuous integration, CI), с помощью GitHub Actions. Нажмите на ссылки ниже, чтобы увидеть результаты последних сборок и сам код тестирования для всех команд и примеров, используемых в книге:

* Cборка простых образов контейнеров Docker и их тестирование в терминале (глава 4)
    * [![Dockerfile CI](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/docker-image.yml/badge.svg?branch=master)](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/docker-image.yml)    [(скрипт)](https://github.com/ivanporty/cloud-docker-k8s/blob/master/.github/workflows/docker-image.yml)

* Начало работы с Kubernetes, minikube, kubectl (глава 5)
    * [![Настройка кластера K8s](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/cluster-setup.yml/badge.svg)](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/cluster-setup.yml)  [(скрипт)](https://github.com/ivanporty/cloud-docker-k8s/blob/master/.github/workflows/cluster-setup.yml)

* Код микросервиса `time-service`, сборка в образ контейнера (image), запуск и проверка результатов (глава 5)
    * [![time-service CI](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/time-service.yml/badge.svg)](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/time-service.yml)   [(скрипт)](https://github.com/ivanporty/cloud-docker-k8s/blob/master/.github/workflows/time-service.yml) 
