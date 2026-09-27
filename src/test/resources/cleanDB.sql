delete from run;
delete from user;

INSERT INTO `user`
VALUES (1, 'Kyle', 'Miller', 'kmiller'),
       (2, 'Test', 'Runner', 'trunner');

INSERT INTO `run`
VALUES (1, '2026-09-20', 5.0, 2250, 'Morning run', 1),
       (2, '2026-09-22', 3.1, 1440, 'Easy run', 1),
       (3, '2026-09-24', 6.0, 2700, 'Evening run', 2);