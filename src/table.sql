﻿

CREATE TABLE Admin_Info (
admin_id VARCHAR(20) NOT NULL ,
passwords VARCHAR(20) NOT NULL ,
category CHAR(15) NOT NULL ,
PRIMARY KEY (admin_id)
);


CREATE TABLE  Personal_Info (
passenger_id VARCHAR(20) NOT NULL ,
passenger_name VARCHAR(20) NOT NULL ,
mobile_number NUMERIC(12) NOT NULL ,
address VARCHAR(20) NOT NULL ,
age NUMERIC NOT NULL ,
PRIMARY KEY (passenger_id)
); 


CREATE TABLE  Train_Info (
train_number serial ,
train_name VARCHAR(20) NOT NULL ,
source VARCHAR(20) NOT NULL ,
destination VARCHAR(20) NOT NULL ,
admin_id VARCHAR(20) NOT NULL ,
arrival time NOT NULL ,
departure TIME NOT NULL ,
price NUMERIC(5) NOT NULL ,
PRIMARY KEY (train_number),
foreign key(admin_id) references Admin_Info(admin_id)
) ;




CREATE TABLE  Reserved (
passenger_id VARCHAR(20) NOT NULL ,
train_number integer NOT NULL ,
passenger_name VARCHAR(20) NOT NULL ,
mobile_number NUMERIC(12) NOT NULL ,
address VARCHAR(20) NOT NULL ,
pnr serial NOT NULL ,
PRIMARY KEY (pnr) ,
foreign key(train_number) references Train_Info(train_number),
foreign key(passenger_id) references Personal_Info(passenger_id)
);








SELECT * FROM Admin_Info;
SELECT * FROM Personal_Info;
SELECT * FROM Train_Info;
SELECT * FROM Reserved;





INSERT INTO Admin_Info VALUES('rohit','pass','admin');
INSERT INTO Admin_Info VALUES('nitesh','pass','admin');
INSERT INTO Admin_Info VALUES('nitin','pass','admin');




INSERT INTO Personal_Info VALUES('1','Parth Modi',9871357283,'Manipal Block-15',19);
INSERT INTO Personal_Info VALUES('2','Akash Agarwal',9901572837,'Manipal Block-6',21);
INSERT INTO Personal_Info VALUES('3','Nitesh Narayan',9663556029,'Manipal Block-5',20);

INSERT INTO Train_Info VALUES(1,'Mangla Express','Udupi','Delhi','nitesh','16:30:00','16:35:00',300);
INSERT INTO Train_Info VALUES(2,'Poorna Express','Udupi','Agra','nitesh','17:30:00','17:35:00',300);
INSERT INTO Train_Info VALUES(3,'Mangla Express','Udupi','Delhi','nitesh','18:30:00','18:35:00',300);



INSERT INTO Reserved VALUES('1',1,'Nitesh Narayan',9901572837,'Manipal Block-6',1);
INSERT INTO Reserved VALUES('2',2,'Akash Agarwal',9811357273,'Manipal Block-5',2);
INSERT INTO Reserved VALUES(3,3,'Parth Modi',9899123459,'Manipal Block-14',3);
