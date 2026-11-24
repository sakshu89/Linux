package defpackage;

import android.content.Intent;
import android.net.Uri;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u93 implements bl2 {
    public final n21 a;
    public final bd3 b;
    public final ii1 c;
    public final nb2 d;
    public final j5 e;
    public final r2 f;
    public final Set g;
    public final l82 h;

    public u93(n21 n21Var, bd3 bd3Var, ii1 ii1Var, nb2 nb2Var, j5 j5Var, r2 r2Var) {
        n21Var.getClass();
        bd3Var.getClass();
        ii1Var.getClass();
        nb2Var.getClass();
        j5Var.getClass();
        r2Var.getClass();
        this.a = n21Var;
        this.b = bd3Var;
        this.c = ii1Var;
        this.d = nb2Var;
        this.e = j5Var;
        this.f = r2Var;
        this.g = wh2.c(new w3("web.search"), new w3("web.open"), new w3("youtube.search"), new w3("youtube.play"));
        this.h = l82.a;
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.g;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "web.browse";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Opens a page, searches the web, or searches YouTube.";
    }

    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) {
        String str = f5Var.a;
        x50 x50Var2 = null;
        if (g31.a(str, "web.open")) {
            xa0 xa0Var = ld0.a;
            return uf4.d(qa0.c, new p93(this, f5Var, cl2Var, x50Var2, 0), x50Var);
        }
        if (g31.a(str, "youtube.search")) {
            xa0 xa0Var2 = ld0.a;
            return uf4.d(qa0.c, new p93(this, f5Var, cl2Var, x50Var2, 1), x50Var);
        }
        if (g31.a(str, "youtube.play")) {
            return p(f5Var, cl2Var, (y50) x50Var);
        }
        xa0 xa0Var3 = ld0.a;
        return uf4.d(qa0.c, new p93(this, f5Var, cl2Var, x50Var2, 2), x50Var);
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
        return ii0.a;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.h;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "Web";
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0303  */
    /* JADX WARN: Code duplicated, block: B:104:0x032c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0339  */
    /* JADX WARN: Code duplicated, block: B:108:0x033c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0346 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x0348  */
    /* JADX WARN: Code duplicated, block: B:115:0x0373  */
    /* JADX WARN: Code duplicated, block: B:118:0x037c  */
    /* JADX WARN: Code duplicated, block: B:129:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:131:0x0423  */
    /* JADX WARN: Code duplicated, block: B:133:0x042f  */
    /* JADX WARN: Code duplicated, block: B:69:0x0222 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0224  */
    /* JADX WARN: Code duplicated, block: B:73:0x0247  */
    /* JADX WARN: Code duplicated, block: B:79:0x0276  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:95:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:99:0x02ff  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.net.Uri, java.lang.String, v3, x50] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.net.Uri, java.lang.String, v3] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x03b1 -> B:13:0x0047). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:131:0x0423 -> B:92:0x02c2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x02b3 -> B:88:0x02b4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object n(java.lang.String r29, java.lang.String r30, int r31, defpackage.y50 r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1132
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u93.n(java.lang.String, java.lang.String, int, y50):java.lang.Object");
    }

    public final jl2 o(Uri uri, String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (str3 != null) {
            intent.setPackage(str3);
        }
        n21 n21Var = this.a;
        t61 t61VarA = n21Var.a(intent, str);
        if ((t61VarA instanceof q61) && str3 != null) {
            t61VarA = n21Var.a(new Intent("android.intent.action.VIEW", uri), str);
        }
        if (t61VarA instanceof p61) {
            String strV = cq.v("Opening ", str, ".");
            String strV2 = cq.v("The app accepted the request; I haven't checked ", str2, " yet.");
            p61 p61Var = (p61) t61VarA;
            String str4 = p61Var.b;
            if (str4 == null) {
                str4 = p61Var.a;
            }
            return new hl2(strV, strV2, new c73("SONIC handed " + uri + " to " + str4 + " and cannot observe what it renders"), null, false, 24);
        }
        if (t61VarA instanceof q61) {
            return new fl2("There's no browser on this phone I can hand that to.", "no activity resolved for ACTION_VIEW on " + uri, null, false, 4);
        }
        if (t61VarA instanceof r61) {
            return new fl2("Android wouldn't let me open the browser just now.", "startActivity refused: ".concat(((r61) t61VarA).a), null, false, 12);
        }
        if (t61VarA instanceof s61) {
            return new fl2("I won't open that address.", "rejected by IntentLauncher validation: ".concat(((s61) t61VarA).a), null, false, 4);
        }
        if (t61VarA instanceof o61) {
            return new fl2("I couldn't open that.", ((o61) t61VarA).a, null, false, 12);
        }
        dk0.l();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x023d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0241  */
    /* JADX WARN: Code duplicated, block: B:105:0x0254 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:106:0x0255  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:51:0x0118  */
    /* JADX WARN: Code duplicated, block: B:54:0x0126  */
    /* JADX WARN: Code duplicated, block: B:55:0x0129  */
    /* JADX WARN: Code duplicated, block: B:58:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0134  */
    /* JADX WARN: Code duplicated, block: B:62:0x014f A[PHI: r1 r4 r6 r10 r11
      0x014f: PHI (r1v26 int) = (r1v25 int), (r1v27 int), (r1v27 int) binds: [B:19:0x004c, B:58:0x0132, B:60:0x014b] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r4v23 int) = (r4v22 int), (r4v24 int), (r4v24 int) binds: [B:19:0x004c, B:58:0x0132, B:60:0x014b] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r6v5 boolean) = (r6v4 boolean), (r6v6 boolean), (r6v6 boolean) binds: [B:19:0x004c, B:58:0x0132, B:60:0x014b] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r10v14 t61) = (r10v13 t61), (r10v15 t61), (r10v15 t61) binds: [B:19:0x004c, B:58:0x0132, B:60:0x014b] A[DONT_GENERATE, DONT_INLINE]
      0x014f: PHI (r11v7 id3) = (r11v6 id3), (r11v8 id3), (r11v8 id3) binds: [B:19:0x004c, B:58:0x0132, B:60:0x014b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01e4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:86:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:88:0x020d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0211  */
    /* JADX WARN: Code duplicated, block: B:92:0x0221  */
    /* JADX WARN: Code duplicated, block: B:94:0x0225  */
    /* JADX WARN: Code duplicated, block: B:96:0x0229  */
    /* JADX WARN: Code duplicated, block: B:99:0x023c A[RETURN] */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x016d, code lost:
    
        if (r2 == r9) goto L113;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x016d -> B:65:0x0171). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(defpackage.f5 r21, defpackage.cl2 r22, defpackage.y50 r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u93.p(f5, cl2, y50):java.lang.Object");
    }

    @Override // defpackage.bl2
    public final void f() {
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
