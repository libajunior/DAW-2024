package com.unimater.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Imovel implements Entity {

    private int id;
    private TipoImovel tipoImovel;

    private String titulo;
    private String descricao;
    private String thumbs;
    private double valor;

    public Imovel(int id, TipoImovel tipoImovel, String titulo, String descricao, String thumbs, double valor) {
        this.id = id;
        this.tipoImovel = tipoImovel;
        this.titulo = titulo;
        this.descricao = descricao;
        this.thumbs = thumbs;
        this.valor = valor;
    }

    public Imovel(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.titulo = resultSet.getString("titulo");
        this.descricao = resultSet.getString("descricao");
        this.thumbs = resultSet.getString("thumbs");
        this.valor = resultSet.getDouble("valor");
        this.tipoImovel = new TipoImovel(resultSet.getInt("tipo_imovel_id"));
    }

    public Imovel() {
    }

    public Imovel(int id) {
        this.id = id;
    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException {
        return new Imovel(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, this.getTipoImovel().getId());
        preparedStatement.setString(2, getTitulo());
        preparedStatement.setString(3, getDescricao());
        preparedStatement.setString(4, getThumbs());
        preparedStatement.setDouble(5, getValor());
        return preparedStatement;
    }

    public int getId() {
        return id;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public String getTitulo() {
        return descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getThumbs() {
        return thumbs;
    }

    public double getValor() {
        return valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", tipoImovel=" + tipoImovel +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", thumbs='" + thumbs + '\'' +
                ", valor=" + valor +
                '}';
    }
}
