-- Select the wand details required for the final output
SELECT w.id, wp.age, w.coins_needed, w.power
-- Start with the Wands table containing prices and power
FROM Wands w
-- Link to Wands_Property using the code column to get age and evil status
JOIN Wands_Property wp ON w.code = wp.code
-- Filter out evil wands and ensure we only get the minimum price for each age/power combination
WHERE wp.is_evil = 0 
  AND w.coins_needed = (
      -- Subquery to find the absolute cheapest cost for the current wand's exact age and power
      SELECT MIN(w2.coins_needed)
      FROM Wands w2
      JOIN Wands_Property wp2 ON w2.code = wp2.code
      WHERE wp2.is_evil = 0 
        AND wp2.age = wp.age 
        AND w2.power = w.power
  )
-- Sort the final list by power (highest first), then by age (oldest first)
ORDER BY w.power DESC, wp.age DESC;
