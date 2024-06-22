package com.tdf.tarjeta.service;

import com.tdf.tarjeta.model.Merchant;
import com.tdf.tarjeta.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MerchantService implements MerchantServiceInterface{

    @Autowired
    private MerchantRepository merchantRepository;


    @Override
    public List<Merchant> getAllMerchant() {
        return merchantRepository.findAll();
    }
}
