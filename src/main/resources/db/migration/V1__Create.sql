create table USER_INF (
  id smallint primary key,
  name varchar(255) not null
);
create table PRAISE_INF (
  id smallint primary key,
  user_id smallint not null,
  praise_type smallint not null,
  overview varchar(255) not null,
  updated_time timestamp not null default current_timestamp,
  created_time timestamp not null default current_timestamp
);
