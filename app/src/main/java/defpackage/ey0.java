package defpackage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ey0 {
    public static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final List f;
    public final String g;
    public final String h;
    public final boolean i;

    public ey0(String str, String str2, String str3, String str4, int i, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        str.getClass();
        str4.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = arrayList2;
        this.g = str5;
        this.h = str6;
        this.i = str.equals("https");
    }

    public final String a() {
        if (this.c.length() == 0) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.h;
        return str.substring(cs2.x(str, ':', length, 4) + 1, cs2.x(str, '@', 0, 6));
    }

    public final String b() {
        int length = this.a.length() + 3;
        String str = this.h;
        int iX = cs2.x(str, '/', length, 4);
        return str.substring(iX, z53.g(str, iX, str.length(), "?#"));
    }

    public final ArrayList c() {
        int length = this.a.length() + 3;
        String str = this.h;
        int iX = cs2.x(str, '/', length, 4);
        int iG = z53.g(str, iX, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iX < iG) {
            int i = iX + 1;
            int iF = z53.f(str, '/', i, iG);
            arrayList.add(str.substring(i, iF));
            iX = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f == null) {
            return null;
        }
        String str = this.h;
        int iX = cs2.x(str, '?', 0, 6) + 1;
        return str.substring(iX, z53.f(str, '#', iX, str.length()));
    }

    public final String e() {
        if (this.b.length() == 0) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.h;
        return str.substring(length, z53.g(str, length, str.length(), ":@"));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ey0) && ((ey0) obj).h.equals(this.h);
    }

    public final dy0 f() {
        int i;
        dy0 dy0Var = new dy0();
        String str = this.a;
        dy0Var.a = str;
        dy0Var.b = e();
        dy0Var.c = a();
        dy0Var.d = this.d;
        str.getClass();
        if (str.equals("http")) {
            i = 80;
        } else {
            i = str.equals("https") ? 443 : -1;
        }
        int i2 = this.e;
        dy0Var.e = i2 != i ? i2 : -1;
        ArrayList arrayList = dy0Var.f;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        String strSubstring = null;
        dy0Var.g = strD != null ? fl4.j(fl4.c(0, 0, 211, strD, " \"'<>#", true)) : null;
        if (this.g != null) {
            String str2 = this.h;
            strSubstring = str2.substring(cs2.x(str2, '#', 0, 6) + 1);
        }
        dy0Var.h = strSubstring;
        return dy0Var;
    }

    public final String g() {
        dy0 dy0Var;
        try {
            dy0Var = new dy0();
            dy0Var.d(this, "/...");
        } catch (IllegalArgumentException unused) {
            dy0Var = null;
        }
        dy0Var.getClass();
        dy0Var.b = fl4.c(0, 0, 251, "", " \"':;<=>@[]^`{}|/\\?#", false);
        dy0Var.c = fl4.c(0, 0, 251, "", " \"':;<=>@[]^`{}|/\\?#", false);
        return dy0Var.b().h;
    }

    public final URI h() {
        String strReplaceAll;
        dy0 dy0VarF = f();
        ArrayList arrayList = dy0VarF.f;
        String str = dy0VarF.d;
        if (str != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            patternCompile.getClass();
            strReplaceAll = patternCompile.matcher(str).replaceAll("");
            strReplaceAll.getClass();
        } else {
            strReplaceAll = null;
        }
        dy0VarF.d = strReplaceAll;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.set(i, fl4.c(0, 0, 227, (String) arrayList.get(i), "[]", true));
        }
        ArrayList arrayList2 = dy0VarF.g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = (String) arrayList2.get(i2);
                arrayList2.set(i2, str2 != null ? fl4.c(0, 0, 195, str2, "\\^`{|}", true) : null);
            }
        }
        String str3 = dy0VarF.h;
        dy0VarF.h = str3 != null ? fl4.c(0, 0, 163, str3, " \"#<>\\^`{|}", true) : null;
        String string = dy0VarF.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                patternCompile2.getClass();
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                strReplaceAll2.getClass();
                URI uriCreate = URI.create(strReplaceAll2);
                uriCreate.getClass();
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final int hashCode() {
        return this.h.hashCode();
    }

    public final String toString() {
        return this.h;
    }
}
