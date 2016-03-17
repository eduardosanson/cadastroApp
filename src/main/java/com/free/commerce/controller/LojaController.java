package com.free.commerce.controller;

import com.free.commerce.entity.Loja;
import com.free.commerce.entity.UserLogin;
import com.free.commerce.service.interfaces.LoginService;
import com.free.commerce.service.interfaces.LojaService;
import com.free.commerce.to.StoreForm;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotBlank;
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
    private LojaService lojaService;

    @Autowired
    private LoginService loginService;

    private static final Logger logger =Logger.getLogger(LojaController.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StoreForm> cadastraLoja(@Valid StoreForm storeForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<StoreForm>(storeForm,HttpStatus.BAD_REQUEST);

        }else{

            return new ResponseEntity<StoreForm>(lojaService.realizarCadastroCompleto(storeForm),HttpStatus.CREATED);
        }
    }
//
//    @Valid @NotBlank(message = "Digite seu email")
//    @PathVariable("login") String login,
//    @Valid @NotBlank(message = "Digite sua senha")
//    @PathVariable("senha") String senha,
//    BindingResult bindingResult
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Loja> efetuarLogin(){
        UserLogin userLogin = new UserLogin();

        userLogin = loginService.recuperarPorEmail("eduardo@gmail.com");

        logger.info(userLogin);

        return new ResponseEntity<Loja>(lojaService.login(userLogin),HttpStatus.OK);

    }
}
