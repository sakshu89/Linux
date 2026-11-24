package defpackage;

import com.ibm.icu.text.Transliterator;
import com.ibm.icu.text.UnicodeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e4 implements fq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ e4(int i) {
        this.a = i;
    }

    @Override // defpackage.fq0
    public final Object a() {
        switch (this.a) {
            case 0:
                o1 o1Var = s22.a;
                return Integer.valueOf(s22.a.a().nextInt(2147418112) + 65536);
            case 1:
                return Long.valueOf(System.nanoTime() / 1000000);
            case 2:
                return new cn2(ki4.b(1308617531));
            case 3:
                sr2 sr2Var = cl.a;
                return null;
            case 4:
                long j = vz.z;
                return new yz(j, vz.j, vz.A, vz.k, vz.e, vz.E, vz.n, vz.F, vz.o, vz.R, vz.t, vz.S, vz.u, vz.a, vz.g, vz.I, vz.r, vz.Q, vz.s, j, vz.f, vz.d, vz.b, vz.h, vz.c, vz.i, vz.x, vz.y, vz.D, vz.J, vz.P, vz.K, vz.L, vz.M, vz.N, vz.O, vz.B, vz.C, vz.l, vz.m, vz.G, vz.H, vz.p, vz.q, vz.T, vz.U, vz.v, vz.w);
            case 5:
                sr2 sr2Var2 = a00.a;
                return Boolean.TRUE;
            case 6:
                sr2 sr2Var3 = f30.a;
                return null;
            case 7:
                y20.b("Unexpected call to default provider");
                throw new b10();
            case 8:
                return Long.valueOf(System.currentTimeMillis());
            case 9:
                return Long.valueOf(System.nanoTime() / 1000000);
            case 10:
                float f = cf0.a;
                return Boolean.TRUE;
            case 11:
                m30 m30Var = zz0.a;
                return fa0.a;
            case 12:
                sr2 sr2Var4 = w11.a;
                return null;
            case 13:
                qw0 qw0Var = u21.a;
                return Boolean.TRUE;
            case 14:
                return new de0(48.0f);
            case 15:
                return Transliterator.getInstance("Any-Latin");
            case 16:
                return Transliterator.getInstance("Latin-ASCII");
            case 17:
                return new UnicodeSet("[:Indic_Syllabic_Category=Consonant:]").freeze();
            case 18:
                return new UnicodeSet("[:Indic_Syllabic_Category=Vowel_Dependent:]").freeze();
            case 19:
                return new ea1(0, 0);
            case 20:
                return Long.valueOf(System.nanoTime() / 1000000);
            case 21:
                return Long.valueOf(System.nanoTime() / 1000000);
            case 22:
                return Long.valueOf(System.nanoTime() / 1000000);
            case 23:
                throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present");
            case 24:
                m30 m30Var2 = je1.a;
                return null;
            case 25:
                sr2 sr2Var5 = ke1.a;
                return el1.e;
            case 26:
                throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present");
            case 27:
                sr2 sr2Var6 = gh1.a;
                return Boolean.FALSE;
            case 28:
                return tk1.a;
            default:
                return new et1();
        }
    }
}
