INSERT INTO OfficeVisits(
	id,
	visitDate,
	HCPID,
	notes,
	HospitalID,
	PatientID
)
VALUES (1234,'2012-02-01',9000000000,'Test office visit','1',25);

INSERT INTO OVMedication (
VisitID,
NDCode,
StartDate,
EndDate,
Dosage,
Instructions) 
VALUES (
1234,
'00882219',
'2012-02-01',
'2012-08-01',
100,
'Take once daily.')