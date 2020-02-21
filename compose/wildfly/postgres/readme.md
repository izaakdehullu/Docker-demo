###Restoren database 

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

