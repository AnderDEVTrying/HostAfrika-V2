CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE listings(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id UUID,
    title VARCHAR(30) NOT NULL,
    description TEXT,
    country VARCHAR(25) NOT NULL,
    region VARCHAR(50) NOT NULL,
    address TEXT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    create_stamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);