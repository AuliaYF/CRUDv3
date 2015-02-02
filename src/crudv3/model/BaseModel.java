/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crudv3.model;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author auliayf
 */
public abstract class BaseModel {
    
    private HashMap<String, String> mMap = new HashMap<String, String>();
    /**
     *
     * @return
     */
    public abstract String[] getHeader();
    
    public void set(String key, String value){
        this.mMap.put(key, value);
    }
    
    public String get(String key){
        return this.mMap.get(key);
    }
}
