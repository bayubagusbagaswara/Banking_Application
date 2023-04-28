package com.bbb.bankingapplication.model.ziswaf;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ziswaf_category", uniqueConstraints = {
        @UniqueConstraint(name = "ziswaf_category_code_unique", columnNames = "code")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafCategory extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

}
