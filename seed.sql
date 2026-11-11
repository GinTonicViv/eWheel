--Vehicles
INSERT INTO `Vehicle`
(`uuid`, `name`, `licence_plate`, `category`, `is_active`,
 `kilometers`, `last_stk`, `next_oil_change_kilometers`, `next_oil_change_date`)
VALUES
    (UNHEX(REPLACE('0b854872-23c8-4838-929a-081211132f46', '-', '')),
     'Škoda Octavia', 'PO123AB', 'OSO', TRUE, 84250.5, '2025-09-15', 90000.0, '2026-12-01'),
    (UNHEX(REPLACE('3ea89cd4-0026-4ed1-ba7b-9e4592aa828b', '-', '')),
     'VW Transporter', 'PO456CD', 'NAK', TRUE, 152300.0, '2026-02-10', 160000.0, '2027-01-15'),
    (UNHEX(REPLACE('fd5ca77f-2a06-4de3-bba6-ad38a47e53c2', '-', '')),
     'Ford Focus', 'KE789EF', 'OSO', TRUE, 61400.2, '2026-05-20', 70000.0, '2027-03-10'),
    (UNHEX(REPLACE('137ebde3-9881-4cc8-b17b-96cc5e222df3', '-', '')),
     'Renault Master', 'PO321GH', 'DOD', FALSE, 198750.8, '2025-03-01', 200000.0, '2026-08-30'),
    (UNHEX(REPLACE('5af12545-d079-43c3-90c2-bea0634b8b88', '-', '')),
     'Toyota Corolla', 'BA654IJ', 'OSO', TRUE, 23100.0, '2026-07-12', 30000.0, '2027-06-01');