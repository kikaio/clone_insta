package com.clone.insta.Entities.Base;

import java.time.OffsetDateTime;
import java.time.ZoneId;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UTCTimeBaseEntity {

    @Column
    private OffsetDateTime cdate;

    @Column
    private OffsetDateTime mdate;

    @PrePersist
    public void prePersist() {
        this.cdate = OffsetDateTime.now(ZoneId.of("UTC"));
        this.mdate = this.cdate;
    }

    @PreUpdate
    public void preUpdate() {
        this.mdate = OffsetDateTime.now(ZoneId.of("UTC"));
    }
}
