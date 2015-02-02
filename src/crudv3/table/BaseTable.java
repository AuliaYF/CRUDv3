/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudv3.table;

import crudv3.model.BaseModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author auliayf
 */
public class BaseTable extends AbstractTableModel {

    private final BaseModel mModel;
    public final List<BaseModel> mModels;

    public BaseTable(List<BaseModel> models, BaseModel model) {
        this.mModels = models;
        this.mModel = model;
    }

    @Override
    public int getRowCount() {
        return mModels.size();
    }

    @Override
    public int getColumnCount() {
        return mModel.getHeader().length;
    }

    @Override
    public String getColumnName(int c) {
        return mModel.getHeader()[c];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
