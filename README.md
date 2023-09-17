# Проект по автоматизации тестирования API reqres.in

### Технологии и инструменты:
<p align="center">
<img src="images/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/>
<img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/>
<img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/>
<img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="images/logos/Allure_Report.svg" width="50" height="50"  alt="Allure_Report"/>
<img src="images/logos/Rest-Assured.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logos/Telegram.svg" width="50" height="50"  alt="Jenkins"/>
</p>

### Реализованные проверки:
* Создание нового пользователя
* Проверка наличия пользователя в базе
* Обновление данных пользователя
* Получение данных пользователя по id
* Удаление пользователя 

### Запуск тестов из терминала
#### Локальный запуск тестов:
```bash
gradle clean api_tests
```
    
### Сборка в [Jenkins](https://jenkins.autotests.cloud/job/jenkins_rest_api_tests/)
<p align="center">
<img title="Jenkins Build" src="images/screens/Jenkins.png">
</p>

### Отчет в [Allure report](https://jenkins.autotests.cloud/job/jenkins_rest_api_tests/7/allure/)
#### Основная страница отчета
<p align="center">
<img title="Jenkins Build" src="images/screens/Allure-report.png">
</p>

#### Тест-кейсы
<p align="center">
<img title="Jenkins Build" src="images/screens/Allure-tests.png">
</p>

### Уведомления в Telegram с использованием бота
<p align="center">
<img title="Jenkins Build" src="images/screens/Telegram.png">
</p>
