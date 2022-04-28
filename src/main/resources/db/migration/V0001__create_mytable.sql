create table if not exists currency (
    id UUID primary key,
    name varchar,
    code varchar,
    createdAt timeStamp
);