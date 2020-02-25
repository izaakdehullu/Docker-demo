### pushen image

1. Login op dockerhub ihullu (clear repository op dockerhub)
2. Maken image: `docker build -t ihullu/devops-hello-world:0.32.0 .`
3. Push image: `docker push ihullu/devops-hello-world:0.32.0`
   (docker login)
4. Checken in repository
5. Verwijder image lokaal
6. run image: 'docker container run ihullu/devops-hello-world:0.32.0

#### Tonen van de lagen

```shell
$ docker run --rm -it -v /var/run/docker.sock:/var/run/docker.sock  wagoodman/dive:latest  ihullu/devops-hello-world:0.32.0      --source docker
```
