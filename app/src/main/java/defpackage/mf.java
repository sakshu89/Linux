package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mf extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mf(Object obj, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.i = obj;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        s70 s70Var = (s70) obj;
        x50 x50Var = (x50) obj2;
        switch (i) {
            case 0:
                return ((mf) q(x50Var, s70Var)).s(q43Var);
            case 1:
                return ((mf) q(x50Var, s70Var)).s(q43Var);
            case 2:
                return ((mf) q(x50Var, s70Var)).s(q43Var);
            case 3:
                return ((mf) q(x50Var, s70Var)).s(q43Var);
            case 4:
                return ((mf) q(x50Var, s70Var)).s(q43Var);
            default:
                ((mf) q(x50Var, s70Var)).s(q43Var);
                return q43Var;
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.i;
        switch (i) {
            case 0:
                return new mf((nf) obj2, x50Var, 0);
            case 1:
                return new mf((String) obj2, x50Var, 1);
            case 2:
                return new mf((h61) obj2, x50Var, 2);
            case 3:
                return new mf((sn1) obj2, x50Var, 3);
            case 4:
                return new mf((sx1) obj2, x50Var, 4);
            default:
                return new mf((oj2) obj2, x50Var, 5);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        Integer num;
        String str;
        int i = this.f;
        q43 q43Var = q43.a;
        String string = null;
        Object obj2 = this.i;
        switch (i) {
            case 0:
                bz3.g(obj);
                AccessibilityNodeInfo accessibilityNodeInfoB = ((nf) obj2).b.b();
                if (accessibilityNodeInfoB != null) {
                    try {
                        CharSequence packageName = accessibilityNodeInfoB.getPackageName();
                        string = packageName != null ? packageName.toString() : null;
                    } finally {
                        accessibilityNodeInfoB.recycle();
                    }
                    break;
                }
                return string;
            case 1:
                bz3.g(obj);
                String str2 = (String) obj2;
                fu fuVarA = rg4.a(str2);
                String str3 = fuVarA.b;
                String str4 = fuVarA.a;
                if (str4.equals("_data")) {
                    File parentFile = new File(str3).getParentFile();
                    if (parentFile == null) {
                        og.i("Required value was null.");
                        return null;
                    }
                    if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                        og.n("Could not create the SONIC photo folder");
                        return null;
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", str2);
                contentValues.put("mime_type", "image/jpeg");
                contentValues.put(str4, str3);
                return contentValues;
            case 2:
                bz3.g(obj);
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    keyStore.load(null);
                    keyStore.deleteEntry("sonic_secret_store_v1");
                    return q43Var;
                } catch (IOException e) {
                    num = new Integer(Log.w("SecretStore", "Could not delete keystore entry", e));
                    return num;
                } catch (GeneralSecurityException e2) {
                    num = new Integer(Log.w("SecretStore", "Could not delete keystore entry", e2));
                    return num;
                }
            case 3:
                bz3.g(obj);
                x00 x00VarA = ui4.a();
                sn1 sn1Var = (sn1) obj2;
                sn1Var.d = x00VarA;
                int i2 = 0;
                TextToSpeech textToSpeech = new TextToSpeech(sn1Var.a, new on1(i2, x00VarA), "com.k2fsa.sherpa.onnx.tts.engine");
                sn1Var.c = textToSpeech;
                return new Integer(textToSpeech.setOnUtteranceProgressListener(new pn1(i2, sn1Var)));
            case 4:
                bz3.g(obj);
                sx1 sx1Var = (sx1) obj2;
                Context context = sx1Var.b;
                hf2 hf2Var = sx1Var.c;
                TextClassificationManager textClassificationManager = (TextClassificationManager) context.getSystemService(TextClassificationManager.class);
                int iOrdinal = hf2Var.ordinal();
                if (iOrdinal == 0) {
                    str = "edittext";
                } else {
                    if (iOrdinal != 1) {
                        dk0.l();
                        return null;
                    }
                    str = "textview";
                }
                zw2.f();
                TextClassifier textClassifierCreateTextClassificationSession = textClassificationManager.createTextClassificationSession(zw2.c(context.getPackageName(), str).build());
                sx1Var.f = textClassifierCreateTextClassificationSession;
                return textClassifierCreateTextClassificationSession;
            default:
                bz3.g(obj);
                oj2 oj2Var = (oj2) obj2;
                oj2Var.j();
                oj2.g(oj2Var);
                return q43Var;
        }
    }
}
