package com.clone.insta.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class PostThumbnail {

    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_post_id"), unique = true)
    @ToString.Exclude
    private Post post;

}
