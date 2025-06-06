SELECT 
    SC.*,
    D.Name AS Dealership_Name
FROM 
    cardealershipdatabase.sales_contracts SC
JOIN 
    vehicles V ON SC.VIN = V.VIN
JOIN 
    dealerships D ON V.Dealership_id = D.Dealership_id
WHERE 
    V.Dealership_id = 3
    AND SC.Sales_Date BETWEEN '2024-01-01' AND '2024-12-31';