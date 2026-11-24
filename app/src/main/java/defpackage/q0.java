package defpackage;

import android.media.session.MediaController;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q0 extends gr0 implements hq0 {
    public final /* synthetic */ int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(int i, Object obj, Class cls, String str, String str2, int i2, int i3, int i4) {
        super(i, obj, cls, str, str2, i2, i3);
        this.k = i4;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0241  */
    /* JADX WARN: Code duplicated, block: B:136:0x026d  */
    /* JADX WARN: Code duplicated, block: B:139:0x0278  */
    /* JADX WARN: Code duplicated, block: B:149:0x029c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0083  */
    /* JADX WARN: Code duplicated, block: B:44:0x00df  */
    /* JADX WARN: Code duplicated, block: B:76:0x016b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [f51, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r6v0, types: [x50] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r6v52 */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v54 */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // defpackage.hq0
    public final Object j(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr;
        Object h72Var;
        Object value;
        Object g43Var;
        r00 r00Var;
        Object r2;
        f51 f51Var;
        Integer numValueOf;
        int i = this.k;
        int i2 = 2;
        boolean z = false;
        z = false;
        z = false;
        z = false;
        boolean z2 = false;
        z = false;
        z = false;
        z = false;
        int i3 = 1;
        int i4 = 3;
        var r6 = 0;
        r6 = 0;
        r6 = 0;
        r6 = 0;
        r6 = 0;
        q43 q43Var = q43.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                ky kyVar = (ky) obj2;
                rl1 rl1Var = kyVar.l0;
                if (zBooleanValue) {
                    kyVar.P0();
                } else {
                    if (kyVar.X != null) {
                        Object[] objArr2 = rl1Var.c;
                        long[] jArr = rl1Var.a;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i5 = 0;
                            while (true) {
                                long j = jArr[i5];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i6 = 8;
                                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                                    int i8 = 0;
                                    while (i8 < i7) {
                                        if ((j & 255) < 128) {
                                            uf4.b(kyVar.w0(), null, new v0(kyVar, (b02) objArr2[(i5 << 3) + i8], r6, z ? 1 : 0), 3);
                                        }
                                        j >>= i6;
                                        i8++;
                                        i6 = i6;
                                        objArr2 = objArr2;
                                    }
                                    objArr = objArr2;
                                    if (i7 == i6) {
                                    }
                                } else {
                                    objArr = objArr2;
                                }
                                if (i5 != length) {
                                    i5++;
                                    objArr2 = objArr;
                                }
                            }
                        }
                        b02 b02Var = kyVar.n0;
                        if (b02Var != null) {
                            uf4.b(kyVar.w0(), null, new v0(kyVar, b02Var, r6, 1), 3);
                        }
                    }
                    rl1Var.a();
                    kyVar.n0 = null;
                }
                return q43Var;
            case 1:
                ((i41) obj2).r((Throwable) obj);
                return q43Var;
            case 2:
                Boolean bool = (Boolean) obj;
                boolean zBooleanValue2 = bool.booleanValue();
                so2 so2Var = (so2) obj2;
                co2 co2Var = so2Var.d;
                jr2 jr2Var = co2Var.f;
                jr2Var.getClass();
                jr2Var.j(null, bool);
                if (zBooleanValue2) {
                    co2Var.c();
                }
                if (zBooleanValue2) {
                    so2Var.k.j();
                }
                return q43Var;
            case 3:
                String str = (String) obj;
                str.getClass();
                so2 so2Var2 = (so2) obj2;
                jr2 jr2Var2 = so2Var2.n;
                ii1 ii1Var = so2Var2.m;
                mt0 mt0Var = so2Var2.k;
                String string = cs2.V(str).toString();
                if (string.length() != 0) {
                    if (xy.o(string)) {
                        so2Var2.p();
                    } else {
                        if (ii1Var != null) {
                            try {
                                if (ii1Var.b.a()) {
                                    MediaController mediaControllerG = ii1Var.g(null);
                                    ro1 ro1VarF = mediaControllerG != null ? ii1Var.f(mediaControllerG) : null;
                                    if (ro1VarF != null && ro1VarF.f) {
                                        z = true;
                                    }
                                }
                            } catch (Throwable th) {
                                h72Var = new h72(th);
                            }
                        }
                        h72Var = Boolean.valueOf(z);
                        Boolean bool2 = Boolean.FALSE;
                        boolean z3 = h72Var instanceof h72;
                        Object obj3 = h72Var;
                        if (z3) {
                            obj3 = bool2;
                        }
                        boolean zBooleanValue3 = ((Boolean) obj3).booleanValue();
                        if ((((eo2) jr2Var2.getValue()).l || ((ee1) mt0Var.l.a.getValue()).b) && xy.q(string, zBooleanValue3)) {
                            so2Var2.d.c();
                            mt0Var.p();
                        } else if (so2Var2.o()) {
                            so2Var2.F = null;
                            if (!so2Var2.r || so2Var2.E || !mt0Var.n(string)) {
                                so2Var2.F = string;
                                so2Var2.j();
                                do {
                                    value = jr2Var2.getValue();
                                } while (!jr2Var2.h(value, eo2.a((eo2) value, null, null, null, null, string, null, null, null, false, false, false, false, false, so2Var2.r ? "Waiting for Gemini Live. Your request is queued and hasn't run yet." : "Your request is queued. Tap the orb to start Sonic.", 0L, 24559)));
                            }
                        } else {
                            uf4.b(gb4.c(so2Var2), null, new ko2(so2Var2, string, r6, i3), 3);
                        }
                    }
                }
                return q43Var;
            case 4:
                h52 h52Var = (h52) obj;
                h52Var.getClass();
                so2 so2Var3 = (so2) obj2;
                so2Var3.getClass();
                if (h52Var instanceof e52) {
                    g43Var = new f43(((e52) h52Var).a);
                } else if (h52Var instanceof f52) {
                    f52 f52Var = (f52) h52Var;
                    g43Var = new d43(f52Var.a, f52Var.b);
                } else if (h52Var instanceof d52) {
                    g43Var = new g43(((d52) h52Var).c);
                } else {
                    if (!(h52Var instanceof g52)) {
                        dk0.l();
                        return null;
                    }
                    g43Var = new g43(((g52) h52Var).b);
                }
                so2Var3.p.s(g43Var);
                return q43Var;
            case 5:
                boolean zBooleanValue4 = ((Boolean) obj).booleanValue();
                oj2 oj2Var = (oj2) obj2;
                if (zBooleanValue4) {
                    oj2Var.getClass();
                } else {
                    yq2 yq2Var = oj2Var.k;
                    if (yq2Var != null) {
                        yq2Var.e(null);
                    }
                    oj2Var.h.o();
                }
                uf4.b(gb4.c(oj2Var), null, new nj2(zBooleanValue4, oj2Var, null), 3);
                return q43Var;
            case 6:
                boolean zBooleanValue5 = ((Boolean) obj).booleanValue();
                oj2 oj2Var2 = (oj2) obj2;
                oj2Var2.getClass();
                uf4.b(gb4.c(oj2Var2), null, new nj2(oj2Var2, zBooleanValue5, r6, i3), 3);
                return q43Var;
            case 7:
                String str2 = (String) obj;
                str2.getClass();
                oj2 oj2Var3 = (oj2) obj2;
                oj2Var3.getClass();
                String string2 = cs2.V(str2).toString();
                if (string2.length() == 0) {
                    oj2Var3.h();
                } else {
                    yq2 yq2Var2 = oj2Var3.k;
                    if (yq2Var2 == null || !yq2Var2.c()) {
                        for (int i9 = 0; i9 < string2.length(); i9++) {
                            char cCharAt = string2.charAt(i9);
                            if ('!' > cCharAt || cCharAt >= 127) {
                                oj2Var3.i("The key contains invalid characters. Paste only the Gemini API key.");
                            }
                        }
                        oj2Var3.h.o();
                        oj2Var3.k = uf4.b(gb4.c(oj2Var3), null, new sc2(oj2Var3, string2, (x50) r6, i2), 3);
                    }
                }
                return q43Var;
            case 8:
                l82 l82Var = (l82) obj;
                l82Var.getClass();
                oj2 oj2Var4 = (oj2) obj2;
                oj2Var4.getClass();
                uf4.b(gb4.c(oj2Var4), null, new sc2(oj2Var4, l82Var, (x50) r6, i4), 3);
                return q43Var;
            case 9:
                ((so2) obj2).v(((Boolean) obj).booleanValue());
                return q43Var;
            case 10:
                boolean zBooleanValue6 = ((Boolean) obj).booleanValue();
                oj2 oj2Var5 = (oj2) obj2;
                oj2Var5.getClass();
                uf4.b(gb4.c(oj2Var5), null, new nj2(oj2Var5, zBooleanValue6, r6, i4), 3);
                return q43Var;
            case 11:
                boolean zBooleanValue7 = ((Boolean) obj).booleanValue();
                oj2 oj2Var6 = (oj2) obj2;
                oj2Var6.getClass();
                uf4.b(gb4.c(oj2Var6), null, new nj2(oj2Var6, zBooleanValue7, r6, i2), 3);
                return q43Var;
            case 12:
                l61 l61Var = (l61) obj;
                l61Var.getClass();
                sj2 sj2Var = (sj2) obj2;
                sj2Var.getClass();
                uf4.b(gb4.c(sj2Var), null, new sc2(sj2Var, l61Var, (x50) r6, 5), 3);
                return q43Var;
            case 13:
                ((so2) obj2).v(((Boolean) obj).booleanValue());
                return q43Var;
            case 14:
                e5 e5Var = (e5) obj;
                e5Var.getClass();
                ((so2) obj2).t(e5Var);
                return q43Var;
            case 15:
                e5 e5Var2 = (e5) obj;
                e5Var2.getClass();
                ((so2) obj2).t(e5Var2);
                return q43Var;
            case 16:
                e5 e5Var3 = (e5) obj;
                e5Var3.getClass();
                ((so2) obj2).t(e5Var3);
                return q43Var;
            case 17:
                e5 e5Var4 = (e5) obj;
                e5Var4.getClass();
                ((so2) obj2).t(e5Var4);
                return q43Var;
            case 18:
                String str3 = (String) obj;
                str3.getClass();
                ((bq2) obj2).getClass();
                return bq2.y(str3);
            case 19:
                long j2 = ((jp1) obj).a;
                hx2 hx2Var = (hx2) obj2;
                hx2Var.getClass();
                lx2 lx2Var = (lx2) ij4.a(hx2Var, mx2.a);
                if (lx2Var != null) {
                    uf4.b(hx2Var.w0(), null, new s0(hx2Var, j2, lx2Var, new gx2(hx2Var, j2), (x50) null), 3);
                }
                return q43Var;
            case 20:
                ((ax2) obj2).b.a((hq0) obj);
                return q43Var;
            default:
                KeyEvent keyEvent = ((g51) obj).a;
                yx2 yx2Var = (yx2) obj2;
                nz2 nz2Var = yx2Var.f;
                boolean z4 = yx2Var.d;
                if (keyEvent.getAction() != 0 || Character.isISOControl(keyEvent.getUnicodeChar())) {
                    r00Var = null;
                } else {
                    z90 z90Var = yx2Var.i;
                    z90Var.getClass();
                    int unicodeChar = keyEvent.getUnicodeChar();
                    if ((Integer.MIN_VALUE & unicodeChar) != 0) {
                        z90Var.a = Integer.valueOf(unicodeChar & Integer.MAX_VALUE);
                        numValueOf = null;
                    } else {
                        Integer num = z90Var.a;
                        if (num != null) {
                            z90Var.a = null;
                            int deadChar = KeyCharacterMap.getDeadChar(num.intValue(), unicodeChar);
                            Integer numValueOf2 = Integer.valueOf(deadChar);
                            if (deadChar == 0) {
                                numValueOf2 = null;
                            }
                            if (numValueOf2 != null) {
                                unicodeChar = numValueOf2.intValue();
                            }
                            numValueOf = Integer.valueOf(unicodeChar);
                        } else {
                            numValueOf = Integer.valueOf(unicodeChar);
                        }
                    }
                    if (numValueOf != null) {
                        r00Var = new r00(new StringBuilder().appendCodePoint(numValueOf.intValue()).toString(), 1);
                    } else {
                        r00Var = null;
                    }
                }
                if (r00Var != null) {
                    if (z4) {
                        yx2Var.a(nz.h(r00Var));
                        nz2Var.a = null;
                        z2 = true;
                    }
                } else if (h51.b(keyEvent) == 2) {
                    yx2Var.j.getClass();
                    if (keyEvent.isShiftPressed() && keyEvent.isAltPressed()) {
                        long jA = mp4.a(keyEvent.getKeyCode());
                        if (d51.a(jA, d51.f)) {
                            r2 = f51.SELECT_LINE_LEFT;
                        } else if (d51.a(jA, d51.g)) {
                            r2 = f51.SELECT_LINE_RIGHT;
                        } else if (d51.a(jA, d51.d)) {
                            r2 = f51.SELECT_HOME;
                        } else if (d51.a(jA, d51.e)) {
                            r2 = f51.SELECT_END;
                        } else {
                            r2 = 0;
                        }
                    } else if (keyEvent.isAltPressed()) {
                        long jA2 = mp4.a(keyEvent.getKeyCode());
                        if (d51.a(jA2, d51.f)) {
                            r2 = f51.LINE_LEFT;
                        } else if (d51.a(jA2, d51.g)) {
                            r2 = f51.LINE_RIGHT;
                        } else if (d51.a(jA2, d51.d)) {
                            r2 = f51.HOME;
                        } else if (d51.a(jA2, d51.e)) {
                            r2 = f51.END;
                        } else {
                            r2 = 0;
                        }
                    } else {
                        r2 = 0;
                    }
                    if (r2 == 0) {
                        py0 py0Var = n51.a;
                        py0Var.getClass();
                        boolean zIsShiftPressed = keyEvent.isShiftPressed();
                        f51 f51Var2 = f51.SELECT_LINE_END;
                        f51 f51Var3 = f51.SELECT_LINE_START;
                        f51 f51Var4 = f51.DELETE_PREV_CHAR;
                        if (zIsShiftPressed && keyEvent.isCtrlPressed()) {
                            long jA3 = mp4.a(keyEvent.getKeyCode());
                            if (d51.a(jA3, d51.f)) {
                                f51Var = f51.SELECT_LEFT_WORD;
                            } else if (d51.a(jA3, d51.g)) {
                                f51Var = f51.SELECT_RIGHT_WORD;
                            } else if (d51.a(jA3, d51.d)) {
                                f51Var = f51.SELECT_PREV_PARAGRAPH;
                            } else if (d51.a(jA3, d51.e)) {
                                f51Var = f51.SELECT_NEXT_PARAGRAPH;
                            } else {
                                f51Var = null;
                            }
                        } else if (keyEvent.isCtrlPressed()) {
                            long jA4 = mp4.a(keyEvent.getKeyCode());
                            if (d51.a(jA4, d51.f)) {
                                f51Var = f51.LEFT_WORD;
                            } else if (d51.a(jA4, d51.g)) {
                                f51Var = f51.RIGHT_WORD;
                            } else if (d51.a(jA4, d51.d)) {
                                f51Var = f51.PREV_PARAGRAPH;
                            } else if (d51.a(jA4, d51.e)) {
                                f51Var = f51.NEXT_PARAGRAPH;
                            } else if (d51.a(jA4, d51.k)) {
                                f51Var = f51Var4;
                            } else if (d51.a(jA4, d51.t)) {
                                f51Var = f51.DELETE_NEXT_WORD;
                            } else if (d51.a(jA4, d51.s)) {
                                f51Var = f51.DELETE_PREV_WORD;
                            } else if (d51.a(jA4, d51.B)) {
                                f51Var = f51.DESELECT;
                            } else {
                                f51Var = null;
                            }
                        } else if (keyEvent.isShiftPressed()) {
                            long jA5 = mp4.a(keyEvent.getKeyCode());
                            if (d51.a(jA5, d51.v)) {
                                f51Var = f51Var3;
                            } else if (d51.a(jA5, d51.w)) {
                                f51Var = f51Var2;
                            } else {
                                f51Var = null;
                            }
                        } else if (keyEvent.isAltPressed()) {
                            long jA6 = mp4.a(keyEvent.getKeyCode());
                            if (d51.a(jA6, d51.s)) {
                                f51Var = f51.DELETE_FROM_LINE_START;
                            } else if (d51.a(jA6, d51.t)) {
                                f51Var = f51.DELETE_TO_LINE_END;
                            } else {
                                f51Var = null;
                            }
                        } else {
                            f51Var = null;
                        }
                        if (f51Var == null) {
                            Object obj4 = py0Var.b;
                            int i10 = m51.k;
                            boolean zIsCtrlPressed = keyEvent.isCtrlPressed();
                            f51 f51Var5 = f51.REDO;
                            if (!zIsCtrlPressed || !keyEvent.isShiftPressed()) {
                                boolean zIsCtrlPressed2 = keyEvent.isCtrlPressed();
                                f51 f51Var6 = f51.COPY;
                                f51 f51Var7 = f51.CUT;
                                f51 f51Var8 = f51.PASTE;
                                if (zIsCtrlPressed2) {
                                    long jA7 = h51.a(keyEvent);
                                    if (d51.a(jA7, d51.j) || d51.a(jA7, d51.x)) {
                                        r6 = f51Var6;
                                    } else if (d51.a(jA7, d51.l)) {
                                        r6 = f51Var8;
                                    } else if (d51.a(jA7, d51.m)) {
                                        r6 = f51Var7;
                                    } else if (d51.a(jA7, d51.i)) {
                                        r6 = f51.SELECT_ALL;
                                    } else if (d51.a(jA7, d51.n)) {
                                        r6 = f51Var5;
                                    } else if (d51.a(jA7, d51.o)) {
                                        r6 = f51.UNDO;
                                    }
                                } else if (!keyEvent.isCtrlPressed()) {
                                    if (keyEvent.isShiftPressed()) {
                                        long jA8 = mp4.a(keyEvent.getKeyCode());
                                        if (d51.a(jA8, d51.f)) {
                                            r6 = f51.SELECT_LEFT_CHAR;
                                        } else if (d51.a(jA8, d51.g)) {
                                            r6 = f51.SELECT_RIGHT_CHAR;
                                        } else if (d51.a(jA8, d51.d)) {
                                            r6 = f51.SELECT_UP;
                                        } else if (d51.a(jA8, d51.e)) {
                                            r6 = f51.SELECT_DOWN;
                                        } else if (d51.a(jA8, d51.C)) {
                                            r6 = f51.SELECT_PAGE_UP;
                                        } else if (d51.a(jA8, d51.D)) {
                                            r6 = f51.SELECT_PAGE_DOWN;
                                        } else if (d51.a(jA8, d51.v)) {
                                            r6 = f51Var3;
                                        } else if (d51.a(jA8, d51.w)) {
                                            r6 = f51Var2;
                                        } else if (d51.a(jA8, d51.x)) {
                                            r6 = f51Var8;
                                        }
                                    } else {
                                        long jA9 = mp4.a(keyEvent.getKeyCode());
                                        if (d51.a(jA9, d51.f)) {
                                            r6 = f51.LEFT_CHAR;
                                        } else if (d51.a(jA9, d51.g)) {
                                            r6 = f51.RIGHT_CHAR;
                                        } else if (d51.a(jA9, d51.d)) {
                                            r6 = f51.UP;
                                        } else if (d51.a(jA9, d51.e)) {
                                            r6 = f51.DOWN;
                                        } else if (d51.a(jA9, d51.h)) {
                                            r6 = f51.CENTER;
                                        } else if (d51.a(jA9, d51.C)) {
                                            r6 = f51.PAGE_UP;
                                        } else if (d51.a(jA9, d51.D)) {
                                            r6 = f51.PAGE_DOWN;
                                        } else if (d51.a(jA9, d51.v)) {
                                            r6 = f51.LINE_START;
                                        } else if (d51.a(jA9, d51.w)) {
                                            r6 = f51.LINE_END;
                                        } else if (d51.a(jA9, d51.r) || d51.a(jA9, d51.E)) {
                                            r6 = f51.NEW_LINE;
                                        } else if (d51.a(jA9, d51.s)) {
                                            r6 = f51Var4;
                                        } else if (d51.a(jA9, d51.t)) {
                                            r6 = f51.DELETE_NEXT_CHAR;
                                        } else if (d51.a(jA9, d51.A)) {
                                            r6 = f51Var8;
                                        } else if (d51.a(jA9, d51.y)) {
                                            r6 = f51Var7;
                                        } else if (d51.a(jA9, d51.z)) {
                                            r6 = f51Var6;
                                        } else if (d51.a(jA9, d51.p)) {
                                            r6 = f51.TAB;
                                        }
                                    }
                                }
                            } else if (d51.a(mp4.a(keyEvent.getKeyCode()), d51.o)) {
                                r6 = f51Var5;
                            }
                            r2 = r6;
                        } else {
                            r2 = f51Var;
                        }
                    }
                    if (r2 != 0 && (!r2.a || z4)) {
                        o42 o42Var = new o42();
                        o42Var.a = true;
                        e2 e2Var = new e2((Object) r2, yx2Var, o42Var, 13);
                        ty2 ty2Var = yx2Var.c;
                        ay2 ay2Var = new ay2(ty2Var, yx2Var.g, yx2Var.a.d(), nz2Var);
                        e2Var.j(ay2Var);
                        boolean zB = oz2.b(ay2Var.f, ty2Var.b);
                        be beVar = ay2Var.g;
                        if (!zB || !g31.a(beVar, ty2Var.a)) {
                            yx2Var.k.j(ty2.a(ty2Var, beVar, ay2Var.f, 4));
                        }
                        m43 m43Var = yx2Var.h;
                        if (m43Var != null) {
                            m43Var.e = true;
                        }
                        z2 = o42Var.a;
                    }
                }
                return Boolean.valueOf(z2);
        }
    }
}
