DROP TABLE IF EXISTS books;

CREATE TABLE books (
                           id LONG AUTO_INCREMENT  PRIMARY KEY,
                           title VARCHAR(100) NOT NULL,
                           description TEXT ,
                           available BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO books (title, description, available) VALUES
                                                                  ('GINA', 'laurentgina@mail.com', true),
                                                                  ('FONCEK', 'sophiefoncek@mail.com', false),
                                                                  ('Agathe', 'FEELING', false);