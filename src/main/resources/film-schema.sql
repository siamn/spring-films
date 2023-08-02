drop table if exists film CASCADE;
create table film (id integer generated by default as identity, genre varchar(25), title varchar(255), release_year integer check (release_year>=1920 AND release_year<=2025), primary key (id));