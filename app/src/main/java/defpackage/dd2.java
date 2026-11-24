package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dd2 implements bl2 {
    public final Context a;
    public final r2 b;
    public final zv1 c;
    public final Set d;
    public final l82 e;

    public dd2(Context context, r2 r2Var, zv1 zv1Var) {
        r2Var.getClass();
        zv1Var.getClass();
        this.a = context;
        this.b = r2Var;
        this.c = zv1Var;
        this.d = wh2.b(new w3("device.screenshot"));
        this.e = l82.a;
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.d;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "device.screenshot";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Takes a screenshot and saves it to the gallery.";
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008f A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #1 {all -> 0x0033, blocks: (B:13:0x002f, B:32:0x008b, B:34:0x008f), top: B:62:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x008f, please report this as an issue */
    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) throws Throwable {
        bd2 bd2Var;
        Throwable th;
        Bitmap bitmap;
        AccessibilityService accessibilityServiceI;
        Uri uri;
        if (x50Var instanceof bd2) {
            bd2Var = (bd2) x50Var;
            int i = bd2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                bd2Var.j = i - Integer.MIN_VALUE;
            } else {
                bd2Var = new bd2(this, (y50) x50Var);
            }
        } else {
            bd2Var = new bd2(this, (y50) x50Var);
        }
        Object objC = bd2Var.f;
        int i2 = bd2Var.j;
        r2 r2Var = this.b;
        int i3 = 2;
        x50 x50Var2 = null;
        t70 t70Var = t70.a;
        if (i2 == 0) {
            bz3.g(objC);
            if (Build.VERSION.SDK_INT >= 30) {
                x00 x00VarA = ui4.a();
                ss0 ss0Var = new ss0(x00VarA, i3);
                r2Var.getClass();
                r2Var.o(new f2(ss0Var, 0));
                d60 d60Var = new d60(x00VarA, x50Var2, 4);
                bd2Var.j = 1;
                objC = xc4.c(3000L, d60Var, bd2Var);
                if (objC != t70Var) {
                }
                return t70Var;
            }
            int i4 = Build.VERSION.SDK_INT;
            r2Var.getClass();
            if (i4 >= 28) {
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bitmap = bd2Var.e;
            try {
                bz3.g(objC);
                uri = (Uri) objC;
                if (uri == null) {
                    try {
                        bitmap.recycle();
                    } catch (Throwable unused) {
                    }
                    int i5 = Build.VERSION.SDK_INT;
                    r2Var.getClass();
                    return (i5 >= 28 || (accessibilityServiceI = r2Var.i()) == null || !accessibilityServiceI.performGlobalAction(9)) ? new fl2("I couldn't take a screenshot.", "AccessibilityService screenshot action was refused or unavailable", null, false, 4) : new hl2("Capturing your screen right now.", "taking system screenshot", new c73("System screenshot dispatched"), null, false, 24);
                }
                String string = uri.toString();
                string.getClass();
                il2 il2Var = new il2("Screenshot saved to your gallery.", new d73("MediaStore.Images.Media", string), null, "Saved as " + uri, 4);
                try {
                    bitmap.recycle();
                } catch (Throwable unused2) {
                }
                return il2Var;
            } catch (Throwable th2) {
                th = th2;
                try {
                    bitmap.recycle();
                    throw th;
                } catch (Throwable unused3) {
                    throw th;
                }
            }
        }
        bz3.g(objC);
        Bitmap bitmap2 = (Bitmap) objC;
        if (bitmap2 != null) {
            try {
                bd2Var.e = bitmap2;
                bd2Var.j = 2;
                try {
                    xa0 xa0Var = ld0.a;
                    Object objD = uf4.d(qa0.c, new f61(this, bitmap2, x50Var2, i3), bd2Var);
                    if (objD != t70Var) {
                        objC = objD;
                        bitmap = bitmap2;
                        uri = (Uri) objC;
                        if (uri == null) {
                            String string2 = uri.toString();
                            string2.getClass();
                            il2 il2Var2 = new il2("Screenshot saved to your gallery.", new d73("MediaStore.Images.Media", string2), null, "Saved as " + uri, 4);
                            bitmap.recycle();
                            return il2Var2;
                        }
                        bitmap.recycle();
                    }
                    return t70Var;
                } catch (Throwable th3) {
                    th = th3;
                    bitmap = bitmap2;
                    bitmap.recycle();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        r2Var.getClass();
        if (i6 >= 28) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        cd2 cd2Var;
        if (y50Var instanceof cd2) {
            cd2Var = (cd2) y50Var;
            int i = cd2Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                cd2Var.i = i - Integer.MIN_VALUE;
            } else {
                cd2Var = new cd2(this, y50Var);
            }
        } else {
            cd2Var = new cd2(this, y50Var);
        }
        Object objE = cd2Var.e;
        int i2 = cd2Var.i;
        if (i2 == 0) {
            bz3.g(objE);
            int i3 = Build.VERSION.SDK_INT;
            r2 r2Var = this.b;
            r2Var.getClass();
            if (i3 < 28) {
                return new c32("Taking screenshots requires Android 9 or newer", null);
            }
            zv1 zv1Var = this.c;
            np2 np2Var = np2.c;
            if (!zv1Var.b(np2Var)) {
                return new c32("SONIC needs Android's accessibility access to take a screenshot", zv1.d(np2Var));
            }
            cd2Var.i = 1;
            objE = r2Var.e(2000L, cd2Var);
            t70 t70Var = t70.a;
            if (objE == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objE);
        }
        return !((Boolean) objE).booleanValue() ? new c32("SONIC's screen service is still starting up", null) : a32.a;
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final List k() {
        return ii0.a;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.e;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "Screenshot";
    }

    @Override // defpackage.bl2
    public final void f() {
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
