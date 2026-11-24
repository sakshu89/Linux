package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jw3 implements iu3 {
    public static final jw3 b = new jw3(0);
    public static final jw3 c = new jw3(1);
    public static final jw3 d = new jw3(2);
    public static final jw3 e = new jw3(3);
    public static final jw3 f = new jw3(4);
    public static final jw3 g = new jw3(5);
    public static final jw3 h = new jw3(6);
    public static final jw3 i = new jw3(7);
    public static final jw3 j = new jw3(8);
    public final /* synthetic */ int a;

    public /* synthetic */ jw3(int i2) {
        this.a = i2;
    }

    @Override // defpackage.iu3
    public final boolean a(int i2) {
        switch (this.a) {
            case 0:
                return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3;
            case 1:
                return i2 == 0 || i2 == 1;
            case 2:
                return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3;
            case 3:
                return i2 == 0 || i2 == 1 || i2 == 2;
            case 4:
                return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
            case 5:
                return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3;
            case 6:
                return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3;
            case 7:
                return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 8 || i2 == 16 || i2 == 32 || i2 == 64 || i2 == 128;
            default:
                return i2 == 0 || i2 == 1;
        }
    }
}
