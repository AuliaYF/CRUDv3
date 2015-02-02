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
public class StandarKompetensiModel extends BaseModel {

    private String mSKKode;
    private String mKompetensiKode;
    private String mSKNama;
    private String mSKKelas;

    public StandarKompetensiModel() {

    }

    @Override
    public String[] getHeader() {
        return new String[]{"SK Kode", "Kompetensi Kode", "SK Nama", "SK Kelas"};
    }

}
