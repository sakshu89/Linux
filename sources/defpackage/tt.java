package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Trace;
import android.provider.MediaStore;
import com.ibm.icu.impl.locale.BaseLocale;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tt {
    public final Context a;

    public tt(Context context) {
        this.a = context;
    }

    public static Object c(tt ttVar, ry0 ry0Var, hw hwVar) {
        return ttVar.b(ry0Var, "SONIC_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + BaseLocale.SEP + UUID.randomUUID() + ".jpg", hwVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(ob1 ob1Var, r02 r02Var, boolean z, y50 y50Var) throws Throwable {
        rt rtVar;
        wp wpVarA;
        if (y50Var instanceof rt) {
            rtVar = (rt) y50Var;
            int i = rtVar.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                rtVar.n = i - Integer.MIN_VALUE;
            } else {
                rtVar = new rt(this, y50Var);
            }
        } else {
            rtVar = new rt(this, y50Var);
        }
        Object objA = rtVar.j;
        t70 t70Var = t70.a;
        int i2 = rtVar.n;
        if (i2 == 0) {
            bz3.g(objA);
            rtVar.e = ob1Var;
            rtVar.f = r02Var;
            rtVar.i = z;
            rtVar.n = 1;
            q92 q92Var = new q92(fp4.b(rtVar), t70.b);
            y02 y02Var = y02.g;
            Context context = this.a;
            y02 y02Var2 = y02.g;
            synchronized (y02Var2.a) {
                wpVarA = y02Var2.b;
                int i3 = 6;
                if (wpVarA == null) {
                    wpVarA = hg4.a(new qq(i3, y02Var2, new ov(context)));
                    y02Var2.b = wpVarA;
                }
            }
            xw xwVarG = oz3.g(wpVarA, new q82(new zq(6, new h6(18, context))), xg4.a());
            xwVarG.a(new or0(this, q92Var, xwVarG), al4.b(this.a));
            objA = q92Var.a();
            if (objA == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z = rtVar.i;
            r02Var = rtVar.f;
            ob1Var = rtVar.e;
            bz3.g(objA);
        }
        y02 y02Var3 = (y02) objA;
        ju juVar = z ? ju.b : ju.c;
        juVar.getClass();
        yr yrVar = new yr(2);
        yrVar.b.v(sy0.b, 1);
        ry0 ry0VarC = yrVar.c();
        h02 h02Var = new h02(gs1.l(new yr(3).b));
        xy0.s(h02Var);
        g02 g02Var = new g02(h02Var);
        g02Var.p = g02.w;
        g02Var.B(r02Var.getSurfaceProvider());
        y02Var3.getClass();
        Trace.beginSection(hd4.e("CX:unbindAll"));
        try {
            vc4.b();
            int i4 = 0;
            y02.b(y02Var3, 0);
            y02Var3.c.I();
            Trace.endSection();
            o53[] o53VarArr = {g02Var, ry0VarC};
            ob1Var.getClass();
            Trace.beginSection(hd4.e("CX:bindToLifecycle"));
            try {
                ov ovVar = y02Var3.d;
                if (ovVar != null) {
                    mq mqVar = ovVar.f;
                    if (mqVar == null) {
                        throw new IllegalStateException("CameraX not initialized yet.");
                    }
                    i4 = mqVar.b.c;
                }
                if (i4 == 2) {
                    throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
                }
                y02.b(y02Var3, 1);
                y02Var3.c(ob1Var, juVar, (o53[]) Arrays.copyOf(o53VarArr, 2));
                Trace.endSection();
                return ry0VarC;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(ry0 ry0Var, String str, y50 y50Var) throws Throwable {
        st stVar;
        if (y50Var instanceof st) {
            stVar = (st) y50Var;
            int i = stVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                stVar.j = i - Integer.MIN_VALUE;
            } else {
                stVar = new st(this, y50Var);
            }
        } else {
            stVar = new st(this, y50Var);
        }
        Object objD = stVar.f;
        int i2 = stVar.j;
        int i3 = 1;
        x50 x50Var = null;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objD);
            xa0 xa0Var = ld0.a;
            qa0 qa0Var = qa0.c;
            mf mfVar = new mf(str, x50Var, i3);
            stVar.e = ry0Var;
            stVar.j = 1;
            objD = uf4.d(qa0Var, mfVar, stVar);
            if (objD != t70Var) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                bz3.g(objD);
                return objD;
            }
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ry0Var = stVar.e;
        bz3.g(objD);
        Context context = this.a;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        kf kfVar = new kf(contentResolver, (ContentValues) objD);
        stVar.e = ry0Var;
        stVar.j = 2;
        q92 q92Var = new q92(fp4.b(stVar), t70.b);
        ry0Var.E(kfVar, al4.b(context), new uf1(9, q92Var));
        Object objA = q92Var.a();
        return objA == t70Var ? t70Var : objA;
    }
}
