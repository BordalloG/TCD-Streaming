# TCD-Streaming
TDC is the acronym for the final coursework of a subject (from Brazilian Portuguese).  
The main ideia of this project is to study software architecture.   
We have user spring boot with some spring cloud services.   
In this example we are simulating a movie streaming plataform.

Feel free to reach us if you have any question about it.

# Depencencies:
 - Docker
 - Java 
 
# How to run:
First of all, you gonna need Kafka running.  
For this, use the following command:
> docker-compose up -d  

Check [docker-compose file](ttps://github.com/BordalloG/TCD-Streaming/blob/master/docker-compose.yml) for more details.

Then, you can import all projects to your favorite IDE and start them.  

Note: You need to run __Configuration Management Service__ and __Service Discovery__ before running the others.

# Docs:
- [[Postman] Movies Service](https://www.getpostman.com/collections/7317b569324618049e5b)
- [[Postman] HelpDesk Service](https://www.getpostman.com/collections/43742e86aa89bb2de1db)
- [[Postman] User History Service](https://www.getpostman.com/collections/508b145c31e5391b63d4)
- [[Postman] User Service](https://www.getpostman.com/collections/ca9468847cf160f86b7b)  

<em> If you have doubts about importing the docs to your postman check [this link](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/)</em>
