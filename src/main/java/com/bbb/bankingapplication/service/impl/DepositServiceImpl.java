package com.bbb.bankingapplication.service.impl;

import com.bbb.bankingapplication.dto.DetailTabunganDto;
import com.bbb.bankingapplication.dto.UserAccountDTO;
import com.bbb.bankingapplication.dto.deposit.*;
import com.bbb.bankingapplication.dto.transfer.TransferRequestDTO;
import com.bbb.bankingapplication.model.enumerator.TransactionCurrency;
import com.bbb.bankingapplication.model.user.UserAccount;
import com.bbb.bankingapplication.model.user.UserProfile;
import com.bbb.bankingapplication.repository.UserAccountRepository;
import com.bbb.bankingapplication.repository.UserProfileRepository;
import com.bbb.bankingapplication.service.DepositService;
import com.bbb.bankingapplication.service.UserAccountService;
import com.bbb.bankingapplication.util.*;
import com.bbb.bankingapplication.util.constant.InvestAccountConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Value("${default.vakueDate.openAccDepo:false}")
    private Boolean flagDefaultValueDate;


    @Override
    public OpeningDepositResponse openingDeposit(OpeningDepositRequest request) {
//
//        // deposit intinya ada perhitungan bagi hasil antara total jumlah uang yg di depositkan dengan jangka waktu yg dipilih
//
//        String modulNameNisbahBank = "NISBAH_BAGI_HASIL_BANK";
//        String modulNameNisbahNasabah = "NISBAH_BAGI_HASIL_NASABAH";
//
//        String nisbahBankDefault = "75";
//        String nisbahNasabahDefault = "25";
//
//        // CHECK TIME PERIOD
//        if (request.getTimePeriod().equals(3)) {
//            modulNameNisbahBank = "NISBAH_BAGI_HASIL_BANK_3";
//            modulNameNisbahNasabah = "NISBAH_BAGI_HASIL_NASABAH_3";
//        } else if (request.getTimePeriod().equals(6)) {
//            modulNameNisbahBank = "NISBAH_BAGI_HASIL_BANK_6";
//            modulNameNisbahNasabah = "NISBAH_BAGI_HASIL_NASABAH_6";
//            nisbahBankDefault = "76";
//            nisbahNasabahDefault = "24";
//        }
//
//        ModuleNisbahResponse nisbahResponse = checkTimePeriodDeposit(request.getTimePeriod());
//
//        // AMBIL DATA USER
//        Long userProfileId = request.getUserProfileId();
//
//        // ambil data user (GetUserDataResponse), via userRepository
////        var userData = userManagementService.getUserData(userProfileId);
//        UserProfile userProfile = userProfileRepository.findById(userProfileId)
//                .orElseThrow(() -> new RuntimeException("User profile not found with id : [" + userProfileId + "]"));
//
//        // ambil CIF
//        String cif = userProfile.getCif();
//
//        // AMBIL DATA REQUEST
//
//        // ambil time period
//        Integer timePeriod = request.getTimePeriod();
//
//        // ambil account index (kita skip dulu)
////        var accountIndex = request.getAccountIndex();
//
//        // ambil amountDeposit
//        BigDecimal depositAmount = request.getDepositAmount();
//
//        // exception for CIF NOT FOUND or userProfile is null
////        if (userData == null || userData.getUserProfile().getCif() == null) {
////            throw new GenericException(InvestAccountConstant.DATA_NOT_FOUND_ERROR_CODE, "CIF not found");
////        }
//
//        // request untuk spec
//        // menghitung jatuh tempo (maturity). Jatuh tempo 1 bulan kedepan
//        LocalDateTime calculateMaturity = DateUtil.getCurrentDate().plusMonths(timePeriod);
////        String maturity = DateUtil.convertDate(calculateMaturity, "dd MMMM uuuu", DateUtil.getZoneIdLocal(), DateUtil.getLocale());
//        String maturityString = DateUtil.convertDate(calculateMaturity, "dd MMMM yyyy", DateUtil.getZoneIdLocal(), DateUtil.getLocale());
//
//        // dapatkan data UserAccount by userProfileId
////        UserAccountDTO userAccount = flowService.getUserAccount(userProfileId, accountIndex);
//        UserAccount userAccount = userAccountRepository.findByUserProfileId(userProfileId)
//                .orElseThrow(() -> new RuntimeException("User Account not found with user profile id : [" + userProfileId + "]"));
//
//        String accountNumber = userAccount.getAccountNumber();
//        String currency = request.getCurrency();
//        String accountOwnerName = userAccount.getAccountOwnerName();
//
////        var accountType = userAccount.getAccountType();
////        var accountAlias = userAccount.getAccountAlias();
//
//        // pengecekan rekening yang digunakan beserta handphone yang digunakan
//        validateAccountNo(accountNumber, metadata.getDeviceId());
//
//        // TRANSFER BIAYA MATERAI
//        String biayaMateraiString = "10000";
//
//        // biaya materai = stamp duty
//        BigDecimal biayaMaterai = new BigDecimal(10000);
//
//        // dapatkan biayaMaterai string
//        biayaMateraiString = getParameterMap(
//                prameterMap,
//                InvestAccountConstant.MODULE_DEPOSITO,
//                InvestAccountConstant.BIAYA_MATERAI,
//                biayaMateraiString
//        );
//
////        BigDecimal biayaMaterai = new BigDecimal(biayaMateraiString);
//
//        // Get Balance Inquiry (mengambil data balance)
//        List<String> listDto = new ArrayList<>();
//        listDto.add(InvestAccountConstant.SA);
//
//        // object response nya adalah BalanceInquiryCasaResponse
//        var inquiryListCasa = esbService.inquiryBalanceCasa(
//                BalanceInquiryCasaRq.builder()
//                        .accountNo(accountNumber)
//                        .balanceType(listDto)
//                        .additionalInfo(AdditionalInfoDto.builder().deviceId(metadata.getDeviceId()).build())
//                        .build()
//        );
//
//        String saldo = StringUtil.responseStrngValueMinLast3Digits(
//                inquiryListCasa.getAccountInfo().getBalance().getAvailableBalance(),
//                ".");
//
//        BigDecimal balanceAvilable = new BigDecimal(saldo);
//
//        // transaction ini darimana? dari object TransferRequestDTO
//        // kita buat object transferRequest
//        TransferRequestDTO transferRequest = TransferRequestDTO.builder()
//                .toAccountNumber(getAccountAdmin())
//                .fromAccountNumber(accountNumber)
//                .transactionDescription("Biaya Materai Pembukaan Deposito")
//                .transactionCurrency(TransactionCurrency.IDR.name())
//                .transactionAmount(biayaMaterai)
//                .build();
//
//        BigDecimal debit = biayaMaterai.add(depositAmount);
//        validateSaldo(balanceAvilable, debit);
//
//        // handle format value date
//        // flagDefaultValueDate diambil dari nilai di property
//        String bookingDate = DepositUtil.getValueDate(flagDefaultValueDate);
//
//        String idDepo;
//
//        Calendar now = Calendar.getInstance();
//
//        String mudTenor = GeneralUtil.generateMudTenor(String.valueOf(timePeriod));
//
//        String messageId = GeneralUtil.customRandomString(String.valueOf(userProfileId), 10);
//
//        // new
//        String mudbilyet = GeneralUtil.customRandomNumber("S" + DateUtil.convertDate(LocalDateTime.now(), "yyMMdd", DateUtil.getZoneIdLocal(), DateUtil.getLocale()), 10);
//
//        // Aro Or No Arro
//        String depositType = request.getSystemDeposit();
//        String aroOption = DepositUtil.systemDepositAroOption(depositType);
//        String nroOption = DepositUtil.systemDepositNroOption(depositType);
//        String maturity = DepositUtil.systemDepositMaturity(depositType);
//
//        // Request Spec ESB
//        OpenAccountDepositRequest req = OpenAccountDepositRequest.builder()
//                .messageId(messageId)
//                .cif(cif)
//                .currency(currency)
//                .accountOfficer("1")
//                .interestLiquAcct(String.valueOf(accountNumber))
//                .amnestyFlag("")
//                .company(request.getBranchCode())
//                .principal(String.valueOf(depositAmount))
//                .valueDate(bookingDate)
//                .repayAccount(String.valueOf(accountNumber))
//                .nominatedAccount(String.valueOf(accountNumber))
//                .maturityInstr(maturity)
//                .mudprintednam(accountOwnerName)
//                .descProdDpk(request.getDepositPurpose())
//                .mudbilyet(mudbilyet)
//                .mudTenor(mudTenor)
//                .mudNisbah("")
//                .zakat("N")
//                .aroOption(aroOption)
//                .nroOption(nroOption)
//                .qqName("")
//                .taxAble("")
//                .noRefferal("")
//                .acopenpurpose("11")
//                .lock("")
//                .refOutSource("")
//                .refProgram("")
//                .eventCode("")
//                .build();
//
//        req.setDeviceId(metadata.getDeviceId());
//        log.info("request open account {}", req);
//
//        var resposeESB = openAccountDepoSvc.openAccountDeposito(req);
//        log.info("response open account ESB {}", resp);
//
//        if (!StringUtils.isEmpty(resposeESB.getErrorCode())
//                && !resposeESB.getResponseCode().equals("00")) {
//            throw new GenericException(InvestAccountConstant.FAILED_OPENING_ACCOUNT, "Error from ESB");
//        }
//
//        resp = resposeESB;
//
//        trxMaterai = transferIntraBank(transaction, "Opening");
//
//        if (!trxMaterai.getResponseCode().equals("00")) {
//            throw new GenericException(InvestAccountConstant.FAILED_OPENING_ACCOUNT, "Error from ESB transferIntraBank");
//        }
//
//        var terminal = userData.getUserProfile().getPhoneNumber();
//        var result = resp.getResult();
//
//        idDepo = result.getId();
//
//        var coCode = result.getCoCode();
//        var posityoType = result.getPositionType();
//        var noStruk = transactionHistoryManagementService.generateTransactionId();
//
//        transactionStore.setTransactionId(noStruk);
//
//        var dataBranchLocation = parameterManagementService.getBranchByBranchCode(GetLocationByBranchCodeRq.builder()
//                .branchCode(request.getBranchCode())
//                .build());
//
//        var branchNameLocation = "";
//
//        if (dataBranchLocation == null) {
//            branchNameLocation = request.getBranchCode();
//        } else {
//            branchNameLocation = dataBranchLocation.getBranchLocations().getBranchName();
//        }
//
//        BigDecimal totalTransaksi = depositAmount.add(biayaMaterai);
//
//        // tanggal jatuh tempo
//        Calendar maturityDate = Calendar.getInstance();
//        maturityDate.setTime(new Date());
//        maturityDate.set(Calendar.MONTH, maturityDate.get(Calendar.MONTH) + periode);
//
//        // SIMPAN DB
//        userManagementService.storeData(StoreDataDepositoRequest.builder()
//                .idDeposito(idDepo)
//                .cif(cif)
//                .systemDeposito(request.getSystemDeposit())
//                .noDeposito(mudbilyet)
//                .aroOption(aroOption)
//                .branchCode(request.getBranchCode())
//                .nroOption(nroOption)
//                .maturityInstr(maturity)
//                .nominatedAccount(accountNumber)
//                .mudbilyet(mudbilyet)
//                .amount(depositAmount)
//                .branchName(branchNameLocation)
//                .interestLiquAcct(accountNumber)
//                .repayAccount(accountNumber)
//                .accountIndex(request.getAccountIndex())
//                .coCode(coCode)
//                .positionType(posityoType)
//                .userProfileId(userProfileId)
//                .currency(currency)
//                .timePeriode(timePeriod)
//                .noStruk(noStruk)
//                .depositoPurpose(request.getDepositPurpose())
//                .terminal(terminal)
//                .build());
//
//        // RESPONSE UNTUK FE
//        DetailTabunganDto detailTabungan = DetailTabunganDto.builder().build();
//        detailTabungan.setNoDeposito(mudbilyet);
//        detailTabungan.setBranchOffice(StringUtil.upperCaseFirstWord(branchNameLocation));
//        detailTabungan.setFromAccountOwnerName(accountOwnerName);
//        detailTabungan.setTimePeriod(timePeriod + " Bulan");
//        detailTabungan.setBiayaMaterai(biayaMaterai);
//        detailTabungan.setNisbahBagiHasilBank(valueNisBank + "%");
//        detailTabungan.setMaturityDate(jatuhTempo);
//        detailTabungan.setDepositoAmount(request.getDepositoAmount());
//        detailTabungan.setSystemDeposito(request.getSystemDeposito());
//        detailTabungan.setNisbahBagiHasilNasabah(valueNisNasabah + "%");
//        detailTabungan.setAccountAlias(accountAlias);
//        openingDepositoRs.setId(idDepo);
//        openingDepositoRs.setCurrency(currency);
//        openingDepositoRs.setTerminal(userData.getUserProfile().getPhoneNumber());
//        openingDepositoRs.setTotalTransaksi(totalTransaksi);
//        openingDepositoRs.setDepositoPurpose(request.getDepositoPurpose());
//        openingDepositoRs.setAccountNumber(accountNumber);
//        openingDepositoRs.setAccountAlias(accountAlias);
//        openingDepositoRs.setDetailtabungan(detailTabungan);
//        openingDepositoRs.setAccountType(accountType);
//        openingDepositoRs.setNoStruk(noStruk);
//
//        activityStatus = ActivityStatus.SUCCESS;
//
//        //getCoreReff
//        var coreReffNo = getCoreRefFromHistortTrx(idDepo, metadata.getDeviceId());
//
//        /**Store data Transaction History management Service**/
//        transactionStore = constractTransactionOpenDeposito(openingDepositoRs, resp, userData);
//        transactionStore.setCoreRefNo(coreReffNo);
//        ArrayList<Object> transactionStatusData = generateDataOpenDeposito(openingDepositoRs, TEMPLATE_TRANSACTION_OPENING_DEPO_IDN);
//        ArrayList<Object> receiptData = generateDataReceiptOpenDepo(openingDepositoRs, transactionStore, TEMPLATE_RECEIPT_DATA_OPENING_DEPO_IDN);
//
//        Map<String, Object> mapReceipt = new HashMap<>();
//        //resi form redis / db
//        var dataObject = constructDataObjectPembukaan(openingDepositoRs,transactionStore);
//        ReceiptDataDtoV2 receiptDataDto = receiptService.generateReceiptV2(dataObject, transactionStore.getTransactionCategory().name(), userData.getUserProfile().getLanguage());
//
//        mapReceipt.put("transactionStatusData", null == receiptDataDto.getTransactionStatusData() ? transactionStatusData : receiptDataDto.getTransactionStatusData());
//        mapReceipt.put("receiptData", null == receiptDataDto.getReceiptData() ? receiptData : receiptDataDto.getReceiptData());
//        var additionalData3 = JsonBuilder.toJson(mapReceipt);
//        transactionStore.setAdditionalData3(additionalData3);
//        /**store data opening **/
//        var storeThms = flowService.storeTransactionHistory(transactionStore);
//
//        /** store biaya materai */
//        transactionStore.setCoreRefNo(trxMaterai.getData().getCustReffNo());
//        transactionStore.setEsbRefNo(trxMaterai.getPartnerReferenceNo());
////			getModule()
//        transactionStore.setToAccountNumber(getAccountAdmin());
//        flowService.storeTransactionHistory(transactionStore);
//
//        openingDepositoRs.setTransactionStatusData( null == receiptDataDto.getTransactionStatusData() ? transactionStatusData : receiptDataDto.getTransactionStatusData());
//        openingDepositoRs.setReceiptData(null == receiptDataDto.getReceiptData() ? receiptData : receiptDataDto.getReceiptData());
//
//        var reqSenNotif = SendNotificationRequest.builder()
//                .additionalData3(additionalData3)
//                .additionalData2(JsonBuilder.toJson(transactionStore)).build();
//
//        // SEND NOTIFICATION EMAIL
//        notificationManagementService.sendNotificationEmailDeposito(userData,
//                DepositoRequest.builder()
//                        .depositoAmount(amountDeposito)
//                        .depositoPurpose(request.getDepositoPurpose())
//                        .accountNumber(accountNumber)
//                        .branchName(branchNameLocation)
//                        .transactionStatus(TransactionStatus.SUCCESS.name())
//                        .transactionCategory(TransactionCategory.INVEST_OPENING_DEPOSITO.name())
//                        .totalTransaksi(totalTransaksi)
//                        .transactionId(storeThms.getTransactionHistory().getTransactionId())
//                        .biayaAdmin(biayaMaterai)
//                        .accountOwnerName(accountOwnerName)
//                        .maturityDate(maturityDate.getTime().getTime())
//                        .noDeposito(mudbilyet)
//                        .timePeriod(periode + " Bulan")
//                        .rekeningDeposito(idDepo)
//                        .depositoType(request.getSystemDeposito())
//                        .nisbahBagiHasilBank(valueNisBank + "%")
//                        .nisbahBagiHasilNasabah(valueNisNasabah + "%")
//                        .noStruk(noStruk)
//                        .terminal(terminal)
//                        .currency(currency)
//                        .build(), TemplateCodeConstant.TEMPLATE_OPENING_DEPOSITO, reqSenNotif
//        );
//
//        deleteListDeposito(String.valueOf(userProfileId));
//        // RESPONSE CODE
//        errorDetail = ErrorDetailUtil.constructSuccessErrorCode();
//        activityStatus = ActivityStatus.SUCCESS;
//        openingDepositoRs.setTransactionStatus(TransactionStatus.SUCCESS);
//        openingDepositoRs.setResponseCode(errorDetail.getErrorCode());
//        openingDepositoRs.setResponseMessage(errorDetail.getMessage());
//    } catch (Exception e) {
//        errorDetail = ErrorUtil.getErrorDetail(e);
//        openingDepositoRs.setTransactionStatus(TransactionStatus.FAILED);
//        openingDepositoRs.setResponseCode(errorDetail.getErrorCode());
//        openingDepositoRs.setResponseMessage(errorDetail.getMessage());
//        log.info("Error opening deposit : {}", errorDetail, e);
//        throw e;
//    } finally {
//        auditManagementService.sendAuditData(metadata, ActivityName.DEPOSITO_OPENING_DEPOSITO, activityDate,
//                activityStatus, ActivityCategory.INVEST_DEPOSITO);
//
//        if (null == resp.getResult()) {
//            throw new GenericException(errorDetail.getErrorCode(), errorDetail.getMessage());
//        }
//        if (null == trxMaterai.getResponseCode()) {
//            throw new GenericException(InvestAccountConstant.FAILED_OPENING_ACCOUNT, errorDetail.getMessage());
//        } else if (!openingDepositoRs.getResponseCode().equals("00")) {
//            throw new GenericException(errorDetail.getErrorCode(), "Error Open Account");
//        }
//
//        return openingDepositoRs;
        return null;
    }

        // biasanya memilih deposit dengan ketentuan bagi hasil yang berbeda dengan jangka waktu juga berbeda
        // karena itu nanti akan masuk dalam perhitungan bagi hasil dalam setahun

