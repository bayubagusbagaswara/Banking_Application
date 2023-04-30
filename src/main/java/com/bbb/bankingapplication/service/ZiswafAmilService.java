package com.bbb.bankingapplication.service;

import com.bbb.bankingapplication.dto.ziswaf.amil.AmilDTO;
import com.bbb.bankingapplication.dto.ziswaf.amil.CreateAmilRequest;
import com.bbb.bankingapplication.model.ziswaf.Amil;
import com.bbb.bankingapplication.model.ziswaf.ZiswafCategory;

/**
 * Ini sebenarnya table many to many antara Amil dengan Ziswaf Category
 * Jadi 1 Amil bisa memilik banyak Ziswaf Category, begitu juga sebaliknya
 */
public interface ZiswafAmilService {

    // intinya disini kita hubungkan/relasikan antara Amil dengan Ziswaf Category
    // tapi kita bikin table ZiswafAmil, data kolom nya adalah gabungan beberapa data antara ZiswafCategory dan Amil
    // jika kita createZiswafAmil, maka request nya harus juga mengirimkan code ZiswafCategory dan code Amil

    void createZiswafAmil(String amilCode, String ziswafCategoryCode);

    // harusnya parameter nya adalah Amil dan Ziswaf Category, lalu kita ambil data-datanya, masukkan ke ZiswafAmil

    // get amil

    //get list amil

    // update amil

    // delete amil
}
