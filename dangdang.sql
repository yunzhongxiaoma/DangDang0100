/*-----------------------建表语句----------------------------------*/
drop trigger tib_d_buyaddress
/

drop trigger tib_d_buyorder
/

drop trigger tib_d_buyorderdetall
/

drop trigger tib_d_goodcategory
/

drop trigger tib_d_goods
/

drop trigger tib_d_user
/

alter table d_buyaddress
   drop constraint FK_D_BUYADD_REFERENCE_D_USER
/

alter table d_buyorder
   drop constraint FK_D_BUYORD_REFERENCE_D_USER
/

alter table d_buyorder
   drop constraint FK_D_BUYORD_REFERENCE_D_BUYADD
/

alter table d_buyorderdetall
   drop constraint FK_D_BUYORD_REFERENCE_D_GOODS
/

alter table d_buyorderdetall
   drop constraint FK_D_BUYORD_REFERENCE_D_BUYORD
/

alter table d_goods
   drop constraint FK_D_GOODS_REFERENCE_D_GOODCA
/

/*危险操作--删表*/
drop table d_buyaddress cascade constraints
/

drop table d_buyorder cascade constraints
/

drop table d_buyorderdetall cascade constraints
/

drop table d_goodcategory cascade constraints
/

drop table d_goods cascade constraints
/

drop table d_user cascade constraints
/



drop sequence S_d_buyaddress
/

drop sequence S_d_buyorder
/

drop sequence S_d_buyorderdetall
/

drop sequence S_d_goodcategory
/

drop sequence S_d_goods
/

drop sequence S_d_user
/

create sequence S_d_buyaddress
/

create sequence S_d_buyorder
/

create sequence S_d_buyorderdetall
/

create sequence S_d_goodcategory
/

create sequence S_d_goods
/

create sequence S_d_user
/

/*==============================================================*/
/* Table: d_buyaddress                                          */
/*==============================================================*/
create table d_buyaddress  (
   d_addrid             NUMBER(6)                       not null,
   d_username           VARCHAR2(16),
   d_posthome           VARCHAR2(100),
   d_postcode           VARCHAR2(16),
   d_telephone          VARCHAR2(16),
   d_mobilephone        VARCHAR2(16),
   d_default            SMALLINT,
   d_addrstatus         SMALLINT,
   d_uid                INTEGER,
   constraint PK_D_BUYADDRESS primary key (d_addrid)
)
/

/*==============================================================*/
/* Table: d_buyorder                                            */
/*==============================================================*/
create table d_buyorder  (
   d_orderid            NUMBER(6)                       not null,
   d_onumber            VARCHAR2(80),
   d_totalprice         FLOAT(126),
   d_createtimer        DATE  DEFAULT CURRENT_TIMESTAMP,
   d_orderstatus        SMALLINT,
   d_uid                INTEGER,
   d_addrid             INTEGER,
   constraint PK_D_BUYORDER primary key (d_orderid)
)
/

/*==============================================================*/
/* Table: d_buyorderdetall                                      */
/*==============================================================*/
create table d_buyorderdetall  (
   d_id                 NUMBER(6)                       not null,
   d_number             INTEGER,
   d_total              INTEGER,
   d_orderid            INTEGER,
   d_gid                INTEGER,
   constraint PK_D_BUYORDERDETALL primary key (d_id)
)
/

/*==============================================================*/
/* Table: d_goodcategory                                        */
/*==============================================================*/
create table d_goodcategory  (
   d_cateid             NUMBER(6)                       not null,
   d_cname              VARCHAR2(16),
   d_parentid           INTEGER,
   d_goodsquantity      INTEGER,
   constraint PK_D_GOODCATEGORY primary key (d_cateid)
)
/

