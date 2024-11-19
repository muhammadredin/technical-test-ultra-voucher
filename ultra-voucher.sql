CREATE TABLE parent
(
    id        int primary key,
    name      varchar(100),
    parent_id int,
    CONSTRAINT fk_parent
        FOREIGN KEY (parent_id) REFERENCES parent (id)
);

INSERT INTO parent (id, name, parent_id)
VALUES (1, 'Zaki', 2),
       (2, 'Ilham', NULL),
       (3, 'Irwan', 2),
       (4, 'Arka', 3);

SELECT p1.id,
       p1.name    name,
       p2.name AS parent_name
FROM parent p1
         LEFT JOIN parent p2
                   ON p1.parent_id = p2.id;


