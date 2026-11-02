INSERT INTO workspaces (space_name, space_type, hourly_rate, is_active) VALUES
                                                                            ('Desk-A10', 'HOT_DESK', 150.00, TRUE),
                                                                            ('Desk-A11', 'HOT_DESK', 150.00, TRUE),
                                                                            ('DedDesk-B01', 'DEDICATED_DESK', 250.00, TRUE),
                                                                            ('Boardroom-1', 'MEETING_ROOM', 800.00, TRUE),
                                                                            ('ExecCabin-C1', 'CABIN', 500.00, TRUE);

INSERT INTO users (full_name, email, wallet_balance) VALUES
                                                         ('Aarav Sharma', 'aarav@example.com', 2000.00),
                                                         ('Priya Nair', 'priya@example.com', 1500.00),
                                                         ('Rohan Verma', 'rohan@example.com', 100.00);

INSERT INTO bookings (user_id, space_id, booking_date, slot_hour, total_cost, booking_status) VALUES
                                                                                                  (1, 1, '2026-11-10', 9, 150.00, 'CONFIRMED'),
                                                                                                  (2, 4, '2026-11-10', 10, 800.00, 'CONFIRMED'),
                                                                                                  (1, 5, '2026-11-11', 14, 500.00, 'CONFIRMED');