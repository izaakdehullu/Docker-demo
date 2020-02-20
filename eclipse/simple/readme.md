### wsl command

```shell
docker run -v /mnt/c/Workspaces/Docker/Eclipse2019/sample/target/:/opt/app/ -p 8000:8000 eclipse/test
```

docker run -v /c/Workspaces/Docker/Eclipse2019/sample/target/:/opt/app/ -p 8000:8000 eclipse/test

#### Maven container

```shell
docker run -it --rm -v {$PWD}:/usr/src/mymaven -v "$HOME/.m2":/root/.m2 -v "$PWD/target:/usr/src/mymaven/target" -w /usr/src/mymaven maven mvn clean package
```

```shell
$ docker run -it --rm --name my-maven-project -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:3.3-jdk-8 mvn clean install
```

docker run -it --rm -v C:\Users\Izaak de Hullu\.m2:/usr/src/mymaven

docker run -it --rm -v "{$PWD}:/usr/src/mymaven"  -v "$HOME/.m2":/root/.m2 -v "\${PWD}/target:/usr/src/mymaven/target" -w /usr/src/mymaven maven:3.6.3-jdk-11-slim mvn clean package

docker run -it --rm -v ${PWD}:/usr/src/mymaven  -v ${HOME}/.m2:/root/.m2 -v \${PWD}/target:/usr/src/mymaven/target -w /usr/src/mymaven maven:3.6.3-jdk-11-slim mvn clean package

### This one is working (PowerShell!)

```shell
docker run -it --rm -v ${PWD}:/usr/src/mymaven  -v ${HOME}/.m2:/root/.m2  -w /usr/src/mymaven maven:3.6.3-jdk-11-slim  mvn clean package
```
