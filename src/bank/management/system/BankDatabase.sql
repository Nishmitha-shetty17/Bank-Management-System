create database bankSystem;
use bankSystem;
CREATE TABLE signup (form_no varchar(30),name varchar(30),father_name varchar(30),DOB varchar(30),gender varchar(30),email varchar(50),marital_status varchar(30),address varchar(100),city varchar(30),pincode varchar(30),state varchar(30));
select * from signup;

CREATE TABLE signuptwo (form_no varchar(30),religion varchar(30),category varchar(30),income varchar(30),education varchar(30),occupation varchar(50),pan varchar(30),aadhar varchar(100),seniorcitizen varchar(30),existing_account varchar(30));
select * from signuptwo;

CREATE TABLE signupthree (form_no varchar(30),account_type varchar(40),card_number varchar(30),pin varchar(30),facility varchar(200));
select * from signupthree;

CREATE TABLE login(form_no varchar(30),card_number varchar(30),pin varchar(30));
select * from login;

CREATE TABLE bank(pin varchar(10),date varchar(50),type varchar(20),amount varchar(20));
SELECT * FROM bank;
