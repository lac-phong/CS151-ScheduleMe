# ScheduleMe
ScheduleMe is an application designed to help users maintain and track goals made in java utilizing java swing.
## Table of contents
* [Team Number and Members](#Team-#11)
* [Contributions to presentation](#Contributions-to-presentation)
* [Contributions to code](#Contributions-to-code)
* [Issue](#Issue)
* [Previous Works](#Previous-works)
* [Assumptions](#Assumptions)
* [Operations](#Operations)
* [How to run code](#How-to-run-code)
* [Snapshot of program running](#Snapshot-of-program-running)
* [References](#References)


## Team #11
* Steven Stansberry
* Lac-Phong Nguyen
* Tyler Moquin

## Contributions to presentation
* Steven Stansberry:
* Lac-Phong Nguyen: Created View Goals, View Completed Goals slides, and demo for our application
* Tyler Moquin:

## Contributions to code
* Steven Stansberry: Login and signup functionality, Storage and retrieval of user information via
, implemtnation of the strategy design pattern for behavior of write and reads for CSVHandler classes.
  GUI for homeFrame, startUpFrame, signUpFrame, loginFrame, and achievementsFrame. User and
  achievement class. Incorporated singleton design pattern for handling the instance of accounts.
* Lac-Phong Nguyen: Created and implemented Goal object with GoalType (General, Financial, Relationship, Educational, Physical) and GoalInterval (Indefinite, Definite) functionality through strategy design pattern, created and implemented notification window for goals within 1 day of being due, implemented method of tracking financial goal progress, general bug fixes, created GUI for ViewGoalsFrame, CompletedGoalsFrame, CreateGoalFrame, and EditGoalFrame
* Tyler Moquin:

## Issue
There are a plethora of habit or goal related apps, However
a lot of these applications that are designed to be used on one's computer, most
other habit related apps or designed to be run on a mobile device.
While there are a lot of advantages to running such an application on the phone,
this solution doesn't fit everyone. ScheduleMe aims to make it easy for users
who do not wish to track goals or habits on their phone to do so on their 
computer.

## Previous works

## Assumptions
ScheduleMe is designed as a standalone computer program.

## Functionality
ScheduleMe allows users to input a goal that they wish to accomplish. Users are
able to set a name, description, category, and depending on whether the goal is 
marked as indefinite or definite: a frequency or due date respectively. The user 
also has access to some predefined activity types as well. Users 
are able to view all of their currently in progress goals as well as any goal
that completed. Users are able to edit or delete the goal as necessary. ScheduleMe
also incorporates an achievement system as an incentive to motivate the user.

### Operations:
- Add goal: The user is able to create a goal with custom name, description,
category, activity, time interval, due date or frequency depending on the 
time interval set
- Modify goal: Once a goal is created, the user will be able to modify its attributes
- Delete goal: Deletes a goal
- Complete goal: By marking a goal as complete, it will be removed from the view goals frame
and moved into the view completed goals frame. Completing a goal will allow users to earn achievements
- Achievements: Users are able to earn achievements by completing a certain number of 
goals within a given category. On the achievements page, the user will also be able to see
some of their statistics regarding number of goals completed as well as their progress
towards these achievements

## Solution
Since ScheduleMe is designed to be used on the computer, it gives users a 
lot more power and flexibility when it comes to their goals. If a user has 
a very intricate goal with lots of details, it is much simpler to input these
criteria into a computer app compared to a mobile app. Additionally, our program
makes it easy to retrieve to the CSV files associated with the goals if the user
wishes to plot these metrics or otherwise store them.
# How to run code

# Installing via Git
To install this project, navigate to an ideally empty directory and
execute the following command:

    $ git clone https://github.com/lac-phong/CS151-ScheduleMe
    $ cd ...

#### Running from terminal
```
1
2
3
4
5
6
```
#### Running .JAR file
```
1
2
3
4
5
6
```



    


## Snapshot of program running

## References

