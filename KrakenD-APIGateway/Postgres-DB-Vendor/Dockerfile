ARG IMAGE_REPOSITORY=postgres
ARG IMAGE_TAG=14.5

FROM ${IMAGE_REPOSITORY}:${IMAGE_TAG}
ENV POSTGRES_DB keycloak
ENV POSTGRES_USER keycloak 
ENV POSTGRES_PASSWORD password

# docker build -t postgres-keycloak:1.0 .
# docker run -d -p 5432:5432 -t postgres-keycloak:1.0
# docker inspect <container_id> | grep IPAddress