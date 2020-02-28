## bouwen van wildfly

1. Maken van het base image:

```shell
$ cd ./wildfly/base
$ docker build -t wildfly:10.1.0-jdk-8 .
```

2. Daarna maken van ebx wildfly versie. Hierin staan een aantal omgevingsvariabelen die ik in de compose moet doorgeven. Ik zal ze hieruit weghalen. Voor de testversie nog wel.

```shell
$ cd ./wildfly/postgres
$ docker build -t wildfly/postgres .
```

3. Opstarten van de docker-compose

```shell
$ docker-compose up -d
```

### Demo

1. VSCode: open Docker Extension
2. Start compose op: ```$ docker-compose up -d ```
3. Opwn [pgadmin](http://localhost:5050) 
4. inloggen met: a@b.nl/ebx
5. Aanmaken Nieuwe server: 
    5.1 tab1: server naam: postgres
    5.2 tab2: postgres_contaner  (of postgres alleen)

### nice to known

Snel slopen

```shell
docker-compose down ;  docker volume prune
```

Het mouten van files kan:

```shell
 $ docker container run -d --rm -p 9990:9990 --mount type=bind,source=${PWD}/ebx.properties,target=/opt/ebx/ebx.properties ebxtest:latest
```
