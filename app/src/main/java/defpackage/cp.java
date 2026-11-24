package defpackage;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cp implements bl2 {
    public static final Set d = wh2.c('+', '-', '*', '/', '^', '%');
    public final Set a = wh2.b(new w3("util.calculate"));
    public final ii0 b = ii0.a;
    public final l82 c = l82.a;

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.a;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "util.calculate";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Works out arithmetic exactly, on the device.";
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0119  */
    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) {
        String string;
        Object woVar;
        Object woVar2;
        Object fl2Var;
        String strC = f5Var.c("text");
        if (strC == null || (string = cs2.V(strC).toString()) == null) {
            return new fl2("What would you like me to work out?", "CALCULATE with no text", null, false, 12);
        }
        MathContext mathContext = sk0.a;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < string.length(); i2++) {
            char cCharAt = string.charAt(i2);
            if (!ph4.c(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string2 = sb.toString();
        int length = string2.length();
        uo uoVar = uo.a;
        if (length == 0) {
            woVar2 = new vo("the expression was empty");
        } else {
            c10 c10Var = new c10();
            c10Var.b = string2;
            try {
                qk0 qk0VarJ = c10Var.j();
                if (c10Var.c()) {
                    BigDecimal bigDecimalR = cq.r(qk0VarJ.a);
                    bigDecimalR.getClass();
                    woVar2 = new xo(bigDecimalR, qk0VarJ.b);
                } else {
                    woVar2 = new vo("I couldn't read the part starting at \"" + cs2.T(12, string2.substring(c10Var.a)) + "\"");
                }
            } catch (ArithmeticException unused) {
                woVar2 = new wo("that number is too big for me to work out");
            } catch (ok0 unused2) {
                woVar2 = uoVar;
            } catch (pk0 e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "that isn't an expression I can read";
                }
                woVar = new vo(message);
                woVar2 = woVar;
            } catch (rk0 e2) {
                String message2 = e2.getMessage();
                if (message2 == null) {
                    message2 = "that's beyond what I can work out exactly";
                }
                woVar = new wo(message2);
                woVar2 = woVar;
            }
        }
        if (woVar2 instanceof xo) {
            xo xoVar = (xo) woVar2;
            MathContext mathContext2 = sk0.a;
            String strA = sk0.a(xoVar.a);
            StringBuilder sb2 = new StringBuilder(string.length() * 2);
            int i3 = 0;
            while (i < string.length()) {
                char cCharAt2 = string.charAt(i);
                int i4 = i3 + 1;
                Character chValueOf = Character.valueOf(cCharAt2);
                Set set = d;
                if (!set.contains(chValueOf) || i3 <= 0) {
                    sb2.append(cCharAt2);
                } else {
                    int i5 = i3 - 1;
                    if (set.contains(Character.valueOf(string.charAt(i5))) || string.charAt(i5) == '(') {
                        sb2.append(cCharAt2);
                    } else {
                        sb2.append(' ');
                        sb2.append(cCharAt2);
                        sb2.append(' ');
                    }
                }
                i++;
                i3 = i4;
            }
            String string3 = sb2.toString();
            if (xoVar.b) {
                return new hl2(cq.v("About ", strA, "."), "that division doesn't come out evenly, so I've rounded it", new c73(ky0.k(string3, " rounds to ", strA, " at 16 significant figures; the exact value doesn't terminate")), null, false, 24);
            }
            fl2Var = new il2(strA, new d73("evaluated with exact decimal arithmetic on the device", cq.k(string3, " = ", strA)), null, cq.k(string3, " = ", strA), 4);
        } else {
            if (woVar2.equals(uoVar)) {
                return new fl2("You can't divide by zero — there's no answer to that one.", cq.v("division or modulo by zero in \"", string, "\""), null, false, 4);
            }
            if (woVar2 instanceof wo) {
                String str = ((wo) woVar2).a;
                fl2Var = new fl2(cq.v("I can't do that one — ", str, "."), cq.l("evaluator declined \"", string, "\": ", str), null, false, 4);
            } else {
                if (!(woVar2 instanceof vo)) {
                    dk0.l();
                    return null;
                }
                String str2 = ((vo) woVar2).a;
                fl2Var = new fl2(cq.v("I couldn't make sense of that sum — ", str2, "."), cq.l("malformed expression \"", string, "\": ", str2), null, true, 4);
            }
        }
        return fl2Var;
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        return a32.a;
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final List k() {
        return this.b;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.c;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "Calculator";
    }

    @Override // defpackage.bl2
    public final void f() {
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
