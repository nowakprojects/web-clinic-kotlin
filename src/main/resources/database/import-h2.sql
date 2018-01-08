
INSERT INTO address VALUES
  (1, '2016-01-01', NULL, 'Wrocław', 'Polska', '20', 'Radosna', '51-123'),
  (2, '2016-01-01', NULL, 'Wrocław', 'Polska', '11/3', 'Mickiewicza', '51-222');

INSERT INTO user
VALUES (1, '2017-08-27', NULL, FALSE, NULL, '1996-08-23', 'kontakt.mateusznowak@gmail.com', 'Mateusz',
           '$2a$10$3eWtzQGWcvNeZWNx3TYVAezxdOvbWPWP/2sIYjWrw9F21GBbZknD2', 'Nowak', FALSE, '122122122', 1),
  (2, '2017-08-28', NULL, FALSE, NULL, '1923-02-12', 'test1@testowy.com', 'Test1',
      '$2a$10$3eWtzQGWcvNeZWNx3TYVAezxdOvbWPWP/2sIYjWrw9F21GBbZknD2', 'Testowy', FALSE, '123123123', 1),
  (3, '2017-08-31', NULL, FALSE, NULL, '1934-11-11', 'test2@testowy.com', 'Test2',
      '$2a$10$3eWtzQGWcvNeZWNx3TYVAezxdOvbWPWP/2sIYjWrw9F21GBbZknD2', 'Testowy', FALSE, '223123123', 1),
  (4, '2017-09-01', NULL, FALSE, NULL, '1994-01-02', 'test3@testowy.com', 'Test3',
      '$2a$10$3eWtzQGWcvNeZWNx3TYVAezxdOvbWPWP/2sIYjWrw9F21GBbZknD2', 'Testowy', FALSE, '323123123', 2),
  (5, '2017-07-11', NULL, FALSE, NULL, '2006-05-12', 'rejestrator1@testowy.com', 'Rejestrator1',
      '$2a$10$3eWtzQGWcvNeZWNx3TYVAezxdOvbWPWP/2sIYjWrw9F21GBbZknD2', 'Testowy', FALSE, '423123123', 2),
  (6, '2016-01-12', NULL, FALSE, NULL, '1966-05-12', 'lekarz1@testowy.com', 'Lekarz1',
      '$2a$10$3eWtzQGWcvNeZWNx3TYVAezxdOvbWPWP/2sIYjWrw9F21GBbZknD2', 'Testowy', FALSE, '444111333', 2),
  (7, '2017-09-01', NULL, FALSE, NULL, '1994-01-02', 'pacjent1@testowy.com', 'Pacjent',
      '$2a$10$3eWtzQGWcvNeZWNx3TYVAezxdOvbWPWP/2sIYjWrw9F21GBbZknD2', 'Testowy', FALSE, '343123123', 2),
  (8, '2017-09-01', NULL, FALSE, NULL, '1944-01-02', 'jan@testowy.com', 'Jan',
      '$2a$10$3eWtzQGWcvNeZWNx3TYVAezxdOvbWPWP/2sIYjWrw9F21GBbZknD2', 'Testowy', FALSE, '543123123', 2);


INSERT INTO employment
VALUES (1, '2017-01-01', NULL, '2018-12-31', 'DOCTOR', 5599, '2018-01-01', 'FULL_TIME', 6),
  (2, '2017-01-01', NULL, '2018-12-31', 'REGISTRAR', 2399, '2018-01-01', 'FULL_TIME', 5);


INSERT INTO doctor
VALUES ('123123', 1);

INSERT INTO registrar
VALUES (2);

INSERT INTO patient_card VALUES
  (1, '2017-01-01', NULL, FALSE, NULL, 2, 2),
  (2, '2017-01-01', NULL, FALSE, NULL, 2, 3),
  (3, '2017-01-01', NULL, FALSE, NULL, 2, 4),
  (4, '2017-01-01', NULL, FALSE, NULL, 2, 7),
  (5, '2017-01-01', NULL, FALSE, NULL, 2, 8);

INSERT INTO medical_visit VALUES
  (1, '2018-01-01', NULL, FALSE, NULL, FALSE, NULL, CURRENT_DATE, DATEADD('HOUR', 1, CURRENT_TIME), NULL, 1, 1),
  (2, '2018-01-01', NULL, FALSE, NULL, FALSE, NULL, CURRENT_DATE, DATEADD('HOUR', 2, CURRENT_TIME), NULL, 1, 2),
  (3, '2018-01-01', NULL, FALSE, NULL, FALSE, NULL, CURRENT_DATE, DATEADD('HOUR', 3, CURRENT_TIME), NULL, 1, 3),
  (4, '2018-01-01', NULL, FALSE, NULL, FALSE, NULL, CURRENT_DATE, DATEADD('HOUR', 4, CURRENT_TIME), NULL, 1, 4),
  (5, '2018-01-01', NULL, FALSE, NULL, FALSE, NULL, CURRENT_DATE, DATEADD('HOUR', 5, CURRENT_TIME), NULL, 1, 5);
