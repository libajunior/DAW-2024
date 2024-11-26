package com.unimater.dao;

import com.unimater.model.TipoImovel;

import java.sql.Connection;
import java.util.List;

public class TipoImovelDAO extends GenericDAOImpl<TipoImovel> implements GenericDAO<TipoImovel> {

    private Connection connection;
    private final String TABLE_NAME = "tipo_imovel";

    private final List<String> COLUMNS = List.of("descricao");

    public TipoImovelDAO(Connection connection) {
        super(TipoImovel::new, connection);
        super.tableName = TABLE_NAME;
        super.columns = COLUMNS;
    }

}
