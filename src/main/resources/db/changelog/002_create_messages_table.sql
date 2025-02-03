CREATE TABLE messages
(
    id          uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    sender_id   uuid                           NOT NULL,
    receiver_id uuid                           NOT NULL,
    content     varchar                        NOT NULL,
    is_read     boolean          DEFAULT false,
    created_at  timestamptz(0) DEFAULT now(),
    created_by  varchar(50) NULL,
    updated_at  timestamptz(0) NULL,
    updated_by  varchar(50) NULL,
    deleted_at  timestamptz(0)  NULL,
    deleted_by  varchar(50) NULL,
    is_deleted  boolean          DEFAULT false NOT NULL
);