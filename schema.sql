-- Drop existing tables if they exist (for development purposes)
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS discussion;

-- Create the discussion table
CREATE TABLE discussion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for each discussion
    title VARCHAR(255) NOT NULL,           -- Title of the discussion
    content TEXT NOT NULL,                  -- Content of the discussion
    user_id VARCHAR(255) NOT NULL,         -- Identifier for the user who created the discussion
);

-- Create the comment table
CREATE TABLE comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,   -- Unique identifier for each comment
    content TEXT NOT NULL,                  -- Content of the comment
    user_id VARCHAR(255) NOT NULL,         -- Identifier for the user who created the comment
    discussion_id BIGINT,                   -- Foreign key reference to the discussion
    FOREIGN KEY (discussion_id) REFERENCES discussion(id) ON DELETE CASCADE  -- Establishing foreign key relationship
);
