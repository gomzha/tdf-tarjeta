#!/bin/bash

set -eou pipefail

docker run -d --rm \
  --name tdf-db-postgres \
  -p 5432:5432 \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=admin \
  -e POSTGRES_DB=gonzadb \
  postgres:16-alpine