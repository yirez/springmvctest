A basic test app using

Spring Rest, JPA, AOP, Security, MVC

DB used: Postgres


Using spring-usr user, springapp as schema

Scripts to run

    CREATE TABLE springapp.alien (
    	id numeric NULL,
    	"name" varchar NULL
    );
    INSERT INTO springapp.alien
    (id, "name")
    VALUES(1, 'test1');
    INSERT INTO springapp.alien
    (id, "name")
    VALUES(2, 'test2');
    INSERT INTO springapp.alien
    (id, "name")
    VALUES(12, 'heey2');
    INSERT INTO springapp.alien
    (id, "name")
    VALUES(44, 'this is new');
    INSERT INTO springapp.alien
    (id, "name")
    VALUES(5, 'test5');
    INSERT INTO springapp.alien
    (id, "name")
    VALUES(6, 'test6');
    INSERT INTO springapp.alien
    (id, "name")
    VALUES(0, NULL);
    INSERT INTO springapp.alien
    (id, "name")
    VALUES(7, 'test7');





    CREATE TABLE springapp."user" (
    id numeric NULL,
    username varchar NULL,
    "password" varchar NULL
    );
    INSERT INTO springapp."user"
    (id, username, "password")
    VALUES(1, 'test1', '123');
    INSERT INTO springapp."user"
    (id, username, "password")
    VALUES(2, 'test2', '123');
    INSERT INTO springapp."user"
    (id, username, "password")
    VALUES(3, 'test3', '$2a$10$GwCrHmwBv9Tae9mvDCTeXuLjl6UO.0gQo.svUZczolE3.IkSn2psi');
    INSERT INTO springapp."user"
    (id, username, "password")
    VALUES(4, 'test4', '$2a$10$GwCrHmwBv9Tae9mvDCTeXuLjl6UO.0gQo.svUZczolE3.IkSn2psi');