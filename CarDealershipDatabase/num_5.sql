SELECT
	*
FROM
	cardealershipdatabase.dealerships D
JOIN
	cardealershipdatabase.vehicles V
    ON V.Dealership_id = D.Dealership_id
WHERE
	V.Type = 'Sedan';