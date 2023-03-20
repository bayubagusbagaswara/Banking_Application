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
import java.util.Date;

/**
 * Ini untuk biodata user yang inti
 * atau yang digunakan oleh Bank untuk mengenali nasabahnya
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_profile")
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

    @Column(name = "cif")
    private String cif;

    @Column(name = "email")
    private String email;

    @Column(name = "failed_forgot_password_attempts")
    private int failedForgotPasswordAttempts;

    @Column(name = "failed_forgot_user_id_attempts")
    private int failedForgotUserIdAttempts;

    @Column(name = "failed_login_attempts")
    private int failedLoginAttempts;

    @Column(name = "failed_otp_attempts")
    private int failedOTPAttempts;

    @Column(name = "failed_soft_token_attempts")
    private int failedSoftTokenAttempts;

    @Column(name = "first_login")
    private Boolean firstLogin;

    @Column(name = "language", length = 3)
    private String language;

    @Column(name = "last_failed_login")
    private Date lastFailedLogin;

    @Column(name = "name_alias")
    private String nameAlias;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "quick_access")
    private boolean quickAccess;

    @Column(name = "register_atm")
    private Boolean registerATM;

    @Column(name = "user_status")
    private int userStatus;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Column(name = "sid")
    private String sid;

    @Column(name = "sid_status")
    private String sidStatus;
}
