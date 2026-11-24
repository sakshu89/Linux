package defpackage;

import android.content.Intent;
import android.provider.Settings;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.text.DateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b6 implements bl2 {
    public final /* synthetic */ int a = 1;
    public final Set b;
    public final l82 c;
    public final Object d;

    public b6(j13 j13Var) {
        j13Var.getClass();
        this.d = j13Var;
        this.b = wh2.c(new w3("device.flashlight.on"), new w3("device.flashlight.off"), new w3("device.flashlight.toggle"));
        this.c = l82.a;
    }

    public static Integer A(f5 f5Var) {
        String strC = f5Var.c("duration_seconds");
        Integer num = null;
        if (strC == null) {
            return null;
        }
        if (f5Var.d == q21.e) {
            return s03.c(strC);
        }
        Integer numL = js2.l(10, strC);
        if (numL != null) {
            int iIntValue = numL.intValue();
            if (1 <= iIntValue && iIntValue < 86401) {
                num = numL;
            }
            if (num != null) {
                return num;
            }
        }
        return s03.c(strC);
    }

    public static wt1 v(String str) {
        Integer numM;
        String strB = s03.b(str);
        if (strB == null) {
            return null;
        }
        List listN = cs2.N(strB, new char[]{':'}, 6);
        if (listN.size() != 2 || (numM = js2.m((String) listN.get(0))) == null) {
            return null;
        }
        int iIntValue = numM.intValue();
        Integer numM2 = js2.m((String) listN.get(1));
        if (numM2 == null) {
            return null;
        }
        int iIntValue2 = numM2.intValue();
        if (iIntValue < 0 || iIntValue >= 24 || iIntValue2 < 0 || iIntValue2 >= 60) {
            return null;
        }
        return new wt1(numM, numM2);
    }

    public static String w(int i, String str) {
        return i + Padder.FALLBACK_PADDING_STRING + str + (i == 1 ? "" : DateFormat.SECOND);
    }

    public static String y(int i) {
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        qc1 qc1VarE = nz.e();
        if (i2 > 0) {
            qc1VarE.add(w(i2, "hour"));
        }
        if (i3 > 0) {
            qc1VarE.add(w(i3, "minute"));
        }
        if (i4 > 0) {
            qc1VarE.add(w(i4, "second"));
        }
        qc1 qc1VarC = nz.c(qc1VarE);
        return qc1VarC.isEmpty() ? w(i, "second") : mz.C(qc1VarC, Padder.FALLBACK_PADDING_STRING, null, null, null, 62);
    }

    public static String z(int i, int i2) {
        String str = i < 12 ? "am" : "pm";
        int i3 = i % 12;
        int i4 = i3 != 0 ? i3 : 12;
        if (i2 == 0) {
            return i4 + Padder.FALLBACK_PADDING_STRING + str;
        }
        return String.format(Locale.ROOT, i4 + ":%02d " + str, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0171  */
    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        String strC;
        wt1 wt1VarV;
        Object n5Var;
        boolean z;
        switch (this.a) {
            case 0:
                o5 o5Var = o5.a;
                if (!g31.a(f5Var.a, "time.alarm.set") || (strC = f5Var.c("date_time")) == null || (wt1VarV = v(strC)) == null) {
                    return null;
                }
                int iIntValue = ((Number) wt1VarV.a).intValue();
                int iIntValue2 = ((Number) wt1VarV.b).intValue();
                s5 s5Var = (s5) this.d;
                s5Var.getClass();
                if (iIntValue < 0 || iIntValue >= 24 || iIntValue2 < 0 || iIntValue2 >= 60) {
                    n5Var = new n5(iIntValue + ":" + iIntValue2 + " is not a valid time");
                } else {
                    Long lB = s5Var.b();
                    if (lB != null) {
                        long jLongValue = lB.longValue();
                        q5 q5Var = s5Var.c;
                        if (q5Var != null && q5Var.a == iIntValue && q5Var.b == iIntValue2) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - q5Var.d;
                            if (0 > jCurrentTimeMillis || jCurrentTimeMillis >= 30001) {
                                q5Var = null;
                            }
                        } else {
                            q5Var = null;
                        }
                        long jC = q5Var != null ? q5Var.c : s5.c(iIntValue, iIntValue2);
                        if (jLongValue / 60000 == jC / 60000) {
                            n5Var = new m5(cq.v("AlarmManager.nextAlarmClock is ", s5.a(jLongValue), ", the time requested"));
                        } else {
                            n5Var = jLongValue < jC ? new p5(cq.v("an alarm at ", s5.a(jLongValue), " comes first, so I can't see past it")) : new p5(ky0.l("the system's next alarm is ", s5.a(jLongValue), ", which is later than the ", s5.a(jC), " alarm requested; the clock app has not published a matching record"));
                        }
                    } else {
                        n5Var = o5Var;
                    }
                }
                if (n5Var instanceof m5) {
                    return new d73("AlarmManager.getNextAlarmClock, compared against the requested time", ((m5) n5Var).a);
                }
                if (n5Var instanceof p5) {
                    return new c73(((p5) n5Var).a);
                }
                if (n5Var instanceof n5) {
                    return new b73("AlarmManager.getNextAlarmClock", "an alarm at ".concat(z(iIntValue, iIntValue2)), ((n5) n5Var).a);
                }
                if (n5Var.equals(o5Var)) {
                    return new c73("no app has published a next alarm to the system, so there's nothing for me to read");
                }
                dk0.l();
                return null;
            case 1:
                return new d73("BatteryManager capacity property", ((fl) this.d).a().a());
            case 2:
                Integer numA = ((nm) this.d).a();
                if (numA == null) {
                    return new c73("the brightness setting is unreadable");
                }
                int iIntValue3 = numA.intValue();
                Integer numB = f5Var.b("level_percent");
                if (numB == null) {
                    return new d73("Settings.System.SCREEN_BRIGHTNESS", iIntValue3 + "%");
                }
                int iIntValue4 = numB.intValue();
                if (Math.abs(iIntValue3 - iIntValue4) <= 3) {
                    return new d73("Settings.System.SCREEN_BRIGHTNESS", iIntValue3 + "%");
                }
                return new b73("Settings.System.SCREEN_BRIGHTNESS", iIntValue4 + "%", iIntValue3 + "%");
            default:
                j13 j13Var = (j13) this.d;
                if (j13Var.d.getValue() == null) {
                    return new c73("The camera has not reported a current torch state");
                }
                boolean zBooleanValue = ((Boolean) j13Var.e.a.getValue()).booleanValue();
                String str = f5Var.a;
                if (g31.a(str, "device.flashlight.on")) {
                    z = true;
                } else {
                    if (!g31.a(str, "device.flashlight.off")) {
                        return new d73("camera torch state", "torch is ".concat(zBooleanValue ? "on" : "off"));
                    }
                    z = false;
                }
                if (zBooleanValue == z) {
                    return new d73("camera torch state", "torch is ".concat(zBooleanValue ? "on" : "off"));
                }
                return new b73("camera torch state", z ? "on" : "off", zBooleanValue ? "on" : "off");
        }
    }

    @Override // defpackage.bl2
    public final Set b() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return this.b;
    }

    @Override // defpackage.bl2
    public final String d() {
        switch (this.a) {
            case 0:
                return "time.alarm";
            case 1:
                return "device.battery";
            case 2:
                return "device.brightness";
            default:
                return "device.flashlight";
        }
    }

    @Override // defpackage.bl2
    public final String e() {
        switch (this.a) {
            case 0:
                return "Sets an alarm or a countdown timer in your clock app.";
            case 1:
                return "Reports the battery level, charging state and battery saver.";
            case 2:
                return "Sets the screen brightness.";
            default:
                return "Turns the camera flash on or off, and confirms it actually changed.";
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

    /* JADX WARN: Code duplicated, block: B:9:0x0027  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) {
        w5 w5Var;
        Object y5Var;
        Object fl2Var;
        String strA;
        String str;
        Object fl2Var2;
        int iC;
        nm nmVar;
        boolean z;
        Object omVar;
        boolean z2;
        Object fl2Var3;
        cm0 cm0Var;
        boolean z3;
        p13 p13Var;
        Object hl2Var;
        String str2;
        Object n43Var = null;
        switch (this.a) {
            case 0:
                if (!g31.a(f5Var.a, "time.timer.set")) {
                    return x(f5Var, (y50) x50Var);
                }
                x5 x5Var = x5.a;
                Integer numA = A(f5Var);
                if (numA == null) {
                    return new gl2(f5Var.c("duration_seconds") == null ? "How long should the timer be?" : "How long should the timer be? For example, 5 minutes.", new yx("How long?", "duration_seconds", ii0.a, "time.timer.set", bh1.d("duration_seconds", f5Var.b)));
                }
                int iIntValue = numA.intValue();
                String strC = f5Var.c("label");
                String strD = strC != null ? n61.a.d(strC) : null;
                String strY = y(iIntValue);
                s5 s5Var = (s5) this.d;
                s5Var.getClass();
                if (iIntValue <= 0) {
                    y5Var = new w5("a timer needs a positive length");
                } else {
                    Intent intent = new Intent("android.intent.action.SET_TIMER");
                    intent.putExtra("android.intent.extra.alarm.LENGTH", iIntValue);
                    intent.putExtra("android.intent.extra.alarm.SKIP_UI", true);
                    if (strD != null) {
                        if (cs2.A(strD)) {
                            strD = null;
                        }
                        if (strD != null) {
                            intent.putExtra("android.intent.extra.alarm.MESSAGE", strD);
                        }
                    }
                    t61 t61VarA = s5Var.a.a(intent, "set a " + iIntValue + "s timer");
                    if (t61VarA instanceof p61) {
                        y5Var = new y5("Android gives apps no way to read back a running timer, so I can't confirm it started");
                    } else if (t61VarA instanceof q61) {
                        y5Var = x5Var;
                    } else {
                        if (t61VarA instanceof r61) {
                            w5Var = new w5(((r61) t61VarA).a);
                        } else if (t61VarA instanceof s61) {
                            w5Var = new w5(((s61) t61VarA).a);
                        } else {
                            if (!(t61VarA instanceof o61)) {
                                dk0.l();
                                return null;
                            }
                            w5Var = new w5(((o61) t61VarA).a);
                        }
                        y5Var = w5Var;
                    }
                }
                if (y5Var instanceof v5) {
                    fl2Var = new il2(strY.concat(" timer started."), new d73("timer read-back", ((v5) y5Var).b), null, null, 12);
                } else if (y5Var instanceof y5) {
                    String strV = cq.v("I've asked your clock app to start a ", strY, " timer.");
                    String str3 = ((y5) y5Var).a;
                    fl2Var = new hl2(strV, str3, new c73(str3), null, false, 24);
                } else if (y5Var instanceof u5) {
                    fl2Var = new hl2(cq.v("Your clock app is open with ", strY, " ready."), "The clock app has not confirmed that the timer started.", new c73("the clock app was opened rather than handed a running timer"), null, false, 24);
                } else if (y5Var.equals(x5Var)) {
                    fl2Var = new fl2("There's no clock app on this phone that can run a timer.", "no activity handles AlarmClock.ACTION_SET_TIMER", null, false, 4);
                } else {
                    if (!(y5Var instanceof w5)) {
                        dk0.l();
                        return null;
                    }
                    fl2Var = new fl2("I couldn't start that timer.", ((w5) y5Var).a, null, false, 12);
                }
                return fl2Var;
            case 1:
                gl glVarA = ((fl) this.d).a();
                boolean z4 = glVarA.b;
                int i = glVarA.a;
                if (i == 0 && !z4) {
                    return new fl2("I couldn't read the battery level.", "BatteryManager returned no usable capacity and no sticky broadcast", null, false, 4);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Battery is at " + i + " percent");
                cz1 cz1Var = glVarA.c;
                if (z4) {
                    strA = cz1Var.a();
                    str = " and ";
                } else {
                    strA = cz1Var.a();
                    str = ", ";
                }
                sb.append(str.concat(strA));
                sb.append(".");
                if (glVarA.e) {
                    sb.append(" Battery saver is on.");
                }
                if (g31.a(glVarA.f, "overheat")) {
                    sb.append(" It's running hot.");
                }
                String string = sb.toString();
                d73 d73Var = new d73("BatteryManager capacity property and ACTION_BATTERY_CHANGED extras", glVarA.a());
                Float f = glVarA.d;
                return new il2(string, d73Var, null, f != null ? cq.v("Battery temperature ", String.format("%.1f", Arrays.copyOf(new Object[]{new Float(f.floatValue())}, 1)), " °C") : null, 4);
            case 2:
                np2 np2Var = np2.a;
                Integer numB = f5Var.b("level_percent");
                String strC2 = f5Var.c("direction");
                Integer numA2 = ((nm) this.d).a();
                int iIntValue2 = numA2 != null ? numA2.intValue() : 50;
                try {
                    if (numB != null) {
                        iC = ky3.c(numB.intValue(), 0, 100);
                    } else {
                        if (!g31.a(strC2, "up")) {
                            if (g31.a(strC2, "down")) {
                                iC = ky3.c(iIntValue2 - 20, 0, 100);
                            } else {
                                fl2Var2 = new fl2("What brightness would you like? Say a number between 0 and 100.", "SET_BRIGHTNESS with no level_percent slot or direction", null, false, 12);
                            }
                            return fl2Var2;
                        }
                        iC = ky3.c(iIntValue2 + 20, 0, 100);
                    }
                    z = Settings.System.getInt(nmVar.a.getContentResolver(), "screen_brightness_mode") == 1;
                } catch (Settings.SettingNotFoundException unused) {
                }
                nmVar = (nm) this.d;
                nmVar.getClass();
                Integer numA3 = ((nm) this.d).a();
                nm nmVar2 = (nm) this.d;
                if (Settings.System.canWrite(nmVar2.b.a)) {
                    nmVar2.b();
                    int iC2 = ky3.c(iC, 5, 100);
                    int iC3 = ky3.c(hh1.f((nmVar2.c * iC2) / 100.0f), 0, nmVar2.c);
                    try {
                        try {
                            z2 = Settings.System.getInt(nmVar2.a.getContentResolver(), "screen_brightness_mode") == 1;
                        } catch (Settings.SettingNotFoundException unused2) {
                        }
                        if (z2) {
                            Settings.System.putInt(nmVar2.a.getContentResolver(), "screen_brightness_mode", 0);
                        }
                        Settings.System.putInt(nmVar2.a.getContentResolver(), "screen_brightness", iC3);
                        Integer numB2 = nmVar2.b();
                        if (numB2 != null) {
                            int iIntValue3 = numB2.intValue();
                            omVar = iIntValue3 == iC3 ? new pm(ky3.c(hh1.f((iIntValue3 * 100.0f) / nmVar2.c), 0, 100), iIntValue3, nmVar2.c) : new qm(iC2, ky3.c(hh1.f((iIntValue3 * 100.0f) / nmVar2.c), 0, 100));
                        } else {
                            omVar = new rm("couldn't read the brightness back");
                        }
                    } catch (IllegalArgumentException e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = "the brightness value was rejected";
                        }
                        omVar = new rm(message);
                    } catch (SecurityException unused3) {
                        nmVar2.b.getClass();
                        omVar = new om(zv1.d(np2Var));
                    }
                } else {
                    nmVar2.b.getClass();
                    omVar = new om(zv1.d(np2Var));
                }
                if (!(omVar instanceof pm)) {
                    if (omVar instanceof qm) {
                        qm qmVar = (qm) omVar;
                        fl2Var3 = new hl2(cq.h("Brightness ended up at ", qmVar.b, " percent."), cq.h("I asked for ", qmVar.a, " percent but the system settled somewhere else"), new b73("Settings.System.SCREEN_BRIGHTNESS", qmVar.a + "%", qmVar.b + "%"), null, false, 24);
                    } else {
                        if (omVar instanceof om) {
                            f52 f52Var = ((om) omVar).a;
                            fl2Var2 = new el2("I need permission to change system settings before I can adjust brightness. I can take you there.", new c32("WRITE_SETTINGS is not granted", f52Var), f52Var);
                            return fl2Var2;
                        }
                        if (!(omVar instanceof rm)) {
                            dk0.l();
                            return null;
                        }
                        fl2Var3 = new fl2("I couldn't change the brightness.", ((rm) omVar).a, null, false, 12);
                    }
                    return fl2Var3;
                }
                StringBuilder sb2 = new StringBuilder();
                pm pmVar = (pm) omVar;
                sb2.append("Brightness is at " + pmVar.a + " percent.");
                if (z) {
                    sb2.append(" I turned off adaptive brightness to do that.");
                }
                String string2 = sb2.toString();
                d73 d73Var2 = new d73("Settings.System.SCREEN_BRIGHTNESS, read back after the write", pmVar.b + " of " + pmVar.c + " (" + pmVar.a + "%)");
                if (numA3 != null) {
                    int iIntValue4 = numA3.intValue();
                    n43Var = new n43(bh1.c(new wt1("previous_percent", String.valueOf(iIntValue4)), new wt1("was_automatic", String.valueOf(z))), "device.brightness", cq.h("put the brightness back to ", iIntValue4, " percent"));
                }
                return new il2(string2, d73Var2, n43Var, null, 8);
            default:
                j13 j13Var = (j13) this.d;
                if (x50Var instanceof cm0) {
                    cm0Var = (cm0) x50Var;
                    int i2 = cm0Var.j;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        cm0Var.j = i2 - Integer.MIN_VALUE;
                    } else {
                        cm0Var = new cm0(this, (y50) x50Var);
                    }
                } else {
                    cm0Var = new cm0(this, (y50) x50Var);
                }
                Object obj = cm0Var.f;
                t70 t70Var = t70.a;
                int i3 = cm0Var.j;
                if (i3 == 0) {
                    bz3.g(obj);
                    boolean zBooleanValue = ((Boolean) j13Var.e.a.getValue()).booleanValue();
                    String str4 = f5Var.a;
                    if (g31.a(str4, "device.flashlight.on")) {
                        cm0Var.e = zBooleanValue;
                        cm0Var.j = 1;
                        Object objB = j13Var.b(true, cm0Var);
                        if (objB != t70Var) {
                            z3 = zBooleanValue;
                            obj = objB;
                            p13Var = (p13) obj;
                        }
                    } else if (g31.a(str4, "device.flashlight.off")) {
                        cm0Var.e = zBooleanValue;
                        cm0Var.j = 2;
                        Object objB2 = j13Var.b(false, cm0Var);
                        if (objB2 != t70Var) {
                            z3 = zBooleanValue;
                            obj = objB2;
                            p13Var = (p13) obj;
                        }
                    } else {
                        cm0Var.e = zBooleanValue;
                        cm0Var.j = 3;
                        Object objB3 = j13Var.b(!((Boolean) j13Var.c.getValue()).booleanValue(), cm0Var);
                        if (objB3 != t70Var) {
                            z3 = zBooleanValue;
                            obj = objB3;
                            p13Var = (p13) obj;
                        }
                    }
                    return t70Var;
                }
                if (i3 == 1) {
                    z3 = cm0Var.e;
                    bz3.g(obj);
                    p13Var = (p13) obj;
                } else if (i3 == 2) {
                    z3 = cm0Var.e;
                    bz3.g(obj);
                    p13Var = (p13) obj;
                } else {
                    if (i3 != 3) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    z3 = cm0Var.e;
                    bz3.g(obj);
                    p13Var = (p13) obj;
                }
                if (p13Var instanceof l13) {
                    boolean z5 = ((l13) p13Var).a;
                    if (z5 && z3) {
                        str2 = "The flashlight was already on, Boss.";
                    } else if (z5) {
                        str2 = "Flashlight on, Boss.";
                    } else {
                        str2 = (z5 || z3) ? "Flashlight off, Boss." : "The flashlight was already off, Boss.";
                    }
                    String str5 = str2;
                    d73 d73Var3 = new d73("camera torch state, via CameraManager.TorchCallback", "torch reported ".concat(z5 ? "on" : "off"));
                    if (z5 != z3) {
                        Map mapSingletonMap = Collections.singletonMap("previous_state", String.valueOf(z3));
                        mapSingletonMap.getClass();
                        n43Var = new n43(mapSingletonMap, "device.flashlight", "turn the flashlight back ".concat(z3 ? "on" : "off"));
                    }
                    hl2Var = new il2(str5, d73Var3, n43Var, null, 8);
                } else if (g31.a(p13Var, m13.a)) {
                    hl2Var = new fl2("This phone doesn't have a flash I can control.", "no camera on this device reports a flash unit", null, false, 4);
                } else if (p13Var instanceof k13) {
                    hl2Var = new fl2("Something else is using the camera, so I can't control the flash.", "CameraAccessException: ".concat(((k13) p13Var).a), new g52("Try again after closing the camera", "Close whichever app has the camera open and ask again."), false, 8);
                } else {
                    if (!(p13Var instanceof o13)) {
                        if (g31.a(p13Var, n13.a)) {
                            return new el2("Android requires camera permission to control this phone's flashlight.", new z22(nz.h("android.permission.CAMERA")), new e52(nz.h("android.permission.CAMERA"), "Allow flashlight access"));
                        }
                        dk0.l();
                        return null;
                    }
                    hl2Var = new hl2("I sent the flashlight command.", "but the camera didn't report back in time, so I can't say for certain it changed", new c73("the camera service did not report a torch state change in time"), null, false, 24);
                }
                return hl2Var;
        }
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        switch (this.a) {
            case 0:
                return a32.a;
            case 1:
                return a32.a;
            case 2:
                nm nmVar = (nm) this.d;
                if (Settings.System.canWrite(nmVar.b.a)) {
                    return a32.a;
                }
                zv1 zv1Var = nmVar.b;
                np2 np2Var = np2.a;
                zv1Var.getClass();
                return new c32("SONIC needs the \"modify system settings\" grant to change brightness", zv1.d(np2Var));
            default:
                j13 j13Var = (j13) this.d;
                if (!j13Var.a.getPackageManager().hasSystemFeature("android.hardware.camera.flash") || ((String) j13Var.g.getValue()) == null) {
                    return new c32("this device doesn't have a flash", null);
                }
                j13 j13Var2 = (j13) this.d;
                return (j13Var2.a.getPackageManager().hasSystemFeature("android.hardware.camera.flash") && ((String) j13Var2.g.getValue()) != null && j13Var2.f) ? a32.a : new c32("another app is using the camera right now", new g52("Close the camera app", "The flash can't be driven while another app holds the camera."));
        }
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        wt1 wt1VarV;
        switch (this.a) {
            case 0:
                if (g31.a(f5Var.a, "time.timer.set")) {
                    Integer numA = A(f5Var);
                    if (numA != null) {
                        return cq.v("Start a ", y(numA.intValue()), " timer");
                    }
                    return null;
                }
                String strC = f5Var.c("date_time");
                if (strC == null || (wt1VarV = v(strC)) == null) {
                    return null;
                }
                int iIntValue = ((Number) wt1VarV.a).intValue();
                int iIntValue2 = ((Number) wt1VarV.b).intValue();
                String strC2 = f5Var.c("label");
                String strZ = z(iIntValue, iIntValue2);
                return strC2 == null ? "Set an alarm for ".concat(strZ) : cq.l("Set a ", strZ, " alarm for ", strC2);
            case 1:
            case 2:
            default:
                return null;
        }
    }

    @Override // defpackage.bl2
    public final List k() {
        int i = this.a;
        return ii0.a;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return this.c;
    }

    @Override // defpackage.bl2
    public final String m() {
        switch (this.a) {
            case 0:
                return "Alarms and timers";
            case 1:
                return "Battery";
            case 2:
                return "Brightness";
            default:
                return "Flashlight";
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public Object x(f5 f5Var, y50 y50Var) {
        a6 a6Var;
        wt1 wt1VarV;
        String strD;
        Object w5Var;
        String str;
        x5 x5Var = x5.a;
        if (y50Var instanceof a6) {
            a6Var = (a6) y50Var;
            int i = a6Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                a6Var.k = i - Integer.MIN_VALUE;
            } else {
                a6Var = new a6(this, y50Var);
            }
        } else {
            a6Var = new a6(this, y50Var);
        }
        Object obj = a6Var.i;
        t70 t70Var = t70.a;
        int i2 = a6Var.k;
        if (i2 == 0) {
            bz3.g(obj);
            String strC = f5Var.c("date_time");
            if (strC == null || (wt1VarV = v(strC)) == null) {
                return new gl2(f5Var.c("date_time") == null ? "What time should I set it for?" : "What time should the alarm be? For example, 7 pm.", new yx("What time should the alarm go off?", "date_time", ii0.a, "time.alarm.set", bh1.d("date_time", f5Var.b)));
            }
            int iIntValue = ((Number) wt1VarV.a).intValue();
            int iIntValue2 = ((Number) wt1VarV.b).intValue();
            String strC2 = f5Var.c("label");
            strD = strC2 != null ? n61.a.d(strC2) : null;
            String strZ = z(iIntValue, iIntValue2);
            s5 s5Var = (s5) this.d;
            a6Var.e = strD;
            a6Var.f = strZ;
            a6Var.k = 1;
            s5Var.getClass();
            if (iIntValue < 0 || iIntValue >= 24 || iIntValue2 < 0 || iIntValue2 >= 60) {
                w5Var = new w5(iIntValue + ":" + iIntValue2 + " is not a valid time");
            } else {
                Intent intent = new Intent("android.intent.action.SET_ALARM");
                intent.putExtra("android.intent.extra.alarm.HOUR", iIntValue);
                intent.putExtra("android.intent.extra.alarm.MINUTES", iIntValue2);
                intent.putExtra("android.intent.extra.alarm.SKIP_UI", true);
                if (strD != null) {
                    String str2 = !cs2.A(strD) ? strD : null;
                    if (str2 != null) {
                        intent.putExtra("android.intent.extra.alarm.MESSAGE", str2);
                    }
                }
                Long lB = s5Var.b();
                long jC = s5.c(iIntValue, iIntValue2);
                t61 t61VarA = s5Var.a.a(intent, ky0.i("set an alarm for ", iIntValue, iIntValue2, ":"));
                if (t61VarA instanceof p61) {
                    s5Var.c = new q5(iIntValue, iIntValue2, jC, System.currentTimeMillis());
                    w5Var = s5Var.d(lB, jC, a6Var);
                } else if (t61VarA instanceof q61) {
                    w5Var = x5Var;
                } else if (t61VarA instanceof r61) {
                    w5Var = new w5(((r61) t61VarA).a);
                } else if (t61VarA instanceof s61) {
                    w5Var = new w5(((s61) t61VarA).a);
                } else {
                    if (!(t61VarA instanceof o61)) {
                        dk0.l();
                        return null;
                    }
                    w5Var = new w5(((o61) t61VarA).a);
                }
            }
            if (w5Var == t70Var) {
                return t70Var;
            }
            obj = w5Var;
            str = strZ;
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = a6Var.f;
            strD = a6Var.e;
            bz3.g(obj);
        }
        z5 z5Var = (z5) obj;
        if (z5Var instanceof v5) {
            return new il2(cq.v("Alarm set for ", str, "."), new d73("AlarmManager.getNextAlarmClock, read before and after the handoff", ((v5) z5Var).b), null, strD != null ? cq.v("Requested label: \"", strD, "\"") : null, 4);
        }
        if (z5Var instanceof y5) {
            String strV = cq.v("I've asked your clock app for an alarm at ", str, ".");
            String str3 = ((y5) z5Var).a;
            return new hl2(strV, str3, new c73(str3), null, false, 24);
        }
        if (z5Var instanceof u5) {
            return new hl2(cq.v("Your clock app is open with ", str, " filled in."), "The clock app has not confirmed that the alarm was saved.", new c73("the clock app was opened rather than handed a completed alarm"), null, false, 24);
        }
        if (g31.a(z5Var, x5Var)) {
            return new fl2("There's no clock app on this phone that can take an alarm.", "no activity handles AlarmClock.ACTION_SET_ALARM", null, false, 4);
        }
        if (z5Var instanceof w5) {
            return new fl2("I couldn't set that alarm.", ((w5) z5Var).a, null, false, 12);
        }
        dk0.l();
        return null;
    }

    private final void n() {
    }

    private final void o() {
    }

    private final void p() {
    }

    private final void q() {
    }

    private final void r() {
    }

    private final void s() {
    }

    private final void t() {
    }

    private final void u() {
    }

    public b6(nm nmVar) {
        nmVar.getClass();
        this.d = nmVar;
        this.b = wh2.b(new w3("device.brightness.set"));
        this.c = l82.a;
    }

    public b6(s5 s5Var) {
        s5Var.getClass();
        this.d = s5Var;
        this.b = wh2.c(new w3("time.alarm.set"), new w3("time.timer.set"));
        this.c = l82.b;
    }

    public b6(fl flVar) {
        flVar.getClass();
        this.d = flVar;
        this.b = wh2.b(new w3("device.battery.status"));
        this.c = l82.a;
    }
}
