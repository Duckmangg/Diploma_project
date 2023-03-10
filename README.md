Дипломный проект по курсу «Тестировщик ПО»
О проекте:
В дипломном проекте реализовано автотестирование сервиса по заказу туров. В приложении возможно формить тур двумя способами:

Оплата по дебетовой карте
Выдача кредита по данным банковской карты.
Инструкция по запуску тестов:
Предварительная подготовка к тестированию:
Установить IntelliJ Idea. https://www.jetbrains.com/ru-ru/idea/.

Установить Docker Desktop. https://www.docker.com/get-started.

Для запуска тестов необходимо:

С помощью команды git clone, скачать себе локально репозиторий https://github.com/Duckmangg/Diploma_project.git

Открыть проект при помощи IntelliJ Idea

Дождаться прогрузки всех связей.

Запустить в терминале команду ```docker-compose up```

В соседних вкладках запустить само приложение командой:

```java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app``` БД PostgreSQL

```java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app``` БД MySQL

Запустить тесты командой

```./gradlew clean test.```

Для генерации отчета Allure о выполненных тестах выполнить в терминале команду:

```./gradlew allureServe```
