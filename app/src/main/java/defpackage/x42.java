package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x42 implements Serializable {
    public final Pattern a;

    public x42(String str, y42 y42Var) {
        str.getClass();
        int i = y42Var.a;
        Pattern patternCompile = Pattern.compile(str, (i & 2) != 0 ? i | 64 : i);
        patternCompile.getClass();
        this.a = patternCompile;
    }

    public static fh1 b(x42 x42Var, CharSequence charSequence) {
        x42Var.getClass();
        charSequence.getClass();
        Matcher matcher = x42Var.a.matcher(charSequence);
        matcher.getClass();
        return ty3.a(matcher, 0, charSequence);
    }

    public static au0 c(x42 x42Var, CharSequence charSequence) {
        x42Var.getClass();
        charSequence.getClass();
        if (charSequence.length() >= 0) {
            return new au0(0, new zb(14, x42Var, charSequence), w42.k);
        }
        dk0.f(charSequence.length(), ky0.p("Start index out of bounds: ", 0, ", input length: "));
        return null;
    }

    public final boolean a(CharSequence charSequence) {
        charSequence.getClass();
        return this.a.matcher(charSequence).find();
    }

    public final fh1 d(CharSequence charSequence) {
        charSequence.getClass();
        Matcher matcher = this.a.matcher(charSequence);
        matcher.getClass();
        if (matcher.matches()) {
            return new fh1(matcher, charSequence);
        }
        return null;
    }

    public final boolean e(CharSequence charSequence) {
        charSequence.getClass();
        return this.a.matcher(charSequence).matches();
    }

    public final String f(CharSequence charSequence, String str) {
        charSequence.getClass();
        str.getClass();
        String strReplaceAll = this.a.matcher(charSequence).replaceAll(str);
        strReplaceAll.getClass();
        return strReplaceAll;
    }

    public final String g(String str, hq0 hq0Var) {
        str.getClass();
        Matcher matcher = this.a.matcher(str);
        matcher.getClass();
        int i = 0;
        fh1 fh1VarA = ty3.a(matcher, 0, str);
        if (fh1VarA == null) {
            return str.toString();
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append((CharSequence) str, i, fh1VarA.b().a);
            sb.append((CharSequence) hq0Var.j(fh1VarA));
            i = fh1VarA.b().b + 1;
            fh1VarA = fh1VarA.d();
            if (i >= length) {
                break;
            }
        } while (fh1VarA != null);
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        return sb.toString();
    }

    public final String h(String str) {
        str.getClass();
        String strReplaceFirst = this.a.matcher(str).replaceFirst("");
        strReplaceFirst.getClass();
        return strReplaceFirst;
    }

    public final List i(String str) {
        str.getClass();
        int iEnd = 0;
        cs2.L(0);
        Matcher matcher = this.a.matcher(str);
        if (!matcher.find()) {
            return nz.h(str.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        do {
            arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
        } while (matcher.find());
        arrayList.add(str.subSequence(iEnd, str.length()).toString());
        return arrayList;
    }

    public final String toString() {
        String string = this.a.toString();
        string.getClass();
        return string;
    }

    public x42(String str) {
        Pattern patternCompile = Pattern.compile(str);
        patternCompile.getClass();
        this.a = patternCompile;
    }
}
