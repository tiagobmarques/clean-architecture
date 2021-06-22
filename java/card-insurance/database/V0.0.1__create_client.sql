
------------------------------------------------------------------
-- Create client table
------------------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'client') THEN
      create table client (
        client_id UUID DEFAULT gen_random_uuid(),
        code INTEGER NOT NULL,
        name VARCHAR(200) NOT NULL,
        PRIMARY KEY (client_id)
      );
      comment on column client.client_id is 'Inner guid of client';
      comment on column client.code is	'Client`s code';
      comment on column client.name is 'Client`s name';
      RAISE INFO 'Added client table';
    ELSE
      RAISE INFO 'client table already added';
    END IF;
  END
$$;