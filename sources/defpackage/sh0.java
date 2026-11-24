package defpackage;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sh0 extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile sh0 b;
    public static Class c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? new kp2(cls, charSequence) : super.newEditable(charSequence);
    }
}
