package defpackage;

import android.media.session.MediaController;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cj1 implements o21 {
    public static final Set b = wh2.c("shut down", "sonic shut down", "shutdown", "turn off assistant", "close assistant", "stop assistant", "shut down assistant", "assistant shut down", "band karo assistant", "sonic band karo");
    public static final Set c = wh2.c("stop", "pause", "stop speaking", "pause speaking", "stop talking", "cancel", "cancel that", "cancel request", "never mind", "nevermind", "forget it", "abort", "quiet", "be quiet", "shut up", "chup", "chup karo", "stop it", "leave it", "no thanks", "no thank you", "wait");
    public static final Set d = wh2.c("who are you", "what are you", "whats your name", "what is your name", "your name", "what can you do", "what can you do for me", "help", "what are your features", "introduce yourself", "about", "about you", "tum kaun ho", "aap kaun ho");
    public final ii1 a;

    public cj1(ii1 ii1Var) {
        this.a = ii1Var;
    }

    @Override // defpackage.o21
    public final int a() {
        return 1000;
    }

    @Override // defpackage.o21
    public final String b() {
        return "meta";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        Object h72Var;
        i60Var.getClass();
        String str = b63Var.a;
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        String string = cs2.V(cs2.G(cs2.G(lowerCase, "sonic "), "sonics ")).toString();
        String lowerCase2 = b63Var.c.toLowerCase(locale);
        lowerCase2.getClass();
        String string2 = cs2.V(cs2.G(cs2.G(lowerCase2, "sonic "), "sonics ")).toString();
        boolean zBooleanValue = false;
        ii1 ii1Var = this.a;
        if (ii1Var != null) {
            try {
                if (ii1Var.b.a()) {
                    MediaController mediaControllerG = ii1Var.g(null);
                    ro1 ro1VarF = mediaControllerG != null ? ii1Var.f(mediaControllerG) : null;
                    if (ro1VarF != null && ro1VarF.f) {
                        zBooleanValue = true;
                    }
                }
                h72Var = Boolean.valueOf(zBooleanValue);
            } catch (Throwable th) {
                h72Var = new h72(th);
            }
            Object obj = Boolean.FALSE;
            if (h72Var instanceof h72) {
                h72Var = obj;
            }
            zBooleanValue = ((Boolean) h72Var).booleanValue();
        }
        if (xy.o(str) || xy.o(string2)) {
            return dp4.d(b63Var, "meta.shutdown", null, 0.99f, 10);
        }
        Set set = b;
        if (set.contains(string) || set.contains(string2)) {
            return dp4.d(b63Var, "meta.shutdown", null, 0.99f, 10);
        }
        if (zBooleanValue) {
            Set setC = wh2.c("stop speaking", "pause speaking", "stop talking", "chup", "chup karo", "quiet", "be quiet", "shut up");
            if (setC.contains(string) || setC.contains(string2)) {
                return dp4.d(b63Var, "meta.cancel", null, 0.99f, 10);
            }
        }
        if (!zBooleanValue) {
            Set set2 = c;
            if (set2.contains(string) || set2.contains(string2)) {
                return dp4.d(b63Var, "meta.cancel", null, 0.99f, 10);
            }
        }
        Set set3 = d;
        if (set3.contains(string) || set3.contains(string2)) {
            return dp4.d(b63Var, "meta.about", null, 0.99f, 10);
        }
        return null;
    }
}
