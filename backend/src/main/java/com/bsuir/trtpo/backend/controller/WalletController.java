package com.bsuir.trtpo.backend.controller;

import com.bsuir.trtpo.backend.entity.Wallet;
import com.bsuir.trtpo.backend.service.serviceImpl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private WalletServiceImpl walletService;

    @Autowired
    public WalletController(WalletServiceImpl walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createWallet(@RequestBody Wallet wallet) {
        walletService.saveWallet(wallet);
        return ResponseEntity.ok("Wallet added");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getWalletByNumber(@RequestParam(name = "number") Long number) {
        return ResponseEntity.ok(walletService.getWalletByNumber(number));
    }
}
