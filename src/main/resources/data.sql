-- Script de inserção de dados

INSERT INTO `papeis` (`nome`) VALUES ('USUARIO');
INSERT INTO `papeis` (`nome`) VALUES ('CRIADOR');
INSERT INTO `papeis` (`nome`) VALUES ('EDITOR');
INSERT INTO `papeis` (`nome`) VALUES ('ADMIN');

INSERT INTO `usuarios` (`email`, `senha`) VALUES ('mercurio@teste.com', '$2a$10$wSa39/yk/UTovsqPt817X.c0I8xlS2s76YQy4ViDxag0mlxUoYUq2');
INSERT INTO `usuarios` (`email`, `senha`) VALUES ('venus@teste.com', '$2a$10$v8Wr0mf6HgmIG0ANimKJOuOIt/09qIkXIF7wCwzq8.U/LTqTs9ovq');
INSERT INTO `usuarios` (`email`, `senha`) VALUES ('terra@teste.com', '$2a$10$SXuWtufjZVvmMFpc56HMEObBhX/vov8UJxUBeZX3RoEnOIR0yqdH6');
INSERT INTO `usuarios` (`email`, `senha`) VALUES ('marte@teste.com', '$2a$10$Wl1gojjJgFhXztvHIULT3e0hiEMrDbCWCys0p6LnfrqxcxYkgh9OW');
INSERT INTO `usuarios` (`email`, `senha`) VALUES ('jupiter@teste.com', '$2a$10$5sci59bfdcED4XxxuN9gx.SJBPsdNknirJSkLbTCouf2mFzLmX/Gi');

INSERT INTO `usuarios_papeis` (`usuario_id`, `papel_id`) VALUES (1, 1); -- usuário mercurio tem papel USUARIO
INSERT INTO `usuarios_papeis` (`usuario_id`, `papel_id`) VALUES (2, 2); -- usuário venus tem papel CRIADOR
INSERT INTO `usuarios_papeis` (`usuario_id`, `papel_id`) VALUES (3, 3); -- usuário terra tem papel EDITOR
INSERT INTO `usuarios_papeis` (`usuario_id`, `papel_id`) VALUES (4, 2); -- usuário marte tem papel CRIADOR
INSERT INTO `usuarios_papeis` (`usuario_id`, `papel_id`) VALUES (4, 3); -- usuário marte tem papel EDITOR
INSERT INTO `usuarios_papeis` (`usuario_id`, `papel_id`) VALUES (5, 4); -- usuário jupiter tem papel ADMIN