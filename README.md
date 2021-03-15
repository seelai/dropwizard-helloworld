#Introduction
This is a simple hello world Dropwizard application extended with a fibonacci sequence calculation.

# Running the application
* To build the application using Apache Maven from root directory:
     ```
    ./mvnw package
    ```
* To run the application:
    ```
    java -jar target/dropwizard-helloworld-1.0-SNAPSHOT.jar server target/classes/hello-world.yml
    ```
* To test hello world example:  
http://localhost:8080/hello-world?name=stranger

* To test fibonacci calculation example:  
http://localhost:8080/fibonacci-calculation?num=8