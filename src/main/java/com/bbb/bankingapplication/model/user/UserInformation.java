package com.bbb.bankingapplication.model.user;

import com.bbb.bankingapplication.model.base.UserAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @JsonIgnore
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "gender")
    private String gender; // M or F

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "resident_type")
    private String residentType;

    @Column(name = "referral_code")
    private String referralCode;

    @Column(name = "address")
    private String address;

    @Column(name = "sud_district")
    private String subDistrict;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "job_position")
    private String jobPosition;

    @Column(name = "card_number_id")
    private String cardNumberId; // no induk karyawan

    @Column(name = "phone_home")
    private String phoneHome;

    @Column(name = "division")
    private String division;

    @Column(name= "postal_code")
    private String postalCode;

    @Column(name= "religion")
    private String religion;

    @Column(name= "nik")
    private String nik;
}
