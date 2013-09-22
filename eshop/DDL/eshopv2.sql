
    create table ADMIN_LOG (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        admin_id varchar(255),
        log_ip varchar(20) not null,
        log_role varchar(20) not null,
        log_time date,
        primary key (ID)
    );

    create table ADVERTISEMENT (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        ad_begin datetime,
        ad_end datetime,
        content varchar(255),
        imageurl varchar(100),
        primary key (ID)
    );

    create table BUYER_ADDR (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        address varchar(100),
        building varchar(20) not null,
        buyer_id varchar(64),
        consignee varchar(10) not null,
        email varchar(30),
        is_default varchar(1),
        phone varchar(15),
        school_area varchar(10) not null,
        primary key (ID)
    );

    create table BUYER_LEVEL (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        description varchar(100),
        discount double precision,
        name varchar(50) not null,
        primary key (ID)
    );

    create table CATEGORY (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        description varchar(100),
        name varchar(20) not null,
        primary key (ID)
    );

    create table CATEGORY_DETAIL (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        category_id varchar(64) not null,
        description varchar(100),
        name varchar(20) not null,
        primary key (ID)
    );

    create table ORDERITEM (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        buyer_id varchar(64),
        count integer,
        is_remain char(1) not null,
        itempris double precision,
        order_id varchar(64) not null,
        price double precision not null,
        product_id varchar(64) not null,
        product_name varchar(64),
        primary key (ID)
    );

    create table ORDERMENU (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        arrivtime varchar(100) not null,
        buyer_id varchar(64) not null,
        finaladdr varchar(16) not null,
        order_id varchar(64) not null,
        orderdate varchar(16) not null,
        qrcode varchar(100) not null,
        seller_id varchar(64) not null,
        status char(1) not null,
        totalpris double precision not null,
        primary key (ID)
    );

    create table PRODUCT_COMMENT (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        buyer_id varchar(64),
        content varchar(100) not null,
        product_id varchar(64),
        starlevel integer,
        title varchar(50) not null,
        primary key (ID)
    );

    create table PRODUCT_INFO (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        counter integer,
        description varchar(200) not null,
        Downdate datetime not null,
        image_big varchar(100) not null,
        inprice double precision,
        is_eshop char(1),
        is_onsale char(1),
        is_sale varchar(1),
        keyword varchar(30),
        name varchar(100) not null,
        onsale_num integer not null,
        onsale_price double precision,
        price double precision not null,
        priority integer,
        productid varchar(50) not null,
        remain_Number integer not null,
        salenumber integer,
        seller_id varchar(64),
        update_date datetime not null,
        uploadate datetime not null,
        primary key (ID)
    );

    create table SEARCH_KEYWORDS (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        count integer,
        keyword varchar(50) not null,
        primary key (ID)
    );

    create table USER_ADMIN (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        admin_name varchar(12) not null,
        admin_role varchar(20),
        password varchar(200) not null,
        primary key (ID)
    );

    create table USER_BUYER (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        email varchar(30),
        is_valudate varchar(1),
        level_id varchar(64),
        name varchar(15) not null,
        password varchar(200) not null,
        phone varchar(15),
        realname varchar(15),
        reg_date varchar(15),
        score integer,
        userid varchar(15),
        primary key (ID)
    );

    create table USER_EXPRESS (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        name varchar(8),
        phone varchar(15),
        studentid varchar(15),
        primary key (ID)
    );

    create table USER_SHOP (
        ID varchar(64) not null,
        create_time varchar(20),
        create_user varchar(15),
        update_time varchar(20),
        address varchar(100),
        email varchar(30),
        is_eshop varchar(1) not null,
        name varchar(15) not null,
        password varchar(200) not null,
        phone varchar(15),
        store_id varchar(5) not null,
        store_name varchar(50) not null,
        primary key (ID)
    );