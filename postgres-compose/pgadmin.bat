docker run --name pgadmin4 -p 5050:80 --network bridge --mount source=pgdmin4,target=/var/lib/pgadmin -e 'PGADMIN_DEFAULT_EMAIL=izaakdehullu@systemation.nl' -e 'PGADMIN_DEFAULT_PASSWORD=ebx'  -d dpage/pgadmin4