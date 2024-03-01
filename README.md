To build and run, we will need Docker, Docker-compose and Java17 installed as a prerequisite. <br />
If the prerequisites are met, do the following, <br />
1. Using a terminal navigate into the project folder and run ```./gradlew clean build``` to build the project.
2. Run the command ```docker-compose up --build```. This will download the required docker images including MySQL server and the application will be up in a few seconds.
3. Once the application is up, you can test the APIs at **localhost:8080**

## API examples
You can use the following curl queries as reference for APIs <br />

### View all items (admin)
```
curl --location 'localhost:8080/admin/view-all'
```
### View available items (user)
```
curl --location 'localhost:8080/user/available-items'
```
### Add item (admin)
```
curl --location 'localhost:8080/admin/add' \
--header 'Content-Type: application/json' \
--data '{
    "name": "corn",
    "price": 438,
    "quantity": 1
}'
```
### Delete item (admin)
```
curl --location --request DELETE 'localhost:8080/admin/delete-item/{{id}}'
```
### Update item (admin)
```
curl --location --request PUT 'localhost:8080/admin/update-item/{{id}}' \
--header 'Content-Type: application/json' \
--data '{
    "name": "wheat",
    "price": 490
}'
```
### Update stock (admin)
```
curl --location --request PUT 'localhost:8080/admin/update-stock/{{id}}' \
--header 'Content-Type: application/json' \
--data '{
    "operation": "sale",
    "quantity": 2
}'
```
### Book items (user)
```
curl --location --request PUT 'localhost:8080/user/book' \
--header 'Content-Type: application/json' \
--data '[
    {
        "id": 1,
        "quantity": 2
    },
    {
        "id": 52,
        "quantity": 1
    }
]'
```
