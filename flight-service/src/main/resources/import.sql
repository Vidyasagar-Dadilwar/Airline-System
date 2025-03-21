INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price) VALUES (1, 'AA100', 'Delhi', 'Chennai', 200, 100, 5000);
INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price) VALUES (2, 'AA200', 'Mumbai', 'Kolkata', 100, 20, 3250);
INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price) VALUES (3, 'AA300', 'Nagpur', 'Mumbai', 200, 150, 4500);
INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price) VALUES (4, 'AA400', 'Kolkata', 'Nagpur', 100, 50, 7050);
INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price) VALUES (5, 'AA500', 'Chennai', 'Delhi', 200, 100, 9000);

ALTER TABLE FLIGHTS ALTER COLUMN id RESTART WITH 6;

-- Insert sample flight schedules
INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status) VALUES (1, 1, '2025-03-15T08:30:00', '2025-03-16T05:30:00', 'SCHEDULED');
INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status) VALUES (2, 1, '2025-03-16T01:00:00', '2025-03-16T06:30:00', 'SCHEDULED');
INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status) VALUES (3, 2, '2025-03-15T11:30:00', '2025-03-16T02:00:00', 'SCHEDULED');
INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status) VALUES (4, 2, '2025-02-16T07:00:00', '2025-02-16T10:30:00', 'SCHEDULED');
INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status) VALUES (5, 3, '2025-02-15T04:30:00', '2025-02-15T06:00:00', 'SCHEDULED');
INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status) VALUES (6, 4, '2025-03-16T03:00:00', '2025-05-17T11:30:00', 'SCHEDULED');
INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status) VALUES (7, 5, '2025-03-17T06:30:00', '2025-05-18T06:30:00', 'SCHEDULED');

ALTER TABLE FLIGHT_SCHEDULES ALTER COLUMN id RESTART WITH 6;