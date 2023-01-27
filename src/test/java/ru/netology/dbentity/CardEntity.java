package ru.netology.dbentity;


import lombok.*;

@Data
@NoArgsConstructor

public class CardEntity {
    String id;
    String created;
    String credit_id;
    String payment_id;
}
