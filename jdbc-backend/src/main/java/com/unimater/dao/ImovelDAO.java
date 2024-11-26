package com.unimater.dao;

import com.unimater.model.Imovel;

import java.sql.Connection;
import java.util.List;

public class ImovelDAO extends GenericDAOImpl<Imovel> implements GenericDAO<Imovel> {

    private Connection connection;
    private final String TABLE_NAME = "imovel";

    private final List<String> COLUMNS = List.of("tipo_imovel_id", "titulo", "descricao", "thumbs", "valor");

    private final TipoImovelDAO tipoImovelDAO;

    public ImovelDAO(Connection connection) {
        super(Imovel::new, connection);
        super.tableName = TABLE_NAME;
        super.columns = COLUMNS;
        this.tipoImovelDAO = new TipoImovelDAO(connection);
    }

    public Imovel feedTipoImovel(Connection connection, Imovel imovel){
        imovel.setTipoImovel(tipoImovelDAO.getById(imovel.getTipoImovel().getId()));
        return imovel;
    }

}
