# Docker container operations by docker compose
Source:       
Introduction to Docker Compose: https://www.baeldung.com/ops/docker-compose

## Requirements
### Install Docker Desktop for Window
Source: https://docs.docker.com/desktop/install/windows-install/

### Run docker-demon
Run Docker Desktop for Window for it

## Build the app's docker image
### Check the app building
``
mvn clean install
``

### Create the following files in classpath: 
docker-compose.yaml in order to run group of containers; 

Dockerfile - to build docker containers for app  

### Build and run the containers in classpath
``
docker-compose up
``

Result:                      
``
PS D:\projects\examples\spring\job-tasks\kameleoon> docker-compose up
[+] Running 2/2
- Network kameleoon_default          Created                                                                                                                                                             0.6s
- Container kameleoon-app-compose-1  Created                                                                                                                                                             1.9s
  Attaching to kameleoon-app-compose-1
  kameleoon-app-compose-1  | [INFO] Scanning for projects...
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO] ------------------------< job.tasks:kameleoon >-------------------------
  kameleoon-app-compose-1  | [INFO] Building kameleoon 0.0.1-SNAPSHOT
  kameleoon-app-compose-1  | [INFO] --------------------------------[ jar ]---------------------------------
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO] >>> spring-boot-maven-plugin:2.7.5:run (default-cli) > test-compile @ kameleoon >>>
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ kameleoon ---
  kameleoon-app-compose-1  | [INFO] Using 'UTF-8' encoding to copy filtered resources.
  kameleoon-app-compose-1  | [INFO] Using 'UTF-8' encoding to copy filtered properties files.
  kameleoon-app-compose-1  | [INFO] Copying 1 resource
  kameleoon-app-compose-1  | [INFO] Copying 0 resource
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO] --- maven-compiler-plugin:3.10.1:compile (default-compile) @ kameleoon ---
  kameleoon-app-compose-1  | [INFO] Nothing to compile - all classes are up to date
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO] --- maven-resources-plugin:3.2.0:testResources (default-testResources) @ kameleoon ---
  kameleoon-app-compose-1  | [INFO] Using 'UTF-8' encoding to copy filtered resources.
  kameleoon-app-compose-1  | [INFO] Using 'UTF-8' encoding to copy filtered properties files.
  kameleoon-app-compose-1  | [INFO] skip non existing resourceDirectory /usr/src/app/src/test/resources
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO] --- maven-compiler-plugin:3.10.1:testCompile (default-testCompile) @ kameleoon ---
  kameleoon-app-compose-1  | [INFO] Nothing to compile - all classes are up to date
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO] <<< spring-boot-maven-plugin:2.7.5:run (default-cli) < test-compile @ kameleoon <<<
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO]
  kameleoon-app-compose-1  | [INFO] --- spring-boot-maven-plugin:2.7.5:run (default-cli) @ kameleoon ---
  kameleoon-app-compose-1  | [INFO] Attaching agents: []
  kameleoon-app-compose-1  |
  kameleoon-app-compose-1  |   .   ____          _            __ _ _
  kameleoon-app-compose-1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
  kameleoon-app-compose-1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
  kameleoon-app-compose-1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  kameleoon-app-compose-1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
  kameleoon-app-compose-1  |  =========|_|==============|___/=/_/_/_/
  kameleoon-app-compose-1  |  :: Spring Boot ::                (v2.7.5)
  kameleoon-app-compose-1  |
  kameleoon-app-compose-1  | 2023-02-09 14:21:29.952  INFO 54 --- [           main] job.tasks.kameleoon.DemoApplication      : Starting DemoApplication using Java 11.0.16 on 431226e373b0 with PID 54 (/usr/src/
  app/target/classes started by root in /usr/src/app)
  kameleoon-app-compose-1  | 2023-02-09 14:21:29.960  INFO 54 --- [           main] job.tasks.kameleoon.DemoApplication      : No active profile set, falling back to 1 default profile: "default"
  kameleoon-app-compose-1  | 2023-02-09 14:21:32.780  INFO 54 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
  kameleoon-app-compose-1  | 2023-02-09 14:21:32.818  INFO 54 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
  kameleoon-app-compose-1  | 2023-02-09 14:21:32.819  INFO 54 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.68]
  kameleoon-app-compose-1  | 2023-02-09 14:21:33.246  INFO 54 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
  kameleoon-app-compose-1  | 2023-02-09 14:21:33.247  INFO 54 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3095 ms
  kameleoon-app-compose-1  | 2023-02-09 14:21:34.136  INFO 54 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
  kameleoon-app-compose-1  | 2023-02-09 14:21:34.169  INFO 54 --- [           main] job.tasks.kameleoon.DemoApplication      : Started DemoApplication in 5.73 seconds (JVM running for 6.797)
  kameleoon-app-compose-1  | 2023-02-09 14:22:57.493  INFO 54 --- [nio-8080-exec-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
  kameleoon-app-compose-1  | 2023-02-09 14:22:57.495  INFO 54 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
  kameleoon-app-compose-1  | 2023-02-09 14:22:57.498  INFO 54 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 3 ms
``

## Push the app image to remote repository on DockerHub
### Create link to exist local image before pushing
``
docker tag kameleoon-app-compose:11 goldenboy369/kameleoon-app-compose:11
``

Result: the image goldenboy369/kameleoon-app-compose:11 has been created in local docker

### Sign in my account on DockerHub
``
docker login
``

Result:         
``
Authenticating with existing credentials...
Login Succeeded
Logging in with your password grants your terminal complete access to your account.
For better security, log in with a limited-privilege personal access token. Learn more at https://docs.docker.com/go/access-tokens/
``

### Push the image goldenboy369/kameleoon-app-compose:11 to the remote repository on DockerHub
``
docker push goldenboy369/kameleoon-app-compose:11
``

Result:         
``
...
92a4e8a3140f: Mounted from library/maven
11: digest: sha256:3b226f1788d886eab338b66db26b5921614bf777aa85edfda2bc452dc3cee75d size: 2625
``

## Run app's container on another PC
### Prepare an environment as above 
### Pull the image into a local docker manually using docker engine (not necessary)
In Windows PowerSell (or other terminal)

``
docker pull goldenboy369/kameleoon-app-compose:11
``

Result(the image already exists):   
``
PS D:\projects\examples\spring\job-tasks\kameleoon> docker pull goldenboy369/kameleoon-app-compose:11
11: Pulling from goldenboy369/kameleoon-app-compose
Digest: sha256:3b226f1788d886eab338b66db26b5921614bf777aa85edfda2bc452dc3cee75d
Status: Image is up to date for goldenboy369/kameleoon-app-compose:11
docker.io/goldenboy369/kameleoon-app-compose:11
``

## Run the app's container (the image is pulling automatically if not exist in local docker)
There:    
--name {app name inside container}      
-p {container's port}:{app's port}      
``
docker run -d --name app-compose -p 8080:8080 goldenboy369/kameleoon-app-compose:11
``

Result:       
``
Unable to find image 'goldenboy369/kameleoon-app-compose:11' locally
11: Pulling from goldenboy369/kameleoon-app-compose
Digest: sha256:3b226f1788d886eab338b66db26b5921614bf777aa85edfda2bc452dc3cee75d
Status: Downloaded newer image for goldenboy369/kameleoon-app-compose:11
d2293d1c61cc82e3d86be9bab5c0b3c4f348d2968e8e6c4415fce8d695633dc0
``

