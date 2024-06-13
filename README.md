# Task-Management

## Запуск из среды

- Скачать плагин `EnvFile`
- В конфигурации запуска нажать `Modify Options`
- Поставить галочку на `Environment Variables`
- Поставить галочку `Enable EnvFile`
- Нажать на плюсик и добавить файл `config/local/local.env`
- Запустить `TaskManagementApplication`

## Деплой приложения

- Сборка проекта - ` mvn clean install `
- Соберите образ Docker с помощью команды docker build - ` docker build -t task-management-app . `
- Тег - `docker tag task-management-app username/task-management-app`
- Загрузите созданный образ на репозиторий с помощью команды docker push - `docker push username/task-management-app`
- Скачайте образ с вашего репозитория образов на сервер с помощью команды docker pull - `docker pull username/task-management-app`
- Загрузите файлы в каталоге ./config/deploy и в этом каталоге запустите приложение с помощью Docker Compose - `docker-compose --env-file ./compose.env up -d`

## Дополнительно
##### Есть два вида хранения данных
- Коллекция
- База данных
##### Вы можете переключать это с помощью параметра DB.TYPE=database/in-memory
## Доступные URL

- /task-management/swagger-ui/index.html
- /task-management/api/ - API 
