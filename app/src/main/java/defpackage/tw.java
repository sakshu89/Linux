package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.core.impl.utils.SurfaceUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tw {
    public bv2 d;
    public bv2 e;
    public kh2 f;
    public int i;
    public wp j;
    public tp k;
    public final jb o;
    public final q82 p;
    public final ph q;
    public final boolean r;
    public final Object a = new Object();
    public final ArrayList b = new ArrayList();
    public final HashMap g = new HashMap();
    public List h = Collections.EMPTY_LIST;
    public HashMap l = new HashMap();
    public final rh2 m = new rh2(1);
    public final rh2 n = new rh2(3);
    public final sw c = new sw(this);

    public tw(q82 q82Var, cq0 cq0Var, boolean z) {
        this.i = 1;
        this.i = 2;
        this.p = q82Var;
        this.o = new jb(cq0Var.c(CaptureNoResponseQuirk.class));
        this.q = new ph(cq0Var, 3);
        this.r = z;
    }

    public static cr b(List list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        CameraCaptureSession.CaptureCallback crVar;
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            es esVar = (es) it.next();
            if (esVar == null) {
                crVar = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                hh4.a(esVar, arrayList2);
                crVar = arrayList2.size() == 1 ? (CameraCaptureSession.CaptureCallback) arrayList2.get(0) : new cr(arrayList2);
            }
            arrayList.add(crVar);
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return new cr(arrayList);
    }

    public static HashMap c(HashMap map, HashMap map2) {
        HashMap map3 = new HashMap();
        for (Integer num : map.keySet()) {
            num.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) map.get(num)).iterator();
            if (it.hasNext()) {
                SurfaceUtil.a((Surface) map2.get(((dj) it.next()).a));
                a7.D();
                throw null;
            }
            xq4.a("CaptureSession", "Skips to create instances for multi-resolution output. imageFormat: 0, streamInfos size: " + arrayList.size());
        }
        return map3;
    }

    public static HashMap f(ArrayList arrayList) {
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            dj djVar = (dj) obj;
            int i2 = djVar.d;
            if (i2 > 0 && djVar.b.isEmpty()) {
                List arrayList2 = (List) map.get(Integer.valueOf(i2));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(Integer.valueOf(i2), arrayList2);
                }
                arrayList2.add(djVar);
            }
        }
        HashMap map2 = new HashMap();
        for (Integer num : map.keySet()) {
            num.getClass();
            if (((List) map.get(num)).size() >= 2) {
                map2.put(num, (List) map.get(num));
            }
        }
        return map2;
    }

    public final void a() {
        synchronized (this.a) {
            try {
                int iX = cq.x(this.i);
                if (iX == 0) {
                    throw new IllegalStateException("close() should not be possible in state: ".concat(cq.z(this.i)));
                }
                if (iX == 1) {
                    this.i = 8;
                } else if (iX == 2) {
                    hh1.d(this.d, "The Opener shouldn't null in state:".concat(cq.z(this.i)));
                    this.d.q();
                    this.i = 8;
                } else if (iX == 3 || iX == 4) {
                    hh1.d(this.d, "The Opener shouldn't null in state:".concat(cq.z(this.i)));
                    this.d.q();
                    this.i = 6;
                    this.o.i();
                    this.f = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        if (this.i == 8) {
            xq4.c(3, "CaptureSession");
            return;
        }
        this.i = 8;
        this.e = null;
        tp tpVar = this.k;
        if (tpVar != null) {
            tpVar.a(null);
            this.k = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a2  */
    public final ws1 e(dj djVar, HashMap map, String str) {
        long jLongValue;
        ob0 ob0Var = djVar.a;
        List list = djVar.b;
        Surface surface = (Surface) map.get(ob0Var);
        hh1.d(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        ws1 ws1Var = new ws1(djVar.d, surface);
        ys1 ys1Var = ws1Var.a;
        if (str != null) {
            ys1Var.e(str);
        } else {
            ys1Var.e(null);
        }
        int i = djVar.c;
        if (i == 0) {
            ys1Var.d(1);
        } else if (i == 1) {
            ys1Var.d(2);
        }
        if (!list.isEmpty()) {
            ((OutputConfiguration) ys1Var.a()).enableSurfaceSharing();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Surface surface2 = (Surface) map.get((ob0) it.next());
                hh1.d(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                ((OutputConfiguration) ys1Var.a()).addSurface(surface2);
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            q82 q82Var = this.p;
            q82Var.getClass();
            hh1.e("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", i2 >= 33);
            DynamicRangeProfiles dynamicRangeProfilesUnwrap = ((kg0) q82Var.a).unwrap();
            if (dynamicRangeProfilesUnwrap == null) {
                jLongValue = 1;
            } else {
                ig0 ig0Var = djVar.e;
                Long lA = jg0.a(ig0Var, dynamicRangeProfilesUnwrap);
                if (lA == null) {
                    xq4.a("CaptureSession", "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + ig0Var);
                    jLongValue = 1;
                } else {
                    jLongValue = lA.longValue();
                }
            }
        } else {
            jLongValue = 1;
        }
        ys1Var.c(jLongValue);
        return ws1Var;
    }

    public final boolean g() {
        boolean z;
        synchronized (this.a) {
            int i = this.i;
            z = i == 5 || i == 4;
        }
        return z;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h(ArrayList arrayList) {
        ls lsVar;
        synchronized (this.a) {
            try {
                int i = 5;
                if (this.i != 5) {
                    xq4.c(3, "CaptureSession");
                    return;
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                try {
                    iq iqVar = new iq(1);
                    ArrayList arrayList2 = new ArrayList();
                    xq4.c(3, "CaptureSession");
                    int size = arrayList.size();
                    boolean z = false;
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        lw lwVar = (lw) obj;
                        if (!Collections.unmodifiableList(lwVar.a).isEmpty()) {
                            Iterator it = Collections.unmodifiableList(lwVar.a).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    if (lwVar.c == 2) {
                                        z = true;
                                    }
                                    ur urVar = new ur(lwVar);
                                    if (lwVar.c == i && (lsVar = lwVar.h) != null) {
                                        urVar.h = lsVar;
                                    }
                                    kh2 kh2Var = this.f;
                                    if (kh2Var != null) {
                                        urVar.c(kh2Var.g.b);
                                    }
                                    urVar.c(lwVar.b);
                                    lw lwVarD = urVar.d();
                                    bv2 bv2Var = this.e;
                                    bv2Var.g.getClass();
                                    CaptureRequest captureRequestC = jg4.c(lwVarD, ((CameraCaptureSession) ((l11) bv2Var.g.a).b).getDevice(), this.g, false, this.q);
                                    if (captureRequestC != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        Iterator it2 = lwVar.e.iterator();
                                        while (it2.hasNext()) {
                                            hh4.a((es) it2.next(), arrayList3);
                                        }
                                        iqVar.a(captureRequestC, arrayList3);
                                        arrayList2.add(captureRequestC);
                                        i = 5;
                                        break;
                                    }
                                    xq4.c(3, "CaptureSession");
                                    return;
                                }
                                ob0 ob0Var = (ob0) it.next();
                                if (!this.g.containsKey(ob0Var)) {
                                    Objects.toString(ob0Var);
                                    xq4.c(3, "CaptureSession");
                                    break;
                                }
                            }
                        } else {
                            xq4.c(3, "CaptureSession");
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        xq4.c(3, "CaptureSession");
                        return;
                    }
                    if (this.m.c(arrayList2, z)) {
                        bv2 bv2Var2 = this.e;
                        hh1.d(bv2Var2.g, "Need to call openCaptureSession before using this API.");
                        ((CameraCaptureSession) ((l11) bv2Var2.g.a).b).stopRepeating();
                        iqVar.c = new qw(this);
                    }
                    if (this.n.b(arrayList2, z)) {
                        iqVar.a((CaptureRequest) arrayList2.get(arrayList2.size() - 1), Collections.singletonList(new cr(this)));
                    }
                    this.e.i(arrayList2, iqVar);
                } catch (CameraAccessException e) {
                    xq4.a("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(List list) {
        synchronized (this.a) {
            try {
                switch (cq.x(this.i)) {
                    case 0:
                        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: ".concat(cq.z(this.i)));
                    case 1:
                    case 2:
                    case 3:
                        this.b.addAll(list);
                        break;
                    case 4:
                        this.b.addAll(list);
                        this.o.d().a(new s7(13, this), xg4.a());
                        break;
                    case 5:
                    case 6:
                    case 7:
                        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(kh2 kh2Var) {
        synchronized (this.a) {
            try {
                if (kh2Var == null) {
                    xq4.c(3, "CaptureSession");
                    return;
                }
                if (this.i != 5) {
                    xq4.c(3, "CaptureSession");
                    return;
                }
                lw lwVar = kh2Var.g;
                if (Collections.unmodifiableList(lwVar.a).isEmpty()) {
                    xq4.c(3, "CaptureSession");
                    try {
                        bv2 bv2Var = this.e;
                        hh1.d(bv2Var.g, "Need to call openCaptureSession before using this API.");
                        ((CameraCaptureSession) ((l11) bv2Var.g.a).b).stopRepeating();
                    } catch (CameraAccessException e) {
                        xq4.a("CaptureSession", "Unable to access camera: " + e.getMessage());
                        Thread.dumpStack();
                    }
                    return;
                }
                try {
                    xq4.c(3, "CaptureSession");
                    bv2 bv2Var2 = this.e;
                    bv2Var2.g.getClass();
                    CaptureRequest captureRequestC = jg4.c(lwVar, ((CameraCaptureSession) ((l11) bv2Var2.g.a).b).getDevice(), this.g, true, this.q);
                    if (captureRequestC == null) {
                        xq4.c(3, "CaptureSession");
                        return;
                    } else {
                        this.e.o(captureRequestC, this.o.c(b(lwVar.e, new CameraCaptureSession.CaptureCallback[0])));
                        return;
                    }
                } catch (CameraAccessException e2) {
                    xq4.a("CaptureSession", "Unable to access camera: " + e2.getMessage());
                    Thread.dumpStack();
                    return;
                }
                throw th;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final wc1 k(kh2 kh2Var, CameraDevice cameraDevice, bv2 bv2Var) {
        wc1 wc1VarP;
        synchronized (this.a) {
            try {
                if (cq.x(this.i) != 1) {
                    xq4.a("CaptureSession", "Open not allowed in state: ".concat(cq.z(this.i)));
                    return new mz0(1, new IllegalStateException("open() should not allow the state: ".concat(cq.z(this.i))));
                }
                this.i = 3;
                ArrayList arrayList = new ArrayList(kh2Var.b());
                this.h = arrayList;
                this.d = bv2Var;
                synchronized (bv2Var.p) {
                    bv2Var.q = arrayList;
                    wc1VarP = bv2Var.p(arrayList);
                }
                xw xwVarG = oz3.g(jr0.b(wc1VarP), new rw(this, kh2Var, cameraDevice), this.d.d);
                uf1 uf1Var = new uf1(11, this);
                xwVarG.a(new or0(0, xwVarG, uf1Var), this.d.d);
                return oz3.e(xwVarG);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final wc1 l() {
        synchronized (this.a) {
            try {
                switch (cq.x(this.i)) {
                    case 0:
                        throw new IllegalStateException("release() should not be possible in state: ".concat(cq.z(this.i)));
                    case 2:
                        hh1.d(this.d, "The Opener shouldn't null in state:".concat(cq.z(this.i)));
                        this.d.q();
                    case 1:
                        this.i = 8;
                        return mz0.c;
                    case 4:
                    case 5:
                        bv2 bv2Var = this.e;
                        if (bv2Var != null) {
                            bv2Var.j();
                            break;
                        }
                    case 3:
                        this.i = 7;
                        this.o.i();
                        hh1.d(this.d, "The Opener shouldn't null in state:".concat(cq.z(this.i)));
                        if (this.d.q()) {
                            d();
                            return mz0.c;
                        }
                    case 6:
                        if (this.j == null) {
                            this.j = hg4.a(new qw(this));
                        }
                        return this.j;
                    default:
                        return mz0.c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(kh2 kh2Var) {
        synchronized (this.a) {
            try {
                switch (cq.x(this.i)) {
                    case 0:
                        throw new IllegalStateException("setSessionConfig() should not be possible in state: ".concat(cq.z(this.i)));
                    case 1:
                    case 2:
                    case 3:
                        this.f = kh2Var;
                        break;
                    case 4:
                        this.f = kh2Var;
                        if (kh2Var == null) {
                            return;
                        }
                        if (!this.g.keySet().containsAll(kh2Var.b())) {
                            xq4.a("CaptureSession", "Does not have the proper configured lists");
                            return;
                        } else {
                            xq4.c(3, "CaptureSession");
                            j(this.f);
                        }
                        break;
                    case 5:
                    case 6:
                    case 7:
                        throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
