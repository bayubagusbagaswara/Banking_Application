package com.bbb.bankingapplication.model.ziswaf;

import com.bbb.bankingapplication.model.base.UserAudit;
import lombok.*;

import javax.persistence.*;

/**
 * Ini difungsikan sebagai table many to many
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ziswaf_amil")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZiswafAmil extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nama ziswaf category

}
