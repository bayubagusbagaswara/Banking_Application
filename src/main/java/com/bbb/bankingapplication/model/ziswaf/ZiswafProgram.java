package com.bbb.bankingapplication.model.ziswaf;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ziswaf_program")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafProgram extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "program_module", length = 255)
    private String programModule;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "VALUE", length = 255)
    private String value;

    @Column(name =  "DESCRIPTION" , length = 255)
    private String description;

    @Column(name = "LABELID", length = 255)
    private String labelId;

    @Column(name = "LABEL_EN", length = 255)
    private String labelEn;

    @Column(name = "STARTDATE")
    private Date startDate;

    @Column(name = "ENDDATE" )
    private Date endDate;

    @Column(name = "ICON" , length = 255)
    private String icon;

    @Column(name = "IMAGE", length = 255)
    private String image;

    @Column(name = "ADDITIONAL_DATA")
    private String additionalData;

    @Column(name = "STATUS")
    private Boolean status;

}
