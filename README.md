# OKNO-Tracker





## Подключение к базе

Для подключения к базе нужны *Environment variables*:

- DATABASE_USERNAME
- DATABASE_PASSWORD
- DATABASE_URL



### Настройка подключения к локальной базе в Docker'е

Для создания базы нужно:

- выполнить скрипт *"createStuff.sh"* для создания всего для базы (его достаточно выполнить лишь 1 раз)
- выполнить *"docker-compose.yaml"* (запустить базу)

Для запуска приложения с подключением к этой БД нужно в конфигурацию запуска Intellij IdeA добавить в Environment variables путь до файла *src/main/resources/local-docker.env*.



### Настройка подключения к удаленной базе

Сначала ждем, пока Науруз развернет базу.

Для запуска приложения с подключением к этой БД нужно в конфигурацию запуска Intellij IdeA добавить в Environment variables путь до файла *src/main/resources/test.env*.