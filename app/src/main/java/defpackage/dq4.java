package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dq4 {
    /* JADX WARN: Code duplicated, block: B:114:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d0 A[Catch: y31 -> 0x019a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {y31 -> 0x019a, blocks: (B:36:0x00c0, B:40:0x00d0, B:53:0x00f4, B:55:0x0108, B:57:0x0116, B:61:0x0123, B:65:0x012b), top: B:104:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:59:0x0120  */
    /* JADX WARN: Code duplicated, block: B:60:0x0122  */
    /* JADX WARN: Code duplicated, block: B:63:0x0126  */
    /* JADX WARN: Code duplicated, block: B:64:0x0129  */
    /* JADX WARN: Code duplicated, block: B:74:0x0174  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0174 -> B:18:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(defpackage.z91 r27, int r28, int r29, defpackage.jc0 r30, defpackage.y50 r31) {
        /*
            Method dump skipped, instruction units count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dq4.a(z91, int, int, jc0, y50):java.lang.Object");
    }

    public static final boolean b(boolean z, z91 z91Var, int i) {
        ea1 ea1Var = (ea1) z91Var.c;
        if (z) {
            if (ea1Var.g() > i) {
                return true;
            }
            return ea1Var.g() == i && ea1Var.h() > 0;
        }
        if (ea1Var.g() < i) {
            return true;
        }
        return ea1Var.g() == i && ea1Var.h() < 0;
    }

    public static final boolean c(z91 z91Var, int i) {
        return i <= z91Var.c() && ((ea1) z91Var.c).g() <= i;
    }
}
