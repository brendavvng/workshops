SELECT 
	D.Name as Dealership_Name,
    V.VIN,
    V.Make,
    V.Model
FROM 
	cardealershipdatabase.vehicles V
JOIN
	cardealershipdatabase.dealerships D
    ON V.Dealership_id = D.Dealership_id
WHERE
	VIN = 'ABL35K2N6V';