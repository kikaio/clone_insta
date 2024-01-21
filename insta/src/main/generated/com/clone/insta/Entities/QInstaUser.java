package com.clone.insta.Entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QInstaUser is a Querydsl query type for InstaUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInstaUser extends EntityPathBase<InstaUser> {

    private static final long serialVersionUID = 1872821962L;

    public static final QInstaUser instaUser = new QInstaUser("instaUser");

    public final com.clone.insta.Entities.Base.QUTCTimeBaseEntity _super = new com.clone.insta.Entities.Base.QUTCTimeBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> cdate = _super.cdate;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isAccountExpired = createBoolean("isAccountExpired");

    public final BooleanPath isAccountNonLocked = createBoolean("isAccountNonLocked");

    public final BooleanPath isCredentialsNonExpired = createBoolean("isCredentialsNonExpired");

    public final BooleanPath isEnabled = createBoolean("isEnabled");

    //inherited
    public final DateTimePath<java.time.OffsetDateTime> mdate = _super.mdate;

    public final StringPath password = createString("password");

    public final EnumPath<com.clone.insta.enums.ERoles> role = createEnum("role", com.clone.insta.enums.ERoles.class);

    public final StringPath signProvider = createString("signProvider");

    public QInstaUser(String variable) {
        super(InstaUser.class, forVariable(variable));
    }

    public QInstaUser(Path<? extends InstaUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInstaUser(PathMetadata metadata) {
        super(InstaUser.class, metadata);
    }

}

