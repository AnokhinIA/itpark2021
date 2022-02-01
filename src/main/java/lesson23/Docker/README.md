# Домашнее задание к вебинару №23

1. Необходимо установить Docker Desktop
2. Запустить <code>docker run hello-world</code>
3. Запустить из директории проекта команду
   <code>docker-compose up -d</code>
   и подключиться к СУБД MySQL из-под IntelliJ IDEA

## Отчет о выполнении
1. ОС Ubuntu, поэтому Docker Desktop не устанавливался.
2. Результат запуска команды <code>docker run hello-world</code>:  
<code>
   igor@igor-HP-ProBook-6560b:~/idea-IC-212.5457.46/bin$ docker run hello-world   
 Unable to find image 'hello-world:latest' locally
   latest: Pulling from library/hello-world
   2db29710123e: Pull complete
   Digest: sha256:507ecde44b8eb741278274653120c2bf793b174c06ff4eaa672b713b3263477b
   Status: Downloaded newer image for hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.
</code>
 и так далее ...  
3. Подключение к СУБД MySQL из-под IntelliJ IDEA было произведено успешно:  
<code> 
   DBMS: MySQL (ver. 8.0.20)
   Case sensitivity: plain=exact, delimited=exact
   Driver: MySQL Connector/J (ver. mysql-connector-java-8.0.25 (Revision: 08be9e9b4cba6aa115f9b27b215887af40b159e0), JDBC4.2)
   Ping: 182 ms
   SSL: yes
</code>
  