//        return null;

    @Override
    public UpdateDepositResponse updateDeposit(UpdateDepositRequest request) {
        // get list deposit by user profile id
        // request membawa data mPin, depositId, depositSystem;

        // RESPONSE changeDepositResponse atau UpdateDepositResponse

        UpdateDepositResponse updateDepositResponse = new UpdateDepositResponse();

        updateDepositResponse.setBankName("BSI");

//        changeDepositoRs.setBankName("BSI");
//        changeDepositoRs.setTabunganSumber(nominatedAccount);
//        changeDepositoRs.setId(request.getIdDeposito());
//        changeDepositoRs.setSystemDeposito(request.getSystemDeposito());
//        changeDepositoRs.setMudbilyet(detailDto.getMudBilyet());
//        changeDepositoRs.setListDetail(detailTabungan);
//        changeDepositoRs.setAccountAlias(accountAlias);
//        changeDepositoRs.setAccountType(accountType);
//        changeDepositoRs.setDepositoPurpose(detailDto.getDepositoPurpose());
//        changeDepositoRs.setAccountOwnerName(ownerName);

        return null;
    }

    // Efektif Bagi Hasil = amount + keuntungan bagi hasil (calculation for effective profit sharing)
    private static HitungNisbahResponse calculationForEffectiveProfitSharing(BigDecimal depositAmount, Integer timePeriod) {

        HitungNisbahResponse response = HitungNisbahResponse.builder().build();

        // CEK TIME PERIOD
        ModuleNisbahResponse nisbahResponse = checkTimePeriodDeposit(timePeriod);

        // CEK MODULE UNTUK MENDAPATKAN VALUE NISBAH
        GetSysParamByModuleAndNameResponse nisbahBank = getSysParamByModuleAndName(
                DepositConstant.MODULE_NAME_DEPOSIT,
                nisbahResponse.getModuleNameNisbahBank());

        GetSysParamByModuleAndNameResponse nisbahNasabah = getSysParamByModuleAndName(
                DepositConstant.MODULE_NAME_DEPOSIT,
                nisbahResponse.getModuleNameNisbahNasabah());

        // pendapatan kotor
        GetSysParamByModuleAndNameResponse grossRevenue = getSysParamByModuleAndName(
                DepositConstant.MODULE_NAME_DEPOSIT,
                "GROSS_REVENUE");

        String valueNisBank = nisbahBank.getValue() == null || nisbahBank.getValue().equalsIgnoreCase("") ? DepositConstant.NISBAH_BANK_DEFAULT : nisbahBank.getValue();

        String valueNisNasabah = nisbahNasabah.getValue() == null ? DepositConstant.NISBAH_NASABAH_DEFAULT : nisbahNasabah.getValue();

        // jika grossRevenue == null, maka isi dengan "9". Jika tidak null, maka ambil getValuenya
        // kita coba isi null aja dulu
        String valueGR = grossRevenue.getValue() == null ? "9" : grossRevenue.getValue();

        // value to Bigdecimal
        BigDecimal bDecNisNasabah = new BigDecimal(valueNisNasabah);
        BigDecimal bDecGR = new BigDecimal(valueGR);

        // big decimal di bagi 100 atau menyesuaikan nilai satuan persen
        BigDecimal persen = new BigDecimal(100);

        BigDecimal nisNasabahPersen = bDecNisNasabah.divide(persen, 3, RoundingMode.CEILING);

        BigDecimal gRpersen = bDecGR.divide(persen, 3, RoundingMode.CEILING);

        // Bunga = GR x nisbahnasabah
        BigDecimal bunga = gRpersen.multiply(nisNasabahPersen);

        // asumsi bagi hasil pertahun = bunga x nominal deposito
        BigDecimal estimasipertahun = depositAmount.multiply(bunga);

        estimasipertahun = new BigDecimal(GeneralUtil.printCustomBigDecimalFormat(estimasipertahun, "####"));

        // asumsi bagi hasil perbulan = asumsi bagi hasil pertahun : nominal deposito
        BigDecimal estimasiperbulan = estimasipertahun.divide(new BigDecimal(12), RoundingMode.HALF_DOWN);

        // asumsi bagi hasil per priode = asumsi bagi hasil perbulan x periode
        // result ini adalah estimasi perbulan
        BigDecimal result = estimasiperbulan.multiply(new BigDecimal(timePeriod));

        result = new BigDecimal(GeneralUtil.printCustomBigDecimalFormat(result, "####"));

        var timePeriodMonthly = timePeriod + " Bulan";

        response.setResult(result);
        response.setTimePeriod(timePeriodMonthly);
        response.setDepositAmount(depositAmount);
        response.setNisbahBagiHasilBank(valueNisBank + "%");
        response.setNisbahBagiHasilNasabah(valueNisNasabah + "%");

        return response;
    }

    private static ModuleNisbahResponse checkTimePeriodDeposit(Integer timePeriod) {
        // jadi pengecekan ini berdasarkan timePeriod 3 bulan atau 6 bulan
        // balikannya adalah data string module nisbah dan nilai nisbah
        ModuleNisbahResponse nisbahResponse = new ModuleNisbahResponse();

        if (timePeriod.equals(3)) {
            nisbahResponse.setModuleNameNisbahBank(DepositConstant.MODULE_NAME_NISBAH_BANK_3);
            nisbahResponse.setModuleNameNisbahNasabah(DepositConstant.MODULE_NAME_NISBAH_NASABAH_3);
            nisbahResponse.setNisbahBank(DepositConstant.NISBAH_BANK_3);
            nisbahResponse.setNisbahNasabah(DepositConstant.NISBAH_NASABAH_3);

        } else if (timePeriod.equals(6)) {
            nisbahResponse.setModuleNameNisbahBank(DepositConstant.MODULE_NAME_NISBAH_BANK_6);
            nisbahResponse.setModuleNameNisbahNasabah(DepositConstant.MODULE_NAME_NISBAH_NASABAH_6);
            nisbahResponse.setNisbahBank(DepositConstant.NISBAH_BANK_6);
            nisbahResponse.setNisbahNasabah(DepositConstant.NISBAH_NASABAH_6);

        } else {
            nisbahResponse.setModuleNameNisbahBank(DepositConstant.MODULE_NAME_NISBAH_BANK);
            nisbahResponse.setModuleNameNisbahNasabah(DepositConstant.MODULE_NAME_NISBAH_NASABAH);
            nisbahResponse.setNisbahBank(DepositConstant.NISBAH_BANK_DEFAULT);
            nisbahResponse.setNisbahNasabah(DepositConstant.NISBAH_NASABAH_DEFAULT);
        }

        return nisbahResponse;
    }

    private static GetSysParamByModuleAndNameResponse getSysParamByModuleAndName(String module, String name) {
        // pengecekan menurut name saja, karena module nya cuma DEPOSIT, jadi pengecekan by module bisa di method utama

        // create object GetSysParamByModuleAndNameResponse, nanti setValue nya yang berubah tergantung hasil pengecekan
        GetSysParamByModuleAndNameResponse response = new GetSysParamByModuleAndNameResponse();

        if (DepositConstant.MODULE_NAME_DEPOSIT.equalsIgnoreCase(module)
                && DepositConstant.NISBAH_BAGI_HASIL_BANK_3.equalsIgnoreCase(name)) {
            response.setValue("75");

        } else if (DepositConstant.MODULE_NAME_DEPOSIT.equalsIgnoreCase(module)
                && DepositConstant.NISBAH_BAGI_HASIL_NASABAH_3.equalsIgnoreCase(name)) {
            response.setValue("25");

        } else if (DepositConstant.MODULE_NAME_DEPOSIT.equalsIgnoreCase(module)
                && DepositConstant.NISBAH_BAGI_HASIL_BANK_6.equalsIgnoreCase(name)) {
            response.setValue("76");

        } else if (DepositConstant.MODULE_NAME_DEPOSIT.equalsIgnoreCase(module)
                && DepositConstant.NISBAH_BAGI_HASIL_NASABAH_6.equalsIgnoreCase(name)) {
            response.setValue("24");
        } else {
            response.setValue("");
        }

        return response;
    }


