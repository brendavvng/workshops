SELECT 
    v.VIN,
    v.Make,
    v.Model,
    v.Year,
    v.Price,
    v.Mileage,
    v.Type,
    v.Sold,
    d.Name AS Dealership_Name,
    d.Address,
    d.Phone
FROM 
    cardealershipdatabase.vehicles v
JOIN 
    cardealershipdatabase.dealerships d
    ON v.Dealership_id = d.Dealership_id
WHERE 
    v.Dealership_id = 8;