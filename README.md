**Sales Management API**


**Products Management**


1. Fetch Products: GET http://localhost:8080/sales-management-api/products
2. Create new product: POST http://localhost:8080/sales-management-api/products
3. Update existing product: PUT http://localhost:8080/sales-management-api/products/1


**Clients Management**


1. Fetch clients: GET http://localhost:8080/sales-management-api/clients
2. Create new client: POST http://localhost:8080/sales-management-api/clients
3. Update existing client: PUT http://localhost:8080/sales-management-api/clients


**Sales**


1. Fetch all sales operations: GET http://localhost:8080/sales-management-api/sales
2. Create new sales with multiple transactions : POST http://localhost:8080/sales-management-api/sales
3. Edit quantities and prices of the sale: PUT http://localhost:8080/sales-management-api/sales/transaction/{saleTransactionId}


**UML Diagram:**

![image](https://github.com/ReemGharib/sales-api/assets/53252416/57fe2b47-01b4-4b9b-9948-81de7450ec2b)


