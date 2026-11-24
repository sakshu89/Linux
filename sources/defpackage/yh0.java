package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yh0 implements wh0 {
    public final String a;

    public /* synthetic */ yh0(String str) {
        this.a = str;
    }

    @Override // defpackage.wh0
    public boolean f(CharSequence charSequence, int i, int i2, q33 q33Var) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.a)) {
            return true;
        }
        q33Var.c = (q33Var.c & 3) | 4;
        return false;
    }

    @Override // defpackage.wh0
    public Object e() {
        return this;
    }
}
