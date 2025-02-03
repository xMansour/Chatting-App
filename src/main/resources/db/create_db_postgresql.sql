CREATE ROLE chattingappuser WITH LOGIN SUPERUSER CONNECTION LIMIT -1 PASSWORD 'Ch@ttingAppPassw0rd';
CREATE DATABASE chattingapp WITH  OWNER = chattingappuser ENCODING = 'UTF8' CONNECTION LIMIT = -1;
GRANT ALL ON DATABASE chattingapp TO chattingappuser;
GRANT ALL ON SCHEMA public TO chattingappuser;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
