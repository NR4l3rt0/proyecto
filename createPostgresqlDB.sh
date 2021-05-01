#!/bin/sh

docker run --name postgresDB  \
-e POSTGRES_PASSWORD=postgres \
-e POSTGRES_USER=postgres \
-e POSTGRES_DB=proyecto  \
-p 5432:5432  \
-d postgres;

docker exec -it postgresDB /bin/bash;

