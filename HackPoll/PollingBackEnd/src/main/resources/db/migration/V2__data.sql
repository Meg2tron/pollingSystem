INSERT INTO rating 
            (rating_id,
             rating)
VALUES      (1,1),
             (2,2),
             (3,3),
             (4,4),
             (5,5);
             
INSERT INTO expert(expert_id,ds,algo,java,python,angular)
VALUES      (1,5,5,5,5,5);

INSERT INTO candidate(candidate_id,candidate_name,challanges_solved,candiate_experience_level,expert_in)
VALUES      (1,'Kapil',5,5,1);

INSERT INTO users(user_id,user_name,user_password,user_role)
VALUES      (1,'Kapil','password','CANDIDATE'),
(2,'Kaps','password','ADMIN')
;
