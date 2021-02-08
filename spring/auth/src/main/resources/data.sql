insert into authority values(0, 'customer');
insert into authority values(1,'employee');
insert into authority values(2,'manager');

insert into users values('customer', true, 'customer');
insert into users values('employee', true, 'employee');
insert into users values('manager', true, 'manager');

insert into user_authorities (user_authority_pk, authority_id, username) values(0,0,'customer');

insert into user_authorities  (user_authority_pk, authority_id, username) values(1,0,'employee');
insert into user_authorities  (user_authority_pk, authority_id, username) values(2,1,'employee');

insert into user_authorities  (user_authority_pk, authority_id, username) values(3,0,'manager');
insert into user_authorities  (user_authority_pk, authority_id, username) values(4,1,'manager');
insert into user_authorities  (user_authority_pk, authority_id, username) values(5,2,'manager');