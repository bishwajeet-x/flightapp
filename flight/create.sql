create table airline.mst_airline (airline_id int8 not null, airline_name varchar(255), status_id int4 not null, status varchar(255), airline_status_status_id int4, primary key (status_id))
alter table if exists airline.mst_airline add constraint FKp1f5v41bqgty5iq7ekpsuw8xh foreign key (airline_status_status_id) references airline.mst_airline
create table airline.mst_airline (airline_id int8 not null, airline_name varchar(255), status_id int4 not null, status varchar(255), airline_status_status_id int4, primary key (status_id))
alter table if exists airline.mst_airline add constraint FKp1f5v41bqgty5iq7ekpsuw8xh foreign key (airline_status_status_id) references airline.mst_airline
