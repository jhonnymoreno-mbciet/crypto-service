CREATE TABLE IF NOT EXISTS currency(
    id SERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    code VARCHAR(80) NOT NULL,
	createdAt TIMESTAMP
);

INSERT INTO currency(name, code, createdAt) VALUES('Bitcoin', 'BTC', current_timestamp);
INSERT INTO currency(name, code, createdAt) VALUES('Ethereum', 'ETH', current_timestamp);
INSERT INTO currency(name, code, createdAt) VALUES('Tether', 'USDT', current_timestamp);
INSERT INTO currency(name, code, createdAt) VALUES('USD Coin', 'USDC', current_timestamp);
INSERT INTO currency(name, code, createdAt) VALUES('SOLANA', 'SOL', current_timestamp);