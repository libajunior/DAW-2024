-- Create Database
CREATE DATABASE IF NOT EXISTS `dawdb`;
USE `dawdb`;

-- Table: tipo_imovel
CREATE TABLE `tipo_imovel` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `descricao` VARCHAR(255) NOT NULL
);

-- Table: imovel
CREATE TABLE `imovel` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `tipo_imovel_id` INT NOT NULL,
    `titulo` VARCHAR(255) NOT NULL,
    `descricao` VARCHAR(255) NOT NULL,
    `thumbs` VARCHAR(255) NOT NULL,
    `valor` DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (`tipo_imovel_id`) REFERENCES `tipo_imovel`(`id`)
);

-- Inserting into tipo_imovel
INSERT INTO `tipo_imovel` (`descricao`) VALUES
    ('Apartamento'), ('Casa'), ('Sobrado'), ('Terreno');

-- Inserting into imovel
INSERT INTO `imovel` (`tipo_imovel_id`, `titulo`, `descricao`, `thumbs`, `valor`)
VALUES
    (1, 'Apto 1 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb1.png', 500000),
    (1, 'Apto 2 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb2.png', 600000),
    (1, 'Apto 3 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb3.png', 700000),
    (1, 'Apto 4 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb4.png', 800000),
    (1, 'Apto 5 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb5.png', 900000),

    (2, 'Casa 1 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb1.png', 500000),
    (2, 'Casa 2 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb2.png', 600000),
    (2, 'Casa 3 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb3.png', 700000),
    (2, 'Casa 4 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb4.png', 800000),
    (2, 'Casa 5 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb5.png', 900000),

    (3, 'Sobrado 1 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb1.png', 500000),
    (3, 'Sobrado 2 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb2.png', 600000),
    (3, 'Sobrado 3 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb3.png', 700000),
    (3, 'Sobrado 4 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb4.png', 800000),
    (3, 'Sobrado 5 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb5.png', 900000),

    (4, 'Terreno 1 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb1.png', 500000),
    (4, 'Terreno 2 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb2.png', 600000),
    (4, 'Terreno 3 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb3.png', 700000),
    (4, 'Terreno 4 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb4.png', 800000),
    (4, 'Terreno 5 - Lorem ipsum dolor sit amet, consectetur adipisicing elit', 'Commodi quae repudiandae sed maiores architecto adipisci aut doloremque ipsa, harum repellendus praesentium autem voluptates ducimus itaque quaerat totam asperiores suscipit', './assets/img/thumb5.png', 900000);