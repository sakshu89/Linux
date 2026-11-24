package defpackage;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h61 {
    public final Context a;
    public final an1 b = new an1();

    public h61(Context context) {
        this.a = context;
    }

    public static final Object a(h61 h61Var, String str, Exception exc, b61 b61Var) {
        Log.w("SecretStore", "Discarding undecryptable secret '" + str + "'", exc);
        Object objH = h61Var.h(str, b61Var);
        return objH == t70.a ? objH : q43.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Serializable b(h61 h61Var, y50 y50Var) {
        g61 g61Var;
        an1 an1Var;
        h61Var.getClass();
        if (y50Var instanceof g61) {
            g61Var = (g61) y50Var;
            int i = g61Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                g61Var.j = i - Integer.MIN_VALUE;
            } else {
                g61Var = new g61(h61Var, y50Var);
            }
        } else {
            g61Var = new g61(h61Var, y50Var);
        }
        Object obj = g61Var.f;
        int i2 = g61Var.j;
        if (i2 == 0) {
            bz3.g(obj);
            an1Var = h61Var.b;
            g61Var.e = an1Var;
            g61Var.j = 1;
            Object objE = an1Var.e(g61Var);
            t70 t70Var = t70.a;
            if (objE == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            an1Var = g61Var.e;
            bz3.g(obj);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey("sonic_secret_store_v1", null);
            SecretKey secretKeyD = key instanceof SecretKey ? (SecretKey) key : null;
            if (secretKeyD == null) {
                secretKeyD = d();
            }
            return secretKeyD;
        } finally {
            an1Var.h(null);
        }
    }

    public static SecretKey d() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder("sonic_secret_store_v1", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).setRandomizedEncryptionRequired(true).setUserAuthenticationRequired(false).build();
        keyGenParameterSpecBuild.getClass();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(keyGenParameterSpecBuild);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        secretKeyGenerateKey.getClass();
        return secretKeyGenerateKey;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (defpackage.uf4.d(r7, r1, r0) == r5) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(defpackage.y50 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof defpackage.z51
            if (r0 == 0) goto L13
            r0 = r7
            z51 r0 = (defpackage.z51) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            z51 r0 = new z51
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.e
            int r1 = r0.i
            r2 = 0
            r3 = 1
            r4 = 2
            t70 r5 = defpackage.t70.a
            if (r1 == 0) goto L35
            if (r1 == r3) goto L31
            if (r1 != r4) goto L2b
            defpackage.bz3.g(r7)
            goto L5e
        L2b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r6)
            return r2
        L31:
            defpackage.bz3.g(r7)
            goto L4c
        L35:
            defpackage.bz3.g(r7)
            android.content.Context r7 = r6.a
            c90 r7 = defpackage.i61.a(r7)
            z r1 = new z
            r1.<init>(r4, r2, r4)
            r0.i = r3
            java.lang.Object r7 = defpackage.rq1.a(r7, r1, r0)
            if (r7 != r5) goto L4c
            goto L5d
        L4c:
            xa0 r7 = defpackage.ld0.a
            qa0 r7 = defpackage.qa0.c
            mf r1 = new mf
            r1.<init>(r6, r2, r4)
            r0.i = r4
            java.lang.Object r6 = defpackage.uf4.d(r7, r1, r0)
            if (r6 != r5) goto L5e
        L5d:
            return r5
        L5e:
            q43 r6 = defpackage.q43.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h61.c(y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(String str, y50 y50Var) throws Throwable {
        a61 a61Var;
        if (y50Var instanceof a61) {
            a61Var = (a61) y50Var;
            int i = a61Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                a61Var.j = i - Integer.MIN_VALUE;
            } else {
                a61Var = new a61(this, y50Var);
            }
        } else {
            a61Var = new a61(this, y50Var);
        }
        Object objC = a61Var.f;
        int i2 = a61Var.j;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objC);
            mm0 mm0VarD = ((c90) ((py0) i61.a(this.a)).b).d();
            a61Var.e = str;
            a61Var.j = 1;
            objC = rn4.c(mm0VarD, a61Var);
            if (objC != t70Var) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(objC);
                return objC;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        str = a61Var.e;
        bz3.g(objC);
        str.getClass();
        String str2 = (String) ((dm1) objC).c(new iz1(str));
        if (str2 == null) {
            return null;
        }
        xa0 xa0Var = ld0.a;
        qa0 qa0Var = qa0.c;
        b61 b61Var = new b61(null, this, str2, str);
        a61Var.e = null;
        a61Var.j = 2;
        Object objD = uf4.d(qa0Var, b61Var, a61Var);
        return objD == t70Var ? t70Var : objD;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(String str, y50 y50Var) throws Throwable {
        c61 c61Var;
        if (y50Var instanceof c61) {
            c61Var = (c61) y50Var;
            int i = c61Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                c61Var.i = i - Integer.MIN_VALUE;
            } else {
                c61Var = new c61(this, y50Var);
            }
        } else {
            c61Var = new c61(this, y50Var);
        }
        Object objE = c61Var.e;
        int i2 = c61Var.i;
        if (i2 == 0) {
            bz3.g(objE);
            c61Var.i = 1;
            objE = e(str, c61Var);
            Object obj = t70.a;
            if (objE == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objE);
        }
        return Boolean.valueOf(objE != null);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public final Object g(String str, String str2, y50 y50Var) throws Throwable {
        d61 d61Var;
        Object obj;
        String str3;
        if (y50Var instanceof d61) {
            d61Var = (d61) y50Var;
            int i = d61Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                d61Var.j = i - Integer.MIN_VALUE;
            } else {
                d61Var = new d61(this, y50Var);
            }
        } else {
            d61Var = new d61(this, y50Var);
        }
        d61 d61Var2 = d61Var;
        Object obj2 = d61Var2.f;
        int i2 = d61Var2.j;
        q43 q43Var = q43.a;
        x50 x50Var = null;
        Object obj3 = t70.a;
        if (i2 == 0) {
            bz3.g(obj2);
            if (cs2.A(str2)) {
                d61Var2.e = null;
                d61Var2.j = 1;
                if (h(str, d61Var2) != obj3) {
                    return q43Var;
                }
            } else {
                xa0 xa0Var = ld0.a;
                qa0 qa0Var = qa0.c;
                e61 e61Var = new e61(null, this, str, str2);
                d61Var2.e = str;
                d61Var2.j = 2;
                Object objD = uf4.d(qa0Var, e61Var, d61Var2);
                if (objD != obj3) {
                    obj = objD;
                    str3 = str;
                }
            }
            return obj3;
        }
        if (i2 == 1) {
            bz3.g(obj2);
            return q43Var;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                bz3.g(obj2);
                return q43Var;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        String str4 = d61Var2.e;
        bz3.g(obj2);
        str3 = str4;
        obj = obj2;
        c90 c90VarA = i61.a(this.a);
        z60 z60Var = new z60(this, str3, (String) obj, x50Var, 1);
        d61Var2.e = null;
        d61Var2.j = 3;
        if (rq1.a(c90VarA, z60Var, d61Var2) == obj3) {
            return obj3;
        }
        return q43Var;
    }

    public final Object h(String str, y50 y50Var) {
        Object objA = rq1.a(i61.a(this.a), new f61(this, str, (x50) null, 0), y50Var);
        return objA == t70.a ? objA : q43.a;
    }
}
