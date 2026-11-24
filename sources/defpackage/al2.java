package defpackage;

import android.util.Size;
import com.ibm.icu.impl.coll.Collation;
import com.ibm.icu.lang.UCharacter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class al2 {
    public static final Size a = new Size(0, 0);
    public static final Size b;
    public static final Size c;
    public static final Size d;
    public static final Size e;
    public static final Size f;

    static {
        new Size(UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID, 240);
        b = new Size(640, 480);
        c = new Size(720, 480);
        d = new Size(Collation.COMMON_WEIGHT16, 720);
        e = new Size(1920, 1080);
        f = new Size(1920, 1440);
    }

    public static int a(Size size) {
        return size.getHeight() * size.getWidth();
    }
}
