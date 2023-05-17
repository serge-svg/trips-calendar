CREATE TABLE IF NOT EXISTS Trips (
    id INTEGER AUTO_INCREMENT,
    description varchar(255) NOT NULL,
    status VARCHAR(25) NOT NULL,
    trip_type VARCHAR(25) NOT NULL,
    distance INT NULL,
    price FLOAT NULL,
    start_date TIMESTAMP NULL,
    end_date TIMESTAMP NULL,
    URL VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

INSERT INTO Trips (description, status, trip_type, distance, price, start_date, end_date, URL) VALUES ('Trip to the beach', 'COMPLETED', 'WORK', 100, 100.00, NULL, NULL, NULL);
INSERT INTO Trips (description, status, trip_type, distance, price, start_date, end_date, URL) VALUES ('Trip to the mountains', 'COMPLETED', 'WORK', 200, 200.00, NULL, NULL, NULL);
INSERT INTO Trips (description, status, trip_type, distance, price, start_date, end_date, URL) VALUES ('Trip to the forest', 'COMPLETED', 'WORK', 300, 300.00, NULL, NULL, NULL);