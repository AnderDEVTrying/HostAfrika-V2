CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE messages(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    sender_id UUID,
    receiver_id UUID,
    content TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY(sender_id) REFERENCES users(id) ,
    FOREIGN KEY(receiver_id) REFERENCES users(id)
);