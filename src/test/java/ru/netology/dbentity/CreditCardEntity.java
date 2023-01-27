package ru.netology.dbentity;

import lombok.*;

@Data
@NoArgsConstructor

public class CreditCardEntity {
    String id;
    String bank_id;
    String created;
    String status;
}