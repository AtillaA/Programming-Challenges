-- Select [hacker_id] and [name] for the final output
SELECT h.hacker_id, h.name
-- Start with Submissions table containing user attempts and scores
FROM Submissions s
-- Link submissions to the Hackers table to retrieve the hacker's name
JOIN Hackers h ON s.hacker_id = h.hacker_id
-- Link submissions to the Challenges table to find which challenge was taken
JOIN Challenges c ON s.challenge_id = c.challenge_id
-- Link challenges to the Difficulty table to find the maximum possible score
JOIN Difficulty d ON c.difficulty_level = d.difficulty_level
-- Filter to keep only submissions where: the user's score matches the maximum score
WHERE s.score = d.score
-- Group rows by individual hacker so we can count their perfect submissions
GROUP BY h.hacker_id, h.name
-- Keep only hackers who achieved a full score on more than one challenge
HAVING COUNT(s.challenge_id) > 1
-- Order by the total number of full scores (highest first), then by hacker ID (lowest first)
ORDER BY COUNT(s.challenge_id) DESC, h.hacker_id ASC;
