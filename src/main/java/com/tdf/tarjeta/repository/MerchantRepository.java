package com.tdf.tarjeta.repository;

import com.tdf.tarjeta.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,Long> {
}
