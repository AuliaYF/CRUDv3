/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudv3.controller;

import crudv3.DBDriver;
import crudv3.model.BaseModel;
import crudv3.model.BidangStudiModel;
import crudv3.model.StandarKompetensiModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author auliayf
 */
public class StandarKompetensiController implements BaseController {

    @Override
    public List<BaseModel> selectAll() {
        List<BaseModel> models = new ArrayList<BaseModel>();
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        try {
            conn = DBDriver.getConnection();
            state = conn.createStatement();
            result = state.executeQuery("SELECT * FROM standar_kompetensi");

            while (result.next()) {
                StandarKompetensiModel model = new StandarKompetensiModel();

                model.set("sk_kode", result.getString("sk_kode"));
                model.set("kompetensi_kode", result.getString("kompetensi_kode"));
                model.set("sk_nama", result.getString("sk_nama"));
                model.set("sk_kelas", result.getString("sk_kelas"));

                models.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StandarKompetensiController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBDriver.close(conn, state, result);
        }
        return models;
    }

    @Override
    public void insert(BaseModel model) {
        Connection conn = null;
        PreparedStatement state = null;
        try {
            conn = DBDriver.getConnection();
            state = conn.prepareStatement("INSERT INTO standar_kompetensi VALUES(?, ?, ?, ?)");

            state.setString(1, model.get("sk_kode"));
            state.setString(2, model.get("kompetensi_kode"));
            state.setString(3, model.get("sk_nama"));
            state.setString(4, model.get("sk_kelas"));

            state.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StandarKompetensiController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBDriver.close(conn, state);
        }
    }

    @Override
    public void update(BaseModel model) {
        Connection conn = null;
        PreparedStatement state = null;
        try {
            conn = DBDriver.getConnection();
            state = conn.prepareStatement("UPDATE standar_kompetensi SET kompetensi_kode = ?, sk_nama = ?, sk_kelas = ? WHERE sk_kode = ?");

            state.setString(1, model.get("kompetensi_kode"));
            state.setString(2, model.get("sk_nama"));
            state.setString(3, model.get("sk_kelas"));
            state.setString(4, model.get("sk_kode"));

            state.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StandarKompetensiController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBDriver.close(conn, state);
        }
    }

    @Override
    public void delete(BaseModel model) {
        Connection conn = null;
        PreparedStatement state = null;
        try {
            conn = DBDriver.getConnection();
            state = conn.prepareStatement("DELETE FROM standar_kompetensi WHERE sk_kode = ?");

            state.setString(1, model.get("sk_kode"));

            state.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StandarKompetensiController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBDriver.close(conn, state);
        }
    }

    @Override
    public List<BaseModel> selectByParameter(String parameter) {
        List<BaseModel> models = new ArrayList<BaseModel>();
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            conn = DBDriver.getConnection();
            state = conn.prepareStatement("SELECT * FROM standar_kompetensi WHERE sk_kode LIKE '%" + parameter + "%' or kompetensi_kode LIKE '%" + parameter + "%' or sk_nama LIKE '%" + parameter + "%' or sk_kelas LIKE '%" + parameter + "%'");
            result = state.executeQuery();

            while (result.next()) {
                StandarKompetensiModel model = new StandarKompetensiModel();

                model.set("sk_kode", result.getString("sk_kode"));
                model.set("kompetensi_kode", result.getString("kompetensi_kode"));
                model.set("sk_nama", result.getString("sk_nama"));
                model.set("sk_kelas", result.getString("sk_kelas"));

                models.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StandarKompetensiController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBDriver.close(conn, state, result);
        }
        return models;
    }
}
