create database db1;

use db1;

CREATE TABLE registration (
  regId INT PRIMARY KEY,
  name VARCHAR(255),
  datetime DATETIME,
  status VARCHAR(255)
);



INSERT INTO registration (regId, name, datetime, status)
VALUES (1, 'John Doe', '2023-02-11 12:00:00', 'registered');

INSERT INTO registration (regId, name, datetime, status)
VALUES (2, 'Jane Doe', '2023-02-11 13:00:00', 'pending');

INSERT INTO registration (regId, name, datetime, status)
VALUES (3, 'Bob Smith', '2023-02-11 14:00:00', 'confirmed');

INSERT INTO registration (regId, name, datetime, status)
VALUES (4, 'bhaiyya', '2023-02-11 12:00:00', 'registered');





############################################################


create database db2;

use db2;

CREATE TABLE hf_dms (
  id INT PRIMARY KEY,
  status VARCHAR(255)
);

INSERT INTO hf_dms VALUES (1, 'registered');

INSERT INTO hf_dms VALUES (11, 'pending');

INSERT INTO hf_dms VALUES (22, 'confirmed');

INSERT INTO hf_dms VALUES (4, 'registered');