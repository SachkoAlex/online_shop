package com.bsuir.trtpo.backend.repository;

import com.bsuir.trtpo.backend.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Integer> {
    Wallet findWalletByNumber(Long number);
}
