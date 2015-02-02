/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudv3.controller;

import crudv3.DBDriver;
import crudv3.model.BaseModel;
import crudv3.model.BidangStudiModel;
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
public class BidangStudiController implements BaseController {

    @Override
    public List<BaseModel> selectAll() {
        List<BaseModel> models = new ArrayList<BaseModel>();
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        try {
            conn = DBDriver.getConnection();
            state = conn.createStatement();
            result = state.executeQuery("SELECT * from bidang_studi");

            while (result.next()) {
                BidangStudiModel model = new BidangStudiModel();

                model.set("bidang_kode", result.getString("bidang_kode"));
                model.set("bidang_nama", result.getString("bidang_nama"));

                models.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BidangStudiModel.class.getName()).log(Level.SEVERE, null, ex);
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
            state = conn.prepareStatement("INSERT INTO bidang_studi VALUES(?, ?)");

            state.setString(1, model.get("bidang_kode"));
            state.setString(2, model.get("bidang_nama"));

            state.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BidangStudiController.class.getName()).log(Level.SEVERE, null, ex);
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
            state = conn.prepareStatement("UPDATE bidang_studi SET bidang_nama = ? WHERE bidang_kode = ?");

            state.setString(1, model.get("bidang_nama"));
            state.setString(2, model.get("bidang_kode"));

            state.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BidangStudiController.class.getName()).log(Level.SEVERE, null, ex);
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
            state = conn.prepareStatement("DELETE FROM bidang_studi where bidang_kode = ?");

            state.setString(1, model.get("bidang_kode"));

            state.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BidangStudiController.class.getName()).log(Level.SEVERE, null, ex);
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
            state = conn.prepareStatement("SELECT * FROM bidang_studi WHERE bidang_kode LIKE '%" + parameter + "%' or bidang_nama LIKE '%" + parameter + "%'");
            result = state.executeQuery();

            while (result.next()) {
                BidangStudiModel model = new BidangStudiModel();

                model.set("bidang_kode", result.getString("bidang_kode"));
                model.set("bidang_nama", result.getString("bidang_nama"));

                models.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BidangStudiController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBDriver.close(conn, state, result);
        }
        return models;
    }
}
