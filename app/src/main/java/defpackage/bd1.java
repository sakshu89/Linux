package defpackage;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bd1 {
    public final AudioManager a;
    public zc1 b;
    public AudioFocusRequest c;
    public volatile boolean d;

    public bd1(Context context) {
        this.a = (AudioManager) context.getSystemService(AudioManager.class);
    }

    public final synchronized boolean a(zc1 zc1Var) {
        return this.b == zc1Var && !this.d;
    }

    public final void b(zc1 zc1Var) {
        boolean z;
        AudioManager audioManager;
        synchronized (this) {
            z = this.b == zc1Var && ((audioManager = this.a) == null || audioManager.getMode() != 0);
        }
        if (z) {
            f(zc1Var, ad1.b);
        }
    }

    public final synchronized void c(zc1 zc1Var) {
        zc1Var.getClass();
        if (this.b != zc1Var) {
            return;
        }
        AudioFocusRequest audioFocusRequest = this.c;
        if (audioFocusRequest == null) {
            return;
        }
        this.c = null;
        try {
            AudioManager audioManager = this.a;
            if (audioManager != null) {
                audioManager.abandonAudioFocusRequest(audioFocusRequest);
            }
        } catch (Throwable unused) {
        }
    }

    public final void d(zc1 zc1Var, AudioFocusRequest audioFocusRequest) {
        synchronized (this) {
            if (this.b == zc1Var && this.c == audioFocusRequest) {
                c(zc1Var);
                zc1Var.b.a();
            }
        }
    }

    public final synchronized void e(zc1 zc1Var) {
        zc1Var.getClass();
        if (this.b != zc1Var) {
            return;
        }
        c(zc1Var);
        this.b = null;
    }

    public final void f(zc1 zc1Var, ad1 ad1Var) {
        zc1Var.getClass();
        synchronized (this) {
            if (this.b == zc1Var && !this.d) {
                this.d = true;
                try {
                    zc1Var.a.j(ad1Var);
                } finally {
                    e(zc1Var);
                }
            }
        }
    }
}
