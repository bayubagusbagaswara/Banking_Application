package com.bbb.bankingapplication.model.user;

import com.bbb.bankingapplication.model.base.UserAudit;
import com.bbb.bankingapplication.model.enumerator.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Ini untuk biodata user yang inti
 * atau yang digunakan oleh Bank untuk mengenali nasabahnya
 * CIF adalah Customer Information File, informasi yang berisi data lengkap mengenai Nasabah.
 * UserProfile digunakan utamanya untuk penggunaan Mobile Banking, karena tiap login harus membawa userProfileId, phoneNumber
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_profile", uniqueConstraints = {
        @UniqueConstraint(name = "user_profile_cif_unique", columnNames = "cif"),
        @UniqueConstraint(name = "user_profile_email_unique", columnNames = "email")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile extends UserAudit {

    @Id
    @SequenceGenerator(name="user_profile_seq", sequenceName="user_profile_seq", allocationSize=1)
    @GeneratedValue(generator="user_profile_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "cif", nullable = false)
    private String cif;

    @Column(name = "email", nullable = false)
    private String email;

    // default seperti dibawah tidak bisa otomatis ditulis di table
    @Column(name = "language", length = 3, columnDefinition="VARCHAR(3) default 'IDN'") // default IDR
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "name_alias")
    private String nameAlias;

    @Column(name = "phone_number")
    private String phoneNumber;

//    @Column(name = "profile_image_url")
//    private String profileImageUrl;

}
