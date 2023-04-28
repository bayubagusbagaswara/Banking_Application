package com.bbb.bankingapplication.model.ziswaf;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ziswaf_content_parameter")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafContentParameter extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category", length = 255)
    private String category;

    @Column(name = "code_ref", length = 255)
    private String codeRef;

    @Column(name = "label_en", length = 255)
    private String nameEn;

    @Column(name = "label_id", length = 255)
    private String nameId;

    @Column(name = "value", length = 255)
    private String value; // 10000

    @Column(name = "additional_data", columnDefinition = "TEXT")
    private String additionalData;

}
