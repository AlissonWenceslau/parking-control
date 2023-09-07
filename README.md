
# Parking Control

Nesse projeto foi construído uma API com o objetivo de controlar o estacionamento de um condomínio. Nela foi implementada operações de CRUD, bem como a regra de negócio que consiste em:

- Cada apartamento pode ter apenas uma vaga registrada no banco.
- Cada carro pode possuir apenas um registro no banco
- O número da vaga não pode se repetir no banco

## Tecnologias
- Springboot MVC
- Spring Validation
- Spring Data JPA
- Spring Security
- Postgres SQL

```SQL
SELECT * FROM tb_user;
SELECT * FROM tb_role;
SELECT * FROM tb_users_roles;
SELECT * FROM tb_parking_spot;

INSERT INTO tb_user (user_id, username, password) VALUES ('bfb4adb7-c3ba-4642-b0ce-c08f3b7cb9f2','maria','$2a$10$dw3Ag8e/LvVietgcYnjm9.bJSjrjUOi60KbHyLo0J4R2TjrckbG1O');
INSERT INTO tb_user (user_id, username, password) VALUES ('964c127e-4d5e-11ee-be56-0242ac120002','joao','$2a$10$dw3Ag8e/LvVietgcYnjm9.bJSjrjUOi60KbHyLo0J4R2TjrckbG1O');
INSERT INTO tb_user (user_id, username, password) VALUES ('bc3f1eae-4d5e-11ee-be56-0242ac120002','marcio','$2a$10$dw3Ag8e/LvVietgcYnjm9.bJSjrjUOi60KbHyLo0J4R2TjrckbG1O');

INSERT INTO tb_role VALUES (gen_random_uuid(),'ROLE_ADMIN');
INSERT INTO tb_role VALUES (gen_random_uuid(),'ROLE_USER');

INSERT INTO tb_users_roles VALUES ('bfb4adb7-c3ba-4642-b0ce-c08f3b7cb9f2', '913247a8-c980-4029-a056-c96c24a0dd73');
INSERT INTO tb_users_roles VALUES ('964c127e-4d5e-11ee-be56-0242ac120002', '8a85acc3-43a0-4c50-aa0c-28ca123afc7d');
```

### Configuração postgres
- DB: parking-control-db
- PASS: 1234567