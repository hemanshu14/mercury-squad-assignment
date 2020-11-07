# mercury-squad-assignment

A coding challenge consisting of a spring boot application, a front end UI and stub server provided by wire mock running with Dockerfile. The application will give you the ability to fetch either the details of all the users or serach the user details with the provided first name and last name. The REST APIs are built with Spring Boot, Front end is built with vue.js and Wiremock stub is used to mock the APIs and Docker is used to run the wiremock stub.

# Project setup

First clone the code by using the below mentioned command:

git clone https://github.com/hemanshu14/mercury-squad-assignment.git

cd user-management

# Run the following commands to build and run the wiremock stub image with Docker:
# To build the docker image: 
docker build -t wiremock-stub wire-mock
# To run the wiremock stub server:         
docker run -it --rm -p 8080:8080 wiremock-stub

Then run the spring boot application and hit the url: http://localhost:9001/usermanagement.html
