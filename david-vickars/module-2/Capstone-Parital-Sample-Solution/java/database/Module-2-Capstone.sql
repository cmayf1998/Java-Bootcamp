SELECT p.name, p.location, c.name, c.daily_fee
FROM park p
JOIN campground c ON p.park_id = c.park_id
ORDER BY p.name;

SELECT * FROM site
JOIN campground ON site.campground_id = 1
WHERE site.campground_id = 1    
AND site.site_id NOT IN (
        SELECT s.site_id FROM site s
        JOIN reservation r ON s.site_id = r.site_id
        WHERE s.campground_id = 1  
        AND 
        (
                '2020-07-01' > r.from_date AND '2020-07-01' < r.to_date    -- REQUESTED fromDate AND fromDate
                OR
                '2020-09-30' > r.from_date AND '2020-09-30' < r.to_date     -- REQUESTED toDate AND toDate
        )   
        OR 
        (
                r.from_date BETWEEN '2020-07-01' AND '2020-09-30'     -- REQUESTED fromDate AND toDate
                AND 
                r.to_date BETWEEN '2020-07-01' AND '2020-09-30'         -- REQUESTED fromDate AND toDate 
        ) 
);