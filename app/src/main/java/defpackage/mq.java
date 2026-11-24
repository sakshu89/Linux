package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mq {
    public final Context a;
    public final lq b;
    public final xh c;
    public final ru d;
    public final zt e;
    public final ArrayList f;
    public final nd0 g;
    public final long h;
    public final HashMap i = new HashMap();

    public mq(Context context, xh xhVar, ju juVar, long j) throws v01 {
        String strA;
        this.a = context;
        this.c = xhVar;
        zt ztVarA = zt.a(context, xhVar.b);
        this.e = ztVarA;
        this.g = nd0.b(context);
        try {
            ArrayList arrayList = new ArrayList();
            l11 l11Var = ztVarA.a;
            l11Var.getClass();
            try {
                List<String> listAsList = Arrays.asList(((CameraManager) l11Var.b).getCameraIdList());
                int i = 0;
                if (juVar == null) {
                    Iterator it = listAsList.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                    }
                } else {
                    try {
                        strA = vg4.a(ztVarA, juVar.b(), listAsList);
                    } catch (IllegalStateException unused) {
                        strA = null;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String str : listAsList) {
                        if (!str.equals(strA)) {
                            arrayList2.add(b(str));
                        }
                    }
                    ArrayList arrayListA = juVar.a(arrayList2);
                    int size = arrayListA.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayListA.get(i2);
                        i2++;
                        arrayList.add(((ut) obj).c());
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList.size();
                while (i < size2) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    String str2 = (String) obj2;
                    if (str2.equals("0") || str2.equals("1")) {
                        arrayList3.add(str2);
                    } else if (ng4.a(this.e, str2)) {
                        arrayList3.add(str2);
                    } else {
                        xq4.c(3, "Camera2CameraFactory");
                    }
                }
                this.f = arrayList3;
                lq lqVar = new lq(this.e);
                this.b = lqVar;
                ru ruVar = new ru(lqVar);
                this.d = ruVar;
                ((ArrayList) lqVar.e).add(ruVar);
                this.h = j;
            } catch (CameraAccessException e) {
                throw new ds(e);
            }
        } catch (ds e2) {
            throw new v01(new su(e2));
        } catch (su e3) {
            throw new v01(e3);
        }
    }

    public final yq a(String str) throws su {
        if (!this.f.contains(str)) {
            og.i("The given camera id is not on the available camera id list.");
            return null;
        }
        br brVarB = b(str);
        xh xhVar = this.c;
        return new yq(this.a, this.e, str, brVarB, this.b, this.d, xhVar.a, xhVar.b, this.g, this.h);
    }

    public final br b(String str) throws su {
        HashMap map = this.i;
        try {
            br brVar = (br) map.get(str);
            if (brVar != null) {
                return brVar;
            }
            br brVar2 = new br(this.e, str);
            map.put(str, brVar2);
            return brVar2;
        } catch (ds e) {
            throw new su(e);
        }
    }
}
