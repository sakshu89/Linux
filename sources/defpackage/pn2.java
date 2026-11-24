package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.speech.SpeechRecognizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pn2 {
    public final Context a;
    public volatile SpeechRecognizer c;
    public volatile l52 d;
    public float f;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final AtomicLong e = new AtomicLong();
    public final float g = 0.18f;
    public final float h = 2.5f;

    public pn2(Context context) {
        this.a = context;
    }

    public static final Intent a(pn2 pn2Var, boolean z, Locale locale) {
        pn2Var.getClass();
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        int i = Build.VERSION.SDK_INT;
        String languageTag = g31.a(locale.getLanguage(), "en") ? "en-IN" : locale.toLanguageTag();
        intent.putExtra("android.speech.extra.LANGUAGE", languageTag);
        if (i >= 34) {
            intent.putExtra("android.speech.extra.ENABLE_LANGUAGE_DETECTION", true);
            intent.putExtra("android.speech.extra.ENABLE_LANGUAGE_SWITCH", "balanced");
            String[] strArr = {languageTag, "en-IN", "hi-IN"};
            LinkedHashSet linkedHashSet = new LinkedHashSet(bh1.b(3));
            for (int i2 = 0; i2 < 3; i2++) {
                linkedHashSet.add(strArr[i2]);
            }
            Iterator it = l61.k.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(((l61) it.next()).b.toLanguageTag());
            }
            intent.putExtra("android.speech.extra.PREFERRED_LANGUAGES", new ArrayList(linkedHashSet));
        }
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        intent.putExtra("android.speech.extra.MAX_RESULTS", 5);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS", 650L);
        intent.putExtra("android.speech.extras.SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS", 400L);
        intent.putExtra("android.speech.extra.PREFER_OFFLINE", z);
        intent.putExtra("calling_package", pn2Var.a.getPackageName());
        return intent;
    }

    public static sp c(pn2 pn2Var, boolean z, Locale locale, int i) {
        boolean z2 = (i & 1) != 0 ? false : z;
        boolean z3 = (i & 4) == 0;
        pn2Var.getClass();
        locale.getClass();
        return new sp(new on2(pn2Var, z3, locale, z2, null), gi0.a, -2, nn.a);
    }

    public final boolean b() {
        return Build.VERSION.SDK_INT >= 31 && SpeechRecognizer.isOnDeviceRecognitionAvailable(this.a);
    }

    public final void d() {
        this.e.incrementAndGet();
        l52 l52Var = this.d;
        if (!g31.a(Looper.myLooper(), Looper.getMainLooper())) {
            this.b.post(new m4(l52Var, 4));
        } else if (l52Var != null) {
            l52Var.a();
        }
    }
}
