-- SET IDENTITY_INSERT employee ON;
-- insert into employee(id, name, contact_number, office)
-- values(1001, 'Employee1', '1111', 'Office1');
-- insert into employee(id, name, contact_number, office)
-- values(1002, 'Employee2', '2222', 'Office2');
-- insert into employee(id, name, contact_number, office)
-- values(1003, 'Employee3', '3333', 'Office3');
-- SET IDENTITY_INSERT employee OFF;

insert into employee(name, contact_number, office) values('Employee1', '1111', 'Office1');
insert into employee(name, contact_number, office) values('Employee2', '2222', 'Office2');
insert into employee(name, contact_number, office) values('Employee3', '3333', 'Office3');

-- Country
insert into country(code, name) values('us', 'United States');
insert into country(code, name) values('cn', 'China');
insert into country(code, name) values('vn', 'Vietnam');

-- Customer
insert into customer(country_id, name, email) values(3, 'customer 1', 'email 1');
insert into customer(country_id, name, email) values(2, 'customer 2', 'email 2');
insert into customer(country_id, name, email) values(1, 'customer 3', 'email 3');

