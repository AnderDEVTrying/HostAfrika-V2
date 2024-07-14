CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE reviews(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id UUID,
    listing_id UUID,
    rating INTEGER NOT NULL,
    comment TEXT,
    create_stamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ,
    FOREIGN KEY(listing_id) REFERENCES listings(id) ON DELETE CASCADE
);