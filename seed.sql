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

-- 1) Používatelia (heslo je len zástupný text, nie skutočný hash)
INSERT INTO `User`
(`uuid`, `email`, `name`, `last_name`, `role`, `password`, `is_active`, `birthdate`, `driving_licence`, `created_at`)
VALUES
    (UNHEX(REPLACE('e6c80cbb-dffc-433c-9837-15f1b981c007','-','')),
     'jan.novak@ewheel.sk', 'Ján', 'Novák', 'ADMIN', 'test-heslo', TRUE, '1985-04-12', 'SK123456', NOW()),
    (UNHEX(REPLACE('6146921e-d87d-419f-a9da-5352a4a6229d','-','')),
     'eva.kovacova@ewheel.sk', 'Eva', 'Kováčová', 'EMPLOYEE', 'test-heslo', TRUE, '1992-09-30', 'SK654321', NOW());

-- 2) Adresy
INSERT INTO `Address` (`uuid`, `street`, `Number`, `City`, `zip`, `region`)
VALUES
    (UNHEX(REPLACE('01809dec-9733-4665-8893-25656a89309d','-','')), 'Hlavná', '12', 'Prešov', '08001', 'PO'),
    (UNHEX(REPLACE('b141e241-cceb-4b31-a697-578cd5b0bc5b','-','')), 'Hviezdoslavovo námestie', '5', 'Bratislava', '81102', 'BA'),
    (UNHEX(REPLACE('1634fb7c-38dc-4114-810c-72f6a5c13b14','-','')), 'Hlavná', '30', 'Košice', '04001', 'KE'),
    (UNHEX(REPLACE('d33199e6-b23f-4e08-8591-70d89822de3d','-','')), 'Námestie slobody', '2', 'Žilina', '01001', 'ZA');

-- 3) Výjazdy
INSERT INTO `Business_Trip`
(`uuid`, `reason`, `note`, `status`, `vehicle_id`, `user_id`,
 `start_date`, `end_date`, `start_address`, `destination_address`)
VALUES
    (UNHEX(REPLACE('9c28f8fb-a925-4c01-90ca-295ebfcce546','-','')), 'business_trip', 'Porada na centrále', 'approved',
     UNHEX(REPLACE('0b854872-23c8-4838-929a-081211132f46','-','')), UNHEX(REPLACE('e6c80cbb-dffc-433c-9837-15f1b981c007','-','')),
     '2026-11-03 07:30:00', '2026-11-03 18:00:00',
     UNHEX(REPLACE('01809dec-9733-4665-8893-25656a89309d','-','')), UNHEX(REPLACE('b141e241-cceb-4b31-a697-578cd5b0bc5b','-',''))),

    (UNHEX(REPLACE('a9dda5d4-30dc-4af5-b041-2e06f5dec457','-','')), 'client_visit', 'Návšteva klienta', 'approved',
     UNHEX(REPLACE('fd5ca77f-2a06-4de3-bba6-ad38a47e53c2','-','')), UNHEX(REPLACE('6146921e-d87d-419f-a9da-5352a4a6229d','-','')),
     '2026-11-05 08:00:00', '2026-11-05 16:30:00',
     UNHEX(REPLACE('01809dec-9733-4665-8893-25656a89309d','-','')), UNHEX(REPLACE('1634fb7c-38dc-4114-810c-72f6a5c13b14','-',''))),

    (UNHEX(REPLACE('39879832-ff1b-4b46-a3b0-05cdf7e6b4f9','-','')), 'transport_of_goods', 'Prevoz materiálu', 'approved',
     UNHEX(REPLACE('3ea89cd4-0026-4ed1-ba7b-9e4592aa828b','-','')), UNHEX(REPLACE('6146921e-d87d-419f-a9da-5352a4a6229d','-','')),
     '2026-11-07 06:00:00', '2026-11-07 14:00:00',
     UNHEX(REPLACE('1634fb7c-38dc-4114-810c-72f6a5c13b14','-','')), UNHEX(REPLACE('d33199e6-b23f-4e08-8591-70d89822de3d','-',''))),

    (UNHEX(REPLACE('840f092e-cc0c-4818-a439-ce4acba077f9','-','')), 'training', 'Školenie zamestnancov', 'pending',
     UNHEX(REPLACE('5af12545-d079-43c3-90c2-bea0634b8b88','-','')), UNHEX(REPLACE('e6c80cbb-dffc-433c-9837-15f1b981c007','-','')),
     '2026-11-14 08:00:00', '2026-11-15 17:00:00',
     UNHEX(REPLACE('01809dec-9733-4665-8893-25656a89309d','-','')), UNHEX(REPLACE('d33199e6-b23f-4e08-8591-70d89822de3d','-',''))),

    (UNHEX(REPLACE('b0c3122c-89fc-4690-9206-e2977e6c9f93','-','')), 'on_site_work', 'Montáž na mieste', 'denied',
     UNHEX(REPLACE('0b854872-23c8-4838-929a-081211132f46','-','')), UNHEX(REPLACE('6146921e-d87d-419f-a9da-5352a4a6229d','-','')),
     '2026-11-10 09:00:00', '2026-11-10 15:00:00',
     UNHEX(REPLACE('b141e241-cceb-4b31-a697-578cd5b0bc5b','-','')), UNHEX(REPLACE('1634fb7c-38dc-4114-810c-72f6a5c13b14','-',''))),

    (UNHEX(REPLACE('570e9c7b-d920-4b47-a232-a2589e2c3fe8','-','')), 'service_maintenance', NULL, 'pending',
     UNHEX(REPLACE('3ea89cd4-0026-4ed1-ba7b-9e4592aa828b','-','')), UNHEX(REPLACE('e6c80cbb-dffc-433c-9837-15f1b981c007','-','')),
     '2026-11-18 07:00:00', '2026-11-18 12:00:00',
     UNHEX(REPLACE('01809dec-9733-4665-8893-25656a89309d','-','')), UNHEX(REPLACE('01809dec-9733-4665-8893-25656a89309d','-','')));