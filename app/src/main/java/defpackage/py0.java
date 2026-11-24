package defpackage;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class py0 implements o72, c90, f02, l12, wd, o52, kq1 {
    public final /* synthetic */ int a;
    public Object b;

    public py0(int i) {
        this.a = i;
        switch (i) {
            case 5:
                this.b = new ConcurrentHashMap();
                break;
            case 7:
                int i2 = 16;
                this.b = Build.VERSION.SDK_INT >= 28 ? new el1(i2) : new y74(i2);
                break;
            case 11:
                this.b = (ExtraCroppingQuirk) wc0.a.d(ExtraCroppingQuirk.class);
                break;
            case 12:
                this.b = new LinkedHashSet();
                break;
            case 13:
                this.b = o44.g(Boolean.FALSE);
                break;
            case 22:
                this.b = new kb0();
                break;
            default:
                mg1 mg1Var = new mg1();
                this.b = mg1Var;
                if (!mg1Var.b) {
                    if (mg1Var.c) {
                        ez1.a("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                    }
                    mg1Var.a();
                    mg1Var.c = true;
                    break;
                }
                break;
        }
    }

    public static e91 h(py0 py0Var, int i) {
        ea1 ea1Var = (ea1) py0Var.b;
        bm2 bm2VarA = i44.a();
        hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
        bm2 bm2VarB = i44.b(bm2VarA);
        try {
            x91 x91Var = (x91) ea1Var.f.getValue();
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            f91 f91Var = ea1Var.p;
            long j = x91Var.j;
            boolean z = ea1Var.d;
            j jVar = new j(i, x91Var);
            a50 a50Var = f91Var.c;
            if (a50Var == null) {
                return fl4.f;
            }
            kf kfVar = f91Var.b;
            uz1 uz1Var = (uz1) a50Var.e;
            boolean z2 = uz1Var instanceof ib;
            tz1 tz1Var = new tz1(a50Var, i, kfVar, jVar);
            tz1Var.e = new q40(j);
            if (!z2) {
                uz1Var.a(tz1Var);
            } else if (z) {
                ib ibVar = (ib) uz1Var;
                ibVar.b.add(new x02(1, tz1Var));
                if (!ibVar.c) {
                    ibVar.c = true;
                    ibVar.a.post(ibVar);
                }
            } else {
                ib ibVar2 = (ib) uz1Var;
                ibVar2.b.add(new x02(0, tz1Var));
                if (!ibVar2.c) {
                    ibVar2.c = true;
                    ibVar2.a.post(ibVar2);
                }
            }
            ge4.a(i, "compose:lazy:schedule_prefetch:index");
            return tz1Var;
        } catch (Throwable th) {
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            throw th;
        }
    }

    @Override // defpackage.f02
    public void a(fu2 fu2Var) {
        s02 iu2Var;
        if (!vc4.c()) {
            al4.b(((r02) this.b).getContext()).execute(new o8(25, this, fu2Var));
            return;
        }
        xq4.c(3, "PreviewView");
        wt wtVar = fu2Var.d;
        ((r02) this.b).n = wtVar.i();
        t02 t02Var = ((r02) this.b).k;
        Rect rectE = wtVar.l().e();
        t02Var.getClass();
        new Rational(rectE.width(), rectE.height());
        synchronized (t02Var) {
            t02Var.b = rectE;
        }
        fu2Var.b(al4.b(((r02) this.b).getContext()), new rw(this, wtVar, fu2Var));
        r02 r02Var = (r02) this.b;
        s02 s02Var = r02Var.b;
        o02 o02Var = r02Var.a;
        if (!(s02Var instanceof iu2) || r02.b(fu2Var, o02Var)) {
            r02 r02Var2 = (r02) this.b;
            boolean zB = r02.b(fu2Var, r02Var2.a);
            r02 r02Var3 = (r02) this.b;
            l02 l02Var = r02Var3.e;
            if (zB) {
                f03 f03Var = new f03(r02Var3, l02Var);
                f03Var.i = false;
                f03Var.k = new AtomicReference();
                iu2Var = f03Var;
            } else {
                iu2Var = new iu2(r02Var3, l02Var);
            }
            r02Var2.b = iu2Var;
        }
        ut utVarI = wtVar.i();
        r02 r02Var4 = (r02) this.b;
        k02 k02Var = new k02(utVarI, r02Var4.i, r02Var4.b);
        ((r02) this.b).j.set(k02Var);
        wtVar.k().f(al4.b(((r02) this.b).getContext()), k02Var);
        ((r02) this.b).b.e(fu2Var, new rw(this, k02Var, wtVar));
        r02 r02Var5 = (r02) this.b;
        if (r02Var5.indexOfChild(r02Var5.c) == -1) {
            r02 r02Var6 = (r02) this.b;
            r02Var6.addView(r02Var6.c);
        }
    }

    @Override // defpackage.o52
    public void accept(Object obj, Object obj2) {
        iw2 iw2Var = (iw2) obj2;
        pe3 pe3Var = (pe3) ((te3) obj).p();
        ow2 ow2Var = (ow2) this.b;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(pe3Var.c);
        int i = be3.a;
        if (ow2Var == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            ow2Var.writeToParcel(parcelObtain, 0);
        }
        try {
            pe3Var.b.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            iw2Var.a.e(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // defpackage.c90
    public Object b(vq0 vq0Var, x50 x50Var) {
        return ((c90) this.b).b(new gz1(vq0Var, null, 0), x50Var);
    }

    @Override // defpackage.kq1
    public void c(Object obj) {
        ((iw2) ((py0) this.b).b).a.f();
    }

    @Override // defpackage.c90
    public mm0 d() {
        return ((c90) this.b).d();
    }

    public long e(long j) {
        kb0 kb0Var = (kb0) this.b;
        kb0Var.getClass();
        if (x63.b(j) <= 0.0f || x63.c(j) <= 0.0f) {
            z01.b("maximumVelocity should be a positive value. You specified=" + ((Object) x63.f(j)));
        }
        return se4.a(((z63) kb0Var.b).b(x63.b(j)), ((z63) kb0Var.c).b(x63.c(j)));
    }

    @Override // defpackage.l12
    public void f(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        }
        ((ProfileInstallReceiver) this.b).setResultCode(i);
    }

    public void g() {
        View view = (View) this.b;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override // defpackage.wd
    public im0 get(int i) {
        switch (this.a) {
            case 20:
                return ((jm0[]) this.b)[i];
            default:
                return (im0) this.b;
        }
    }

    public void i(Object obj, String str) {
        obj.getClass();
        if (cs2.A(str)) {
            return;
        }
        ((ConcurrentHashMap) this.b).put(str, obj);
    }

    public void j() {
        View viewFindViewById;
        View view = (View) this.b;
        if (view == null) {
            return;
        }
        if (view.isInEditMode() || view.onCheckIsTextEditor()) {
            view.requestFocus();
            viewFindViewById = view;
        } else {
            viewFindViewById = view.getRootView().findFocus();
        }
        if (viewFindViewById == null) {
            viewFindViewById = view.getRootView().findViewById(R.id.content);
        }
        if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
            return;
        }
        viewFindViewById.post(new s7(26, viewFindViewById));
    }

    public void k(int i, Object obj, ev3 ev3Var) {
        st3 st3Var = (st3) this.b;
        st3Var.n(i, 3);
        ev3Var.h((jt3) obj, st3Var.a);
        st3Var.n(i, 4);
    }

    public void l(int i, Object obj, ev3 ev3Var) {
        jt3 jt3Var = (jt3) obj;
        st3 st3Var = (st3) this.b;
        st3Var.p((i << 3) | 2);
        st3Var.p(jt3Var.a(ev3Var));
        ev3Var.h(jt3Var, st3Var.a);
    }

    public String toString() {
        switch (this.a) {
            case 16:
                return ky0.n(new StringBuilder("<"), (String) this.b, '>');
            default:
                return super.toString();
        }
    }

    public /* synthetic */ py0(int i, boolean z) {
        this.a = i;
    }

    public py0(st3 st3Var) {
        this.a = 26;
        Charset charset = nu3.a;
        this.b = st3Var;
        st3Var.a = this;
    }

    public py0(jc0 jc0Var) {
        this.a = 15;
        this.b = new em0(pp2.a, jc0Var);
    }

    public py0(cq0 cq0Var) {
        this.a = 1;
        this.b = (IncorrectJpegMetadataQuirk) cq0Var.d(IncorrectJpegMetadataQuirk.class);
    }

    public py0(e10 e10Var) {
        this.a = 6;
        this.b = new CopyOnWriteArrayList();
        new HashMap();
    }

    public /* synthetic */ py0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public py0(float f, float f2, vd vdVar) {
        this.a = 20;
        int iB = vdVar.b();
        jm0[] jm0VarArr = new jm0[iB];
        for (int i = 0; i < iB; i++) {
            jm0VarArr[i] = new jm0(f, f2, vdVar.a(i));
        }
        this.b = jm0VarArr;
    }
}
