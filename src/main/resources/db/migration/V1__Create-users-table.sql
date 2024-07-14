
CREATE TABLE users (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(40) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    Phone_number VARCHAR(25),
    birth_date DATE NOT NULL,
    role Varchar NOT NULL,
    create_stamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);