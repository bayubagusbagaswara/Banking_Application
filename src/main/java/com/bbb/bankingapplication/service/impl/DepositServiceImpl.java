package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.deposit.OpeningDepositRequest;
import com.bbb.bankingapplication.dto.deposit.OpeningDepositResponse;
import com.bbb.bankingapplication.dto.deposit.UpdateDepositRequest;
import com.bbb.bankingapplication.dto.deposit.UpdateDepositResponse;
import com.bbb.bankingapplication.service.DepositService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepositServiceImpl implements DepositService {

    @Override
    public OpeningDepositResponse openingDeposit(OpeningDepositRequest request) {

        // deposit intinya ada perhitungan bagi hasil antara total jumlah uang yg didepositkan
        log.info("Start opening deposit : {}", request);
        String modulNameNisbahBank = "NISBAH_BAGI_HASIL_BANK";
        String modulNameNisbahNasabah = "NISBAH_BAGI_HASIL_NASABAH";

        String nisbahBankDefault = "75";
        String nisbahNasabahDefault = "25";

        if (request.getTimePeriod() == 3) {
            modulNameNisbahBank = "NISBAH_BAGI_HASIL_BANK_3";
            modulNameNisbahNasabah = "NISBAH_BAGI_HASIL_NASABAH_3";
        } else if (request.getTimePeriod() == 6) {
            modulNameNisbahBank = "NISBAH_BAGI_HASIL_BANK_6";
            modulNameNisbahNasabah = "NISBAH_BAGI_HASIL_NASABAH_6";
            nisbahBankDefault = "76";
            nisbahNasabahDefault = "24";
        }

        //nisbah
//        var nisbahBank = parameterManagementService.getSysParamByModuleAndName(InvestAccountConstant.MODULE_DEPOSITO,modulNameNisBank);
//        var nisbahNasabah = parameterManagementService.getSysParamByModuleAndName(InvestAccountConstant.MODULE_DEPOSITO,modulNameNisNasabah);

        //cek null system param
//        var valueNisBank = nisbahBank.getValue()==null?nisbahBankDefault:nisbahBank.getValue();
//        var valueNisNasabah = nisbahNasabah.getValue()==null?NisNasabahDefault:nisbahNasabah.getValue();

        // biasanya memilih deposit dengan ketentuan bagi hasil yang berbeda dengan jangka waktu juga berbeda
        // karena itu nanti akan masuk dalam perhitungan bagi hasil dalam setahun



        return null;
    }

    @Override
    public UpdateDepositResponse updateDeposit(UpdateDepositRequest request) {
        // get list deposit by user profile id

        return null;
    }
}
