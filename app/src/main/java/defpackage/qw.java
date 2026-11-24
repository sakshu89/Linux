package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qw implements up {
    public final /* synthetic */ tw a;

    public void a() {
        tw twVar = this.a;
        synchronized (twVar.a) {
            try {
                if (twVar.i == 5) {
                    twVar.j(twVar.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.up
    public Object d(tp tpVar) {
        String str;
        tw twVar = this.a;
        synchronized (twVar.a) {
            hh1.e("Release completer expected to be null", twVar.k == null);
            twVar.k = tpVar;
            str = "Release[session=" + twVar + "]";
        }
        return str;
    }
}
