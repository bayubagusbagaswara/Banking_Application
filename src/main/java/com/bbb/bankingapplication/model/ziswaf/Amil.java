package com.bbb.bankingapplication.model.ziswaf;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "amil", uniqueConstraints = {
        @UniqueConstraint(name = "amil_code_unique", columnNames = "amil_code")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Amil extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMIL_CODE")
    private String amilCode;

    @Column(name = "AMIL_NAME")
    private String amilName;

    @Column(name = "AMIL_INITIAL")
    private String amilInitial;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "IMAGE")
    private String image;

}
