package com.free.commerce.service.interfaces;

import com.free.commerce.entity.Loja;
import com.free.commerce.entity.UserLogin;
import com.free.commerce.response.CadastroResponse;
import com.free.commerce.to.CadastroTo;
import com.free.commerce.to.StoreForm;

/**
 * Created by eduardosanson on 05/03/16.
 */
public interface LojaService {

    StoreForm realizarCadastroCompleto(StoreForm storeForm);

    Loja login(UserLogin userLogin);
}
