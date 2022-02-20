/* write your SQL and answers */
/* Execution of various SQL commands based on Autism dataset: */

/*     How many middle eastern children show ASD traits ? */
/* Answer: 96 */
SELECT COUNT(Case_No) FROM autism WHERE "Ethnicity" == "middle eastern" AND "Class/ASDTraits" == "Yes";

/*     How many children who have Jaundice show ASD traits ? */
/* Answer: 215 */
SELECT  COUNT(Case_No) FROM autism WHERE "Jaundice" == "yes" AND "Class/ASDTraits" == "Yes";

/*     Are ASD traits dependent on hereditary ? Justify . */

/* Answer: Using simple probability, I would conclude that ASD traits is NOT dependent on hereditary 
Justification: Assuming the dataset is representative of the population, 
the background probability of occurance of ASD offspring is 0.69 and NonASD offspring is 0.31 in any given population.
The probability of a ASD parents having a ASD offspring is 0.67 and nonASD offspring is 0.32, which is lower than the wild-type population.
Given that the probability of ASD parents having ASD offspring is lower than a wild-type population, I conclude that the data DO NOT support the 
conclusion that ASD traits is hereditary.
*/
SELECT (SELECT COUNT(Case_No)  * 1.0 / (SELECT COUNT(Case_No) FROM autism WHERE Family_mem_with_ASD == "yes")
FROM autism WHERE Family_mem_with_ASD == "yes" 
AND "Class/ASDTraits" == "Yes") 
AS "Occurance of ASD among ASD parents", 
(SELECT COUNT(Case_No)  * 1.0 / (SELECT COUNT(Case_No) FROM autism  WHERE Family_mem_with_ASD == "yes") 
FROM autism WHERE Family_mem_with_ASD == "yes" 
AND "Class/ASDTraits" == "No")
AS "Occurance of NonASD among ASD parents",
(SELECT COUNT(Case_No)  * 1.0 / (SELECT COUNT(Case_No) FROM autism WHERE Family_mem_with_ASD == "no" ) 
FROM autism WHERE Family_mem_with_ASD == "no" 
AND "Class/ASDTraits" == "Yes")
AS "Occurance of ASD among non ASD parents",
(SELECT COUNT(Case_No)  * 1.0 / (SELECT COUNT(Case_No) FROM autism WHERE Family_mem_with_ASD == "no" ) 
FROM autism WHERE Family_mem_with_ASD == "no" 
AND "Class/ASDTraits" == "No")
AS "Occurance of NonASD among non ASD parents",
(SELECT COUNT(Case_No)  * 1.0 / (SELECT COUNT(Case_No) FROM autism)
FROM autism 
WHERE "Class/ASDTraits" == "Yes")
AS "Occurance of ASD offspring in sample population",
(SELECT COUNT(Case_No)  * 1.0 / (SELECT COUNT(Case_No) FROM autism) 
FROM autism 
WHERE "Class/ASDTraits" == "No")
AS "Occurance of NonASD offspring in sample population";

/*     People of which ethnicity are most likely to exhibit ASD traits ? */
/*  Answer: White European, with the probablity at approx 0.24 */
SELECT Ethnicity, Count(Case_No) * 1.0 / (SELECT COUNT(Case_No) FROM autism) as "Probability"
FROM autism
WHERE "Class/ASDTraits" == "Yes"
GROUP BY Ethnicity
ORDER BY Probability DESC;

/*     What is the proportion of a white European girls (female) exhibit ASD traits among all white European girls? */
/*  Answer:
    White European Female ASD : White European Female
                         0.69 : 1
*/

SELECT COUNT(Case_No) * 1.0 / (SELECT COUNT(Case_No) FROM autism WHERE Ethnicity == "White European" AND Sex == "f") 
AS "No. of White European ASD Female per White European Female"
FROM autism
WHERE Ethnicity == "White European" 
AND Sex == "f" 
AND "Class/ASDTraits" == "Yes";
