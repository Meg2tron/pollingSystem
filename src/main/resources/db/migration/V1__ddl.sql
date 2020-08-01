

CREATE TABLE users
  (
     user_id    bigint AUTO_INCREMENT NOT NULL,
     user_name       VARCHAR(255) UNIQUE,
     user_password       VARCHAR(255),
     user_role 			VARCHAR(255),
     PRIMARY KEY (user_id)
  );

CREATE table rating(
	rating_id bigint AUTO_INCREMENT NOT NULL,
	rating bigint,
	PRIMARY KEY (rating_id)
);
  
CREATE TABLE expert
  (
     expert_id    bigint AUTO_INCREMENT NOT NULL,
     ds       bigint,
     algo       bigint,
     java 			bigint,
     python        bigint,
     angular       bigint,
     PRIMARY KEY (expert_id),
     FOREIGN KEY (ds) REFERENCES rating(rating_id),
     FOREIGN KEY (algo) REFERENCES rating(rating_id),
     FOREIGN KEY (java) REFERENCES rating(rating_id),
     FOREIGN KEY (python) REFERENCES rating(rating_id),
     FOREIGN KEY (angular) REFERENCES rating(rating_id)
  );
  
CREATE TABLE candidate(
	candidate_id bigint AUTO_INCREMENT NOT NULL,
	candidate_name   VARCHAR(255),
	challanges_solved int,
	candiate_experience_level bigint,
	expert_in bigint,
	PRIMARY KEY (candidate_id),
    FOREIGN KEY (candiate_experience_level) REFERENCES rating(rating_id),
    FOREIGN KEY (expert_in) REFERENCES expert(expert_id)
);

CREATE TABLE voters(
	ip_add VARCHAR(200) NOT NULL,
	voted_to bigint NOT NULL,
	PRIMARY KEY (ip_add),
    FOREIGN KEY (voted_to) REFERENCES candidate(candidate_id)
);