
------------------------------------------------------------------
-- Create card table
------------------------------------------------------------------
DO
$$
  BEGIN
    IF NOT EXISTS(SELECT 1 FROM pg_tables WHERE tablename = 'card') THEN
      create table card (
        card_id UUID DEFAULT gen_random_uuid(),
        number VARCHAR(200) NOT NULL,
        type VARCHAR(200) NOT NULL,
        name_on_card VARCHAR(200) NOT NULL,
        expiration_date DATE NOT NULL,
        security_code VARCHAR(10) NOT NULL,
        PRIMARY KEY (card_id)
      );
      comment on column card.card_id is 'Inner guid of card';
      comment on column card.number is 'Card`s number';
      comment on column card.type is 'Card`s type';
      comment on column card.name_on_card is 'Name on card';
      comment on column card.expiration_date is 'Expiration date';
      comment on column card.security_code is 'Security code';
      RAISE INFO 'Added card table';
    ELSE
      RAISE INFO 'card table already added';
    END IF;
  END
$$;