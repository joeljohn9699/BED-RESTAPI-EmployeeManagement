-- Insert these values into Database to login using spring security.

insert into role values (1, "Admin");

insert into user values (1, "$2a$12$LYmX.ae5BAisRF1VD0HKluvHeBCLrDUKaXjurXWlRO7atP4nCB7k2", "admin");
--password for admin --> admin

insert into user_roles values (1,1);
