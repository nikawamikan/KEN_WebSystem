# KEN_WebSystem

>閲覧ありがとうございます。  
>本システムはスクールの演習で作成したものであり、動作を保証するものではありませんことをご了承ください。

## MySQL

>基本的にはスクールで用意されたデータベースを使用しています。  
>以下は使用したデータベースです。

### user
```
CREATE TABLE user
(
    usr_id                      INT NOT NULL AUTO_INCREMENT,
    usr_name                    VARCHAR(30) NOT NULL,
    password                    VARCHAR(64) NOT NULL,
    zipcode                     VARCHAR(20),
    address                     VARCHAR(200),
    phone                       VARCHAR(20),
    mail                        VARCHAR(100) NOT NULL,
    exp                         TEXT,
    CONSTRAINT PRIMARY KEY (usr_id),
    CONSTRAINT mail UNIQUE (mail)
);
```
### admin

```
CREATE TABLE admin
(
    adm_name                    VARCHAR(30) NOT NULL,
    password                    VARCHAR(64) NOT NULL,
    exp                         TEXT,
    CONSTRAINT PRIMARY KEY (adm_name, password)
);
```

### course

```
CREATE TABLE course
(
    c_id                        INT NOT NULL AUTO_INCREMENT,
    c_name                      VARCHAR(30) NOT NULL,
    detail                      TEXT,
    orderFlg                    TINYINT,
    price                       INT NOT NULL,
    t_id                        INT,
    CONSTRAINT PRIMARY KEY (c_id)
);
```

### coursectl

```
CREATE TABLE coursectl
(
    c_id                        INT,
    m_id                        INT,
    CONSTRAINT coursectl FOREIGN KEY (m_id) REFERENCES menu (m_id),
    CONSTRAINT coursectl FOREIGN KEY (c_id) REFERENCES course (c_id)
);
```

### menu

```
CREATE TABLE menu
(
    m_id                        INT NOT NULL AUTO_INCREMENT,
    m_Name                      VARCHAR(100) NOT NULL,
    detail                      TEXT,
    orderFlg                    TINYINT,
    price                       INT NOT NULL,
    t_id                        SMALLINT NOT NULL,
    CONSTRAINT PRIMARY KEY (m_id),
    CONSTRAINT menu FOREIGN KEY (t_id) REFERENCES menutype (t_id)
);
```

### menutype

```
CREATE TABLE menutype
(
    t_id                        SMALLINT NOT NULL,
    t_name                      VARCHAR(30),
    CONSTRAINT PRIMARY KEY (t_id)
);
```

### reserve

```
CREATE TABLE reserve
(
    rsv_id                      INT NOT NULL AUTO_INCREMENT,
    usr_id                      INT NOT NULL,
    rsv_date                    DATETIME NOT NULL,
    person                      TINYINT NOT NULL,
    table_id                    TINYINT,
    c_id                        INT,
    app_date                    TIMESTAMP(0) NOT NULL,
    CONSTRAINT PRIMARY KEY (rsv_id),
    CONSTRAINT reserve FOREIGN KEY (c_id) REFERENCES course (c_id),
    CONSTRAINT reserve FOREIGN KEY (table_id) REFERENCES table_loc (table_id)
);
```

### table_loc

```
CREATE TABLE table_loc
(
    table_id                    TINYINT NOT NULL AUTO_INCREMENT,
    table_name                  VARCHAR(30),
    max_capacity                TINYINT,
    CONSTRAINT PRIMARY KEY (table_id)
);
```

