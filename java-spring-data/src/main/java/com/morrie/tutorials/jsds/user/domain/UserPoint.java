package com.morrie.tutorials.jsds.user.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "amount"})
public class UserPoint {
    @Id
    private String id;
    private Long amount;

    @Builder
    public UserPoint(String id, Long amount) {
        this.id = id;
        this.amount = amount;
    }
}
