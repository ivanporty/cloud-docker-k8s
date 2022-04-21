## Примеры Dockerfile, Jib, код микросервисов на Go и Java, манифесты Kubernetes для книги "Программирование Cloud Native. Микросервисы, Docker и Kubernetes"

Все команды сборки образов контейнеров Docker и их тестирование в терминале запускаются ежедневно как часть непрерывной сборки, с помощью GitHub Actions. Нажмите на ссылку чтобы увидеть результаты последних сборок и сам код тестирования:

[![Dockerfile CI](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/docker-image.yml/badge.svg?branch=master)](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/docker-image.yml)

Начало работы с Kubernetes, minikube, kubectl

[![Настройка кластера K8s](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/cluster-setup.yml/badge.svg)](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/cluster-setup.yml)

Код микросервиса `time-service` также собирается ежедневно и как часть любого изменения в коде примера - нажмите на ссылку, чтобы увидеть сам код тестирования:

[![time-service CI](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/time-service.yml/badge.svg)](https://github.com/ivanporty/cloud-docker-k8s/actions/workflows/time-service.yml)
