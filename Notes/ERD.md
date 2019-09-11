# ERB

## MEMBER TABLE

| MEMBER         |
| -------------- |
| MEMBER_ID (PK) |
| F_NAME         |
| L_NAME         |
| CLUB_ID   (FK) | --------------------------------< | CLUB         |
| ROLES_ID  (FK) | ---------< | ROLES         |      | ------------ |
                              | ------------- |      | CLUB_ID (PK) |
| ROLES_ID | ROLE    | >----- | ROLES_ID (PK) |      | CLUB_NAME    |
| -------- | ------- |                               | TIME         |
| 0        | STUDENT |                               | LOCATION     |
| 1        | FACULTY |
| 2        | OFFICER |
