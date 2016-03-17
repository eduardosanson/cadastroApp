package com.free.commerce.controller;

import com.free.commerce.service.interfaces.LojaSerice;
import com.free.commerce.to.StoreForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by eduardosanson on 05/03/16.
 */

@RestController("/v1/loja")
public class LojaController extends WebMvcConfigurerAdapter {

    @Autowired
    private LojaSerice lojaService;

    private static final Logger logger =Logger.getLogger(LojaController.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StoreForm> cadastraLoja(@Valid StoreForm storeForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<StoreForm>(HttpStatus.BAD_REQUEST);

        }else{

            return new ResponseEntity<StoreForm>(lojaService.realizarCadastroCompleto(storeForm),HttpStatus.CREATED);
        }
    }
}
