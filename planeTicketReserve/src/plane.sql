CREATE TABLE orders (
  id            int(10) NOT NULL AUTO_INCREMENT, 
  flight        varchar(25), 
  startpoint    varchar(25), 
  endpoint      varchar(25), 
  starttime     timestamp NULL, 
  endtime       timestamp NULL, 
  advancestatus int(10) DEFAULT 0, 
  ticketstatus  int(10) DEFAULT 0, 
  tickettime    timestamp NULL, 
  price         real, 
  seat          int(10), 
  space         int(10), 
  travellerid   int(10) NOT NULL, 
  teamid        int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE agency (
  id       int(10) NOT NULL AUTO_INCREMENT, 
  pwd      varchar(25), 
  name     varchar(255), 
  address  varchar(255), 
  contacts varchar(255), 
  phone    varchar(25), 
  PRIMARY KEY (id));
CREATE TABLE team (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  name      varchar(25), 
  starttime timestamp NULL, 
  endtime   timestamp NULL, 
  type      int(10), 
  status    int(10) DEFAULT 0, 
  agencyid  int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE route (
  id          int(10) NOT NULL AUTO_INCREMENT, 
  startpoint  varchar(25), 
  endpoint    varchar(25), 
  ordernumber int(10), 
  teamid      int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE traveller (
  id       int(10) NOT NULL AUTO_INCREMENT, 
  sex      varchar(25), 
  name     varchar(25), 
  idcard   varchar(25), 
  phone    varchar(25), 
  agencyid int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE participate (
  travellerid int(10) NOT NULL, 
  teamid      int(10) NOT NULL, 
  jointime    timestamp NULL, 
  PRIMARY KEY (travellerid, 
  teamid));
ALTER TABLE orders ADD INDEX have (travellerid), ADD CONSTRAINT have FOREIGN KEY (travellerid) REFERENCES traveller (id);
ALTER TABLE orders ADD INDEX teamhave (teamid), ADD CONSTRAINT teamhave FOREIGN KEY (teamid) REFERENCES team (id);
ALTER TABLE route ADD INDEX FKroute449476 (teamid), ADD CONSTRAINT FKroute449476 FOREIGN KEY (teamid) REFERENCES team (id);
ALTER TABLE team ADD INDEX FKteam537233 (agencyid), ADD CONSTRAINT FKteam537233 FOREIGN KEY (agencyid) REFERENCES agency (id);
ALTER TABLE traveller ADD INDEX FKtraveller928676 (agencyid), ADD CONSTRAINT FKtraveller928676 FOREIGN KEY (agencyid) REFERENCES agency (id);
ALTER TABLE participate ADD INDEX FKparticipat877580 (travellerid), ADD CONSTRAINT FKparticipat877580 FOREIGN KEY (travellerid) REFERENCES traveller (id);
ALTER TABLE participate ADD INDEX FKparticipat730716 (teamid), ADD CONSTRAINT FKparticipat730716 FOREIGN KEY (teamid) REFERENCES team (id);
