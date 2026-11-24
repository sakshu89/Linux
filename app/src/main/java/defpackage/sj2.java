package defpackage;

import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sj2 extends b83 {
    public static final List h = nz.i(new i92("android.permission.RECORD_AUDIO", "Hear you", "Lets SONIC listen after you tap its orb. While SONIC is on, Live mode streams microphone audio to Google Gemini, including when another app is on screen. Say 'wake up Sonic' to return to its dashboard. Local mode uses your phone's speech service.", false), new i92("android.permission.READ_CONTACTS", "Know who Mum is", "Lets \"call Mum\" find the number on your phone. In cloud conversations, names or numbers mentioned in a request or action result may be sent to Gemini. SONIC does not upload your entire address book.", false), new i92("android.permission.CALL_PHONE", "Place the call itself", "Without this SONIC can only open the dialler with the number typed in, and you press the green button.", false), new i92("android.permission.POST_NOTIFICATIONS", "Show what it's doing", "Used for the listening notification, which is also how you stop it.", false));
    public static final List i = nz.i(new op2(np2.b, "Read notifications and see what's playing", "Also how SONIC checks a song actually started, instead of assuming it did.", false, true), new op2(np2.f, "Glow at the edge of the screen", "Lets SONIC light the screen edge while listening, even when another app is in front, so you can always tell the mic is open.", false, true), new op2(np2.c, "Control and read the screen", "Lets SONIC read, tap and type for requested actions, lock the phone and take screenshots. Screen interaction also needs Read the screen enabled in SONIC. Deep Analyze sends the current screenshot to Gemini when cloud AI is enabled.", false, true), new op2(np2.a, "Change screen brightness", "The only way an app can change system brightness.", false, true));
    public final Context b;
    public final zv1 c;
    public final j5 d;
    public final co2 e;
    public final jr2 f;
    public final jr2 g;

    public sj2(Context context, zv1 zv1Var, j5 j5Var, co2 co2Var) {
        zv1Var.getClass();
        j5Var.getClass();
        co2Var.getClass();
        this.b = context;
        this.c = zv1Var;
        this.d = j5Var;
        this.e = co2Var;
        l61 l61Var = l61.e;
        ii0 ii0Var = ii0.a;
        this.f = o54.a(new qj2(ii0Var, ii0Var, false, false, false, l61Var));
        this.g = o54.a(null);
        uf4.b(gb4.c(this), null, new rj2(this, null, 0), 3);
        e();
    }

    public final void e() {
        zv1 zv1Var;
        jr2 jr2Var;
        Object value;
        qj2 qj2Var;
        ArrayList arrayList;
        boolean z;
        RoleManager roleManagerD;
        List list = h;
        ArrayList arrayList2 = new ArrayList(nz.d(list));
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            zv1Var = this.c;
            boolean zC = true;
            if (!zHasNext) {
                break;
            }
            i92 i92Var = (i92) it.next();
            String str = i92Var.a;
            if (!str.equals("android.permission.POST_NOTIFICATIONS")) {
                zC = zv1Var.c(str);
            } else if (Build.VERSION.SDK_INT < 33) {
                zv1Var.getClass();
            } else {
                zC = zv1Var.c("android.permission.POST_NOTIFICATIONS");
            }
            arrayList2.add(new i92(i92Var.a, i92Var.b, i92Var.c, zC));
        }
        int i2 = Build.VERSION.SDK_INT;
        Context context = this.b;
        boolean z2 = i2 >= 29 && (roleManagerD = bv0.d(context.getSystemService(bv0.h()))) != null && roleManagerD.isRoleHeld("android.app.role.ASSISTANT");
        String string = Settings.Secure.getString(context.getContentResolver(), "assistant");
        ComponentName componentNameUnflattenFromString = string != null ? ComponentName.unflattenFromString(string) : null;
        boolean z3 = z2 || g31.a(componentNameUnflattenFromString != null ? componentNameUnflattenFromString.getPackageName() : null, context.getPackageName());
        do {
            jr2Var = this.f;
            value = jr2Var.getValue();
            qj2Var = (qj2) value;
            List<op2> list2 = i;
            arrayList = new ArrayList(nz.d(list2));
            for (op2 op2Var : list2) {
                boolean zB = zv1Var.b(op2Var.a);
                np2 np2Var = op2Var.a;
                String str2 = op2Var.b;
                String str3 = op2Var.c;
                boolean z4 = op2Var.e;
                np2Var.getClass();
                str2.getClass();
                str3.getClass();
                arrayList.add(new op2(np2Var, str2, str3, zB, z4));
            }
            if (arrayList2.isEmpty()) {
                z = true;
                break;
            }
            int size = arrayList2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = true;
                    break;
                }
                Object obj = arrayList2.get(i3);
                i3++;
                if (!((i92) obj).d) {
                    z = false;
                    break;
                }
            }
        } while (!jr2Var.h(value, qj2.a(qj2Var, arrayList2, arrayList, z3, z, false, null, 48)));
    }
}
