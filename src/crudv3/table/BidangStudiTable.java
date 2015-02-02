/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudv3.table;

import crudv3.model.BaseModel;
import crudv3.model.BidangStudiModel;
import java.util.List;

/**
 *
 * @author auliayf
 */
public class BidangStudiTable extends BaseTable {

    public BidangStudiTable(List<BaseModel> models) {
        super(models, new BidangStudiModel());
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BidangStudiModel model = (BidangStudiModel) mModels.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return model.get("bidang_kode");
            case 1:
                return model.get("bidang_nama");
        }
        return null;
    }
}
