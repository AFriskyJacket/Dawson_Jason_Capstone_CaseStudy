create table image_meta_data (id bigint not null auto_increment, user_id bigint not null, name varchar(255), primary key (id)) engine=InnoDB;
create table image_meta_data_tags (owner_id bigint not null, tag varchar(255)) engine=InnoDB;
create table user (id bigint not null auto_increment, name varchar(255) not null, password varchar(255) not null, primary key (id)) engine=InnoDB;
alter table user add constraint UK_gj2fy3dcix7ph7k8684gka40c unique (name);
alter table image_meta_data add constraint FKt552m7tg369s14migun6ntl12 foreign key (user_id) references user (id);
alter table image_meta_data_tags add constraint FK2h138oasyb714iqvdqectk8a3 foreign key (owner_id) references image_meta_data (id);
create table image_meta_data (id bigint not null auto_increment, user_id bigint not null, name varchar(255), primary key (id)) engine=InnoDB;
create table image_meta_data_tags (owner_id bigint not null, tag varchar(255)) engine=InnoDB;
create table user (id bigint not null auto_increment, name varchar(255) not null, password varchar(255) not null, primary key (id)) engine=InnoDB;
alter table user add constraint UK_gj2fy3dcix7ph7k8684gka40c unique (name);
alter table image_meta_data add constraint FKt552m7tg369s14migun6ntl12 foreign key (user_id) references user (id);
alter table image_meta_data_tags add constraint FK2h138oasyb714iqvdqectk8a3 foreign key (owner_id) references image_meta_data (id);
