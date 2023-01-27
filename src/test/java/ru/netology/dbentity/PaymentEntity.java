package ru.netology.dbentity;

import lombok.*;

@Data
@NoArgsConstructor
public class PaymentEntity {
    String id;
    String amount;
    String created;
    String status;
    String transaction_id;

}