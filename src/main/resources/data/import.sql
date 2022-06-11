insert into user_role(id, role) values ('1', 'ROLE_ADMIN');
insert into user_role(id, role) values ('2', 'ROLE_USER');

INSERT INTO dish_types(id, type) VALUES ('1', 'lunch');
INSERT INTO dish_types(id, type) VALUES ('2', 'soup');
INSERT INTO dish_types(id, type) VALUES ('3', 'snack');
INSERT INTO dish_types(id, type) VALUES ('4', 'pizza');
INSERT INTO dish_types(id, type) VALUES ('5', 'salad');
INSERT INTO dish_types(id, type) VALUES ('6', 'dessert');
INSERT INTO dish_types(id, type) VALUES ('7', 'drink');

INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('1', 'Котлета з яловичини, рукола,  сир Ементаль, салат Коул Слоу, соус барбекю та авторський.', 'kanapka1.png', 'Хайповий Джо', '130', '310', '3', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('2', 'Котлета з  яловичини, багато сиру Ементаль, Трюфельна паста, грибне соте, сирний соус, свіжий огірок.', 'kanapka2.png', 'Грибний фантазер', '180', '360', '3', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('3', 'Яловичина, подвійний чедер, цибуля синя маринована, салат айсберг, солені огірки, амер. гірчиця, соус BBQ та фірмовий.', 'kanapka3.png', 'Той самий чіз', '140', '300', '3', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('4', 'Котлета з яловичини, багато хрусткого бекону та сиру Моцарела, свіжі томати, соус з огірками, маринована цибуля.', 'kanapka4.png', 'Дикий, дикий фарш', '170', '390', '3', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('5', 'Подвійна котлета, багато сиру Дор Блю, сир Моцарела, сир Ементаль, в''ялені томати, яблучне чатні, сирний соус з пармезаном.', 'kanapka5.png', 'Сирний амнямнямчик', '200', '410', '3', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('6', 'Велика яловича котлета фарширована Моцарелою, багато бекону, потрійний сир Чеддер, маринована цибуля,соус авторський.', 'kanapka6.png', 'Фаршинатор', '190', '420', '3', 'true');

INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('8', 'Листя салату "Айсберг", куряча грудинка, сир Пармезан, маслинова олія.', 'Salad1.png', 'Цезар', '120', '200', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('9', 'Томати, сир моцарела і соус "Песто".', 'Salad2.png', 'Капрезе', '150', '200', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('10', 'Помідори, огірки, перець болгарський, маслини, лук, салат, сир Фета, олія оливкова майонезна заправка.', 'Salad3.png', 'Грецький', '85 ', '200', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('11', 'Філе куряче, чорнослив, шампіньйони, лук, яйця, горіхи, огірки, зелень, майонез.', 'Salad4.png', 'Чорна курка', '90', '200', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('12', 'Філе оселедця, картопля, буряк, морква, лук, майонез.', 'Salad5.png', 'Оселедець під шубою', '75', '200', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('13', 'Язик телячий, помідор, огірок, перець, сир, майонез.', 'Salad1.png', 'Пікантний', '105', '200', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('14', 'Куряча грудинка, солоний огірок, свіжі шампіньйони, майонез.', 'Salad2.png', 'Віндзорський', '85', '200', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('15', 'Куряча грудка маринована та приправлена 24 години, щодня свіжа на грилі.', 'Salad3.png', 'Салат з курячим філе', '120', '300', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('16', 'Нарізані кальмари в клярі, приправлені та обсмажені у фритюрі.', 'Salad4.png', 'Салат зі смаженими кальмарами', '200', '300', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('17', 'Філе лосося приправляють і маринують 24 години, а потім готують щодня свіжим на грилі.', 'Salad5.png', 'Салат з лососем на грилі', '200', '300', '5', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('18', 'Шашлик із маринованими креветками щодня готується на грилі.', 'Salad1.png', 'Салат з креветками на грилі', '250', '300', '5', 'true');

INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('19', '5 шматочків курячої грудки маринують і приправляють 24 години, обсмажені на шампурі.', 'lunch1.png', 'Курячі шашлички', '230', '350', '1', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('20', 'Філе лосося приправляють і маринують 24 години, а потім готують щодня свіжим на грилі.', 'lunch2.png', 'Філе лосося на грилі', '380', '400', '1', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('21', 'Відбита куряча грудка панірована і смажена.', 'lunch3.png', 'Шніцель з курки', '230', '350', '1', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('22', 'Запечена в духовці чверть курячих гомілок, заправлена нашим маринадом власного виробництва.', 'lunch4.png', 'Смажена куряча ніжка', '330', '400', '1', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('23', 'Приправлена і повільно смажена бараняча рулька.', 'lunch5.png', 'Смажена баранина', '330', '400', '1', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('24', 'Шашлик із маринованими креветками щодня готується на грилі.', 'lunch6.png', 'Креветки на грилі', '300', '300', '1', 'true');

INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('25', 'Український борщ в горщику.', 'soup1.png', 'Український борщ', '120', '250', '2', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('26', 'Курячий бульйон з фрикадельками, млинцями-спагетті і перепелиними яйцями.', 'soup2.png', 'Курячий бульйон ', '110', '300', '2', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('27', 'Крем-суп сирний з беконом в горщику.', 'soup3.png', 'Крем-суп сирний з беконом в горщику', '150', '250', '2', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('28', 'Крем-суп з лосося.', 'soup4.png', 'Крем-суп з лосося', '170', '250', '2', 'true');

INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('29', 'Cулугуні копчений, горгонзола,моцарелла, пармезан, сирний соус, журавлина, грецькі горіхи, гострий мед, базилік.', 'pizza1.png', 'Чотири сиру', '190', '550', '4', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('30', 'Ковбаса салямі, болгарский перець, рукола, оливки каламата, моцарелла, соус із томатів пелаті, соус песто, пармезан.', 'pizza2.png', 'Салямі', '180', '550', '4', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('31', 'Ковбаса салямі, болгарский перець, рукола, оливки каламата, моцарелла, соус із томатів пелаті, соус песто, пармезан.', 'pizza3.png', 'Маргарита', '140', '550', '4', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('32', 'Свинина, курка, болгарский перець, соус барбекю, моцарелла, гриби,базилік, соус песто.', 'pizza4.png', 'Барбекю', '190', '600', '4', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('33', 'Курка копчена, рукола, сирний соус, моцарелла, гриби, помідори, соус песто.', 'pizza5.png', 'Бьянка', '190', '600', '4', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('34', 'Слабосолоний лосось, міні-креветки, помідори, моцарелла, каперси, сирний соус, сир філадельфія.', 'pizza6.png', 'Філадельфія ', '290', '750', '4', 'true');

INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('35', 'Ніжний вершковий сир на основі печива з полуничним соусом.', 'dessert1.png', 'Львівський сирник', '54', '150', '6', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('36', 'Листкове тісто з заварним кремом та полуничним або карамельним соусом на вибір.', 'dessert2.png', 'Наполеон', '52', '130', '6', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('37', 'Оксамитовий бісквіт з малиновим чизкейком та крем-чізом.', 'dessert3.png', 'Червоний оксамит', '57', '150', '6', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('38', 'Торт з білково-мигдалевих коржів, ванільного крему та мигдалевих пластівців.', 'dessert4.png', 'Мигдалевий бумцик', '57', '120', '6', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('39', 'Ванільний мус з начинкою з манго-маракуйя в глазурі Гурме на молочному шоколаді.', 'dessert5.png', 'Десерт "Сніжний з манго та маракуйя"', '45', '90', '6', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('40', 'Ванільний мус з начинкою із чорної смородини в глазурі Гурме на чорному шоколаді.', 'dessert6.png', 'Десерт "Сніжний з чорною смородиною"', '45', '90', '6', 'true');

INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('41', 'Мінеральна вода газована.', 'drink1.png', 'Вода Боржомі', '50', '500', '7', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('42', 'Мінеральна негазована.', 'drink2.png', 'Вода Моршинська Преміум', '30', '330', '7', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('43', 'Солодка газована вода.', 'drink3.png', '7up', '30', '500', '7', 'true');
INSERT INTO dishes(id, description, image_path, name, price, weight, dish_type_id, active) VALUES ('44', 'Фруктовий сік.', 'drink4.png', 'Сік Сандора', '60', '950', '7', 'true');

INSERT INTO guests(id, address, email, first_name, second_name, role_id, phone) VALUES ('1', 'м.Харків вул.Академіка Вальтера 14', 'vitalik@gmail.com', 'Віталій', 'Бондаренко', '2', '0995678499');
INSERT INTO guests(id, address, email, first_name, second_name, role_id, phone) VALUES ('2', 'м.Харків вул.Академіка Вальтера 15', 'kolomiets23@gmail.com', 'Наталія', 'Коломіець', '2', '0667894567');
INSERT INTO guests(id, address, email, first_name, second_name, role_id, phone) VALUES ('3', 'м.Харків вул.Академіка Вальтера 16', '', 'Владислав', 'Цвіркун', '2', '0678900099');
INSERT INTO guests(id, address, email, first_name, second_name, role_id, phone) VALUES ('4', 'м.Харків вул.Академіка Вальтера 17', '12122@gmail.com', 'Ольга', 'Рибак', '2', '0667894564');
INSERT INTO guests(id, address, email, first_name, second_name, role_id, phone) VALUES ('5', 'м.Харків вул.Академіка Вальтера 18', 'dvdw425@gmail.com', 'Василь', 'Стус', '2', '0998761122');
INSERT INTO guests(id, address, email, first_name, second_name, role_id, phone) VALUES ('6', 'м.Харків вул.Академіка Вальтера 18', 'admin@gmail.com', 'admin', 'admin', '1', '0998761121');

INSERT INTO room_types(id, type) VALUES ('1', 'Економ');
INSERT INTO room_types(id, type) VALUES ('2', 'Стандарт');
INSERT INTO room_types(id, type) VALUES ('3', 'Люкс');
INSERT INTO room_types(id, type) VALUES ('4', 'Напів-люкс');
INSERT INTO room_types(id, type) VALUES ('5', 'Президентський');

INSERT INTO rooms(id, capacity, presentation_name, price_per_night, room_number, room_type_id) VALUES ('1', '2', 'Чудовий номер стандарт для закоханих', '1200', '101', '2');
INSERT INTO rooms(id, capacity, presentation_name, price_per_night, room_number, room_type_id) VALUES ('2', '3', 'Чудовий номер стандарт для трьох', '1800', '102', '2');
INSERT INTO rooms(id, capacity, presentation_name, price_per_night, room_number, room_type_id) VALUES ('3', '1', 'Чудовий номер люкс для одного', '1100', '103', '3');
INSERT INTO rooms(id, capacity, presentation_name, price_per_night, room_number, room_type_id) VALUES ('4', '2', 'Чудовий номер люкс для двох', '1700', '104', '3');
INSERT INTO rooms(id, capacity, presentation_name, price_per_night, room_number, room_type_id) VALUES ('5', '3', 'Чудовий номер стандарт для двух дорослих і дитини', '2100', '105', '3');

INSERT INTO reservation(id, reservation_cancelled, reservation_code, reservation_from,reservation_to, guest_id, room_id) VALUES ('1', 'false', '123456', '2022-06-02 00:00:00.000000', '2022-07-05 00:00:00.000000', 1, 1);
INSERT INTO reservation(id, reservation_cancelled, reservation_code, reservation_from, reservation_to, guest_id, room_id) VALUES ('2', 'false', '111222', '2022-05-05 00:00:00.000000', '2022-06-02 00:00:00.000000', 2, 2);
INSERT INTO reservation(id, reservation_cancelled, reservation_code, reservation_from, reservation_to, guest_id, room_id) VALUES ('3', 'false', '111333', '2022-01-01 00:00:00.000000', '2022-01-08 00:00:00.000000', 3, 3);
INSERT INTO reservation(id, reservation_cancelled, reservation_code, reservation_from, reservation_to, guest_id, room_id) VALUES ('4', 'false', '111444', '2022-06-05 00:00:00.000000', '2022-08-05 00:00:00.000000', 4, 4);

INSERT INTO orders(id,  code, cancelled, confirmed, contact_number, done, expected_at, ordered_at, urgent, reservation_id, bill) VALUES ('1', '678945', 'false', 'true', '0995678499', 'true', '2022-06-02 18:00:00.000000', '2022-06-02 13:00:00.000000', 'false', '1', '310');
INSERT INTO orders(id,  code, cancelled, confirmed, contact_number, done, expected_at, ordered_at, urgent, reservation_id, bill) VALUES ('2', '097336', 'false', 'true', '0995678499', 'true', '2022-06-02 20:00:00.000000', '2022-06-02 19:00:00.000000', 'false', '1', '310');
INSERT INTO orders(id,  code, cancelled, confirmed, contact_number, done, expected_at, ordered_at, urgent, reservation_id, bill) VALUES ('3', '889965', 'true', 'true', '0667894567', 'true', '2022-08-02 20:00:00.000000', '2022-08-02 19:00:00.000000', 'true', '2', '210');
INSERT INTO orders(id,  code, cancelled, confirmed, contact_number, done, expected_at, ordered_at, urgent, reservation_id, bill) VALUES ('4', '343356', 'true', 'true', '0667894567', 'true', '2022-08-02 21:00:00.000000', '2022-08-02 20:00:00.000000', 'true', '2', '200');
INSERT INTO orders(id,  code, cancelled, confirmed, contact_number, done, expected_at, ordered_at, urgent, reservation_id, bill) VALUES ('5', '121122', 'false', 'true', '0678900099', 'true', '2022-05-28 14:00:00.000000', '2022-05-27 12:00:00.000000', 'false', '3', '750');
INSERT INTO orders(id,  code, cancelled, confirmed, contact_number, done, expected_at, ordered_at, urgent, reservation_id, bill) VALUES ('6', '233466', 'false', 'true', '0678900099', 'true', '2022-05-28 15:00:00.000000', '2022-05-30 14:00:00.000000', 'true', '3', '57');
INSERT INTO orders(id,  code, cancelled, confirmed, contact_number, done, expected_at, ordered_at, urgent, reservation_id, bill) VALUES ('7', '234221', 'false', 'true', '0995678499', 'true', '2022-05-28 14:30:00.000000', '2022-05-28 15:30:00.000000', 'true', '1', '90');
INSERT INTO orders(id,  code, cancelled, confirmed, contact_number, done, expected_at, ordered_at, urgent, reservation_id, bill) VALUES ('8', '111221', 'false', 'true', '0995678499', 'true', '2022-05-26 16:45:00.000000', '2022-05-26 18:00:00.000000', 'false', '1', '45');

insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('1', '1', '1', '1');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('2', '1', '2', '1');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('3', '2', '3', '2');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('4', '1', '4', '2');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('5', '2', '13', '3');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('6', '1', '17', '4');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('7', '3', '18', '5');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('8', '1', '38', '6');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('9', '2', '39', '7');
insert into dish_order(id, dish_count, dish_id, order_id) VALUES ('10', '1', '40', '8');
