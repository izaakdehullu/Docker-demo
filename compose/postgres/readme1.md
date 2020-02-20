###Opstarten postgres in docker:

```shell
docker run --name ebxDatabase -e POSTGRES_PASSWORD=ebx -p 5432:5432 -d postgres
```

###Opstarten pgadmin4

```shell
docker run --rm --name pgadmin4 -p 5050:80 --network bridge --mount source=pgdmin4,target=/var/lib/pgadmin -e 'PGADMIN_DEFAULT_EMAIL=izaakdehullu@systemation.nl' -e 'PGADMIN_DEFAULT_PASSWORD=ebx' -d dpage/pgadmin4
```

Zie wel

Kan hier alleen niet mee restoren.

Restoren database als volgt:

1. Find the name and id of the Docker container hosting the Postgres instance
2. Turn on Docker and run docker ps to see the list of containers and their names and ids.

3. Find the volumes available in the Docker container
   `Run docker inspect -f '{{ json .Mounts }}' <container_id> | python -m json.tool`

Copy the dump from your host system to one of the volumes
`Run docker cp </path/to/dump/in/host> <container_name>:<path_to_volume>`

Execute pg_restore via docker exec command
`docker exec <container_name> pg_restore -U <database_owner> -d <database_name> <path_to_dump>`

Aanloggen aan bussybox:

```
docker exec -it <containerid> ash
```

proberen met docker compose:

```yml
version: '3.5'

services:
  postgres:
    container_name: postgres_container
    image: postgres
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: ebx
      PGDATA: /data/postgres
    volumes:
      - postgres:/data/postgres
    ports:
      - '5432:5432'
    networks:
      - postgres
    restart: unless-stopped

  pgadmin:
    container_name: pgadmin_container
    image: dpage/pgadmin4
    environment:
      PGADMIN_DEFAULT_EMAIL: izaakdehullu@systemation.nl
      PGADMIN_DEFAULT_PASSWORD: ebx
    volumes:
      - pgadmin:/root/.pgadmin
    ports:
      - '5050:80'
    networks:
      - postgres
    restart: unless-stopped

networks:
  postgres:
    driver: bridge

volumes:
  postgres:
  pgadmin:
```

Werkt wel. Ik moest met onderstaande commando het ip adres vinden:

```shell
docker inspect -f "{{ .NetworkSettings.Networks.postgress_postgres.IPAddress }}" <containerID>
```

postgress_postgres was de naam an het netwerk. Wat ik niet helemaal begrijp. Dat vond ik via:

```shell
docker inspect <containerID>
```

Testje installeren backup
Hij staat toch wel op pgadmin4. namelijk op:

`/var/lib/pgadmin/storage/izaakdehullu_systemation.nl/ebx2.backup`

Dus nu (vanuit WSL!)

```shell
docker cp /mnt/c/Temp/ebx.backup 45b2ecb22cc9:/var/lib/pgadmin/storage/izaakdehullu_systemation.nl
```

Daarna een restore doen van de database en dat werkt!

Vmmem Windows proces pakt heel veel geheugen
Dit is op te lossen door:

```shell
root@ID07642:/mnt/c/Workspaces/Docker# sudo su
root@ID07642:/mnt/c/Workspaces/Docker# echo 1 > /proc/sys/vm/compact_memory
root@ID07642:/mnt/c/Workspaces/Docker# echo 3 > /proc/sys/vm/drop_caches
```

Dit zorgt ervoor dat het wsl geheugen en de cache worden geleegd. Het geheugen gebruik gaat dan naar beneden.

Zie https://winaero.com/blog/wsl-now-has-memory-reclaim-feature/

C:\> winver
Dit commando laat de Windows versie zien. De build is de juiste.

root@ID07642:/mnt/c/Workspaces/Docker# dmesg
Dit commando laat zien dat er een memory compaction plaats vindt.

[66481.329620] WSL2: Performing memory compaction.
[66542.358583] WSL2: Performing memory compaction.
[66603.419685] WSL2: Performing memory compaction.
