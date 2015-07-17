Vehicle Survey
========

by MSALINAS

A small city government recently bought a vehicle counter. In order for the vehicle counter to work, neumatic rubber hoses are stretched across the road. Data is produced by the vehicle counter as traffic drives across the hoses.  The city government requires a program to interpret the data that the machine produces. Speeding cars are those that speed is above 65 km/h.  


--------------------------
Usage -> This will run the application and all unit tests
-------------------------

Eclipse: 
- 

- Clone repo: git clone https://github.com/marquinhe/msalinas.git

- Import Maven project 

- Right click on main project folder --> Run as --> Maven Test 

- This will run all tests and load main class. 


Maven Console: 

- Clone repo: git clone https://github.com/marquinhe/msalinas.git

- cd msalinas 

- mvn test

-------------------------
Parameters (input file)
-------------------------

By default the tool reads file data.txt 9 included)
To modify input, update POM file line 17: 

< argument >data.txt< /argument >

with 

< argument >yourNewFile.txt< /argument >


After reading file, type-in the time interval 
to analyse distribuition in the following format:  20m  where m represents the number of minutes, other option: 4h where h represents the number of hours. 



-------------------------
Description
-------------------------

The numbers are the number of milliseconds since midnight when the mark occurred. Thus, the first line above represents a pair of tires driving by at 12:04:28am. The second line represents another pair of tires going by 142ms later (almost certainly the 2nd axle of the car).
The vehicle counter has two pneumatic rubber hoses - one stretches across both lanes of traffic, and one goes just across traffic in one direction. Each hose independently records when tires drive over it. As such, cars going in one direction (say, northbound) only record on one sensor (preceded with an 'A'), while cars going in the direction (say, southbound) are recorded on both sensors. Lines 3-6 above represent a second car going in the other direction. The first set of tires hit the 'A' sensor at 12:10:04am, and then hit the 'B' sensor 3ms later. The second set of tires then hit the 'A' sensor 171ms later, and then the 'B' sensor 4ms later.

-------------------------
Output
-------------------------

Total Car Count:
North: 33285 cars (49.60%) South: 33828 cars  (50.40%) 

Average Car Speed:
North: 63.52 km/h South: 63.45 km/h

Average Car Distance:
North 72.29 m South 12.10 m

Total Speeding Cars:
North: 14175 cars (42.59%)  South: 14238 cars (42.09%) 

Day of data: 5 days


+-----------------------------------------------------+

| Day  | Block  |   Dir  | Count  |  Speed | Distance 

+-----------------------------------------------------+

| 1    | 4:00  | North  | 12     | 62.58  | 6509.53 

| 1    | 4:00  | South  | 29     | 64.16  | 28886.61 

| 1    | 8:00  | North  | 179    | 64.50  | 540.82 

| 1    | 8:00  | South  | 324    | 63.17  | -510.38 



Where day represents the day, count the number of occurrences, 
speed the Av speed (km/h) and Distance the Avergae distance between cars in meters. 

Block the interval, as is read as
First interval is from 0 to 4:00, 
Second interval is from 4:00 to 8:00
