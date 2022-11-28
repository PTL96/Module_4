insert into blog.category(id, name)
values (1, 'Tiểu thuyết'),
       (2, 'Sách'),
       (3, 'Tự do');
insert into blog.blog(id, author, content, star_day, title, category_id)
values (1, 'Lê Huy', 'Chia tay người yêu', '2020-12-12', 'Người yêu cũ', 1),
       (2, 'Lê Huy', 'Người yêu cũ có người yêu mới', '2020-12-12', 'Người yêu', 2),
       (3, 'Lê Huy', 'accca', '2020-01-12', 'Người yêu cũ', 1),
       (4, 'Lê Huy', 'Chia tay người yêu', '2020-12-12', 'Người', 3);

