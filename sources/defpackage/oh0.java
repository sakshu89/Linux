package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.inputmethod.EditorInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class oh0 {
    public static final Object j = new Object();
    public static volatile oh0 k;
    public final ReentrantReadWriteLock a;
    public final pg b;
    public volatile int c;
    public final Handler d;
    public final kh0 e;
    public final nh0 f;
    public final su0 g;
    public final int h;
    public final ma0 i;

    public oh0(ap0 ap0Var) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock;
        this.c = 3;
        nh0 nh0Var = ap0Var.a;
        this.f = nh0Var;
        int i = ap0Var.b;
        this.h = i;
        this.i = ap0Var.c;
        this.d = new Handler(Looper.getMainLooper());
        this.b = new pg(0);
        this.g = new su0(12);
        kh0 kh0Var = new kh0(this);
        this.e = kh0Var;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.c = 0;
            } catch (Throwable th) {
                this.a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (c() == 0) {
            try {
                nh0Var.a(new jh0(kh0Var));
            } catch (Throwable th2) {
                f(th2);
            }
        }
    }

    public static oh0 a() {
        oh0 oh0Var;
        synchronized (j) {
            oh0Var = k;
            hh1.e("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.", oh0Var != null);
        }
        return oh0Var;
    }

    public static boolean d() {
        return k != null;
    }

    public final int b(CharSequence charSequence, int i) {
        hh1.e("Not initialized yet", c() == 1);
        hh1.d(charSequence, "charSequence cannot be null");
        kf kfVar = this.e.b;
        kfVar.getClass();
        if (i < 0 || i >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            r33[] r33VarArr = (r33[]) spanned.getSpans(i, i + 1, r33.class);
            if (r33VarArr.length > 0) {
                return spanned.getSpanStart(r33VarArr[0]);
            }
        }
        return ((xh0) kfVar.y(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new xh0(i))).b;
    }

    public final int c() {
        this.a.readLock().lock();
        try {
            return this.c;
        } finally {
            this.a.readLock().unlock();
        }
    }

    public final void e() {
        hh1.e("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading", this.h == 1);
        if (c() == 1) {
            return;
        }
        this.a.writeLock().lock();
        try {
            if (this.c == 0) {
                this.a.writeLock().unlock();
                return;
            }
            this.c = 0;
            this.a.writeLock().unlock();
            kh0 kh0Var = this.e;
            oh0 oh0Var = kh0Var.a;
            try {
                oh0Var.f.a(new jh0(kh0Var));
            } catch (Throwable th) {
                oh0Var.f(th);
            }
        } catch (Throwable th2) {
            this.a.writeLock().unlock();
            throw th2;
        }
    }

    public final void f(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post(new mh0(arrayList, this.c, th));
        } catch (Throwable th2) {
            this.a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a8 A[Catch: all -> 0x008b, TryCatch #3 {all -> 0x008b, blocks: (B:35:0x0063, B:38:0x0068, B:40:0x006c, B:42:0x0079, B:49:0x0098, B:51:0x00a2, B:53:0x00a5, B:55:0x00a8, B:57:0x00b8, B:58:0x00bb), top: B:101:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b8 A[Catch: all -> 0x008b, TryCatch #3 {all -> 0x008b, blocks: (B:35:0x0063, B:38:0x0068, B:40:0x006c, B:42:0x0079, B:49:0x0098, B:51:0x00a2, B:53:0x00a5, B:55:0x00a8, B:57:0x00b8, B:58:0x00bb), top: B:101:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:88:0x010d  */
    public final CharSequence g(CharSequence charSequence, int i, int i2, int i3) {
        CharSequence charSequence2;
        Throwable th;
        int i4;
        int i5;
        r33[] r33VarArr;
        int spanStart;
        hh1.e("Not initialized yet", c() == 1);
        v43 v43Var = null;
        if (i < 0) {
            og.i("start cannot be negative");
            return null;
        }
        if (i2 < 0) {
            og.i("end cannot be negative");
            return null;
        }
        hh1.a("start should be <= than end", i <= i2);
        if (charSequence == null) {
            return null;
        }
        hh1.a("start should be < than charSequence length", i <= charSequence.length());
        hh1.a("end should be < than charSequence length", i2 <= charSequence.length());
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        boolean z = i3 == 1;
        kf kfVar = this.e.b;
        kfVar.getClass();
        boolean z2 = charSequence instanceof kp2;
        if (z2) {
            ((kp2) charSequence).a();
        }
        if (z2) {
            v43Var = new v43((Spannable) charSequence);
            if (v43Var != null) {
                for (r33 r33Var : r33VarArr) {
                    spanStart = v43Var.b.getSpanStart(r33Var);
                    int spanEnd = v43Var.b.getSpanEnd(r33Var);
                    if (spanStart != i2) {
                        v43Var.removeSpan(r33Var);
                    }
                    i = Math.min(spanStart, i);
                    i2 = Math.max(spanEnd, i2);
                }
            }
            i4 = i;
            i5 = i2;
            if (i4 != i5) {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            }
            ((kp2) charSequence2).b();
            return charSequence2;
        }
        try {
            if (charSequence instanceof Spannable) {
                try {
                    v43Var = new v43((Spannable) charSequence);
                } catch (Throwable th2) {
                    th = th2;
                    charSequence2 = charSequence;
                    th = th;
                    if (!z2) {
                        throw th;
                    }
                    ((kp2) charSequence2).b();
                    throw th;
                }
            } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i - 1, i2 + 1, r33.class) <= i2) {
                v43Var = new v43();
                v43Var.a = false;
                v43Var.b = new SpannableString(charSequence);
            }
            if (v43Var != null && (r33VarArr = (r33[]) v43Var.b.getSpans(i, i2, r33.class)) != null && r33VarArr.length > 0) {
                while (i < r2) {
                    spanStart = v43Var.b.getSpanStart(r33Var);
                    int spanEnd2 = v43Var.b.getSpanEnd(r33Var);
                    if (spanStart != i2) {
                        v43Var.removeSpan(r33Var);
                    }
                    i = Math.min(spanStart, i);
                    i2 = Math.max(spanEnd2, i2);
                }
            }
            i4 = i;
            i5 = i2;
            if (i4 != i5 || i4 >= charSequence.length()) {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            } else {
                try {
                    charSequence2 = charSequence;
                    try {
                        v43 v43Var2 = (v43) kfVar.y(charSequence2, i4, i5, Integer.MAX_VALUE, z, new l11(22, v43Var, (su0) kfVar.b));
                        if (v43Var2 != null) {
                            Spannable spannable = v43Var2.b;
                            if (z2) {
                                ((kp2) charSequence2).b();
                            }
                            return spannable;
                        }
                        if (!z2) {
                            return charSequence2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        if (!z2) {
                            throw th;
                        }
                        ((kp2) charSequence2).b();
                        throw th;
                    }
                } catch (Throwable th4) {
                    charSequence2 = charSequence;
                    th = th4;
                }
            }
            ((kp2) charSequence2).b();
            return charSequence2;
        } catch (Throwable th5) {
            th = th5;
            charSequence2 = charSequence;
        }
        if (!z2) {
            throw th;
        }
        ((kp2) charSequence2).b();
        throw th;
    }

    public final void h(lh0 lh0Var) {
        hh1.d(lh0Var, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            if (this.c == 1 || this.c == 2) {
                this.d.post(new mh0(Arrays.asList(lh0Var), this.c, null));
            } else {
                this.b.add(lh0Var);
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public final void i(EditorInfo editorInfo) {
        if (c() != 1 || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        kh0 kh0Var = this.e;
        kh0Var.getClass();
        Bundle bundle = editorInfo.extras;
        hj1 hj1Var = (hj1) kh0Var.c.a;
        int iA = hj1Var.a(4);
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) hj1Var.e).getInt(iA + hj1Var.a) : 0);
        editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }
}
