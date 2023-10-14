From mysql:8.0

Copy my.cnf /etc/my.cnf
Copy conf.d /etc/mysql/conf.d
Copy init.sql /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_DATABASE=recruitdb

CMD ["--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci"]