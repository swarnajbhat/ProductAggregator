# ProductAggregator

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores
across the east coast. myRetail wants to make its internal data available to any number
of client devices, from myRetail.com to native mobile apps. This is  an end-to-end Proof-of-Concept for a products API,
which will aggregate product data from Product Repository and Pricing Information from Pricing Rpository and return it as a single JSON to the
caller.

Database: MongoDb - downaloadable here - https://www.mongodb.com/try/download/community
Database Tools - Compass 
SpringBoot version - 2.7.0

Running Port - 5005

Microservice pattern used - aggreagtor

Running Instructions: 

a. make sure you are running Product Details and Product Pricing services: 
https://github.com/swarnajbhat/ProductPricing

https://github.com/swarnajbhat/ProductDetails

b. git clone this repository and import it to eclipse or any IDE

c. run as mvn spring boot
