package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements bl2 {
    public static final List e = nz.i("what can you", "what do you do", "features", "help", "capabilities", "kya kar sakte", "kya karte");
    public final c22 a;
    public final Set b;
    public final ii0 c;
    public final l82 d;

    public k0(yb0 yb0Var) {
        yb0Var.getClass();
        this.a = yb0Var;
        this.b = wh2.b(new w3("meta.about"));
        this.c = ii0.a;
        this.d = l82.a;
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.b;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "meta.about";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Explains what SONIC is and what it can actually do right now.";
    }

    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) {
        String lowerCase = f5Var.e.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        List list = e;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (cs2.n(lowerCase, (String) it.next(), false)) {
                    return n(cl2Var, (y50) x50Var);
                }
            }
        }
        int size = ((ll2) this.a.get()).b.size();
        StringBuilder sb = new StringBuilder("I'm SONIC — a voice assistant that runs on this phone. I understand commands here on the device, without sending them anywhere, ");
        sb.append("and I can do " + size + " kinds of thing so far. ");
        sb.append(cl2Var.c ? "Ask me what I can do for the list." : "You're offline right now, which doesn't stop most of it. Ask me what I can do for the list.");
        String string = sb.toString();
        d73 d73Var = new d73("read from the running build", cq.h("SONIC 2.0, ", size, " registered skills"));
        String lowerCase2 = cl2Var.a.name().toLowerCase(Locale.ROOT);
        lowerCase2.getClass();
        return new il2(string, d73Var, null, "SONIC 2.0 · " + lowerCase2 + " tier", 4);
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        return a32.a;
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final List k() {
        return this.c;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.d;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "About SONIC";
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0081  */
    /* JADX WARN: Code duplicated, block: B:25:0x009b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x009c  */
    /* JADX WARN: Code duplicated, block: B:29:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009c -> B:27:0x00a0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object n(defpackage.cl2 r13, defpackage.y50 r14) {
        /*
            Method dump skipped, instruction units count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k0.n(cl2, y50):java.lang.Object");
    }

    @Override // defpackage.bl2
    public final void f() {
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
