package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(Object obj, Object obj2, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = obj;
        this.j = obj2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((y) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 1:
                ((y) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 2:
                ((y) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 3:
                ((y) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 4:
                ((y) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 5:
                return ((y) q((x50) obj2, (s70) obj)).s(q43Var);
            case 6:
                return ((y) q((x50) obj2, (s70) obj)).s(q43Var);
            case 7:
                return ((y) q((x50) obj2, (s70) obj)).s(q43Var);
            case 8:
                return ((y) q((x50) obj2, (s70) obj)).s(q43Var);
            case 9:
                return ((y) q((x50) obj2, (s70) obj)).s(q43Var);
            case 10:
                return ((y) q((x50) obj2, (fr2) obj)).s(q43Var);
            case 11:
                ((y) q((x50) obj2, (s70) obj)).s(q43Var);
                return q43Var;
            case 12:
                return ((y) q((x50) obj2, (s70) obj)).s(q43Var);
            default:
                ((y) q((x50) obj2, (s70) obj)).s(q43Var);
                return q43Var;
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.j;
        switch (i) {
            case 0:
                y yVar = new y((String) obj2, x50Var, 0);
                yVar.i = obj;
                return yVar;
            case 1:
                y yVar2 = new y((f0) obj2, x50Var, 1);
                yVar2.i = obj;
                return yVar2;
            case 2:
                y yVar3 = new y((l82) obj2, x50Var, 2);
                yVar3.i = obj;
                return yVar3;
            case 3:
                y yVar4 = new y((b60) obj2, x50Var, 3);
                yVar4.i = obj;
                return yVar4;
            case 4:
                y yVar5 = new y((l61) obj2, x50Var, 4);
                yVar5.i = obj;
                return yVar5;
            case 5:
                return new y((nf) this.i, (f5) obj2, x50Var, 5);
            case 6:
                return new y((np) this.i, (String) obj2, x50Var, 6);
            case 7:
                return new y((np) this.i, (String) obj2, x50Var, 7);
            case 8:
                return new y((uy) this.i, (String) obj2, x50Var, 8);
            case 9:
                y yVar6 = new y((k80) obj2, x50Var, 9);
                yVar6.i = obj;
                return yVar6;
            case 10:
                y yVar7 = new y((fr2) obj2, x50Var, 10);
                yVar7.i = obj;
                return yVar7;
            case 11:
                y yVar8 = new y((ib1) obj2, x50Var, 11);
                yVar8.i = obj;
                return yVar8;
            case 12:
                return new y((bj1) this.i, (String) obj2, x50Var, 12);
            default:
                return new y((eo2) this.i, (mm1) obj2, x50Var, 13);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        Object fl2Var;
        Object il2Var;
        Uri uriWithAppendedPath;
        int i = 3;
        boolean z = false;
        x50 x50Var = null;
        switch (this.f) {
            case 0:
                dm1 dm1Var = (dm1) this.i;
                bz3.g(obj);
                iz1 iz1Var = f0.g;
                String str = (String) dm1Var.c(iz1Var);
                if (str == null) {
                    str = "";
                }
                iz1 iz1Var2 = f0.h;
                Integer num = (Integer) dm1Var.c(iz1Var2);
                int iIntValue = num != null ? num.intValue() : 0;
                Integer num2 = (Integer) dm1Var.c(f0.i);
                int iIntValue2 = num2 != null ? num2.intValue() : 50;
                ez ezVar = new ez(str, iIntValue, iIntValue2);
                String str2 = (String) this.j;
                if (!str.equals(str2)) {
                    ezVar = new ez(str2, 0, iIntValue2);
                }
                int i2 = ezVar.b + 1;
                dm1Var.f(iz1Var, ezVar.a);
                dm1Var.f(iz1Var2, new Integer(i2));
                return q43.a;
            case 1:
                f0 f0Var = (f0) this.j;
                dm1 dm1Var2 = (dm1) this.i;
                bz3.g(obj);
                iz1 iz1Var3 = f0.c;
                Long l = (Long) dm1Var2.c(iz1Var3);
                dm1Var2.f(iz1Var3, new Long((l != null ? l.longValue() : 0L) + 1));
                dm1Var2.d(new iz1("model_override/gemini"));
                dm1Var2.d(f0.d(f0Var, "gemini"));
                dm1Var2.d(f0.c(f0Var, "gemini"));
                dm1Var2.d(f0.b(f0Var, "gemini"));
                dm1Var2.d(f0.a(f0Var, "gemini"));
                dm1Var2.d(f0.d(f0Var, "gemini_live"));
                dm1Var2.d(f0.c(f0Var, "gemini_live"));
                dm1Var2.d(f0.b(f0Var, "gemini_live"));
                dm1Var2.d(f0.a(f0Var, "gemini_live"));
                dm1Var2.d(f0.f);
                return q43.a;
            case 2:
                dm1 dm1Var3 = (dm1) this.i;
                bz3.g(obj);
                iz1 iz1Var4 = j5.c;
                dm1Var3.e(j5.e, ((l82) this.j).name());
                return q43.a;
            case 3:
                dm1 dm1Var4 = (dm1) this.i;
                bz3.g(obj);
                iz1 iz1Var5 = j5.c;
                dm1Var4.e(j5.c, ((b60) this.j).name());
                dm1Var4.e(j5.g, Boolean.FALSE);
                return q43.a;
            case 4:
                dm1 dm1Var5 = (dm1) this.i;
                bz3.g(obj);
                iz1 iz1Var6 = j5.c;
                dm1Var5.e(j5.i, ((l61) this.j).name());
                return q43.a;
            case 5:
                bz3.g(obj);
                ((nf) this.i).d = null;
                boolean zA = g31.a(((f5) this.j).a, "app.list");
                nf nfVar = (nf) this.i;
                if (zA) {
                    List listB = nfVar.a.b();
                    if (listB.isEmpty()) {
                        il2Var = new fl2("I couldn't read the app list.", "queryIntentActivities for MAIN/LAUNCHER returned nothing", null, false, 4);
                    } else {
                        String strC = mz.C(mz.L(listB, 5), ", ", null, null, new j(i), 30);
                        il2Var = new il2("You have " + listB.size() + " apps. The first few are " + strC + ".", new d73("PackageManager MAIN/LAUNCHER activity query", listB.size() + " launchable packages"), null, mz.C(listB, "\n", null, null, new j(4), 30), 4);
                    }
                    return il2Var;
                }
                f5 f5Var = (f5) this.j;
                String strC2 = f5Var.c("app_name");
                if (strC2 == null) {
                    fl2Var = new fl2("Which app would you like me to open?", "OPEN_APP with no app_name slot", null, false, 12);
                } else {
                    rf rfVarN = nf.n(nfVar, strC2);
                    if (rfVarN instanceof pf) {
                        ue ueVar = nfVar.a;
                        synchronized (ueVar.e) {
                            ueVar.c = ii0.a;
                            ueVar.d = 0L;
                        }
                        rfVarN = nf.n(nfVar, strC2);
                    }
                    if (rfVarN instanceof qf) {
                        qf qfVar = (qf) rfVarN;
                        x11 x11Var = qfVar.a;
                        String str3 = qfVar.b;
                        nfVar.d = null;
                        ue ueVar2 = nfVar.a;
                        ueVar2.getClass();
                        x11Var.getClass();
                        String str4 = x11Var.b;
                        PackageManager packageManager = ueVar2.a.getPackageManager();
                        String str5 = x11Var.a;
                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str5);
                        t61 q61Var = launchIntentForPackage == null ? new q61("a way to open ".concat(str4)) : ueVar2.b.a(launchIntentForPackage, str4);
                        if (q61Var instanceof p61) {
                            nfVar.d = str5;
                            fl2Var = new hl2(cq.v("Opening ", str4, ", Boss."), "I haven't confirmed the app is visible yet", new c73(ky0.l("launch request accepted for ", ((p61) q61Var).a, " (matched: ", str3, "); the requested app has not yet been observed in the foreground")), null, false, 24);
                        } else if (q61Var instanceof q61) {
                            fl2Var = new fl2(str4.concat(" is installed but doesn't have a screen I can open."), "getLaunchIntentForPackage returned null for ".concat(str5), null, false, 4);
                        } else if (q61Var instanceof r61) {
                            fl2Var = new fl2(cq.v("Android wouldn't let me open ", str4, " from the background."), "startActivity refused: ".concat(((r61) q61Var).a), null, false, 12);
                        } else if (q61Var instanceof s61) {
                            fl2Var = new fl2("I didn't open that.", "rejected by IntentLauncher validation: ".concat(((s61) q61Var).a), null, false, 4);
                        } else {
                            if (!(q61Var instanceof o61)) {
                                dk0.l();
                                return null;
                            }
                            fl2Var = new fl2(cq.v("I couldn't open ", str4, "."), ((o61) q61Var).a, null, false, 12);
                        }
                    } else {
                        if (rfVarN instanceof of) {
                            of ofVar = (of) rfVarN;
                            String str6 = "I found " + ofVar.b.size() + " apps that could be \"" + ofVar.a + "\". Which one?";
                            List<x11> list = ofVar.b;
                            ArrayList arrayList = new ArrayList(nz.d(list));
                            for (x11 x11Var2 : list) {
                                String str7 = x11Var2.b;
                                String str8 = x11Var2.a;
                                arrayList.add(new zx(str7, str8, str8, 8));
                            }
                            return new gl2(str6, new yx("Which app did you mean?", "app_name", arrayList, "app.open", bh1.d("app_name", f5Var.b)));
                        }
                        if (!(rfVarN instanceof pf)) {
                            dk0.l();
                            return null;
                        }
                        pf pfVar = (pf) rfVarN;
                        fl2Var = new fl2(cq.v("I couldn't find an app called \"", pfVar.a, "\" on your phone."), "no label, alias or close-spelling match for \"" + pfVar.a + "\" among " + nfVar.a.b().size() + " launchable apps", null, true, 4);
                    }
                }
                return fl2Var;
            case 6:
                bz3.g(obj);
                b50 b50Var = (b50) ((np) this.i).e;
                String str9 = (String) this.j;
                b50Var.getClass();
                try {
                    return b50Var.f(str9);
                } catch (SecurityException unused) {
                    return x40.a;
                }
            case 7:
                bz3.g(obj);
                np npVar = (np) this.i;
                String str10 = (String) this.j;
                fu fuVarA = rg4.a(str10);
                try {
                    Cursor cursorQuery = ((Context) npVar.d).getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_size"}, cq.v("_display_name = ? AND ", fuVarA.a, " = ?"), new String[]{str10, fuVarA.b}, "date_added DESC");
                    if (cursorQuery == null) {
                        return null;
                    }
                    do {
                        try {
                            if (!cursorQuery.moveToNext()) {
                                uriWithAppendedPath = null;
                            }
                            cursorQuery.close();
                            return uriWithAppendedPath;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                fi4.a(cursorQuery, th);
                                throw th2;
                            }
                        }
                    } while (cursorQuery.getLong(1) <= 0);
                    uriWithAppendedPath = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(cursorQuery.getLong(0)));
                    cursorQuery.close();
                    return uriWithAppendedPath;
                } catch (Exception unused2) {
                    return null;
                }
            case 8:
                bz3.g(obj);
                b50 b50Var2 = (b50) ((uy) this.i).d;
                String str11 = (String) this.j;
                b50Var2.getClass();
                try {
                    return b50Var2.f(str11);
                } catch (SecurityException unused3) {
                    return x40.a;
                }
            case 9:
                bz3.g(obj);
                s70 s70Var = (s70) this.i;
                k80 k80Var = (k80) this.j;
                f41 f41Var = (f41) k80Var.b.getAndSet(null);
                AtomicReference atomicReference = k80Var.b;
                yq2 yq2VarB = uf4.b(s70Var, null, new p0(f41Var, k80Var, x50Var, 13), 3);
                while (!atomicReference.compareAndSet(null, yq2VarB)) {
                    if (atomicReference.get() != null) {
                        return Boolean.valueOf(z);
                    }
                }
                z = true;
                return Boolean.valueOf(z);
            case 10:
                bz3.g(obj);
                fr2 fr2Var = (fr2) this.i;
                if ((fr2Var instanceof y80) && fr2Var.a <= ((fr2) this.j).a) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 11:
                bz3.g(obj);
                s70 s70Var2 = (s70) this.i;
                ib1 ib1Var = (ib1) this.j;
                qb1 qb1Var = ib1Var.a;
                if (qb1Var.d.compareTo(eb1.b) >= 0) {
                    qb1Var.a(ib1Var);
                } else {
                    f41 f41Var2 = (f41) s70Var2.o().v(nr4.k);
                    if (f41Var2 != null) {
                        f41Var2.e(null);
                    }
                }
                return q43.a;
            case 12:
                bz3.g(obj);
                b50 b50Var3 = ((bj1) this.i).b;
                String str12 = (String) this.j;
                b50Var3.getClass();
                try {
                    return b50Var3.f(str12);
                } catch (SecurityException unused4) {
                    return x40.a;
                }
            default:
                bz3.g(obj);
                if (((eo2) this.i).o > 0) {
                    ((mm1) this.j).setValue(zt1.a);
                }
                return q43.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(Object obj, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = obj;
    }
}
