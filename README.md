# Проект API автоматизации для сайта <a href="https://reqres.in/">reqres.in</a>

## :point_up: Структура:

- <a href="#point_up_2-стек">Стек</a>
- <a href="#point_up_2-проведенные автотесты">Проведенные автотесты</a>
- <a href="#point_up_2-сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#point_up_2-allure-отчет">Allure отчет</a>
- <a href="#point_up_2-интеграция-с-allure-testops">Интеграция с Allure TestOps</a>
- <a href="#point_up_2-интеграция-с-jira">Интеграция с Jira</a>
- <a href="#point_up_2-отчет-в-telegram">Отчет в Telegram</a>

## :point_up_2: Стек
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Rest-Assured" src="images/logo/rest-assured.png">
<img width="12%" title="Groovy" src="images/logo/groovy.png">
<img width="7%" title="Lombok" src="images/logo/lombok.png">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

## :point_up_2: Проведенные автотесты
- Проверка наличия списка пользователей на странице с помощью Lambok
- Создание пользователя с именем Morpheus с помощью Lambok
- Проверка наличия данных на странице с помощью Groovy
- Проверка работоспособности 404 страницы
- Проверка авторизации
- Проверка наличия списка пользователей на странице
- Удаление данных о пользователе

## :point_up_2: Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/11-Zoloft-Api-tests/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/Screenshots/Jenkins.png">
</p>


## :point_up_2: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/Screenshots/Allure.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/Screenshots/Allure-suites.png">
</p>

## :point_up_2: Интеграция с Allure TestOps
- ### Экран с результатами запуска тестов
<p align="center">
<img title="TestOps Launch Page" src="images/Screenshots/Allure-test-ops.png">
</p>

- ### Страница с тестами в TestOps
<p align="center">
<img title="TestOps tests page" src="images/Screenshots/Allure-test-ops-cases.png">
</p>

## :point_up_2: Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/Screenshots/Telegram.jpg">
</p>