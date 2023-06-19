Tables will created once the application is started. Use below Insert statement to insert the data to table.

INSERT INTO sim_details VALUES('1', '987654321', '987654321234', 'active');
INSERT INTO sim_details VALUES('2', '1234567892', '987654321235', 'inactive');

INSERT INTO sim_offers VALUES('1', '100', '100', '120', '10', 'Free calls and data', '1');
INSERT INTO sim_offers VALUES('2', '150', '50', '100', '15', 'Free calls', '2');

INSERT INTO customer_address VALUES('1', 'Jayanagar', 'Bangalore', '560041', 'Karnataka');
INSERT INTO customer_address VALUES('2', 'Vijaynagar', 'Mysore', '567017', 'Karnataka');

INSERT INTO customer VALUES('987654321234567', '1990-12-12', 'smith@abc.com', 'Smith', 'John', 'Aadhar', '1', '1', 'Karnataka');
INSERT INTO customer VALUES('987654321234568', '1998-12-12', 'bob@abc.com', 'Bob', 'Sam', 'Aadhar', '2', '2', 'Karnataka');

INSERT INTO customer_identity VALUES('987654321234567', '1990-12-12', 'Smith', 'John', 'smith@abc.com', 'Karnataka');
INSERT INTO customer_identity VALUES('987654321234568', '1998-12-12', 'Bob', 'Sam', 'bob@abc.com', 'Karnataka');