//    public void validateAccountNo(String accountNo, String deviceId) {
//        var response = svcInquiryTransfer.inquiryAccount(TransferRequestDto.builder()
//                .toAccountNumber(accountNo)
//                .channelDeviceId(deviceId)
//                .build());
//
//        var beneficiaryAccountRestrictStatus = response.getData().getDestAccountStatusRestrictStatus();
//
//        var accountStatus = response.getData().getDestAccountStatus();
//
//        if (accountStatus.equals("Dormant")) {
//            throw new GenericException(InvestAccountConstant.FAILED_OPENING_ACCOUNT_NO_REKENING_DORMANT, "Rekening yang dilakukan transaksi rekening dormant");
//        }
//
//        if (!beneficiaryAccountRestrictStatus.isEmpty()) {
//            if (beneficiaryAccountRestrictStatus.equals("Tidak Boleh Entry")) {
//                throw new GenericException(InvestAccountConstant.FAILED_OPENING_ACCOUNT_NO_REKENING_BLOKIR, "Rekening yang dilakukan transaksi rekening terblokir");
//            }
//        }
//    }

//    public ValidateOpenDeposito validateSaldo(BigDecimal balance, BigDecimal debit) {
//        log.info("Start validate saldo");
//        var errorDetail = new ErrorDetail();
//        try {
//            if (balance.compareTo(debit) < 0) {
//                throw new GenericException(InvestConstant.OPENING_DEPOSITO_SALDO_LESS_MIN, "saldo tidak cukup");
//            }
//            return ValidateOpenDeposito.builder().valid(true).build();
//        } catch (Exception e) {
//            errorDetail = ErrorUtil.getErrorDetail(e);
//            log.info("error validateOpeningDeposito, detail : {}, exception : {}", errorDetail, e);
//            throw e;
//        }
//    }

