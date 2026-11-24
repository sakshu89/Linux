package defpackage;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h90 extends k61 implements fq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ w90 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h90(w90 w90Var, int i) {
        super(0);
        this.b = i;
        this.c = w90Var;
    }

    @Override // defpackage.fq0
    public final Object a() throws IOException {
        switch (this.b) {
            case 0:
                return ((nl0) this.c.s.getValue()).b;
            default:
                kl0 kl0Var = this.c.a;
                File canonicalFile = ((File) kl0Var.b.a()).getCanonicalFile();
                synchronized (kl0.d) {
                    String absolutePath = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = kl0.c;
                    if (linkedHashSet.contains(absolutePath)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    absolutePath.getClass();
                    linkedHashSet.add(absolutePath);
                }
                return new nl0(canonicalFile, (uk2) kl0Var.a.j(canonicalFile), new ta(3, canonicalFile));
        }
    }
}
