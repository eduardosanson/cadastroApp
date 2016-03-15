package com.free.commerce.controller;

import com.free.commerce.response.CadastroResponse;
import com.free.commerce.service.interfaces.LojaSerice;
import com.free.commerce.to.StoreForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by eduardosanson on 05/03/16.
 */

@RestController("/v1/loja")
public class ClienteController extends WebMvcConfigurerAdapter {

    @Autowired
    private LojaSerice lojaService;

    private static final Logger logger =Logger.getLogger(ClienteController.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public CadastroResponse cadastraLoja(@Valid StoreForm storeForm, BindingResult bindingResult){



        return lojaService.realizarCadastroCompleto(storeForm);
    }



}
