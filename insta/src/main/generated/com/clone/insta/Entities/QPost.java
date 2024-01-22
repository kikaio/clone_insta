package com.clone.insta.Entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -1202809700L;

    public static final QPost post = new QPost("post");

    public final com.clone.insta.Entities.Base.QUTCTimeBaseEntity _super = new com.clone.insta.Entities.Base.QUTCTimeBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> cdate = _super.cdate;

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> mdate = _super.mdate;

    public QPost(String variable) {
        super(Post.class, forVariable(variable));
    }

    public QPost(Path<? extends Post> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost(PathMetadata metadata) {
        super(Post.class, metadata);
    }

}

