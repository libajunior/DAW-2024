package com.unimater.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoImovel implements Entity {

    private int id;
    private String descricao;

    public TipoImovel(ResultSet rs) throws SQLException {
        super();
        this.id = rs.getInt("id");
        this.descricao = rs.getString("descricao");
    }

    public TipoImovel(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public TipoImovel(int id) {
        this.id = id;
    }

    public TipoImovel() {

    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException{
        return new TipoImovel(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, getDescricao());
        return preparedStatement;
    }

    @Override
    public String toString() {
        return "TipoImovel{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
