package com.clone.insta.Entities.Base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUTCTimeBaseEntity is a Querydsl query type for UTCTimeBaseEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUTCTimeBaseEntity extends EntityPathBase<UTCTimeBaseEntity> {

    private static final long serialVersionUID = 44110468L;

    public static final QUTCTimeBaseEntity uTCTimeBaseEntity = new QUTCTimeBaseEntity("uTCTimeBaseEntity");

    public final DateTimePath<java.time.OffsetDateTime> cdate = createDateTime("cdate", java.time.OffsetDateTime.class);

    public final DateTimePath<java.time.OffsetDateTime> mdate = createDateTime("mdate", java.time.OffsetDateTime.class);

    public QUTCTimeBaseEntity(String variable) {
        super(UTCTimeBaseEntity.class, forVariable(variable));
    }

    public QUTCTimeBaseEntity(Path<? extends UTCTimeBaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUTCTimeBaseEntity(PathMetadata metadata) {
        super(UTCTimeBaseEntity.class, metadata);
    }

}

