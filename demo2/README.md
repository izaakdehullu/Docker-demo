### Dockerfile sample

##### docker docs

[Dockerfile reference](https://docs.docker.com/engine/reference/builder/)

[docker-curriculum.com](https://docker-curriculum.com/)

```shell
$ docker build -t ihullu/catnip .
$ docker run -p 8888:5000 ihullu/catnip
```

#### Tonen van de lagen

```shell
$ docker run --rm -it -v /var/run/docker.sock:/var/run/docker.sock  ihullu/catnip  wernight/funbox --source docker
```
