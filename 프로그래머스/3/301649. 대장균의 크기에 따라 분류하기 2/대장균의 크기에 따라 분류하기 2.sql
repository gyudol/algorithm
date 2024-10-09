-- 코드를 작성해주세요
SELECT ID, 
    CASE 
        WHEN COLONY_RANK = 1 THEN 'CRITICAL'
        WHEN COLONY_RANK = 2 THEN 'HIGH'
        WHEN COLONY_RANK = 3 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM (SELECT ID, NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS COLONY_RANK
      FROM ECOLI_DATA
     ) ECOLI_RANK
ORDER BY ID;