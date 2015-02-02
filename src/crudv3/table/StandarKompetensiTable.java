/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crudv3.table;

import crudv3.model.BaseModel;
import crudv3.model.StandarKompetensiModel;
import java.util.List;

/**
 *
 * @author auliayf
 */
public class StandarKompetensiTable extends BaseTable{

    public StandarKompetensiTable(List<BaseModel> models) {
        super(models, new StandarKompetensiModel());
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        StandarKompetensiModel model = (StandarKompetensiModel)mModels.get(rowIndex);
        switch(columnIndex){
            case 0:
                return model.get("sk_kode");
            case 1:
                return model.get("kompetensi_kode");
            case 2:
                return model.get("sk_nama");
            case 3:
                return model.get("sk_kelas");
        }
        return null;
    }
}
