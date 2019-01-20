# Online-Cinema-Booking_System
### RU
18. Система Кинотеатр. 
Вы пишете интернет витрину маленького Кинотеатра с одним залом. 
В нем есть Расписание показа фильмов на все 7 дней недели с 9:00 до 22:00 (начало последнего фильма).
Незарегистрированный пользователь может видеть: расписание, свободные места в зале, возможность зарегистрироваться.
Зарегистрированный пользователь должен быть в состоянии выкупить билет на выбранное место.
Администратор может: внести в расписание новый фильм, отменить фильм, просматривать посещаемость зала.

### EN
18. System Cinema.
You write on the Internet a small cinema with one room.
It has schedule 7 days of the week from 9:00 to 22:00 (the beginning of the latest films).
Unregistered user can see: schedule, free seats in the hall, the ability to register.
Buy a ticket to the selected location.
The administrator can: add a new film to the schedule, cancel the film, see attendance of the hall.

## Installation
Download and install java [jdk](https://www.java.com/en/download/) on your computer,
also you need to install [intelij idea](https://www.jetbrains.com/idea/).
And install [tomcat](https://tomcat.apache.org/download-90.cgi) server.


## Usage
Create new [maven](https://maven.apache.org/) project with added web-module.
Add all dependencies that are needed in this project, you can found them in pom.xml
Click on Run > Run configurations
Navigate to your Java Application's configuration section
Make sure you are using Java 10
```bash
java -v
 Output: java version "10"
```
In console type
```bash
$ git clone github.com/vovaspk/Online-Cinema-Booking_System ${directory}
$ cd ${directory}
$ mvn clean install
```
### To run
Click on 'Run Tomcat Server'


