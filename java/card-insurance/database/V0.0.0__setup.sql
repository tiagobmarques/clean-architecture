--------------------------------------------------------
--  Create healthcheck table
--------------------------------------------------------
CREATE TABLE public.healthcheck (
	healthcheck_id int4 NULL
);

insert into public.healthcheck
values (1);

--------------------------------------------------------
--  Create generate uuid function
--------------------------------------------------------
CREATE EXTENSION IF NOT EXISTS "pgcrypto";