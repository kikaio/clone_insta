package com.clone.insta.Entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostThumbnail is a Querydsl query type for PostThumbnail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostThumbnail extends EntityPathBase<PostThumbnail> {

    private static final long serialVersionUID = -665236560L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostThumbnail postThumbnail = new QPostThumbnail("postThumbnail");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPost post;

    public QPostThumbnail(String variable) {
        this(PostThumbnail.class, forVariable(variable), INITS);
    }

    public QPostThumbnail(Path<? extends PostThumbnail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostThumbnail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostThumbnail(PathMetadata metadata, PathInits inits) {
        this(PostThumbnail.class, metadata, inits);
    }

    public QPostThumbnail(Class<? extends PostThumbnail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post")) : null;
    }

}

