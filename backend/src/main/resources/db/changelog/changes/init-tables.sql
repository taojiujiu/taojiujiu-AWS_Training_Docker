CREATE TABLE account(
	id serial PRIMARY KEY,
	name VARCHAR (50) UNIQUE NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE tracker_type(
	id serial PRIMARY KEY,
	name VARCHAR (50) NOT NULL,
	x_name VARCHAR (50) UNIQUE NOT NULL,
    y_name VARCHAR (50) UNIQUE NOT NULL
);

CREATE TABLE public.tracker_detail(
	id serial PRIMARY KEY,
	account_id integer NOT NULL,
	tracker_type_id integer NOT NULL,
    CONSTRAINT account_tracker_detail_id_fkey FOREIGN KEY (account_id)
      REFERENCES account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT tracker_type_tracker_detail_id_fkey FOREIGN KEY (tracker_type_id)
      REFERENCES tracker_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
    x_value VARCHAR (50) UNIQUE NOT NULL,
    y_value VARCHAR (50) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
