CREATE TABLE consertos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    entrada VARCHAR(20) NOT NULL,
    saida VARCHAR(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    experiencia VARCHAR(10) NOT NULL,
    marca VARCHAR(30) NOT NULL,
    modelo VARCHAR(30) NOT NULL,
    ano VARCHAR(20) NOT NULL,

    PRIMARY KEY(id)
)