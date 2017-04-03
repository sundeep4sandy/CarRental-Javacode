CREATE TABLE Customer
(
Cid INT primary key,
FLname VARCHAR(20) NOT NULL,
Phone varchar(20) ,
Address VARCHAR(40),
Gender VARCHAR(10) NOT NULL,
Age INT NOT NULL
);

CREATE TABLE owner 
(
Owner_id INT PRIMARY KEY,
Ownertype VARCHAR(20) default 'individual' 
);			


CREATE TABLE Car
(
Owner_id int,
License_no varchar(20) NOT NULL,
V_id varchar(20) PRIMARY KEY,
YEAR INT  NOT NULL,
MODEL VARCHAR(20) NOT NULL,
Location VARCHAR(20) ,
Daily_rate INT NOT NULL,
Weekly_rate INT NOT NULL,
Cid INT  ,
Car_type VARCHAR(20) NOT NULL,
 FOREIGN KEY (Owner_id) REFERENCES owner (Owner_id) ON UPDATE CASCADE
);
	



CREATE TABLE COMPACT
(
V_id varchar(20),
No_seats INT NOT NULL,
Milege INT NOT NULL,
Reg_no  VARCHAR(20) PRIMARY KEY,
FOREIGN KEY (V_id) REFERENCES Car (V_id) ON UPDATE CASCADE
);



CREATE TABLE Medium
(
V_id varchar(20),
Milege INT NOT NULL,
No_seats INT NOT NULL,
Reg_no  VARCHAR(20) PRIMARY KEY,
FOREIGN KEY (V_id) REFERENCES Car (V_id) ON UPDATE CASCADE

);

CREATE TABLE suv
(
V_id varchar(20),
Milege INT NOT NULL,
Drivemode VARCHAR(20),
Reg_no  VARCHAR(20) PRIMARY KEY,
FOREIGN KEY (V_id) REFERENCES Car (V_id) ON UPDATE CASCADE

);

CREATE TABLE Large
(
V_id varchar(20),
Milege INT NOT NULL,
No_seats INT NOT NULL,
Reg_no  VARCHAR(20) PRIMARY KEY,
FOREIGN KEY (V_id) REFERENCES Car (V_id) ON UPDATE CASCADE

);


CREATE TABLE Truck
(
V_id varchar(20),
Transmission VARCHAR(20) NOT NULL,
Weight_capacity INT ,
Reg_no  VARCHAR(20) PRIMARY KEY,
FOREIGN KEY (V_id) REFERENCES Car (V_id) ON UPDATE CASCADE

);


CREATE TABLE Van
( 
V_id varchar(20),
No_seats INT NOT NULL,
Reg_no  VARCHAR(20) PRIMARY KEY,
FOREIGN KEY (V_id) REFERENCES Car (V_id) ON UPDATE CASCADE

);




CREATE TABLE company
(
Owner_id INT,
C_addr VARCHAR(20),
C_name VARCHAR(20) PRIMARY KEY,
FOREIGN KEY (Owner_id) REFERENCES owner(Owner_id) ON UPDATE CASCADE 
);


CREATE TABLE Bank
(
Owner_id INT,
B_id INT PRIMARY KEY,
B_addr VARCHAR(20),
FOREIGN KEY (Owner_id) REFERENCES Owner(Owner_id) ON UPDATE CASCADE

);


CREATE TABLE Individual
(
Owner_id INT,
I_name VARCHAR(20) ,
I_addr VARCHAR(20),
I_ssn INT PRIMARY KEY,
FOREIGN KEY (Owner_id) REFERENCES Owner(Owner_id) ON UPDATE CASCADE

);


CREATE TABLE Rentals
(
V_id varchar(20),
Cid INT,
Rental_idi VARCHAR(40) PRIMARY KEY,
Amount_paid INT ,
FOREIGN KEY (V_id) REFERENCES Car (V_id) ON UPDATE CASCADE,
FOREIGN KEY(Cid) REFERENCES Customer (Cid) ON UPDATE CASCADE
);


CREATE TABLE daily
(
Rental_id VARCHAR(40) PRIMARY KEY,	
Rental_idi VARCHAR(40),
D_sdate date,
No_days INT ,
D_rdate date,
Amt_due INT ,
FOREIGN KEY(Rental_idi) REFERENCES Rentals (Rental_idi) ON UPDATE CASCADE
);


CREATE TABLE weekly
(
Rental_id VARCHAR(40) PRIMARY KEY,
Rental_idi VARCHAR(40),
W_start_dt date,
No_weeks INT ,	
W_Rdate date,
Amt_due INT,
FOREIGN KEY(Rental_idi) REFERENCES Rentals (Rental_idi) ON UPDATE CASCADE
);


