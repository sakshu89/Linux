package defpackage;

import java.util.List;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fh1 {
    public final Matcher a;
    public final CharSequence b;
    public final eh1 c;
    public dh1 d;

    public fh1(Matcher matcher, CharSequence charSequence) {
        charSequence.getClass();
        this.a = matcher;
        this.b = charSequence;
        this.c = new eh1(0, this);
    }

    public final List a() {
        if (this.d == null) {
            this.d = new dh1(this);
        }
        dh1 dh1Var = this.d;
        dh1Var.getClass();
        return dh1Var;
    }

    public final h21 b() {
        Matcher matcher = this.a;
        return ky3.f(matcher.start(), matcher.end());
    }

    public final String c() {
        String strGroup = this.a.group();
        strGroup.getClass();
        return strGroup;
    }

    public final fh1 d() {
        Matcher matcher = this.a;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.b;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        matcher2.getClass();
        return ty3.a(matcher2, iEnd, charSequence);
    }
}
