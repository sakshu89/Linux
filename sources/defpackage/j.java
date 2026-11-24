package defpackage;

import android.content.Context;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements hq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ j(int i, x91 x91Var) {
        this.a = 28;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        String string;
        String string2;
        boolean z = false;
        z = false;
        boolean z2 = false;
        z = false;
        switch (this.a) {
            case 0:
                Byte b = (Byte) obj;
                b.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b}, 1));
            case 1:
                AccessibilityWindowInfo accessibilityWindowInfo = (AccessibilityWindowInfo) obj;
                if (accessibilityWindowInfo.getType() == 1 && (accessibilityWindowInfo.isFocused() || accessibilityWindowInfo.isActive())) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                return Boolean.valueOf(!(((xd) obj) instanceof eu1));
            case 3:
                x11 x11Var = (x11) obj;
                x11Var.getClass();
                return x11Var.b;
            case 4:
                x11 x11Var2 = (x11) obj;
                x11Var2.getClass();
                return cq.k(x11Var2.b, "  ·  ", x11Var2.a);
            case 5:
                int i = zk.a;
                return q43.a;
            case 6:
                ((p71) obj).a();
                return q43.a;
            case 7:
                return q43.a;
            case 8:
                return Integer.valueOf((((Integer) obj).intValue() * 2) + 1);
            case 9:
                gw1 gw1Var = (gw1) obj;
                sr2 sr2Var = AndroidCompositionLocals_androidKt.b;
                gw1Var.getClass();
                if (((Context) mj4.a(gw1Var, sr2Var)).getPackageManager().hasSystemFeature("android.software.leanback")) {
                    return en.b;
                }
                cn.a.getClass();
                return bn.c;
            case 10:
                mg2.c((og2) obj);
                return q43.a;
            case 11:
                fh1 fh1Var = (fh1) obj;
                fh1Var.getClass();
                return ((dh1) fh1Var.a()).get(1) + "/100*";
            case 12:
                CharSequence charSequence = (CharSequence) obj;
                if (charSequence == null || (string = charSequence.toString()) == null || (string2 = cs2.V(string).toString()) == null || cs2.A(string2)) {
                    return null;
                }
                return string2;
            case 13:
                return q43.a;
            case 14:
                ((t23) obj).getClass();
                throw new ClassCastException();
            case 15:
                ((t23) obj).getClass();
                throw new ClassCastException();
            case 16:
                Throwable th = (Throwable) obj;
                th.getClass();
                return th.getCause();
            case 17:
                Throwable th2 = (Throwable) obj;
                th2.getClass();
                String message = th2.getMessage();
                return message == null ? "" : message;
            case 18:
                uw1 uw1Var = (uw1) obj;
                uw1Var.getClass();
                return cq.k(uw1Var.b, " on ", uy.B(uw1Var.c));
            case 19:
                uw1 uw1Var2 = (uw1) obj;
                uw1Var2.getClass();
                return cq.k(uw1Var2.a(), "\n", uw1Var2.c);
            case 20:
                ((z83) obj).getClass();
                return q43.a;
            case 21:
                h70 h70Var = (h70) obj;
                if (h70Var instanceof l70) {
                    return (l70) h70Var;
                }
                return null;
            case 22:
                ((JSONObject) obj).getClass();
                return Boolean.TRUE;
            case 23:
                JSONObject jSONObject = (JSONObject) obj;
                jSONObject.getClass();
                return Boolean.valueOf(jSONObject.optBoolean("requires_user_response"));
            case 24:
                String str = (String) obj;
                if (!g31.a(str, "action") && !g31.a(str, "utterance")) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            case 25:
                JSONObject jSONObject2 = (JSONObject) obj;
                jSONObject2.getClass();
                return Boolean.valueOf(jSONObject2.optBoolean("requires_user_response"));
            case 26:
                synchronized (im2.c) {
                    List list = im2.i;
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((hq0) list.get(i2)).j(obj);
                    }
                }
                return q43.a;
            case 27:
                List list2 = (List) obj;
                return new ea1(((Number) list2.get(0)).intValue(), ((Number) list2.get(1)).intValue());
            case 28:
                return q43.a;
            default:
                return q43.a;
        }
    }

    public /* synthetic */ j(int i) {
        this.a = i;
    }
}
