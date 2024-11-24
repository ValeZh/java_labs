
CREATE TABLE Products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(100),
                          price DECIMAL(10, 2),
                          quantity INT
);

CREATE TABLE Customers (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(100),
                           phone VARCHAR(15)
);