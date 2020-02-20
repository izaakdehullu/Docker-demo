## bouwen van wildfly

1. Maken van het base image:

```shell
$ cd ./wildfly/base
$ docker build -t wildfly:10.1.0-jdk-8 .
```

2. Daarna maken van ebx wildfly versie. Hierin staan een aantal omgevingsvariabelen die ik in de compose moet doorgeven. Ik zal ze hieruit weghalen. Voor de testversie nog wel.

Ik zou graag in het wildfly ebx image files willen mounten. Dat zou moeten kunnen met:

```shell
 $ docker container run -d --rm -p 9990:9990 --mount type=bind,source=${PWD}/ebx.properties,target=/opt/ebx/ebx.properties ebxtest:latest
```

3. Compose maken zodanig dat alles met elkaar samenwerkt. Hopelijk werk de datasource ook ;-)
