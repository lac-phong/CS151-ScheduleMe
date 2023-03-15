Tyler Moquin
Lac-Phong Nguyen
Steven Stansberry
Team #11

# ScheduleMe

### Team
Team #11
Tyler Moquin
Lac-Phong Nguyen
Steven Stansberry

### Problem	
Many people have a variety of goals they wish to meet which vary in terms of duration, type, and frequency of required effort or attention. We propose to build an app that will allow users to set goals using flexible goal types and then schedule and keep track of their progress in working towards those goals.

### Description of Solution	
Our app will provide users with the ability to specify their goals as well as a schedule and/or milestones for working towards accomplishing them. This will allow users both to keep track of their progress towards meeting their goals and to be reminded of actions they need to take on a timely (i.e., daily, weekly, monthly) basis in order to progress. The app will also provide the option for the user to receive reminder notifications regarding activities they need to undertake in order to remain on track to accomplish any particular goal, as well as optional motivational messages as they reach particular milestones towards accomplishing a goal.

Given the variety of different types of goals that a user may have, the system will be built to allow the user to specify goals that vary in type. For example, a goal might involve saving a particular amount of money, in which case the app will allow the user to record funds they have set aside whenever they do so. Other goals, for example, exercising, might have temporal scheduling requirements like performing an activity a certain number of times per week; for this type of goal, the app will keep track of the number of times the user has performed the activity in the designated time period and may also provide the user with a proposed schedule for the remainder of the time period for them to be able to accomplish the goal. Other goals might be more nebulous, for example reading a certain number of books per month, in which case the app will allow the user to keep track of their progress towards meeting their goal for each time frame. The overarching design target for the app is to provide maximal flexibility to the user in terms of how they can specify their goals and how they track their progress towards achieving them.

### Workflow and Technologies
For this project, we have decided that it will be an android app as two of our group members have some experience in developing android apps. We are going to follow an agile workflow and primarily use Java to create our app through the IDE Android Studio. For our database we plan to use Firebase. The designing of our app’s UI will be done with the online design tool Figma.

### Functionality	
By giving users a much more concrete, visual manner of tracking and executing goals, we hope that our users will be able to better adhere to their chosen goals. We also hope to give our users a sense of progression and accomplishment as they complete their goals and are slowly able to build up a list of accomplishments. As our application is developed to be as flexible as possible, users are able to define their goals no matter how small or large they may be.

### Operations	
- Account registration (name, email, username, password)
- Login
- Forgot password
- Create/edit/delete goals
- Add tasks to be done (can specify when tasks need to be finished or leave time to finish indefinite)
- Generate progress report for all goals or specified goals
- Generate schedules and time zones to work on tasks (optimizes how much time should be spent on each task each day based on priority of task set by user)
- Dashboard of upcoming activities and deadlines as well as progress
- Set reminders for activities related to particular goals
- Optionally send motivational messages to user when they are nearing particular goal thresholds (10%, 25%, etc.)
- Export as an ICS file for use with traditional calendar apps.
