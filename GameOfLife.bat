@echo off
start "Game of life" cmd /c mvnw spring-boot:run 
start "front end" cmd /c -Pgrunt
timeout /t 15 /nobreak > NUL
start chrome http://localhost:8080/#/