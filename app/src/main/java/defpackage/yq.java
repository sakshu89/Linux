package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yq implements wt {
    public final lq H;
    public final ru X;
    public final boolean Y;
    public final boolean Z;
    public final sg1 a;
    public final zt b;
    public final ch2 c;
    public boolean c0;
    public boolean d0;
    public final xv0 e;
    public boolean e0;
    public final q91 f;
    public lj1 f0;
    public final lj1 g0;
    public final lj1 h0;
    public final l11 i;
    public final HashSet i0;
    public final kq j;
    public zs j0;
    public final xq k;
    public final Object k0;
    public boolean l0;
    public final nd0 m0;
    public final br n;
    public final q82 n0;
    public final jt2 o0;
    public final l11 p0;
    public volatile int q0 = 3;
    public CameraDevice s;
    public int t;
    public tw u;
    public final LinkedHashMap v;
    public int w;
    public final tq x;

    public yq(Context context, zt ztVar, String str, br brVar, lq lqVar, ru ruVar, Executor executor, Handler handler, nd0 nd0Var, long j) throws su {
        q91 q91Var = new q91(1);
        this.f = q91Var;
        this.t = 0;
        new AtomicInteger(0);
        this.v = new LinkedHashMap();
        this.w = 0;
        this.c0 = false;
        this.d0 = false;
        this.e0 = true;
        this.i0 = new HashSet();
        this.j0 = ct.a;
        this.k0 = new Object();
        this.l0 = false;
        this.p0 = new l11(this);
        this.b = ztVar;
        this.H = lqVar;
        this.X = ruVar;
        xv0 xv0Var = new xv0(handler);
        this.e = xv0Var;
        ch2 ch2Var = new ch2(executor);
        this.c = ch2Var;
        this.k = new xq(this, ch2Var, xv0Var, j);
        this.a = new sg1(str);
        ((pl1) q91Var.b).i(new ld1(vt.CLOSED));
        l11 l11Var = new l11(ruVar);
        this.i = l11Var;
        lj1 lj1Var = new lj1(ch2Var);
        this.g0 = lj1Var;
        this.m0 = nd0Var;
        try {
            ys ysVarB = ztVar.b(str);
            kq kqVar = new kq(ysVarB, xv0Var, ch2Var, new uf1(7, this), brVar.h);
            this.j = kqVar;
            this.n = brVar;
            brVar.l(kqVar);
            brVar.f.j((pl1) l11Var.c);
            this.n0 = q82.A(ysVarB);
            this.u = z();
            this.h0 = new lj1(brVar.h, wc0.a, xv0Var, lj1Var, ch2Var, handler);
            this.Y = brVar.h.c(LegacyCameraOutputConfigNullPointerQuirk.class);
            this.Z = brVar.h.c(LegacyCameraSurfaceCleanupQuirk.class);
            tq tqVar = new tq(this, str);
            this.x = tqVar;
            q82 q82Var = new q82(this);
            synchronized (ruVar.b) {
                hh1.e("Camera is already registered: " + this, !ruVar.e.containsKey(this));
                ruVar.e.put(this, new qu(ch2Var, q82Var, tqVar));
            }
            ztVar.a.E(ch2Var, tqVar);
            this.o0 = new jt2(context, str, ztVar, new su0(10));
        } catch (ds e) {
            throw new su(e);
        }
    }

    public static String v(int i) {
        if (i == 0) {
            return "ERROR_NONE";
        }
        if (i == 1) {
            return "ERROR_CAMERA_IN_USE";
        }
        if (i == 2) {
            return "ERROR_MAX_CAMERAS_IN_USE";
        }
        if (i == 3) {
            return "ERROR_CAMERA_DISABLED";
        }
        if (i != 4) {
            return i != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE";
        }
        return "ERROR_CAMERA_DEVICE";
    }

    public static String w(lj1 lj1Var) {
        StringBuilder sb = new StringBuilder("MeteringRepeating");
        lj1Var.getClass();
        sb.append(lj1Var.hashCode());
        return sb.toString();
    }

    public static String x(o53 o53Var) {
        return o53Var.f() + o53Var.hashCode();
    }

    public final void A(boolean z) {
        if (!z) {
            this.k.e.b = -1L;
        }
        this.k.a();
        this.p0.q();
        t("Opening camera.");
        E(8);
        try {
            this.b.a.D(this.n.a, this.c, s());
        } catch (ds e) {
            t("Unable to open camera due to " + e.getMessage());
            if (e.a == 10001) {
                F(3, new wh(7, e), true);
                return;
            }
            l11 l11Var = this.p0;
            int i = ((yq) l11Var.c).q0;
            yq yqVar = (yq) l11Var.c;
            if (i != 8) {
                yqVar.t("Don't need the onError timeout handler.");
                return;
            }
            yqVar.t("Camera waiting for onError.");
            l11Var.q();
            l11Var.b = new kf(l11Var);
        } catch (SecurityException e2) {
            t("Unable to open camera due to " + e2.getMessage());
            E(7);
            this.k.b();
        }
    }

    public final void B() {
        int i = 0;
        int i2 = 1;
        hh1.e(null, this.q0 == 9);
        jh2 jh2VarA = this.a.a();
        if (!jh2VarA.k || !jh2VarA.j) {
            t("Unable to create capture session due to conflicting configurations");
            return;
        }
        if (!this.X.e(this.s.getId(), this.H.m(this.s.getId()))) {
            t("Unable to create capture session in camera operating mode = " + this.H.c);
            return;
        }
        HashMap map = new HashMap();
        Collection<kh2> collectionB = this.a.b();
        Collection collectionC = this.a.c();
        bi biVar = as2.a;
        ArrayList arrayList = new ArrayList(collectionC);
        for (kh2 kh2Var : collectionB) {
            if (kh2Var.g.b.a.containsKey(biVar) && kh2Var.b().size() != 1) {
                xq4.a("StreamUseCaseUtil", String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", Integer.valueOf(kh2Var.b().size())));
                break;
            }
            if (kh2Var.g.b.a.containsKey(biVar)) {
                int i3 = 0;
                for (kh2 kh2Var2 : collectionB) {
                    if (((r53) arrayList.get(i3)).j() == t53.i) {
                        hh1.e("MeteringRepeating should contain a surface", !kh2Var2.b().isEmpty());
                        map.put((ob0) kh2Var2.b().get(0), 1L);
                    } else if (kh2Var2.g.b.a.containsKey(biVar) && !kh2Var2.b().isEmpty()) {
                        map.put((ob0) kh2Var2.b().get(0), (Long) kh2Var2.g.b.f(biVar));
                    }
                    i3++;
                }
                break;
            }
        }
        tw twVar = this.u;
        synchronized (twVar.a) {
            twVar.l = map;
        }
        tw twVar2 = this.u;
        kh2 kh2VarB = jh2VarA.b();
        CameraDevice cameraDevice = this.s;
        cameraDevice.getClass();
        lj1 lj1Var = this.h0;
        wc1 wc1VarK = twVar2.k(kh2VarB, cameraDevice, new bv2((cq0) lj1Var.f, (cq0) lj1Var.g, (xv0) lj1Var.c, (lj1) lj1Var.e, (ch2) lj1Var.b, (Handler) lj1Var.d));
        wc1VarK.a(new or0(i, wc1VarK, new sq(this, twVar2, i2)), this.c);
    }

    public final void C() {
        if (this.f0 != null) {
            StringBuilder sb = new StringBuilder("MeteringRepeating");
            this.f0.getClass();
            sb.append(this.f0.hashCode());
            String string = sb.toString();
            sg1 sg1Var = this.a;
            LinkedHashMap linkedHashMap = sg1Var.a;
            if (linkedHashMap.containsKey(string)) {
                p53 p53Var = (p53) linkedHashMap.get(string);
                p53Var.e = false;
                if (!p53Var.f) {
                    linkedHashMap.remove(string);
                }
            }
            StringBuilder sb2 = new StringBuilder("MeteringRepeating");
            this.f0.getClass();
            sb2.append(this.f0.hashCode());
            String string2 = sb2.toString();
            LinkedHashMap linkedHashMap2 = sg1Var.a;
            if (linkedHashMap2.containsKey(string2)) {
                p53 p53Var2 = (p53) linkedHashMap2.get(string2);
                p53Var2.f = false;
                if (!p53Var2.e) {
                    linkedHashMap2.remove(string2);
                }
            }
            lj1 lj1Var = this.f0;
            lj1Var.getClass();
            xq4.c(3, "MeteringRepeating");
            nz0 nz0Var = (nz0) lj1Var.b;
            if (nz0Var != null) {
                nz0Var.a();
            }
            lj1Var.b = null;
            this.f0 = null;
        }
    }

    public final void D() {
        kh2 kh2Var;
        List listUnmodifiableList;
        int i = 0;
        hh1.e(null, this.u != null);
        t("Resetting Capture Session");
        tw twVar = this.u;
        synchronized (twVar.a) {
            kh2Var = twVar.f;
        }
        synchronized (twVar.a) {
            listUnmodifiableList = Collections.unmodifiableList(twVar.b);
        }
        tw twVarZ = z();
        this.u = twVarZ;
        twVarZ.m(kh2Var);
        this.u.i(listUnmodifiableList);
        if (cq.x(this.q0) != 8) {
            t("Skipping Capture Session state check due to current camera state: " + cq.y(this.q0) + " and previous session status: " + twVar.g());
        } else if (this.Y && twVar.g()) {
            t("Close camera before creating new session");
            E(6);
        }
        if (this.Z && twVar.g()) {
            t("ConfigAndClose is required when close the camera.");
            this.c0 = true;
        }
        twVar.a();
        wc1 wc1VarL = twVar.l();
        t("Releasing session in state ".concat(cq.w(this.q0)));
        this.v.put(twVar, wc1VarL);
        wc1VarL.a(new or0(i, wc1VarL, new sq(this, twVar, i)), xg4.a());
    }

    public final void E(int i) {
        F(i, null, true);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0106  */
    public final void F(int i, wh whVar, boolean z) {
        vt vtVar;
        vt vtVar2;
        qu quVarA;
        HashMap map;
        vh vhVar;
        t("Transitioning camera internal state: " + cq.y(this.q0) + " --> " + cq.y(i));
        if (hd4.a()) {
            hd4.b(cq.x(i), "CX:C2State[" + this + "]");
            if (whVar != null) {
                this.w++;
            }
            if (this.w > 0) {
                hd4.b(whVar != null ? whVar.a : 0, "CX:C2StateErrorCode[" + this + "]");
            }
        }
        this.q0 = i;
        switch (cq.x(i)) {
            case 0:
                vtVar = vt.RELEASED;
                break;
            case 1:
                vtVar = vt.RELEASING;
                break;
            case 2:
                vtVar = vt.CLOSED;
                break;
            case 3:
                vtVar = vt.PENDING_OPEN;
                break;
            case 4:
            case 5:
                vtVar = vt.CLOSING;
                break;
            case 6:
            case 7:
                vtVar = vt.OPENING;
                break;
            case 8:
                vtVar = vt.OPEN;
                break;
            case 9:
                vtVar = vt.CONFIGURED;
                break;
            default:
                og.n("Unknown state: ".concat(cq.y(i)));
                return;
        }
        ru ruVar = this.X;
        synchronized (ruVar.b) {
            try {
                int i2 = ruVar.f;
                vt vtVar3 = vt.RELEASED;
                HashMap map2 = ruVar.e;
                if (vtVar == vtVar3) {
                    qu quVar = (qu) map2.remove(this);
                    if (quVar != null) {
                        ruVar.b();
                        vtVar2 = quVar.a;
                    } else {
                        vtVar2 = null;
                    }
                } else {
                    qu quVar2 = (qu) map2.get(this);
                    hh1.d(quVar2, "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()");
                    vt vtVar4 = quVar2.a;
                    quVar2.a = vtVar;
                    vt vtVar5 = vt.OPENING;
                    if (vtVar == vtVar5) {
                        hh1.e("Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()", vtVar.a || vtVar4 == vtVar5);
                    }
                    if (vtVar4 != vtVar) {
                        ru.c(this, vtVar);
                        ruVar.b();
                    }
                    vtVar2 = vtVar4;
                }
                if (vtVar2 != vtVar) {
                    if (ruVar.d.c == 2 && vtVar == vt.CONFIGURED) {
                        String strM = ruVar.d.m(i().c());
                        if (strM != null) {
                            quVarA = ruVar.a(strM);
                        } else {
                            quVarA = null;
                        }
                    } else {
                        quVarA = null;
                    }
                    if (i2 < 1 && ruVar.f > 0) {
                        map = new HashMap();
                        for (Map.Entry entry : ruVar.e.entrySet()) {
                            if (((qu) entry.getValue()).a == vt.PENDING_OPEN) {
                                map.put((cs) entry.getKey(), (qu) entry.getValue());
                            }
                        }
                    } else if (vtVar != vt.PENDING_OPEN || ruVar.f <= 0) {
                        map = null;
                    } else {
                        map = new HashMap();
                        map.put(this, (qu) ruVar.e.get(this));
                    }
                    if (map != null && !z) {
                        map.remove(this);
                    }
                    if (map != null) {
                        for (qu quVar3 : map.values()) {
                            quVar3.getClass();
                            try {
                                quVar3.b.execute(new s7(10, quVar3.d));
                            } catch (RejectedExecutionException e) {
                                xq4.b("CameraStateRegistry", "Unable to notify camera to open.", e);
                            }
                        }
                    }
                    if (quVarA != null) {
                        try {
                            quVarA.b.execute(new s7(11, quVarA.c));
                        } catch (RejectedExecutionException e2) {
                            xq4.b("CameraStateRegistry", "Unable to notify camera to configure.", e2);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ((pl1) this.f.b).i(new ld1(vtVar));
        l11 l11Var = this.i;
        l11Var.getClass();
        switch (vtVar) {
            case RELEASED:
            case CLOSED:
                vhVar = new vh(5, whVar);
                break;
            case RELEASING:
            case CLOSING:
                vhVar = new vh(4, whVar);
                break;
            case PENDING_OPEN:
                ru ruVar2 = (ru) l11Var.b;
                synchronized (ruVar2.b) {
                    Iterator it = ruVar2.e.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            vhVar = new vh(1, null);
                        } else if (((qu) ((Map.Entry) it.next()).getValue()).a == vt.CLOSING) {
                            vhVar = new vh(2, null);
                        }
                    }
                }
                break;
            case OPENING:
                vhVar = new vh(2, whVar);
                break;
            case OPEN:
            case CONFIGURED:
                vhVar = new vh(3, whVar);
                break;
            default:
                dk0.q(vtVar, "Unknown internal camera state: ");
                return;
        }
        vhVar.toString();
        vtVar.toString();
        Objects.toString(whVar);
        xq4.c(3, "CameraStateMachine");
        if (Objects.equals((vh) ((pl1) l11Var.c).c(), vhVar)) {
            return;
        }
        vhVar.toString();
        xq4.c(3, "CameraStateMachine");
        ((pl1) l11Var.c).i(vhVar);
    }

    public final ArrayList G(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            o53 o53Var = (o53) obj;
            boolean z = this.e0;
            String strX = x(o53Var);
            Class<?> cls = o53Var.getClass();
            kh2 kh2Var = z ? o53Var.m : o53Var.n;
            r53 r53Var = o53Var.f;
            fj fjVar = o53Var.g;
            arrayList2.add(new uh(strX, cls, kh2Var, r53Var, fjVar != null ? fjVar.a : null, fjVar, o53Var.b() != null ? yr2.E(o53Var) : null));
        }
        return arrayList2;
    }

    public final void H(ArrayList arrayList) {
        boolean z;
        p53 p53Var;
        Size size;
        boolean zIsEmpty = this.a.b().isEmpty();
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        Rational rational = null;
        int i = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            uh uhVar = (uh) obj;
            if (!this.a.d(uhVar.a)) {
                sg1 sg1Var = this.a;
                String str = uhVar.a;
                kh2 kh2Var = uhVar.c;
                r53 r53Var = uhVar.d;
                fj fjVar = uhVar.f;
                List list = uhVar.g;
                LinkedHashMap linkedHashMap = sg1Var.a;
                p53 p53Var2 = (p53) linkedHashMap.get(str);
                if (p53Var2 == null) {
                    p53Var = new p53(kh2Var, r53Var, fjVar, list);
                    linkedHashMap.put(str, p53Var);
                } else {
                    p53Var = p53Var2;
                }
                p53Var.e = true;
                sg1Var.f(str, kh2Var, r53Var, fjVar, list);
                arrayList2.add(uhVar.a);
                if (uhVar.b == g02.class && (size = uhVar.e) != null) {
                    rational = new Rational(size.getWidth(), size.getHeight());
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        t("Use cases [" + TextUtils.join(", ", arrayList2) + "] now ATTACHED");
        if (zIsEmpty) {
            z = true;
            this.j.r(true);
            kq kqVar = this.j;
            synchronized (kqVar.d) {
                kqVar.p++;
            }
        } else {
            z = true;
        }
        p();
        L();
        K();
        D();
        if (this.q0 == 9) {
            B();
        } else {
            int iX = cq.x(this.q0);
            if (iX == 2 || iX == 3) {
                I(false);
            } else if (iX != 4) {
                t("open() ignored due to being in state: ".concat(cq.y(this.q0)));
            } else {
                E(7);
                if (!this.v.isEmpty() && !this.d0 && this.t == 0) {
                    if (this.s == null) {
                        z = false;
                    }
                    hh1.e("Camera Device should be open if session close is not complete", z);
                    E(9);
                    B();
                }
            }
        }
        if (rational != null) {
            this.j.h.getClass();
        }
    }

    public final void I(boolean z) {
        t("Attempting to force open the camera.");
        if (this.X.d(this)) {
            A(z);
        } else {
            t("No cameras available. Waiting for available camera before opening camera.");
            E(4);
        }
    }

    public final void J(boolean z) {
        t("Attempting to open the camera.");
        if (this.x.b && this.X.d(this)) {
            A(z);
        } else {
            t("No cameras available. Waiting for available camera before opening camera.");
            E(4);
        }
    }

    public final void K() {
        sg1 sg1Var = this.a;
        sg1Var.getClass();
        jh2 jh2Var = new jh2();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : sg1Var.a.entrySet()) {
            p53 p53Var = (p53) entry.getValue();
            if (p53Var.f && p53Var.e) {
                String str = (String) entry.getKey();
                jh2Var.a(p53Var.a);
                arrayList.add(str);
            }
        }
        arrayList.toString();
        xq4.c(3, "UseCaseAttachState");
        boolean z = jh2Var.k;
        kq kqVar = this.j;
        if (!z || !jh2Var.j) {
            kqVar.x = 1;
            kqVar.h.d = 1;
            kqVar.n.a = 1;
            this.u.m(kqVar.m());
            return;
        }
        int i = jh2Var.b().g.c;
        kqVar.x = i;
        kqVar.h.d = i;
        kqVar.n.a = i;
        jh2Var.a(kqVar.m());
        this.u.m(jh2Var.b());
    }

    public final void L() {
        Iterator it = this.a.c().iterator();
        boolean zBooleanValue = false;
        while (it.hasNext()) {
            zBooleanValue |= ((Boolean) ((r53) it.next()).d(r53.U, Boolean.FALSE)).booleanValue();
        }
        this.j.l.c = zBooleanValue;
    }

    @Override // defpackage.wt
    public final void b(boolean z) {
        this.c.execute(new aq(this, z, 1));
    }

    @Override // defpackage.n53
    public final void c(o53 o53Var) {
        this.c.execute(new pq(this, x(o53Var), this.e0 ? o53Var.m : o53Var.n, o53Var.f, o53Var.g, o53Var.b() == null ? null : yr2.E(o53Var), 0));
    }

    @Override // defpackage.wt
    public final void d(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList(G(arrayList2));
        ArrayList arrayList4 = new ArrayList(arrayList2);
        int size = arrayList4.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList4.get(i2);
            i2++;
            o53 o53Var = (o53) obj;
            String strX = x(o53Var);
            HashSet hashSet = this.i0;
            if (hashSet.contains(strX)) {
                o53Var.t();
                hashSet.remove(strX);
            }
        }
        this.c.execute(new oq(this, arrayList3, i));
    }

    @Override // defpackage.wt
    public final void e(bt btVar) {
        if (btVar == null) {
            btVar = ct.a;
        }
        btVar.k();
        this.j0 = btVar;
        synchronized (this.k0) {
        }
    }

    @Override // defpackage.wt
    public final void f(ArrayList arrayList) {
        int i;
        kq kqVar = this.j;
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return;
        }
        synchronized (kqVar.d) {
            i = 1;
            kqVar.p++;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        HashSet hashSet = this.i0;
        int size = arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList3.get(i2);
            i2++;
            o53 o53Var = (o53) obj;
            String strX = x(o53Var);
            if (!hashSet.contains(strX)) {
                hashSet.add(strX);
                o53Var.s();
                o53Var.q();
            }
        }
        try {
            this.c.execute(new oq(this, new ArrayList(G(arrayList2)), i));
        } catch (RejectedExecutionException unused) {
            t("Unable to attach use cases.");
            kqVar.k();
        }
    }

    @Override // defpackage.wt
    public final void h(boolean z) {
        this.e0 = z;
    }

    @Override // defpackage.wt
    public final ut i() {
        return this.n;
    }

    @Override // defpackage.n53
    public final void j(o53 o53Var) {
        this.c.execute(new pq(this, x(o53Var), this.e0 ? o53Var.m : o53Var.n, o53Var.f, o53Var.g, o53Var.b() == null ? null : yr2.E(o53Var), 2));
    }

    @Override // defpackage.wt
    public final cp1 k() {
        return this.f;
    }

    @Override // defpackage.wt
    public final gt l() {
        return this.j;
    }

    @Override // defpackage.n53
    public final void m(o53 o53Var) {
        this.c.execute(new o8(7, this, x(o53Var)));
    }

    @Override // defpackage.wt
    public final zs n() {
        return this.j0;
    }

    @Override // defpackage.n53
    public final void o(o53 o53Var) {
        this.c.execute(new pq(this, x(o53Var), this.e0 ? o53Var.m : o53Var.n, o53Var.f, o53Var.g, o53Var.b() == null ? null : yr2.E(o53Var), 1));
    }

    public final void p() {
        sg1 sg1Var = this.a;
        kh2 kh2VarB = sg1Var.a().b();
        lw lwVar = kh2VarB.g;
        int size = Collections.unmodifiableList(lwVar.a).size();
        int size2 = kh2VarB.b().size();
        if (kh2VarB.b().isEmpty()) {
            return;
        }
        boolean zIsEmpty = Collections.unmodifiableList(lwVar.a).isEmpty();
        int i = 2;
        if (!zIsEmpty) {
            if (size2 == 1 && size == 1) {
                C();
                return;
            }
            if (size >= 2) {
                C();
                return;
            } else if (this.f0 == null || y()) {
                xq4.c(3, "Camera2CameraImpl");
                return;
            } else {
                C();
                return;
            }
        }
        if (this.f0 == null) {
            this.f0 = new lj1(this.n.b, this.m0, new nq(this, i));
        }
        if (!y()) {
            xq4.a("Camera2CameraImpl", "Failed to add a repeating surface, CameraControl and ImageCapture may encounter issues due to the absence of repeating surface. Please add a UseCase (Preview or ImageAnalysis) that can provide a repeating surface for CameraControl and ImageCapture to function properly.");
            return;
        }
        lj1 lj1Var = this.f0;
        if (lj1Var != null) {
            String strW = w(lj1Var);
            lj1 lj1Var2 = this.f0;
            kh2 kh2Var = (kh2) lj1Var2.c;
            kj1 kj1Var = (kj1) lj1Var2.d;
            t53 t53Var = t53.i;
            List listSingletonList = Collections.singletonList(t53Var);
            LinkedHashMap linkedHashMap = sg1Var.a;
            p53 p53Var = (p53) linkedHashMap.get(strW);
            if (p53Var == null) {
                p53Var = new p53(kh2Var, kj1Var, null, listSingletonList);
                linkedHashMap.put(strW, p53Var);
            }
            p53Var.e = true;
            sg1Var.f(strW, kh2Var, kj1Var, null, listSingletonList);
            lj1 lj1Var3 = this.f0;
            kh2 kh2Var2 = (kh2) lj1Var3.c;
            kj1 kj1Var2 = (kj1) lj1Var3.d;
            List listSingletonList2 = Collections.singletonList(t53Var);
            LinkedHashMap linkedHashMap2 = sg1Var.a;
            p53 p53Var2 = (p53) linkedHashMap2.get(strW);
            if (p53Var2 == null) {
                p53Var2 = new p53(kh2Var2, kj1Var2, null, listSingletonList2);
                linkedHashMap2.put(strW, p53Var2);
            }
            p53Var2.f = true;
        }
    }

    public final void q() {
        ArrayList arrayList;
        int i = 0;
        hh1.e("closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + cq.y(this.q0) + " (error: " + v(this.t) + ")", this.q0 == 5 || this.q0 == 2 || (this.q0 == 7 && this.t != 0));
        D();
        tw twVar = this.u;
        synchronized (twVar.a) {
            try {
                if (twVar.b.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(twVar.b);
                    twVar.b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                lw lwVar = (lw) obj;
                Iterator it = lwVar.e.iterator();
                while (it.hasNext()) {
                    ((es) it.next()).a(lwVar.a());
                }
            }
        }
    }

    public final void r() {
        int i = 1;
        hh1.e(null, this.q0 == 2 || this.q0 == 5);
        hh1.e(null, this.v.isEmpty());
        if (!this.c0) {
            u();
            return;
        }
        if (this.d0) {
            t("Ignored since configAndClose is processing");
            return;
        }
        if (!this.x.b) {
            this.c0 = false;
            u();
            t("Ignore configAndClose and finish the close flow directly since camera is unavailable.");
        } else {
            t("Open camera to configAndClose");
            wp wpVarA = hg4.a(new nq(this, i));
            this.d0 = true;
            wpVarA.b.a(new s7(4, this), this.c);
        }
    }

    public final CameraDevice.StateCallback s() {
        ArrayList arrayList = new ArrayList(this.a.a().b().c);
        arrayList.add((mt) this.g0.g);
        arrayList.add(this.k);
        return lg4.a(arrayList);
    }

    public final void t(String str) {
        toString();
        xq4.c(3, "Camera2CameraImpl");
    }

    public final String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.n.a);
    }

    public final void u() {
        hh1.e(null, this.q0 == 2 || this.q0 == 5);
        hh1.e(null, this.v.isEmpty());
        this.s = null;
        if (this.q0 == 5) {
            E(3);
            return;
        }
        this.b.a.H(this.x);
        E(1);
    }

    public final boolean y() {
        int i;
        ArrayList arrayList = new ArrayList();
        synchronized (this.k0) {
            try {
                i = this.H.c == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        sg1 sg1Var = this.a;
        sg1Var.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : sg1Var.a.entrySet()) {
            if (((p53) entry.getValue()).e) {
                arrayList2.add((p53) entry.getValue());
            }
        }
        for (p53 p53Var : Collections.unmodifiableCollection(arrayList2)) {
            List list = p53Var.d;
            if (list == null || list.get(0) != t53.i) {
                if (p53Var.c == null || p53Var.d == null) {
                    xq4.d("Camera2CameraImpl", "Invalid stream spec or capture types in " + p53Var);
                    return false;
                }
                kh2 kh2Var = p53Var.a;
                r53 r53Var = p53Var.b;
                for (ob0 ob0Var : kh2Var.b()) {
                    jt2 jt2Var = this.o0;
                    int iP = r53Var.p();
                    hj hjVarB = hj.b(i, iP, ob0Var.h, jt2Var.i(iP));
                    int iP2 = r53Var.p();
                    Size size = ob0Var.h;
                    fj fjVar = p53Var.c;
                    arrayList.add(new rh(hjVarB, iP2, size, fjVar.b, p53Var.d, fjVar.d, (Range) r53Var.d(r53.T, null)));
                }
            }
        }
        this.f0.getClass();
        HashMap map = new HashMap();
        lj1 lj1Var = this.f0;
        map.put((kj1) lj1Var.d, Collections.singletonList((Size) lj1Var.e));
        try {
            this.o0.g(i, arrayList, map, false, false);
            t("Surface combination with metering repeating supported!");
            return true;
        } catch (IllegalArgumentException unused) {
            t("Surface combination with metering repeating  not supported!");
            return false;
        }
    }

    public final tw z() {
        tw twVar;
        synchronized (this.k0) {
            twVar = new tw(this.n0, this.n.h, false);
        }
        return twVar;
    }
}
