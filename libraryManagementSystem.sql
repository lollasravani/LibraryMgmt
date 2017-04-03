create table users
(
	user_id SERIAL PRIMARY KEY,
	user_name varchar(20) NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	password varchar(15) NOT NULL,
	email varchar(30) UNIQUE,
	phone_no int UNIQUE
);
alter table users add phone_no numeric(10,0);
select * from users;

create table authors
(
	author_id int PRIMARY KEY,
	author_name varchar(20) NOT NULL
);
select * from authors;

create table publishers
(
	publisher_id int PRIMARY KEY,
	publisher_name varchar(20) NOT NULL,
	isForeignPublisher boolean default false
);
select * from publishers;

create table books
(
	isbn varchar(15) PRIMARY KEY,
	user_id int references users(user_id),
	title varchar(30) NOT NULL,
	author_id int references authors,
	publisher_id int references publishers,
	edition int,
	no_of_pages int,
	total_copies int CHECK (total_copies >= 0),
	copies_left int CHECK (copies_left >= 0),
	shelf_no varchar(3),
	CHECK (copies_left <= total_copies)
);
select * from books;

create table issuedBooks
(
	user_id int references users,
	isbn varchar(15) references books,
	fine int,
	issued_date date,
	return_date date,
	hasReturned boolean DEFAULT false,
	CHECK (issued_date <= return_date)
);
selec * from issuedBooks;

create table admin
(
        admin_id int PRIMARY KEY,
	admin_name varchar(20) NOT NULL
);	
select * from admin;
insert into users values (1,'Priyanka','shalini','Akanksha','a123','priya@gmail.com',8905578559);
insert into users values (2,'Sakshi','Harikumar','Padma','cd45','sakshi@gmail.com',9440944097);
insert into users values (3,'Sindhu','Chaganti','Meka','@123','sindhu@gmail.com',9441308844);
insert into users values (4,'Aditya','Suresh','Gupta','&g68','suresh@gmail.com',9701821722);
insert into users values (5,'Ashok','Nair','Sharma','pm49','ashok@gmail.com',9700471219);
insert into users values (6,'Rajesh','Khanna','Abhishek','kn37','abhishek@gmail.com',7799827270);
insert into users values (7,'Akhil','Shivakumar','Kavuri','2*8d','akhil@gmail.com',9523467911);
insert into users values (8,'Roopitha','Chilukuri','Keerthi','h#v6','anumalamrudula@gmail.com',9633470807);
insert into users values (9,'Kushi','Pallavi','Koganti','g^45','sravanilalitha.lolla@gmail.com',9567924923);
insert into users values (10,'Harsha','Ravinder','Madhav','s03z','madhav@gmail.com',8500213564);

insert into authors values (100,'Vikram Seth');
insert into authors values (101,'Arun Shourie');
insert into authors values (102,'Radhakrishnan');
insert into authors values (103,'Kautilya');
insert into authors values (104,'Naipaul');
insert into authors values (105,'Amrita Pritam');
insert into authors values (106,'Shashi Tharoor');
insert into authors values (107,'Salman Rushdie');
insert into authors values (108,'Vishnu Sharma');
insert into authors values (109,'Prem Chand');

insert into publishers values (200,'Leadstart','t');
insert into publishers values (201,'Young Angels','f');
insert into publishers values (202,'S.Chnad','t');
insert into publishers values (203,'Gyan Books','f');
insert into publishers values (204,'Eklavya','t');
insert into publishers values (205,'Zorba','f');
insert into publishers values (206,'Virtuous','t');
insert into publishers values (207,'Kannadhasan','f');
insert into publishers values (208,'Manitham','t');
insert into publishers values (209,'UBS','f');

delete from publishers;

insert into books values ();
insert into books values ();
insert into books values ();
insert into books values ();
insert into books values ();
insert into books values ();
insert into books values ();
insert into books values ();
insert into books values ();
insert into books values ();