package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.speech.tts.TextToSpeech;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sn1 {
    public final Context a;
    public TextToSpeech c;
    public x00 d;
    public final an1 b = new an1();
    public final ConcurrentHashMap e = new ConcurrentHashMap();
    public float f = 1.05f;

    public sn1(Context context) {
        this.a = context;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e4 A[Catch: all -> 0x0032, TryCatch #1 {all -> 0x0032, blocks: (B:14:0x002d, B:54:0x00e0, B:56:0x00e4, B:58:0x00e8, B:59:0x00ed), top: B:66:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(y50 y50Var) throws Throwable {
        nn1 nn1Var;
        Object h72Var;
        an1 an1Var;
        int i;
        an1 an1Var2;
        an1 an1Var3;
        Object objC;
        Boolean bool;
        x00 x00Var;
        if (y50Var instanceof nn1) {
            nn1Var = (nn1) y50Var;
            int i2 = nn1Var.n;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                nn1Var.n = i2 - Integer.MIN_VALUE;
            } else {
                nn1Var = new nn1(this, y50Var);
            }
        } else {
            nn1Var = new nn1(this, y50Var);
        }
        Object obj = nn1Var.j;
        int i3 = nn1Var.n;
        int i4 = 3;
        int i5 = 0;
        x50 x50Var = null;
        t70 t70Var = t70.a;
        try {
            if (i3 == 0) {
                bz3.g(obj);
                try {
                    List<ResolveInfo> listQueryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent("android.intent.action.TTS_SERVICE").setPackage("com.k2fsa.sherpa.onnx.tts.engine"), 0);
                    listQueryIntentServices.getClass();
                    h72Var = Boolean.valueOf(!listQueryIntentServices.isEmpty());
                } catch (Throwable th) {
                    h72Var = new h72(th);
                }
                Object obj2 = Boolean.FALSE;
                if (h72Var instanceof h72) {
                    h72Var = obj2;
                }
                if (!((Boolean) h72Var).booleanValue()) {
                    return obj2;
                }
                an1Var = this.b;
                nn1Var.e = an1Var;
                nn1Var.f = 0;
                nn1Var.n = 1;
                if (an1Var.e(nn1Var) != t70Var) {
                    i = 0;
                }
                return t70Var;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    an1Var3 = nn1Var.e;
                    try {
                        bz3.g(obj);
                        bool = (Boolean) obj;
                        if (bool == null && (x00Var = this.d) != null) {
                            x00Var.b0(Boolean.FALSE);
                        }
                        Boolean boolValueOf = Boolean.valueOf(g31.a(bool, Boolean.TRUE));
                        an1Var3.h(null);
                        return boolValueOf;
                    } catch (Throwable th2) {
                        th = th2;
                        an1Var3.h(null);
                        throw th;
                    }
                }
                i5 = nn1Var.i;
                i = nn1Var.f;
                an1Var2 = nn1Var.e;
                try {
                    bz3.g(obj);
                    an1Var = an1Var2;
                    l2 l2Var = new l2(this, x50Var, 14);
                    nn1Var.e = an1Var;
                    nn1Var.f = i;
                    nn1Var.i = i5;
                    nn1Var.n = 3;
                    objC = xc4.c(5000L, l2Var, nn1Var);
                    if (objC != t70Var) {
                        an1Var3 = an1Var;
                        obj = objC;
                        bool = (Boolean) obj;
                        if (bool == null) {
                            x00Var.b0(Boolean.FALSE);
                        }
                        Boolean boolValueOf2 = Boolean.valueOf(g31.a(bool, Boolean.TRUE));
                        an1Var3.h(null);
                        return boolValueOf2;
                    }
                    return t70Var;
                } catch (Throwable th3) {
                    th = th3;
                    an1Var3 = an1Var2;
                    an1Var3.h(null);
                    throw th;
                }
            }
            i = nn1Var.f;
            an1 an1Var4 = nn1Var.e;
            bz3.g(obj);
            an1Var = an1Var4;
            if (this.c == null) {
                xa0 xa0Var = ld0.a;
                tv0 tv0Var = ig1.a.i;
                mf mfVar = new mf(this, x50Var, i4);
                nn1Var.e = an1Var;
                nn1Var.f = i;
                nn1Var.i = 0;
                nn1Var.n = 2;
                if (uf4.d(tv0Var, mfVar, nn1Var) != t70Var) {
                    an1Var2 = an1Var;
                    an1Var = an1Var2;
                    l2 l2Var2 = new l2(this, x50Var, 14);
                    nn1Var.e = an1Var;
                    nn1Var.f = i;
                    nn1Var.i = i5;
                    nn1Var.n = 3;
                    objC = xc4.c(5000L, l2Var2, nn1Var);
                    if (objC != t70Var) {
                        an1Var3 = an1Var;
                        obj = objC;
                        bool = (Boolean) obj;
                        if (bool == null) {
                            x00Var.b0(Boolean.FALSE);
                        }
                        Boolean boolValueOf3 = Boolean.valueOf(g31.a(bool, Boolean.TRUE));
                        an1Var3.h(null);
                        return boolValueOf3;
                    }
                }
            } else {
                l2 l2Var3 = new l2(this, x50Var, 14);
                nn1Var.e = an1Var;
                nn1Var.f = i;
                nn1Var.i = i5;
                nn1Var.n = 3;
                objC = xc4.c(5000L, l2Var3, nn1Var);
                if (objC != t70Var) {
                    an1Var3 = an1Var;
                    obj = objC;
                    bool = (Boolean) obj;
                    if (bool == null) {
                        x00Var.b0(Boolean.FALSE);
                    }
                    Boolean boolValueOf4 = Boolean.valueOf(g31.a(bool, Boolean.TRUE));
                    an1Var3.h(null);
                    return boolValueOf4;
                }
            }
            return t70Var;
        } catch (Throwable th4) {
            th = th4;
            an1Var3 = an1Var;
            an1Var3.h(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00cb A[Catch: all -> 0x0036, CancellationException -> 0x0039, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0031, B:45:0x00c7, B:47:0x00cb, B:48:0x00ce, B:55:0x00e1, B:56:0x00e4), top: B:59:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String str, Locale locale, String str2, y50 y50Var) throws Throwable {
        qn1 qn1Var;
        String str3;
        String str4;
        Object objD;
        Object obj;
        Boolean bool;
        Locale locale2 = locale;
        if (y50Var instanceof qn1) {
            qn1 qn1Var2 = (qn1) y50Var;
            int i = qn1Var2.n;
            if ((i & Integer.MIN_VALUE) != 0) {
                qn1Var2.n = i - Integer.MIN_VALUE;
                qn1Var = qn1Var2;
            } else {
                qn1Var = new qn1(this, y50Var);
            }
        } else {
            qn1Var = new qn1(this, y50Var);
        }
        Object objC = qn1Var.j;
        int i2 = qn1Var.n;
        int i3 = 2;
        ConcurrentHashMap concurrentHashMap = this.e;
        x50 x50Var = null;
        Object obj2 = t70.a;
        try {
            if (i2 == 0) {
                bz3.g(objC);
                str3 = str;
                qn1Var.e = str3;
                qn1Var.f = locale2;
                str4 = str2;
                qn1Var.i = str4;
                qn1Var.n = 1;
                objD = d(locale2, qn1Var);
                if (objD != obj2) {
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                obj = qn1Var.i;
                try {
                    bz3.g(objC);
                    bool = (Boolean) objC;
                    if (bool == null) {
                        c();
                    }
                    boolean zA = g31.a(bool, Boolean.TRUE);
                    concurrentHashMap.remove(obj);
                    return Boolean.valueOf(zA);
                } catch (CancellationException e) {
                    e = e;
                    c();
                    throw e;
                }
            }
            String str5 = qn1Var.i;
            Locale locale3 = qn1Var.f;
            String str6 = qn1Var.e;
            bz3.g(objC);
            str4 = str5;
            locale2 = locale3;
            objD = objC;
            str3 = str6;
            if (!((Boolean) objD).booleanValue()) {
                return Boolean.FALSE;
            }
            TextToSpeech textToSpeech = this.c;
            if (textToSpeech == null) {
                return Boolean.FALSE;
            }
            if (textToSpeech.setLanguage(locale2) < 0) {
                return Boolean.FALSE;
            }
            textToSpeech.setSpeechRate(this.f);
            x00 x00VarA = ui4.a();
            concurrentHashMap.put(str4, x00VarA);
            if (textToSpeech.speak(str3, 0, null, str4) != 0) {
                concurrentHashMap.remove(str4);
                return Boolean.FALSE;
            }
            try {
                long jD = ky3.d(((long) str3.length()) * 120, 4000L, 60000L);
                d60 d60Var = new d60(x00VarA, x50Var, i3);
                qn1Var.e = null;
                qn1Var.f = null;
                qn1Var.i = str4;
                qn1Var.n = 2;
                objC = xc4.c(jD, d60Var, qn1Var);
                if (objC != obj2) {
                    obj = str4;
                    bool = (Boolean) objC;
                    if (bool == null) {
                        c();
                    }
                    boolean zA2 = g31.a(bool, Boolean.TRUE);
                    concurrentHashMap.remove(obj);
                    return Boolean.valueOf(zA2);
                }
                return obj2;
            } catch (CancellationException e2) {
                e = e2;
                c();
                throw e;
            } catch (Throwable th) {
                th = th;
                qn1Var = str4;
                concurrentHashMap.remove(qn1Var);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void c() throws IllegalAccessException, InvocationTargetException {
        TextToSpeech textToSpeech = this.c;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        ConcurrentHashMap concurrentHashMap = this.e;
        Collection collectionValues = concurrentHashMap.values();
        collectionValues.getClass();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            ((x00) it.next()).b0(Boolean.FALSE);
        }
        concurrentHashMap.clear();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(Locale locale, y50 y50Var) throws Throwable {
        rn1 rn1Var;
        boolean z;
        if (y50Var instanceof rn1) {
            rn1Var = (rn1) y50Var;
            int i = rn1Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                rn1Var.j = i - Integer.MIN_VALUE;
            } else {
                rn1Var = new rn1(this, y50Var);
            }
        } else {
            rn1Var = new rn1(this, y50Var);
        }
        Object objA = rn1Var.f;
        int i2 = rn1Var.j;
        if (i2 == 0) {
            bz3.g(objA);
            rn1Var.e = locale;
            rn1Var.j = 1;
            objA = a(rn1Var);
            Object obj = t70.a;
            if (objA == obj) {
                return obj;
            }
        } else {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            locale = rn1Var.e;
            bz3.g(objA);
        }
        if (((Boolean) objA).booleanValue()) {
            TextToSpeech textToSpeech = this.c;
            z = (textToSpeech != null ? textToSpeech.isLanguageAvailable(locale) : -2) >= 0;
        }
        return Boolean.valueOf(z);
    }
}
