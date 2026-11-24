package defpackage;

import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.util.Log;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b61 extends nu2 implements vq0 {
    public byte[] f;
    public byte[] i;
    public Cipher j;
    public Cipher k;
    public int n;
    public int s;
    public final /* synthetic */ String t;
    public final /* synthetic */ h61 u;
    public final /* synthetic */ String v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b61(x50 x50Var, h61 h61Var, String str, String str2) {
        super(2, x50Var);
        this.t = str;
        this.u = h61Var;
        this.v = str2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((b61) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new b61(x50Var, this.u, this.t, this.v);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0102 A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.pk
    public final Object s(Object obj) {
        byte[] bArrJ;
        byte[] bArrJ2;
        Cipher cipher;
        Cipher cipher2;
        int i;
        int i2 = this.s;
        h61 h61Var = this.u;
        String str = this.v;
        t70 t70Var = t70.a;
        try {
            if (i2 == 0) {
                bz3.g(obj);
                byte[] bArrDecode = Base64.getDecoder().decode(this.t);
                if (bArrDecode.length <= 12) {
                    throw new IllegalArgumentException("sealed value too short");
                }
                bArrJ = qg.j(0, bArrDecode, 12);
                bArrJ2 = qg.j(12, bArrDecode, bArrDecode.length);
                Cipher cipher3 = Cipher.getInstance("AES/GCM/NoPadding");
                this.f = bArrJ;
                this.i = bArrJ2;
                this.j = cipher3;
                this.k = cipher3;
                this.n = 2;
                this.s = 1;
                Serializable serializableB = h61.b(h61Var, this);
                if (serializableB == t70Var) {
                    return t70Var;
                }
                cipher = cipher3;
                cipher2 = cipher;
                obj = serializableB;
                i = 2;
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                    } else if (i2 == 3) {
                    } else {
                        if (i2 != 4) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    bz3.g(obj);
                    return null;
                }
                i = this.n;
                cipher = this.k;
                cipher2 = this.j;
                bArrJ2 = this.i;
                bArrJ = this.f;
                bz3.g(obj);
            }
            cipher.init(i, (Key) obj, new GCMParameterSpec(128, bArrJ));
            Charset charset = px.a;
            byte[] bytes = str.getBytes(charset);
            bytes.getClass();
            cipher2.updateAAD(bytes);
            byte[] bArrDoFinal = cipher2.doFinal(bArrJ2);
            bArrDoFinal.getClass();
            return new String(bArrDoFinal, charset);
        } catch (KeyPermanentlyInvalidatedException e) {
            this.f = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.s = 2;
            if (h61.a(h61Var, str, e, this) == t70Var) {
                return t70Var;
            }
        } catch (IOException e2) {
            Log.w("SecretStore", "Keystore unavailable while reading '" + str + "'", e2);
        } catch (IllegalArgumentException e3) {
            this.f = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.s = 4;
            if (h61.a(h61Var, str, e3, this) == t70Var) {
                return t70Var;
            }
        } catch (GeneralSecurityException e4) {
            this.f = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.s = 3;
            if (h61.a(h61Var, str, e4, this) == t70Var) {
                return t70Var;
            }
        }
    }
}
