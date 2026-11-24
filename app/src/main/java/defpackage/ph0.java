package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ph0 implements ta0 {
    public final /* synthetic */ qb1 a;

    public ph0(EmojiCompatInitializer emojiCompatInitializer, qb1 qb1Var) {
        this.a = qb1Var;
    }

    @Override // defpackage.ta0
    public final void onResume(ob1 ob1Var) {
        (Build.VERSION.SDK_INT >= 28 ? p30.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new t5(2), 500L);
        this.a.f(this);
    }
}
