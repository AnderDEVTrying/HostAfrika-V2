CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE reservations(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id UUID,
    listing_id UUID,
    from_date DATE NOT NULL,
    to_date DATE NOT NULL,
    total_price DECIMAL(10,2)  NOT NULL,
    status INTEGER NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY(listing_id) REFERENCES listings(id) ON DELETE CASCADE
);