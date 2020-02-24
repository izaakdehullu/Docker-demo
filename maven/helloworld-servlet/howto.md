### Hello world servlet demo

Voer onderstaande in om maven uit te voeren.

```shell
$ mvn package docker:build docker:run
```

Er wordt een image aangemaakt en een container opgestart. In deze container daait <code>jetty</code>. In de <code>pom.xml</code> staat de port mapping.

Startup [url](https://localhost:8081/)

De tekst die de servlet toont kan gewijzigd worden in: [welcome.text](./src/main/docker/welcome.txt).
