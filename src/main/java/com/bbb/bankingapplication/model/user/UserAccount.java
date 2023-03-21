package com.bbb.bankingapplication.model.user;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * ini adalah akun (jenis tabungan) milik nasabah
 * Nasabah (user) bisa memilik banyak akun
 * Jadi ini adalah informasi tentang Akun / rekening yang dipilih nasabah
 */
@Entity
@Table(name = "user_account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;


}
