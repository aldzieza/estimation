CREATE TABLE IF NOT EXISTS supplier;
INSERT INTO supplier(id, classification,id_sap, name,total_score)
VALUES
(1, 'A','23456765','PPG',100),
(2, 'B','23456765','Ravago',99),
(3, 'C','23456765','Poch',93),
(4, 'A','23456765','PGNIG',100)
;
CREATE TABLE IF NOT EXISTS componentpsapt;
INSERT INTO componentpsapt(id, approval, audit_result, average_score, certificate,
collaboration, customer, delivery_deley, id_sap, interference, location, ppm, prima_plant, pscr, sap_name, sap_number, supplier )
VALUES
(1, 100, '100', 97, 98, '100', 'REX', '99', '19283434','99','92',99,'PSCPS','100', 'srubka z gwintem','12345667','Powerrager')
;

