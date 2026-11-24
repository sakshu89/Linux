package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e61 extends nu2 implements vq0 {
    public Cipher f;
    public Cipher i;
    public int j;
    public int k;
    public final /* synthetic */ h61 n;
    public final /* synthetic */ String s;
    public final /* synthetic */ String t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e61(x50 x50Var, h61 h61Var, String str, String str2) {
        super(2, x50Var);
        this.n = h61Var;
        this.s = str;
        this.t = str2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((e61) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        return new e61(x50Var, this.n, this.s, this.t);
    }

    @Override // defpackage.pk
    public final Object s(Object obj) throws we2 {
        Cipher cipher;
        Cipher cipher2;
        int i = this.k;
        String str = this.s;
        int i2 = 1;
        try {
            if (i == 0) {
                bz3.g(obj);
                cipher = Cipher.getInstance("AES/GCM/NoPadding");
                h61 h61Var = this.n;
                this.f = cipher;
                this.i = cipher;
                this.j = 1;
                this.k = 1;
                obj = h61.b(h61Var, this);
                t70 t70Var = t70.a;
                if (obj == t70Var) {
                    return t70Var;
                }
                cipher2 = cipher;
            } else {
                if (i != 1) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i2 = this.j;
                cipher = this.i;
                cipher2 = this.f;
                bz3.g(obj);
            }
            cipher.init(i2, (Key) obj);
            Charset charset = px.a;
            byte[] bytes = str.getBytes(charset);
            bytes.getClass();
            cipher2.updateAAD(bytes);
            byte[] bytes2 = this.t.getBytes(charset);
            bytes2.getClass();
            byte[] bArrDoFinal = cipher2.doFinal(bytes2);
            byte[] iv = cipher2.getIV();
            iv.getClass();
            bArrDoFinal.getClass();
            if (iv.length != 12) {
                throw new IllegalArgumentException(("unexpected GCM IV length " + iv.length).toString());
            }
            Base64.Encoder encoder = Base64.getEncoder();
            int length = iv.length;
            int length2 = bArrDoFinal.length;
            byte[] bArrCopyOf = Arrays.copyOf(iv, length + length2);
            System.arraycopy(bArrDoFinal, 0, bArrCopyOf, length, length2);
            String strEncodeToString = encoder.encodeToString(bArrCopyOf);
            strEncodeToString.getClass();
            return strEncodeToString;
        } catch (IOException e) {
            throw new we2("Keystore unavailable", e);
        } catch (GeneralSecurityException e2) {
            throw new we2(cq.v("Could not encrypt secret '", str, "'"), e2);
        }
    }
}
