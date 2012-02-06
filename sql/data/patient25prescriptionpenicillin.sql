INSERT INTO OfficeVisits(
	id,
	visitDate,
	HCPID,
	notes,
	HospitalID,
	PatientID
)
VALUES (1235,'2012-01-01',9000000000,'Test office visit','1',25);

INSERT INTO OVMedication (
VisitID,
NDCode,
StartDate,
EndDate,
Dosage,
Instructions) 
VALUES (
1235,
'664662530',
'2012-01-01',
'2012-01-31',
60,
'Take three times daily with food.')