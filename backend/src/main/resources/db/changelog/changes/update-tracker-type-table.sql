ALTER TABLE public.tracker_type
    ADD COLUMN 	account_id integer NOT NULL default 1;

ALTER TABLE public.tracker_type
    ADD CONSTRAINT account_tracker_detail_id_fkey FOREIGN KEY (account_id)
      REFERENCES account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
