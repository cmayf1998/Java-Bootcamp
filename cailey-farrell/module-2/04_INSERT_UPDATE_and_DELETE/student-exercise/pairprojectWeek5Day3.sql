BEGIN TRANSACTION;

DROP TABLE if exists customers;
DROP TABLE if exists transactions;
DROP TABLE if exists procedures;
DROP TABLE if exists procedure_transactions;
DROP TABLE if exists pets;
DROP TABLE if exists procedure_pets;

CREATE TABLE customers
(
        customerId serial,
        first_name varchar(64) not null,
        last_name varchar(64) not null,
        address varchar(64) not null,
        city varchar(64) not null,
        state varchar(64) not null,
        zipcode varchar(64) not null,
        
        constraint pk_customers primary key (customerId)      
);

CREATE TABLE transactions
(
        transactionId serial,
        dateOfTransaction varchar(64) not null,
        amount float(8) not null,
        invoiceNumber int not null,
        customerId int not null,
        
        constraint pk_transactions primary key (transactionId),
        constraint fk_transactions_customers foreign key (customerId) references customers (customerId)
         
 );

 
CREATE TABLE procedures
(
        procedureId serial,
        procedureName varchar(64) not null,
        
        constraint pk_procedures primary key (procedureId)
);

CREATE TABLE procedure_transactions
(
        transactionId int not null,
        procedureId int not null,
       
       constraint pk_transaction_procedure primary key (transactionId, procedureId), 
        constraint fk_procedure_transactions_transactions foreign key (transactionId) references transactions (transactionId),
        constraint fk_procedure_transactions_procedures foreign key (procedureId) references procedures (procedureId) 
);




CREATE TABLE pets
(
        petID serial,
        petName varchar(64) not null,
        petAge int not null,
        petType varchar(64) not null,
        ownerID int not null,
        visitDate timestamp not null,
        
        constraint pk_pets primary key (petID),
        constraint fk_pets_customers foreign key (ownerID) references customers (customerId)
        
);

CREATE TABLE procedure_pets
(
        procedureId int not null,
        petID int not null,
        
        constraint fk_procedure_pets_procedures foreign key (procedureId) references procedures (procedureId),
        constraint fk_procedure_pets_pets foreign key (petID) references pets (petID)
);

COMMIT TRANSACTION;

        