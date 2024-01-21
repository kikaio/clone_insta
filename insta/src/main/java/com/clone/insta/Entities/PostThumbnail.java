package com.clone.insta.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class PostThumbnail {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "psot_id", referencedColumnName = "id")
    @Column(nullable = false, unique = true)
    private Post id;

}
