/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudv3.model;

/**
 *
 * @author auliayf
 */
public class BidangStudiModel extends BaseModel {

    public BidangStudiModel() {

    }

    @Override
    public String[] getHeader() {
        return new String[]{"Bidang Kode", "Bidang Nama"};
    }

}
