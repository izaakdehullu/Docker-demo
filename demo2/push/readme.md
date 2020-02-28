### pushen image

1. Login op dockerhub ihullu (clear repository op dockerhub) [dockerhub](https://hub.docker.com/repository/docker/ihullu/devops-hello-world)
2. Tonen inhoud van de dockerfile
3. Maken image: `docker build -t ihullu/devops-hello-world:0.32.0 .`
4. Push image: `docker push ihullu/devops-hello-world:0.32.0`
   (docker login)
5. Checken in repository
6. Verwijder image lokaal
7. run image: 'docker container run ihullu/devops-hello-world:0.32.0

#### Tonen van de lagen

```shell
$ docker run --rm -it -v /var/run/docker.sock:/var/run/docker.sock  wagoodman/dive:latest  ihullu/devops-hello-world:0.32.0      --source docker
```
