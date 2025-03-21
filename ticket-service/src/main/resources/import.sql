INSERT INTO TICKETS (id, user_id, flight_id, flight_schedule_id, passenger_name, seat_number, price, status, booking_time) VALUES (1, 1, 1, 1, 'Vidyasagar Dadilwar', 'A01', 550, 'BOOKED', '2025-03-10T14:30:00');
INSERT INTO TICKETS (id, user_id, flight_id, flight_schedule_id, passenger_name, seat_number, price, status, booking_time) VALUES (2, 2, 1, 1, 'Aditya Pande', 'B01', 850, 'BOOKED', '2025-03-10T15:45:00');
INSERT INTO TICKETS (id, user_id, flight_id, flight_schedule_id, passenger_name, seat_number, price, status, booking_time) VALUES (3, 3, 2, 3, 'Piyush Vyas', 'C01', 500, 'BOOKED', '2025-03-11T09:15:00');
INSERT INTO TICKETS (id, user_id, flight_id, flight_schedule_id, passenger_name, seat_number, price, status, booking_time) VALUES (4, 4, 3, 5, 'Manan Maheshwari', 'D01', 450, 'BOOKED', '2025-03-12T11:20:00');
-- Insert a cancelled ticket
INSERT INTO TICKETS (id, user_id, flight_id, flight_schedule_id, passenger_name, seat_number, price, status, booking_time) VALUES (5, 5, 4, 6, 'Apeksha Jamjar', 'E01', 850, 'CANCELLED', '2025-03-12T16:40:00');
ALTER TABLE TICKETS ALTER COLUMN id RESTART WITH 6;