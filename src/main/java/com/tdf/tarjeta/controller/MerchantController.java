package com.tdf.tarjeta.controller;

import com.tdf.tarjeta.model.Merchant;
import com.tdf.tarjeta.service.MerchantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/merchants")
public class MerchantController {

    @Autowired
    private MerchantServiceInterface merchantServiceInterface;

    @GetMapping
    private List<Merchant> getAllMerchant(){
        return merchantServiceInterface.getAllMerchant();
    }
}
