### demo

1. docker network create traefik
2. docker-compose up -d
3. http://nginx.docker.localhost/

### old stuff

docker container run -d --rm -p 80:80 -v C:\Workspaces\Docker\Docker-demo\nginx-compose\website\:/usr/share/nginx/html/ nginx:alpine
docker container run -d --rm -p 80:80 -v \${PWD}/website:/usr/share/nginx/html/ nginx:alpine
docker container run -d --rm -p 80:80 -v /var/run/docker.sock:/var/run/docker.sock traefik --docker --web --loglevel=DEBUG
