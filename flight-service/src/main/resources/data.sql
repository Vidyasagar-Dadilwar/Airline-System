INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price)
VALUES (1, 'AA100', 'Mumbai', 'Pune', 200, 150, 550.00);

INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price)
VALUES (2, 'AA101', 'Pune', 'Banglore', 180, 120, 320.00);

INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price)
VALUES (3, 'AA102', 'Banglore', 'Kolkata', 220, 180, 400.00);

INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price)
VALUES (4, 'AA103', 'Delhi', 'Mumbai', 350, 250, 700.00);

INSERT INTO FLIGHTS (id, flight_number, origin, destination, capacity, available_seats, price)
VALUES (5, 'AA104', 'Kolkata', 'Delhi', 300, 200, 600.00);

-- Insert sample flight schedules
INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status)
VALUES (1, 1, '2025-03-11T11:00:00', '2025-03-15T15:00:00', 'SCHEDULED');

INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status)
VALUES (2, 1, '2025-03-12T10:00:00', '2025-03-16T21:30:00', 'SCHEDULED');

INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status)
VALUES (3, 2, '2025-03-13T23:00:00', '2025-03-15T22:00:00', 'SCHEDULED');

INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status)
VALUES (4, 2, '2025-03-14T10:00:00', '2025-03-16T10:00:00', 'SCHEDULED');

INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status)
VALUES (5, 3, '2025-03-13T10:00:00', '2025-03-15T11:30:00', 'SCHEDULED');

INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status)
VALUES (6, 4, '2025-03-14T23:00:00', '2025-03-17T23:00:00', 'SCHEDULED');

INSERT INTO FLIGHT_SCHEDULES (id, flight_id, departure_time, arrival_time, status)
VALUES (7, 5, '2025-05-17T18:00:00', '2025-03-18T23:30:00', 'SCHEDULED');