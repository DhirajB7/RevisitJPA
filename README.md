# SB-JPA
- acts as template+ reference + cheats
- JAVA + SPRINGBOOT + PSSQL are used
-------
## Project - revisitJpaBasics
- Basic CRUD.
- Nothing much from Springboot side.
---
## Project - revisitJpaBasicOneToOne
- Implimentation of OneToOne.
- Unidirectional & bidirectional.
- only required endpoints are present.
- User & Address [Entity,Repo,Controller,service] are for unidirectional one to one mapping.
- User & Address [Entity,Repo,Controller,service] are for bidirectional one to one mapping.
- Understand comments in Address Class.
---
## Project - revisitJpaBasicOneToMany
- Implimentation of OneToMany.
- Smilar to OneToOne unidirectional, but @joinColumn has 2 params.
- Insted of Entity List Of Entity is refered.
- In table placement of Forgin Key is in "many" entities' table's row. [ I know it was not easy to read ]  
- User & Address [Entity,Repo,Controller,service] are for one to many mapping.
----