/*==============================================================*/
/* Table: d_goods                                               */
/*==============================================================*/
create table d_goods  (
   d_gid                NUMBER(6)                       not null,
   d_picaddress         VARCHAR2(50),
   d_name               VARCHAR2(16),
   d_author             VARCHAR2(16),
   d_publisher          VARCHAR2(16),
   d_describe           VARCHAR2(200),
   d_originalprice      BINARY_DOUBLE,
   d_dangdangprice      BINARY_DOUBLE,
   d_publishingtime     DATE DEFAULT CURRENT_TIMESTAMP ,
   d_revision           INTEGER,
   d_printingtime       DATE DEFAULT CURRENT_TIMESTAMP,
   d_impression         INTEGER,
   d_Iisbn              VARCHAR2(16),
   d_wordsnumber        INTEGER,
   d_pagesnumber        INTEGER,
   d_format             INTEGER,
   d_paper              VARCHAR2(16),
   d_packaging          VARCHAR2(16),
   d_editorrecommende   VARCHAR2(500),
   d_briefcontent       VARCHAR2(400),
   d_briefauthor        VARCHAR2(600),
   d_catalog            VARCHAR2(300),
   d_mediareviews       VARCHAR2(300),
   d_illustration       VARCHAR2(16),
   d_sheletime          DATE DEFAULT CURRENT_TIMESTAMP,
   d_bookstate          SMALLINT,
   d_stock              INTEGER,
   d_sales              INTEGER,
   d_score              INTEGER,
   d_recommendedlevel   INTEGER,
   d_cateid             INTEGER,
   constraint PK_D_GOODS primary key (d_gid)
)
/

/*==============================================================*/
/* Table: d_user                                                */
/*==============================================================*/
create table d_user  (
   d_uid                NUMBER(6)                       not null,
   d_email              VARCHAR2(30),
   d_password           VARCHAR2(16),
   d_nickname           VARCHAR2(16),
   d_createtime         DATE DEFAULT CURRENT_TIMESTAMP,
   d_accountstate       SMALLINT,
   constraint PK_D_USER primary key (d_uid)
)
/

alter table d_buyaddress
   add constraint FK_D_BUYADD_REFERENCE_D_USER foreign key (d_uid)
      references d_user (d_uid)
/

alter table d_buyorder
   add constraint FK_D_BUYORD_REFERENCE_D_USER foreign key (d_uid)
      references d_user (d_uid)
/

alter table d_buyorder
   add constraint FK_D_BUYORD_REFERENCE_D_BUYADD foreign key (d_addrid)
      references d_buyaddress (d_addrid)
/

alter table d_buyorderdetall
   add constraint FK_D_BUYORD_REFERENCE_D_GOODS foreign key (d_gid)
      references d_goods (d_gid)
/

alter table d_buyorderdetall
   add constraint FK_D_BUYORD_REFERENCE_D_BUYORD foreign key (d_orderid)
      references d_buyorder (d_orderid)
/

alter table d_goods
   add constraint FK_D_GOODS_REFERENCE_D_GOODCA foreign key (d_cateid)
      references d_goodcategory (d_cateid)
/


create trigger tib_d_buyaddress before insert
on d_buyaddress for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "d_addrid" uses sequence S_d_buyaddress
    select S_d_buyaddress.NEXTVAL INTO :new.d_addrid from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger tib_d_buyorder before insert
on d_buyorder for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "d_orderid" uses sequence S_d_buyorder
    select S_d_buyorder.NEXTVAL INTO :new.d_orderid from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger tib_d_buyorderdetall before insert
on d_buyorderdetall for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "d_id" uses sequence S_d_buyorderdetall
    select S_d_buyorderdetall.NEXTVAL INTO :new.d_id from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger tib_d_goodcategory before insert
on d_goodcategory for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "d_cateid" uses sequence S_d_goodcategory
    select S_d_goodcategory.NEXTVAL INTO :new.d_cateid from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger tib_d_goods before insert
on d_goods for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "d_gid" uses sequence S_d_goods
    select S_d_goods.NEXTVAL INTO :new.d_gid from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger tib_d_user before insert
on d_user for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "d_uid" uses sequence S_d_user
    select S_d_user.NEXTVAL INTO :new.d_uid from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/
