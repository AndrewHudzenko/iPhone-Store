CREATE TABLE `products` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `price` decimal(19,2) DEFAULT NULL,
                            `title` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
