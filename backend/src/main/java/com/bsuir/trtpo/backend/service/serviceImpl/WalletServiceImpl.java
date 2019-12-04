package com.bsuir.trtpo.backend.service.serviceImpl;

import com.bsuir.trtpo.backend.entity.Wallet;
import com.bsuir.trtpo.backend.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl {

    private WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public void saveWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    public Wallet getWalletByNumber(Long number) {
        return walletRepository.findWalletByNumber(number);
    }
}
