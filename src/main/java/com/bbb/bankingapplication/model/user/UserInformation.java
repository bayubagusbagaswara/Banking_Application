package com.bbb.bankingapplication.model.user;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Informasi detail tentang user (nasabah)
 * seperti alamat rumah
 * Jadi UserInformation ini sebenarnya lebih lengkap dari UserProfile
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_information")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation extends UserAudit {

    @Id
    @GeneratedValue(generator = "user_information_seq")
    @SequenceGenerator(name = "user_information_seq", sequenceName = "user_information_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;
}
