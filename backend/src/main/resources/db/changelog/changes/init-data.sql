INSERT INTO public.account (name)
VALUES
	('test_user');

INSERT INTO  public.tracker_type (name,x_name,y_name)
VALUES
	('Wake Up', 'Time', 'Day');

INSERT INTO public.tracker_detail (account_id,tracker_type_id,x_value,y_value)
VALUES
	(1,1,'2020-05-01','8:30'),
	(1,1,'2020-05-02','9:00'),
	(1,1,'2020-05-03','10:00'),
	(1,1,'2020-05-04','9:30');
