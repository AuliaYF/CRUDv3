/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudv3.controller;

import crudv3.model.BaseModel;
import java.util.List;

/**
 *
 * @author auliayf
 */
public interface BaseController {

    public void insert(BaseModel model);

    public List<BaseModel> selectAll();
    
    public List<BaseModel> selectByParameter(String parameter);

    public void update(BaseModel model);

    public void delete(BaseModel model);
}
