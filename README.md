# Cinema Project

This application is available on Local Server:
http://185.193.67.121:8080/

# Credentials
##For Admin
username: pattus
password: admin123
</br>

## Contents
* [About](#about)
* [Changelog](#changelog)
* [Technologies](#technologies)
* [Functions](#functions)

## About
This project aimed to broaden the knowledge of programming and the use of my knowledge in practice. The main goal was to create a modern application that is functional and
fault-tolerant. This application is used to book seats in a cinema. Users can browse the repertoire, select a day and time, and then reserveSeatConfiguration seats. The seats are divided into
already reserved and unreserved. All data is stored in the database. Users can register and log into the system. Administrator is able to do CRUD operations on movies and
screening times. The app was tested on mobile devices.

## Changelog
15 December 2023:
- The entire project was upgraded to common correct programming practices based on commercial experience.
- The logic has been moved from the controller to the service.
- Added paths in the controller as Routes.
- Added logs with information in service methods via Lombok.
- Much more fixes, corrections, upgrades to clean code.

## Technologies
* Java
* Spring Boot
* Spring Security
* Hibernate
* H2
* Thymeleaf
* Bootstrap
#### Used tools:
* Maven
* Lombok


## Functions
- Everyone can browse the application without logging into the system.
- Additional menu with more options for admin who can add, edit and delete movies.
- Admin can add, edit and delete the day and time when a particular movie will be playing in the cinema.
- Non logged in users can register and login to the application.
- Logged in users can reserveSeatConfiguration seats.
- Seats validation: user cannot reserveSeatConfiguration the entire cinema hall or leave a seat empty.
- User registration validation: each field must be entered correctly.
- User must confirm his registration to the e-mail adress he provided.
- Seats are divided into reserved(green) and unreserved(red).

 
### The repertoire of movies any user can browse:

![image](https://github.com/pattusdev/Cinema-booking-system23738/assets/34842845/85af0a72-6be5-470c-83c5-789c916266a4)

 
### The next step is to select a time:

![image](https://github.com/pattusdev/Cinema-booking-system23738/assets/34842845/4fca58ef-5501-489c-9b17-fa7841c760bc)

 
 
### Final reservation:

![image](https://github.com/pattusdev/Cinema-booking-system23738/assets/34842845/248bb9f4-1ff1-409c-bb1a-3c545cbe7c1b)



### Admin can do CRUD operations on movies:

![image](https://github.com/pattusdev/Cinema-booking-system23738/assets/34842845/1af46096-bfa3-48b0-a173-5cbf3b542def)


### And repertoires:

![image](https://github.com/pattusdev/Cinema-booking-system23738/assets/34842845/e9f4ba31-08f4-40bb-89c3-141bbd18d885)



### Menu for user:

![image](https://github.com/pattusdev/Cinema-booking-system23738/assets/34842845/28bf63e5-161e-463d-88c5-a91c991226b4)


### Menu for admin:

![image](https://github.com/pattusdev/Cinema-booking-system23738/assets/34842845/d037d403-52a9-4fbf-a90a-ecf6e822f459)


### Responsiveness on mobile devices:

![image](https://github.com/pattusdev/Cinema-booking-system23738/assets/34842845/b7f86e16-eca0-41be-be9a-8c41a6344468)


User can swipe through the application.
