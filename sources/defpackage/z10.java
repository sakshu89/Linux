package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z10 implements yq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ z10(int i) {
        this.a = i;
    }

    @Override // defpackage.yq0
    public final Object l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int i = this.a;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ox2 ox2Var = (ox2) obj;
                dx2 dx2Var = (dx2) obj2;
                fq0 fq0Var = (fq0) obj3;
                x20 x20Var = (x20) obj4;
                int iIntValue = ((Integer) obj5).intValue();
                int i2 = (iIntValue & 6) == 0 ? iIntValue | ((iIntValue & 8) == 0 ? x20Var.f(ox2Var) : x20Var.h(ox2Var) ? 4 : 2) : iIntValue;
                if ((iIntValue & 48) == 0) {
                    i2 |= (iIntValue & 64) == 0 ? x20Var.f(dx2Var) : x20Var.h(dx2Var) ? 32 : 16;
                }
                if ((iIntValue & CollationFastLatin.LATIN_LIMIT) == 0) {
                    i2 |= x20Var.h(fq0Var) ? 256 : 128;
                }
                if (!x20Var.O(i2 & 1, (i2 & 1171) != 1170)) {
                    x20Var.R();
                } else {
                    jb0.c(ox2Var, dx2Var, fq0Var, x20Var, i2 & 1022);
                }
                break;
            case 1:
                ox2 ox2Var2 = (ox2) obj;
                dx2 dx2Var2 = (dx2) obj2;
                fq0 fq0Var2 = (fq0) obj3;
                x20 x20Var2 = (x20) obj4;
                int iIntValue2 = ((Integer) obj5).intValue();
                int i3 = (iIntValue2 & 6) == 0 ? iIntValue2 | ((iIntValue2 & 8) == 0 ? x20Var2.f(ox2Var2) : x20Var2.h(ox2Var2) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i3 |= (iIntValue2 & 64) == 0 ? x20Var2.f(dx2Var2) : x20Var2.h(dx2Var2) ? 32 : 16;
                }
                if ((iIntValue2 & CollationFastLatin.LATIN_LIMIT) == 0) {
                    i3 |= x20Var2.h(fq0Var2) ? 256 : 128;
                }
                if (!x20Var2.O(i3 & 1, (i3 & 1171) != 1170)) {
                    x20Var2.R();
                } else {
                    jb0.c(ox2Var2, dx2Var2, fq0Var2, x20Var2, i3 & 1022);
                }
                break;
            default:
                boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                long j = ((oz2) obj5).a;
                String string = ((CharSequence) obj4).subSequence(oz2.f(j), oz2.e(j)).toString();
                Intent intentPutExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", zBooleanValue);
                ActivityInfo activityInfo = ((ResolveInfo) obj2).activityInfo;
                Intent className = intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
                className.putExtra("android.intent.extra.PROCESS_TEXT", string);
                ((Context) obj).startActivity(className);
                break;
        }
        return q43Var;
    }
}
