#!/bin/sh

java -jar /usr/local/lib/reservas-app.jar --spring.datasource.url=$DB_URL --spring.datasource.username=$DB_USER \
--spring.datasource.password=$DB_PASSWD