//    public String getAccountAdmin() {
//        var getModul = getBiayaAdmin();
//        String getAccountAdmin = "IDR1715500030001";
//        var biayaAdmin = getModul.getBiayaAdmin().stream().filter(data -> List.of(InvestAccountConstant.ACCOUNT_ADMIN).contains(data.getLabel1())).collect(Collectors.toList());
//        log.info("biayaAdmin {}", biayaAdmin);
//        if (null != biayaAdmin) {
//            if (!biayaAdmin.isEmpty()) {
//                getAccountAdmin = biayaAdmin.get(0).getValue();
//            }
//        }
//        return getAccountAdmin;
//    }

//    public GetAllModuleData getBiayaAdmin() {
//        var response = GetAllModuleData.builder().build();
//
//        List<BusinessParameterDto> admin = new ArrayList<>();
//        var adminFeePencairan = BusinessParameterDto.builder().build();
//        var adminFeeUbahSystem = BusinessParameterDto.builder().build();
//        var adminBiayaMaterai = BusinessParameterDto.builder().build();
//        var noRek = BusinessParameterDto.builder().build();
//
//        List<String> moduleList = new ArrayList<>();
//        moduleList.add(InvestAccountConstant.MODULE_ACCOUNT);
//        moduleList.add(InvestAccountConstant.MODULE_DEPOSITO);
//        var sytemParam = parameterManagementService.getSystemParameter(GetSystemParameterRequest.builder().moduleList(moduleList).build());
//
//        //admin pembukaan
//        var valueAdminMaterai = "10000";
//        valueAdminMaterai = getParameterMap(sytemParam, InvestAccountConstant.MODULE_DEPOSITO, InvestAccountConstant.BIAYA_MATERAI, valueAdminMaterai);
//        adminBiayaMaterai.setModule(InvestAccountConstant.MODULE_DEPOSITO);
//        adminBiayaMaterai.setName(StringUtil.formatAmount(new BigDecimal(valueAdminMaterai), "Rp #,###").replace(",", "."));
//        adminBiayaMaterai.setValue(valueAdminMaterai);
//        adminBiayaMaterai.setDescription("biaya admin pembukaan");
//        adminBiayaMaterai.setOrdering(1);
//        adminBiayaMaterai.setLabel1(InvestAccountConstant.BIAYA_MATERAI);
//        admin.add(adminBiayaMaterai);
//
//        //admin ubah system
//        var valueUbahSystem = "10000";
//        valueUbahSystem = getParameterMap(sytemParam, InvestAccountConstant.MODULE_DEPOSITO, InvestAccountConstant.ADMIN_FEE_UBAH_SYSTEM, valueUbahSystem);
//        adminFeeUbahSystem.setModule(InvestAccountConstant.MODULE_DEPOSITO);
//        adminFeeUbahSystem.setName(StringUtil.formatAmount(new BigDecimal(valueUbahSystem), "Rp #,###").replace(",", "."));
//        adminFeeUbahSystem.setValue(valueUbahSystem);
//        adminFeeUbahSystem.setDescription("biaya admin Ubah System");
//        adminFeeUbahSystem.setOrdering(2);
//        adminFeeUbahSystem.setLabel1(InvestAccountConstant.ADMIN_FEE_UBAH_SYSTEM);
//        admin.add(adminFeeUbahSystem);
//
//        // admin pencairan
//        var valuePencairan = "25000";
//        valuePencairan = getParameterMap(sytemParam, InvestAccountConstant.MODULE_DEPOSITO, InvestAccountConstant.ADMIN_FEE_PENCAIRAN, valuePencairan);
//        adminFeePencairan.setModule(InvestAccountConstant.MODULE_DEPOSITO);
//        adminFeePencairan.setName(StringUtil.formatAmount(new BigDecimal(valuePencairan), "Rp #,###").replace(",", "."));
//        adminFeePencairan.setValue(valuePencairan);
//        adminFeePencairan.setDescription("biaya admin pencairan");
//        adminFeePencairan.setOrdering(3);
//        adminFeePencairan.setLabel1(InvestAccountConstant.ADMIN_FEE_PENCAIRAN);
//        admin.add(adminFeePencairan);
//
//        // admin rekening
//        var rekeningAdmin = "IDR1715500030001";
//        rekeningAdmin = getParameterMap(sytemParam, InvestAccountConstant.MODULE_ACCOUNT, InvestAccountConstant.ACCOUNT_ADMIN, rekeningAdmin);
//        noRek.setModule(InvestAccountConstant.MODULE_ACCOUNT);
//        noRek.setValue(rekeningAdmin);
//        noRek.setName(rekeningAdmin);
//        noRek.setDescription("rekening admin");
//        noRek.setOrdering(4);
//        noRek.setLabel1(InvestAccountConstant.ACCOUNT_ADMIN);
//        admin.add(noRek);
//
//        response.setBiayaAdmin(admin);
//        return response;
//    }

}
