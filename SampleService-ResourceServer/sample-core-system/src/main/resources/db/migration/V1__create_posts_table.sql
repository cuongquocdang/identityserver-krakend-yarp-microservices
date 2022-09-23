-- SCS - Sample Core System
CREATE TABLE scs.posts
(
    id          BIGSERIAL,
    posts_id    VARCHAR(255),
    title       VARCHAR(255),
    body        VARCHAR(255),
    PRIMARY KEY (id)
);