### 1. Create db with properties from  src/main/resources/application.properties
### 2. In src/main/resources/application.properties change 
#### spring.jpa.hibernate.ddl-auto=validate -> spring.jpa.hibernate.ddl-auto=create
### 3. Start KanapkaApplication
### 4. In src/main/resources/application.properties change
#### spring.jpa.hibernate.ddl-auto=create -> spring.jpa.hibernate.ddl-auto=validate
### 5. Ensure that hibernate created all tables 
###     (guests, rooms, room_types, dishes, dish_types, order, dish_order, reservation)
### 6. Import data to tables from src/main/resources/data/import.sql