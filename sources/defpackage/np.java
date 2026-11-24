package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class np implements bl2 {
    public final /* synthetic */ int a = 1;
    public final Set b;
    public final l82 c;
    public final Object d;
    public final Object e;
    public final Object f;

    public np(Context context, n21 n21Var, hv hvVar) {
        n21Var.getClass();
        hvVar.getClass();
        this.d = context;
        this.e = n21Var;
        this.f = hvVar;
        this.b = wh2.c(new w3("camera.open"), new w3("camera.photo"), new w3("camera.video"), new w3("camera.video.stop"), new w3("gallery.open"));
        this.c = l82.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static void n(Intent intent, String str) {
        ?? r2;
        if (g31.a(str, "front")) {
            r2 = 1;
        } else if (!g31.a(str, "rear")) {
            return;
        } else {
            r2 = 0;
        }
        intent.putExtra("android.intent.extras.CAMERA_FACING", (int) r2);
        intent.putExtra("android.intent.extras.LENS_FACING_FRONT", (int) r2);
        intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", (boolean) r2);
    }

    public static hl2 s(p61 p61Var) {
        String str = p61Var.b;
        if (str == null) {
            str = p61Var.a;
        }
        return new hl2("Here are your photos.", "I can't see what's in them", new c73(cq.v("SONIC opened ", str, " and does not read the user's photo library")), null, false, 24);
    }

    public static jl2 x(mv mvVar, boolean z) {
        if (!(mvVar instanceof lv)) {
            if (mvVar instanceof kv) {
                return new hl2(z ? "I couldn't confirm that video recording started." : "I couldn't confirm that video recording stopped.", ((kv) mvVar).b, new c73("Camera recording transition was not confirmed"), null, false, 24);
            }
            if (mvVar instanceof jv) {
                String str = z ? "The video camera is open, but I couldn't start recording." : "I couldn't stop video recording yet.";
                String str2 = ((jv) mvVar).a;
                return new hl2(str, str2, new c73(str2), null, false, 24);
            }
            if (mvVar instanceof iv) {
                return new hl2(cq.v("I found more than one ", z ? "record" : "stop recording", " control."), "The camera did not expose one clear control", new c73(mz.C(((iv) mvVar).a, null, null, null, null, 63)), null, false, 24);
            }
            dk0.l();
            return null;
        }
        lv lvVar = (lv) mvVar;
        boolean z2 = lvVar.a;
        return new il2(z2 ? "Recording video." : "Video recording is stopped.", new d73("Visible camera recording state", "package=" + lvVar.c + "; recording=" + z2 + "; already=" + lvVar.b), null, null, 12);
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        switch (this.a) {
        }
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b;
    }

    @Override // defpackage.bl2
    public final List c(f5 f5Var) {
        int i = this.a;
        ii0 ii0Var = ii0.a;
        f5Var.getClass();
        switch (i) {
            case 0:
                return g31.a(f5Var.a, "call.dialer") ? ii0Var : (List) this.f;
            default:
                String str = f5Var.a;
                int i2 = Build.VERSION.SDK_INT;
                str.getClass();
                if (str.equals("gallery.open") || str.equals("camera.video.stop")) {
                    return ii0Var;
                }
                if (!str.equals("camera.photo")) {
                    return nz.h("android.permission.CAMERA");
                }
                qc1 qc1VarE = nz.e();
                qc1VarE.add("android.permission.CAMERA");
                if (i2 < 29) {
                    qc1VarE.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                return nz.c(qc1VarE);
        }
    }

    @Override // defpackage.bl2
    public final String d() {
        switch (this.a) {
            case 0:
                return "call.place";
            default:
                return "camera.open";
        }
    }

    @Override // defpackage.bl2
    public final String e() {
        switch (this.a) {
            case 0:
                return "Calls a contact or a number, asking which one when it's ambiguous.";
            default:
                return "Takes a photo with a visible countdown, controls video recording, or opens your photos.";
        }
    }

    @Override // defpackage.bl2
    public final void f() {
        int i = this.a;
    }

    @Override // defpackage.bl2
    public final void g() {
        int i = this.a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x025d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0263  */
    /* JADX WARN: Code duplicated, block: B:103:0x026c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0295  */
    /* JADX WARN: Code duplicated, block: B:109:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:110:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:112:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:113:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:117:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:118:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:122:0x02da  */
    /* JADX WARN: Code duplicated, block: B:124:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:125:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:128:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:130:0x0307  */
    /* JADX WARN: Code duplicated, block: B:133:0x0328  */
    /* JADX WARN: Code duplicated, block: B:134:0x032a  */
    /* JADX WARN: Code duplicated, block: B:136:0x032e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0331  */
    /* JADX WARN: Code duplicated, block: B:141:0x035e  */
    /* JADX WARN: Code duplicated, block: B:143:0x0362  */
    /* JADX WARN: Code duplicated, block: B:145:0x0380  */
    /* JADX WARN: Code duplicated, block: B:147:0x0384  */
    /* JADX WARN: Code duplicated, block: B:148:0x0397  */
    /* JADX WARN: Code duplicated, block: B:150:0x039f  */
    /* JADX WARN: Code duplicated, block: B:151:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0079  */
    /* JADX WARN: Code duplicated, block: B:82:0x01da  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:90:0x0210 A[LOOP:0: B:88:0x020a->B:90:0x0210, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:103:0x026c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:130:0x0307, please report this as an issue */
    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) throws Throwable {
        mp mpVar;
        String str;
        String strC;
        Object objD;
        fl2 fl2Var;
        Object gpVar;
        Object fl2Var2;
        z40 z40Var;
        fl2 fl2Var3;
        List<uw1> list;
        String str2;
        ArrayList arrayList;
        Iterator it;
        List listT;
        String strV;
        ArrayList arrayList2;
        boolean z;
        ArrayList arrayList3;
        boolean z2;
        StringBuilder sb;
        String str3;
        String str4;
        String str5;
        String strConcat;
        String str6;
        String strA;
        Object objR;
        f5 f5Var2 = f5Var;
        int i = 1;
        x50 x50Var2 = null;
        switch (this.a) {
            case 0:
                dp dpVar = (dp) this.d;
                if (x50Var instanceof mp) {
                    mpVar = (mp) x50Var;
                    int i2 = mpVar.n;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        mpVar.n = i2 - Integer.MIN_VALUE;
                    } else {
                        mpVar = new mp(this, (y50) x50Var);
                    }
                } else {
                    mpVar = new mp(this, (y50) x50Var);
                }
                Object fl2Var4 = mpVar.j;
                int i3 = mpVar.n;
                Object obj = t70.a;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            String str7 = mpVar.i;
                            str = mpVar.f;
                            f5 f5Var3 = mpVar.e;
                            bz3.g(fl2Var4);
                            strC = str7;
                            f5Var2 = f5Var3;
                            objD = fl2Var4;
                            z40Var = (z40) objD;
                            if (z40Var instanceof y40) {
                                if (z40Var instanceof u40) {
                                    if (z40Var instanceof w40) {
                                        String str8 = ((w40) z40Var).a;
                                        fl2Var3 = new fl2(cq.v("I couldn't find anyone called \"", str8, "\" in your contacts."), cq.v("no contact matched \"", str8, "\""), null, true, 4);
                                    } else {
                                        if (z40Var instanceof v40) {
                                            if (g31.a(z40Var, x40.a)) {
                                                return new el2(cq.v("I need access to your contacts to look up ", strC, ". If you tell me the number, I can dial it without that."), new z22(nz.h("android.permission.READ_CONTACTS")), new e52(nz.h("android.permission.READ_CONTACTS"), "Allow contact access"));
                                            }
                                            dk0.l();
                                            return null;
                                        }
                                        fl2Var3 = new fl2(cq.v("Your contacts aren't responding yet, so I couldn't check ", strC, "."), "Contact provider unavailable after fresh lookup retries", null, true, 4);
                                    }
                                    return fl2Var3;
                                }
                                u40 u40Var = (u40) z40Var;
                                list = u40Var.b;
                                str2 = u40Var.a;
                                arrayList = new ArrayList(nz.d(list));
                                it = list.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((uw1) it.next()).b);
                                }
                                listT = mz.t(arrayList);
                                if (listT.size() != 1 && list.size() == 1) {
                                    uw1 uw1Var = (uw1) mz.H(list);
                                    String str9 = uw1Var.b;
                                    Locale locale = Locale.ROOT;
                                    String lowerCase = str9.toLowerCase(locale);
                                    lowerCase.getClass();
                                    String lowerCase2 = str2.toLowerCase(locale);
                                    lowerCase2.getClass();
                                    boolean zEquals = lowerCase.equals(lowerCase2);
                                    String str10 = uw1Var.b;
                                    strV = !zEquals ? cq.v("Did you mean ", str10, "?") : cq.v("Call ", str10, "?");
                                } else if (listT.size() > 1) {
                                    strV = cq.v("There's more than one ", str2, ". Which one?");
                                } else {
                                    strV = mz.H(listT) + " has a few numbers. Which one?";
                                }
                                String str11 = strV;
                                arrayList2 = new ArrayList(nz.d(list));
                                for (uw1 uw1Var2 : list) {
                                    if (listT.size() > 1) {
                                        strA = uw1Var2.a();
                                    } else {
                                        str6 = uw1Var2.d;
                                        if (cs2.A(str6)) {
                                            strA = uw1Var2.c;
                                        } else {
                                            strA = str6;
                                        }
                                    }
                                    arrayList2.add(strA);
                                }
                                if (mz.t(arrayList2).size() < list.size()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                arrayList3 = new ArrayList(nz.d(list));
                                for (uw1 uw1Var3 : list) {
                                    if (listT.size() > 1) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    sb = new StringBuilder();
                                    String str12 = uw1Var3.b;
                                    str3 = uw1Var3.c;
                                    sb.append(str12);
                                    str4 = uw1Var3.d;
                                    if (!cs2.A(str4)) {
                                        sb.append(" — ");
                                        sb.append(str4);
                                    }
                                    if (z) {
                                        sb.append(" (" + cs2.U(4, str3) + ")");
                                    }
                                    String string = sb.toString();
                                    if (z2) {
                                        strConcat = str3;
                                    } else {
                                        if (uw1Var3.e) {
                                            str5 = " · favourite";
                                        } else {
                                            str5 = "";
                                        }
                                        strConcat = str3.concat(str5);
                                    }
                                    Map mapSingletonMap = Collections.singletonMap("contact_name", uw1Var3.b);
                                    mapSingletonMap.getClass();
                                    arrayList3.add(new zx(string, str3, strConcat, mapSingletonMap));
                                }
                                return new gl2(str11, new yx(str11, "phone_number", arrayList3, f5Var2.a, f5Var2.b));
                            }
                            uw1 uw1Var4 = ((y40) z40Var).a;
                            String str13 = uw1Var4.c;
                            String str14 = uw1Var4.b;
                            mpVar.e = null;
                            mpVar.f = null;
                            mpVar.i = null;
                            mpVar.n = 3;
                            objR = r(str13, str14, str, mpVar);
                            if (objR != obj) {
                                return objR;
                            }
                        } else if (i3 != 3) {
                            og.n("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    bz3.g(fl2Var4);
                    return fl2Var4;
                }
                bz3.g(fl2Var4);
                if (!dpVar.a()) {
                    fl2Var = new fl2("This device can't make phone calls.", "TelephonyManager.phoneType is PHONE_TYPE_NONE", null, false, 4);
                } else {
                    if (g31.a(f5Var2.a, "call.dialer")) {
                        t61 t61VarA = dpVar.c.a(new Intent("android.intent.action.DIAL"), "open the dialer");
                        boolean z3 = t61VarA instanceof p61;
                        hp hpVar = hp.a;
                        if (z3) {
                            gpVar = new ep(((p61) t61VarA).b);
                        } else if (t61VarA instanceof q61) {
                            gpVar = hpVar;
                        } else if (t61VarA instanceof r61) {
                            gpVar = new gp(((r61) t61VarA).a);
                        } else if (t61VarA instanceof s61) {
                            gpVar = new gp(((s61) t61VarA).a);
                        } else {
                            if (!(t61VarA instanceof o61)) {
                                dk0.l();
                                return null;
                            }
                            gpVar = new gp(((o61) t61VarA).a);
                        }
                        if (gpVar instanceof ep) {
                            fl2Var2 = new hl2("Dialer's open.", "I can't see what you dial from here", new c73("SONIC opened the dialer and does not observe what happens in it"), null, false, 24);
                        } else {
                            if (gpVar.equals(hpVar)) {
                                fl2Var4 = new fl2("There's no dialer on this device.", "no activity handles ACTION_DIAL", null, false, 4);
                                return fl2Var4;
                            }
                            fl2Var2 = new fl2("I couldn't open the dialer.", "openDialer returned " + gpVar, null, false, 12);
                        }
                        return fl2Var2;
                    }
                    String strC2 = f5Var2.c("message_channel");
                    if (strC2 == null) {
                        strC2 = f5Var2.c("channel");
                    }
                    str = strC2;
                    String strC3 = f5Var2.c("phone_number");
                    if (strC3 != null) {
                        String strC4 = f5Var2.c("contact_name");
                        if (strC4 == null) {
                            strC4 = strC3;
                        }
                        mpVar.e = null;
                        mpVar.f = null;
                        mpVar.i = null;
                        mpVar.n = 1;
                        Object objR2 = r(strC3, strC4, str, mpVar);
                        if (objR2 != obj) {
                            return objR2;
                        }
                    } else {
                        strC = f5Var2.c("contact_name");
                        if (strC == null) {
                            fl2Var = new fl2("Who would you like me to call?", ky0.j(f5Var2.a, " with neither contact_name nor phone_number"), null, false, 12);
                        } else {
                            xa0 xa0Var = ld0.a;
                            qa0 qa0Var = qa0.c;
                            y yVar = new y(this, strC, x50Var2, 6);
                            mpVar.e = f5Var2;
                            mpVar.f = str;
                            mpVar.i = strC;
                            mpVar.n = 2;
                            objD = uf4.d(qa0Var, yVar, mpVar);
                            if (objD != obj) {
                                z40Var = (z40) objD;
                                if (z40Var instanceof y40) {
                                    if (z40Var instanceof u40) {
                                        if (z40Var instanceof w40) {
                                            String str15 = ((w40) z40Var).a;
                                            fl2Var3 = new fl2(cq.v("I couldn't find anyone called \"", str15, "\" in your contacts."), cq.v("no contact matched \"", str15, "\""), null, true, 4);
                                        } else {
                                            if (z40Var instanceof v40) {
                                                if (g31.a(z40Var, x40.a)) {
                                                    return new el2(cq.v("I need access to your contacts to look up ", strC, ". If you tell me the number, I can dial it without that."), new z22(nz.h("android.permission.READ_CONTACTS")), new e52(nz.h("android.permission.READ_CONTACTS"), "Allow contact access"));
                                                }
                                                dk0.l();
                                                return null;
                                            }
                                            fl2Var3 = new fl2(cq.v("Your contacts aren't responding yet, so I couldn't check ", strC, "."), "Contact provider unavailable after fresh lookup retries", null, true, 4);
                                        }
                                        return fl2Var3;
                                    }
                                    u40 u40Var2 = (u40) z40Var;
                                    list = u40Var2.b;
                                    str2 = u40Var2.a;
                                    arrayList = new ArrayList(nz.d(list));
                                    it = list.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((uw1) it.next()).b);
                                    }
                                    listT = mz.t(arrayList);
                                    if (listT.size() != 1) {
                                        if (listT.size() > 1) {
                                            strV = cq.v("There's more than one ", str2, ". Which one?");
                                        } else {
                                            strV = mz.H(listT) + " has a few numbers. Which one?";
                                        }
                                    } else if (listT.size() > 1) {
                                        strV = cq.v("There's more than one ", str2, ". Which one?");
                                    } else {
                                        strV = mz.H(listT) + " has a few numbers. Which one?";
                                    }
                                    String str16 = strV;
                                    arrayList2 = new ArrayList(nz.d(list));
                                    while (r6.hasNext()) {
                                        if (listT.size() > 1) {
                                            strA = uw1Var2.a();
                                        } else {
                                            str6 = uw1Var2.d;
                                            if (cs2.A(str6)) {
                                                strA = uw1Var2.c;
                                            } else {
                                                strA = str6;
                                            }
                                        }
                                        arrayList2.add(strA);
                                    }
                                    if (mz.t(arrayList2).size() < list.size()) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    arrayList3 = new ArrayList(nz.d(list));
                                    while (r0.hasNext()) {
                                        if (listT.size() > 1) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        sb = new StringBuilder();
                                        String str17 = uw1Var3.b;
                                        str3 = uw1Var3.c;
                                        sb.append(str17);
                                        str4 = uw1Var3.d;
                                        if (!cs2.A(str4)) {
                                            sb.append(" — ");
                                            sb.append(str4);
                                        }
                                        if (z) {
                                            sb.append(" (" + cs2.U(4, str3) + ")");
                                        }
                                        String string2 = sb.toString();
                                        if (z2) {
                                            strConcat = str3;
                                        } else {
                                            if (uw1Var3.e) {
                                                str5 = " · favourite";
                                            } else {
                                                str5 = "";
                                            }
                                            strConcat = str3.concat(str5);
                                        }
                                        Map mapSingletonMap2 = Collections.singletonMap("contact_name", uw1Var3.b);
                                        mapSingletonMap2.getClass();
                                        arrayList3.add(new zx(string2, str3, strConcat, mapSingletonMap2));
                                    }
                                    return new gl2(str16, new yx(str16, "phone_number", arrayList3, f5Var2.a, f5Var2.b));
                                }
                                uw1 uw1Var5 = ((y40) z40Var).a;
                                String str18 = uw1Var5.c;
                                String str19 = uw1Var5.b;
                                mpVar.e = null;
                                mpVar.f = null;
                                mpVar.i = null;
                                mpVar.n = 3;
                                objR = r(str18, str19, str, mpVar);
                                if (objR != obj) {
                                    return objR;
                                }
                            }
                        }
                    }
                }
                return fl2Var;
                return obj;
            default:
                String str20 = f5Var2.a;
                if (g31.a(str20, "gallery.open")) {
                    xa0 xa0Var2 = ld0.a;
                    return uf4.d(qa0.c, new nu(this, null, 0), x50Var);
                }
                if (g31.a(str20, "camera.video")) {
                    return v(f5Var2, (y50) x50Var);
                }
                if (g31.a(str20, "camera.video.stop")) {
                    return w((y50) x50Var);
                }
                if (g31.a(str20, "camera.photo")) {
                    return q(f5Var2, (y50) x50Var);
                }
                xa0 xa0Var3 = ld0.a;
                return uf4.d(qa0.c, new lu(this, f5Var2, x50Var2, i), x50Var);
        }
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        int i = this.a;
        a32 a32Var = a32.a;
        switch (i) {
            case 0:
                return !((dp) this.d).a() ? new c32("this device has no phone radio", null) : a32Var;
            default:
                return a32Var;
        }
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        switch (this.a) {
            case 0:
                if (g31.a(f5Var.a, "call.dialer")) {
                    return "Open the dialer";
                }
                String strC = f5Var.c("phone_number");
                String strC2 = f5Var.c("contact_name");
                if (strC != null && strC2 != null) {
                    return cq.l("Call ", strC2, " on ", qp2.a(strC));
                }
                if (strC != null) {
                    return cq.j("Call ", qp2.a(strC));
                }
                if (strC2 != null) {
                    return "Call ".concat(strC2);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // defpackage.bl2
    public final List k() {
        switch (this.a) {
            case 0:
                return (List) this.f;
            default:
                return ii0.a;
        }
    }

    @Override // defpackage.bl2
    public final l82 l() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.c;
    }

    @Override // defpackage.bl2
    public final String m() {
        switch (this.a) {
            case 0:
                return "Phone calls";
            default:
                return "Camera";
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0101  */
    /* JADX WARN: Code duplicated, block: B:38:0x0112  */
    /* JADX WARN: Code duplicated, block: B:47:0x0150  */
    /* JADX WARN: Code duplicated, block: B:49:0x0167  */
    /* JADX WARN: Code duplicated, block: B:51:0x016b  */
    /* JADX WARN: Code duplicated, block: B:53:0x017b  */
    /* JADX WARN: Code duplicated, block: B:55:0x017f  */
    /* JADX WARN: Code duplicated, block: B:57:0x018f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0193  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x012a, code lost:
    
        if (r2 == r11) goto L41;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x012a -> B:42:0x012d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object q(defpackage.f5 r21, defpackage.y50 r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.np.q(f5, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:110:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:112:0x021e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0222  */
    /* JADX WARN: Code duplicated, block: B:116:0x023e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0242  */
    /* JADX WARN: Code duplicated, block: B:120:0x0261  */
    /* JADX WARN: Code duplicated, block: B:122:0x0267  */
    /* JADX WARN: Code duplicated, block: B:124:0x0274  */
    /* JADX WARN: Code duplicated, block: B:126:0x0278  */
    /* JADX WARN: Code duplicated, block: B:128:0x028c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0128  */
    /* JADX WARN: Code duplicated, block: B:63:0x013a  */
    /* JADX WARN: Code duplicated, block: B:71:0x016a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    public Object r(String str, String str2, String str3, y50 y50Var) {
        lp lpVar;
        zc1 zc1Var;
        Object ipVar;
        String str4;
        zc1 zc1Var2;
        String str5;
        jp jpVar;
        Object gpVar = hp.a;
        if (y50Var instanceof lp) {
            lpVar = (lp) y50Var;
            int i = lpVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                lpVar.j = i - Integer.MIN_VALUE;
            } else {
                lpVar = new lp(this, y50Var);
            }
        } else {
            lpVar = new lp(this, y50Var);
        }
        Object gpVar2 = lpVar.f;
        t70 t70Var = t70.a;
        int i2 = lpVar.j;
        if (i2 != 0) {
            if (i2 == 1) {
                str5 = lpVar.e;
                bz3.g(gpVar2);
                return !(((jp) gpVar2) instanceof fp) ? new fl2(cq.v("I couldn't start the WhatsApp call for ", str5, "."), "WhatsApp call launch failed", null, false, 12) : new hl2(cq.v("Calling ", str5, " on WhatsApp."), "WhatsApp call initiation launched", new c73("WhatsApp call launched"), null, false, 24);
            }
            if (i2 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str4 = lpVar.e;
            bz3.g(gpVar2);
            jpVar = (jp) gpVar2;
            if (jpVar instanceof fp) {
                return new hl2(cq.v("Calling ", str4, "."), ((fp) jpVar).a, new c73("Android accepted ACTION_CALL; global audio mode does not prove that this recipient answered"), null, false, 24);
            }
            if (jpVar instanceof ip) {
                return new el2("Android requires phone-call permission before I can place this call.", new z22(nz.h("android.permission.CALL_PHONE")), new e52(nz.h("android.permission.CALL_PHONE"), "Let SONIC place calls"));
            }
            if (jpVar instanceof ep) {
                return new hl2(cq.v("The dialer has ", str4, "'s number, but Android hasn't confirmed a call started."), "Call initiation could not be verified", new c73("Only a composed number was observed"), null, false, 24);
            }
            if (g31.a(jpVar, gpVar)) {
                return new fl2("This device can't make phone calls.", "no activity handles ACTION_CALL", null, false, 4);
            }
            if (jpVar instanceof gp) {
                return new fl2(cq.v("I couldn't call ", str4, "."), ((gp) jpVar).a, null, false, 12);
            }
            dk0.l();
            return null;
        }
        bz3.g(gpVar2);
        boolean zA = g31.a(str3, "whatsapp");
        dp dpVar = (dp) this.d;
        if (zA) {
            lpVar.e = str2;
            lpVar.j = 1;
            n21 n21Var = dpVar.c;
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                if (Character.isDigit(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            if (string.length() == 0) {
                gpVar = new gp("the number was empty");
            } else {
                Uri uri = Uri.parse("https://wa.me/".concat(string));
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                intent.setPackage("com.whatsapp");
                bd1 bd1Var = dpVar.d;
                synchronized (bd1Var) {
                    zc1Var2 = bd1Var.b;
                    if (zc1Var2 == null) {
                        bd1Var.d = true;
                    }
                }
                if (zc1Var2 != null) {
                    bd1Var.f(zc1Var2, ad1.a);
                }
                t61 t61VarA = n21Var.a(intent, "WhatsApp call ".concat(string));
                if (t61VarA instanceof q61) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                    intent2.setPackage("com.whatsapp.w4b");
                    t61VarA = n21Var.a(intent2, "WhatsApp Business call ".concat(string));
                }
                if (t61VarA instanceof p61) {
                    gpVar = new fp("Android opened WhatsApp to call ".concat(string));
                } else if (!(t61VarA instanceof q61)) {
                    if (t61VarA instanceof r61) {
                        gpVar = new gp(((r61) t61VarA).a);
                    } else if (t61VarA instanceof s61) {
                        gpVar = new gp(((s61) t61VarA).a);
                    } else {
                        if (!(t61VarA instanceof o61)) {
                            dk0.l();
                            return null;
                        }
                        gpVar = new gp(((o61) t61VarA).a);
                    }
                }
            }
            if (gpVar != t70Var) {
                str5 = str2;
                gpVar2 = gpVar;
                if (!(((jp) gpVar2) instanceof fp)) {
                }
            }
        } else {
            lpVar.e = str2;
            lpVar.j = 2;
            if (dpVar.a()) {
                if (dpVar.b.c("android.permission.CALL_PHONE")) {
                    String string2 = cs2.V(str).toString();
                    if (string2.length() == 0) {
                        ipVar = new gp("the number was empty");
                    } else {
                        Intent intent3 = new Intent("android.intent.action.CALL", Uri.fromParts("tel", string2, null));
                        bd1 bd1Var2 = dpVar.d;
                        synchronized (bd1Var2) {
                            zc1Var = bd1Var2.b;
                            if (zc1Var == null) {
                                bd1Var2.d = true;
                            }
                        }
                        if (zc1Var != null) {
                            bd1Var2.f(zc1Var, ad1.a);
                        }
                        t61 t61VarA2 = dpVar.c.a(intent3, "call ".concat(string2));
                        if (t61VarA2 instanceof p61) {
                            ipVar = new fp("Android accepted the call request; whether it was answered is not observable.");
                        } else if (t61VarA2 instanceof q61) {
                            gpVar2 = gpVar;
                        } else if (t61VarA2 instanceof r61) {
                            ipVar = new ip();
                        } else if (t61VarA2 instanceof s61) {
                            gpVar2 = new gp(((s61) t61VarA2).a);
                        } else {
                            if (!(t61VarA2 instanceof o61)) {
                                dk0.l();
                                return null;
                            }
                            gpVar2 = new gp(((o61) t61VarA2).a);
                        }
                    }
                } else {
                    ipVar = new ip();
                }
                gpVar2 = ipVar;
            } else {
                gpVar2 = gpVar;
            }
            if (gpVar2 != t70Var) {
                str4 = str2;
                jpVar = (jp) gpVar2;
                if (jpVar instanceof fp) {
                    return new hl2(cq.v("Calling ", str4, "."), ((fp) jpVar).a, new c73("Android accepted ACTION_CALL; global audio mode does not prove that this recipient answered"), null, false, 24);
                }
                if (jpVar instanceof ip) {
                    return new el2("Android requires phone-call permission before I can place this call.", new z22(nz.h("android.permission.CALL_PHONE")), new e52(nz.h("android.permission.CALL_PHONE"), "Let SONIC place calls"));
                }
                if (jpVar instanceof ep) {
                    return new hl2(cq.v("The dialer has ", str4, "'s number, but Android hasn't confirmed a call started."), "Call initiation could not be verified", new c73("Only a composed number was observed"), null, false, 24);
                }
                if (g31.a(jpVar, gpVar)) {
                    return new fl2("This device can't make phone calls.", "no activity handles ACTION_CALL", null, false, 4);
                }
                if (jpVar instanceof gp) {
                    return new fl2(cq.v("I couldn't call ", str4, "."), ((gp) jpVar).a, null, false, 12);
                }
                dk0.l();
                return null;
            }
        }
        return t70Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (r13 == r5) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object v(defpackage.f5 r12, defpackage.y50 r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.np.v(f5, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
    
        if (r8 == r5) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object w(defpackage.y50 r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof defpackage.pu
            if (r0 == 0) goto L13
            r0 = r8
            pu r0 = (defpackage.pu) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            pu r0 = new pu
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f
            int r1 = r0.j
            r2 = 2
            r3 = 1
            r4 = 0
            t70 r5 = defpackage.t70.a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L33
            if (r1 != r2) goto L2d
            np r7 = r0.e
            defpackage.bz3.g(r8)
            goto L62
        L2d:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r7)
            return r4
        L33:
            defpackage.bz3.g(r8)
            goto L4c
        L37:
            defpackage.bz3.g(r8)
            xa0 r8 = defpackage.ld0.a
            qa0 r8 = defpackage.qa0.c
            nu r1 = new nu
            r1.<init>(r7, r4, r3)
            r0.j = r3
            java.lang.Object r8 = defpackage.uf4.d(r8, r1, r0)
            if (r8 != r5) goto L4c
            goto L61
        L4c:
            java.lang.String r8 = (java.lang.String) r8
            xa0 r1 = defpackage.ld0.a
            p0 r3 = new p0
            r6 = 8
            r3.<init>(r7, r8, r4, r6)
            r0.e = r7
            r0.j = r2
            java.lang.Object r8 = defpackage.uf4.d(r1, r3, r0)
            if (r8 != r5) goto L62
        L61:
            return r5
        L62:
            mv r8 = (defpackage.mv) r8
            r7.getClass()
            r7 = 0
            jl2 r7 = x(r8, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.np.w(y50):java.lang.Object");
    }

    private final void o() {
    }

    private final void p() {
    }

    private final void t() {
    }

    private final void u() {
    }

    public np(dp dpVar, b50 b50Var) {
        dpVar.getClass();
        b50Var.getClass();
        this.d = dpVar;
        this.e = b50Var;
        this.b = wh2.c(new w3("call.contact"), new w3("call.number"), new w3("call.dialer"));
        this.f = nz.h("android.permission.CALL_PHONE");
        this.c = l82.c;
    }
}
