package com.bbb.bankingapplication.model.account;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;

/**
 * ini adalah account (rekening) khusus untuk Haji
 * jadi user bisa memiliki rekening haji, jika user tersebut mendaftar
 * tapi user harus memiliki dulu rekening utama, misalnya Easy Wadiah
 * karena rekening utama tersebut menjadi dana sumber untuk tabungan haji
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account_haji")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountHaji extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // IDENTITAS DIRI
    @Column(name = "email")
    private String email;

    @Column(name = "religion")
    private String religion;

    @Column(name = "address")
    private String address;

    @Column(name = "id_district")
    private String districtId; // KABUPATEN/KOTA ID

    private String districtName; // KABUPATEN/KOTA NAME

    @Column(name = "id_province")
    private String provinceId; // PROVINSI ID



}
