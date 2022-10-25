SELECT ai.ANIMAL_ID, ai.NAME
FROM ANIMAL_INS as ai, ANIMAL_OUTS as aout
WHERE ai.ANIMAL_ID = aout.ANIMAL_ID and ai.DATETIME > aout.DATETIME
order by ai.DATETIME;