package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bj1 implements bl2 {
    public final oi1 a;
    public final b50 b;
    public final ja3 c;
    public final zl2 d;
    public final vv1 e;
    public final j5 f;
    public final Set g;
    public final ii0 h;
    public final l82 i;

    public bj1(oi1 oi1Var, b50 b50Var, ja3 ja3Var, zl2 zl2Var, vv1 vv1Var, j5 j5Var) {
        oi1Var.getClass();
        b50Var.getClass();
        ja3Var.getClass();
        zl2Var.getClass();
        vv1Var.getClass();
        j5Var.getClass();
        this.a = oi1Var;
        this.b = b50Var;
        this.c = ja3Var;
        this.d = zl2Var;
        this.e = vv1Var;
        this.f = j5Var;
        this.g = wh2.c(new w3("message.sms.send"), new w3("message.sms.confirm_send"), new w3("message.draft"), new w3("message.share.text"));
        this.h = ii0.a;
        this.i = l82.c;
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.g;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "message.compose";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Prepares an SMS and sends it after your spoken confirmation.";
    }

    @Override // defpackage.bl2
    public final void f() {
        synchronized (this.e) {
        }
    }

    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) {
        return p(m61.a(f5Var), cl2Var, (y50) x50Var);
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        return a32.a;
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        String strC = f5Var.c("message_body");
        if (strC == null) {
            strC = f5Var.c("text");
        }
        if (g31.a(f5Var.a, "message.share.text")) {
            return (strC == null && (strC = f5Var.c("query")) == null) ? "Share that" : cq.v("Share “", qp2.b(strC), "”");
        }
        String strC2 = f5Var.c("phone_number");
        String strC3 = f5Var.c("contact_name");
        if (strC3 == null) {
            String strA = strC2 != null ? qp2.a(strC2) : null;
            if (strA == null) {
                if (strC != null) {
                    return cq.v("Write “", qp2.b(strC), "”");
                }
                return null;
            }
            strC3 = strA;
        }
        if (strC2 != null && f5Var.c("contact_name") != null) {
            strC3 = cq.k(strC3, " on ", qp2.a(strC2));
        }
        return strC == null ? "Write to ".concat(strC3) : ky0.l("Write to ", strC3, ": “", qp2.b(strC), "”");
    }

    @Override // defpackage.bl2
    public final List k() {
        return this.h;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.i;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "Messages";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:275:0x0597 -> B:276:0x059b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:277:0x059f -> B:278:0x05a2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 14811. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object n(java.lang.String r26, java.lang.String r27, java.lang.String r28, defpackage.y50 r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bj1.n(java.lang.String, java.lang.String, java.lang.String, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0119  */
    /* JADX WARN: Code duplicated, block: B:48:0x0133  */
    /* JADX WARN: Code duplicated, block: B:69:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    public final Object o(f5 f5Var, y50 y50Var, String str, String str2, String str3) throws Throwable {
        yi1 yi1Var;
        Object si1Var;
        Object ti1Var;
        vv1 vv1Var;
        Map map;
        f5 f5Var2 = f5Var;
        String str4 = str2;
        String str5 = str3;
        if (y50Var instanceof yi1) {
            yi1Var = (yi1) y50Var;
            int i = yi1Var.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                yi1Var.n = i - Integer.MIN_VALUE;
            } else {
                yi1Var = new yi1(this, y50Var);
            }
        } else {
            yi1Var = new yi1(this, y50Var);
        }
        Object objN = yi1Var.j;
        Object obj = t70.a;
        int i2 = yi1Var.n;
        am2 am2Var = null;
        if (i2 == 0) {
            bz3.g(objN);
            oi1 oi1Var = this.a;
            oi1Var.getClass();
            str.getClass();
            str5.getClass();
            str4.getClass();
            String string = cs2.V(str).toString();
            if (string.length() == 0) {
                ti1Var = new si1("no number to send to");
            } else {
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", string, null));
                intent.putExtra("sms_body", str5);
                t61 t61VarA = oi1Var.a.a(intent, "compose a message to ".concat(string));
                if (t61VarA instanceof p61) {
                    p61 p61Var = (p61) t61VarA;
                    si1Var = new ri1(p61Var.b, str5.length(), str4, p61Var.a);
                } else if (t61VarA instanceof q61) {
                    ti1Var = new ti1("no app on this phone handles text messages");
                } else if (t61VarA instanceof r61) {
                    si1Var = new si1(((r61) t61VarA).a);
                } else if (t61VarA instanceof s61) {
                    si1Var = new si1(((s61) t61VarA).a);
                } else {
                    if (!(t61VarA instanceof o61)) {
                        dk0.l();
                        return null;
                    }
                    si1Var = new si1(((o61) t61VarA).a);
                }
                ti1Var = si1Var;
            }
            if (!(ti1Var instanceof ri1)) {
                if (ti1Var instanceof ti1) {
                    return new fl2("There's no messaging app on this phone I can hand that to.", ((ti1) ti1Var).a, null, true, 4);
                }
                if (ti1Var instanceof si1) {
                    return new fl2(cq.v("I couldn't open a message to ", str4, "."), ((si1) ti1Var).a, null, false, 12);
                }
                dk0.l();
                return null;
            }
            if (!g31.a(f5Var2.a, "message.sms.send")) {
                return new hl2(cq.v("Opened an SMS draft for ", str4, "."), "Draft only; no send was requested", new c73("Messaging composer Intent launched"), null, false, 24);
            }
            String str6 = ((ri1) ti1Var).d;
            if (str6 != null) {
                yi1Var.e = str4;
                yi1Var.f = str5;
                yi1Var.i = f5Var2;
                yi1Var.n = 1;
                objN = n(str6, str, str5, yi1Var);
                if (objN == obj) {
                    return obj;
                }
            }
            if (am2Var == null) {
                return new fl2("I opened the draft, but couldn't verify its recipient and text, so I haven't sent it.", "No stable, readable SMS composer matching the requested package, number and body", null, false, 12);
            }
            vv1Var = this.e;
            map = f5Var2.b;
            synchronized (vv1Var) {
                str4.getClass();
                bh1.h(map);
                ((Number) vv1Var.a.a()).longValue();
            }
            return new hl2(ky0.l("Ready to send to ", str4, ": “", qp2.b(str5), "”. Say 'send it' to confirm."), "Waiting for your send confirmation", new c73("Exact SMS recipient and body verified; awaiting confirmation"), null, true, 8);
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        f5Var2 = yi1Var.i;
        String str7 = yi1Var.f;
        String str8 = yi1Var.e;
        bz3.g(objN);
        str5 = str7;
        str4 = str8;
        am2Var = (am2) objN;
        if (am2Var == null) {
            return new fl2("I opened the draft, but couldn't verify its recipient and text, so I haven't sent it.", "No stable, readable SMS composer matching the requested package, number and body", null, false, 12);
        }
        vv1Var = this.e;
        map = f5Var2.b;
        synchronized (vv1Var) {
            str4.getClass();
            bh1.h(map);
            ((Number) vv1Var.a.a()).longValue();
            return new hl2(ky0.l("Ready to send to ", str4, ": “", qp2.b(str5), "”. Say 'send it' to confirm."), "Waiting for your send confirmation", new c73("Exact SMS recipient and body verified; awaiting confirmation"), null, true, 8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:103:0x01d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:104:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:106:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f3 A[LOOP:0: B:107:0x01ed->B:109:0x01f3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:112:0x0209  */
    /* JADX WARN: Code duplicated, block: B:114:0x0215  */
    /* JADX WARN: Code duplicated, block: B:118:0x0244  */
    /* JADX WARN: Code duplicated, block: B:120:0x0250  */
    /* JADX WARN: Code duplicated, block: B:121:0x0255  */
    /* JADX WARN: Code duplicated, block: B:123:0x025d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0288  */
    /* JADX WARN: Code duplicated, block: B:129:0x028c  */
    /* JADX WARN: Code duplicated, block: B:131:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:133:0x02af  */
    /* JADX WARN: Code duplicated, block: B:135:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:137:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:139:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:153:0x025f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0129  */
    /* JADX WARN: Code duplicated, block: B:68:0x012e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0131  */
    /* JADX WARN: Code duplicated, block: B:72:0x0139  */
    /* JADX WARN: Code duplicated, block: B:76:0x0147  */
    /* JADX WARN: Code duplicated, block: B:78:0x014f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0157  */
    /* JADX WARN: Code duplicated, block: B:84:0x016d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x016e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0177  */
    /* JADX WARN: Code duplicated, block: B:89:0x017f  */
    /* JADX WARN: Code duplicated, block: B:92:0x018d  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ad  */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0117, code lost:
    
        if (r2 == r6) goto L147;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:114:0x0215, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(defpackage.f5 r21, defpackage.cl2 r22, defpackage.y50 r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 819
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bj1.p(f5, cl2, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object q(y50 y50Var) {
        aj1 aj1Var;
        if (y50Var instanceof aj1) {
            aj1Var = (aj1) y50Var;
            int i = aj1Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                aj1Var.i = i - Integer.MIN_VALUE;
            } else {
                aj1Var = new aj1(this, y50Var);
            }
        } else {
            aj1Var = new aj1(this, y50Var);
        }
        Object objC = aj1Var.e;
        int i2 = aj1Var.i;
        if (i2 == 0) {
            bz3.g(objC);
            aj1Var.i = 1;
            objC = rn4.c(this.f.b, aj1Var);
            t70 t70Var = t70.a;
            if (objC == t70Var) {
                return t70Var;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(objC);
        }
        if (!((g5) objC).i) {
            d52 d52Var = new d52("screen_reading", "Enable screen control", "Allow SONIC to verify the SMS recipient and text before a confirmed send.");
            return new el2("Enable screen control so I can verify and send your SMS after confirmation.", new c32("Screen control is off", d52Var), d52Var);
        }
        if (this.d.a.j()) {
            return null;
        }
        f52 f52Var = new f52("android.settings.ACCESSIBILITY_SETTINGS", "Enable SONIC accessibility", "Allow SONIC to use the visible SMS composer after confirmation.");
        return new el2("Enable SONIC accessibility so I can verify and send your SMS after confirmation.", new c32("Accessibility is off", f52Var), f52Var);
    }

    public final jl2 r(String str) {
        Object q61Var;
        Object si1Var;
        Object ti1Var;
        String strD = n61.a.d(str);
        oi1 oi1Var = this.a;
        oi1Var.getClass();
        if (cs2.A(strD)) {
            ti1Var = new si1("there was no text to share");
        } else {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", strD);
            n21 n21Var = oi1Var.a;
            n21Var.getClass();
            String strC = n21.c(intent);
            if (strC != null) {
                q61Var = new s61(strC);
            } else if (n21Var.b(intent) != null) {
                Intent intentCreateChooser = Intent.createChooser(intent, "Send with");
                intentCreateChooser.addFlags(268435456);
                try {
                    n21Var.a.startActivity(intentCreateChooser);
                    q61Var = new p61("android.chooser", "Send with");
                } catch (ActivityNotFoundException unused) {
                    q61Var = new q61("share text");
                } catch (SecurityException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = "Android blocked the request";
                    }
                    q61Var = new r61(message);
                }
            } else {
                q61Var = new q61("share text");
            }
            if (q61Var instanceof p61) {
                ti1Var = new ri1(null, strD.length(), "whichever app you pick", null);
            } else if (q61Var instanceof q61) {
                ti1Var = new ti1("no app on this phone can send text");
            } else {
                if (q61Var instanceof r61) {
                    si1Var = new si1(((r61) q61Var).a);
                } else if (q61Var instanceof s61) {
                    si1Var = new si1(((s61) q61Var).a);
                } else {
                    if (!(q61Var instanceof o61)) {
                        dk0.l();
                        return null;
                    }
                    si1Var = new si1(((o61) q61Var).a);
                }
                ti1Var = si1Var;
            }
        }
        if (ti1Var instanceof ri1) {
            return new hl2("Pick where you'd like it to go.", "I can't see which app you choose, or whether you send it", new c73("the chooser hides the user's selection from the calling app, by design"), null, false, 24);
        }
        if (ti1Var instanceof ti1) {
            return new fl2("Nothing on this phone can send text.", ((ti1) ti1Var).a, null, false, 4);
        }
        if (ti1Var instanceof si1) {
            return new fl2("I couldn't share that.", ((si1) ti1Var).a, null, false, 12);
        }
        dk0.l();
        return null;
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
