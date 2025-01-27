CREATE TABLE users
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) NULL,
    password   varchar     NOT NULL,
    email      varchar(50) NOT NULL,
    created_at timestamptz(0) DEFAULT now(),
    created_by varchar(50) NULL,
    updated_at timestamptz(0) NULL,
    updated_by varchar(50) NULL,
    deleted_at timestamptz(0)  NULL,
    deleted_by varchar(50) NULL,
    is_deleted boolean          DEFAULT false
);