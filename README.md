# spring-rest-jlheidemann

spring-rest-jlheidemann is an example of an web application that uses Spring MVC to create Restful Webservices and Angular for user interface.

This application has the following functionalities:

- Create/Update/Delete/List Companies
- Add Owner to Company 

The application can be acessed from this [website][appSite] and the source code from this [GitHub Repository][git-repo-url]

### Version
0.0.1-SNAPSHOT

### cURL Examples
Create Company
```sh
curl -H "Content-Type: application/json" -X POST -d "{\"name\":\"Company1\",\"address\":\"Address1\",\"city\":\"City1\",\"country\":\"Country1\",\"email\":\"email@email.com\",\"phoneNumber\":\"1234567890\"}" http://spring-rest-jlheidemann.herokuapp.com/api/companyservice/companies
```

Get Company
```sh
curl http://spring-rest-jlheidemann.herokuapp.com/api/companyservice/companies/1
```
Get All Companies
```sh
curl http://spring-rest-jlheidemann.herokuapp.com/api/companyservice/companies
```
Edit Company
```sh
curl -H "Content-Type: application/json" -X PUT -d "{\"name\":\"Company2\",\"address\":\"Address2\",\"city\":\"City2\",\"country\":\"Country2\",\"email\":\"email2@email.com\",\"phoneNumber\":\"0123456789\"}" http://spring-rest-jlheidemann.herokuapp.com/api/companyservice/companies/1
```
Add Owner to Company
```sh
curl -X POST http://spring-rest-jlheidemann.herokuapp.com/api/companyservice/companies/1/Owner1
```
Delete Company
```sh
curl -X DELETE http://spring-rest-jlheidemann.herokuapp.com/api/companyservice/companies/1
```

### Considerations
**Redundance**

We can make the server redundancy adding more servers, working with clusters for example. This application example does not have a database, but having multiple servers reading the same databse would be easy to have redundancy.

**Authentication**

Authentication can be made through the Oauth API.
Oauth is an excellent and very safe API for authentication, which can be used in web applications, desktop and mobile devices.


[appSite]: <https://spring-rest-jlheidemann.herokuapp.com>
[git-repo-url]: <https://github.com/jeanleno/SpringRestService.git>
