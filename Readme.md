##Database Configuration

~~~
  make sure database connection. database name, username and password

  datasource:
    url: jdbc:postgresql://localhost:5432/dans_test
    username: postgres
    password: 1234
~~~
##Running
~~~
    execute mvn spring-boot:run 
~~~

##Note
~~~
    for second running application on local delete file data.sql on resource.
    data.sql only for automatic generated table for first time.
~~~