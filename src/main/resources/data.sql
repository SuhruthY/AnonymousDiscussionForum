INSERT INTO discussion (title, content, user_id) VALUES
('First Discussion', 'This is the first discussion content.', 'user1'),
('Second Discussion', 'This is the second discussion content.', 'user2');

INSERT INTO comment (content, user_id, discussion_id) VALUES
('This is a comment on the first discussion.', 'user2', 1),
('This is another comment on the first discussion.', 'user1', 1),
('This is a comment on the second discussion.', 'user1', 2);
