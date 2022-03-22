#
# docker build -t spring-reactive-postgres .
#
# docker run -d -p 5432:5432 spring-reactive-postgres
FROM library/postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB demo
COPY init.sql /docker-entrypoint-initdb.d/
EXPOSE 5432
