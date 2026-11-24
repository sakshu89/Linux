package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.g73;
import defpackage.h73;
import defpackage.i73;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(g73 g73Var) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        i73 i73VarG = remoteActionCompat.a;
        boolean z = true;
        if (g73Var.e(1)) {
            i73VarG = g73Var.g();
        }
        remoteActionCompat.a = (IconCompat) i73VarG;
        CharSequence charSequence = remoteActionCompat.b;
        if (g73Var.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((h73) g73Var).e);
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (g73Var.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((h73) g73Var).e);
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.d = (PendingIntent) g73Var.f(remoteActionCompat.d, 4);
        boolean z2 = remoteActionCompat.e;
        if (g73Var.e(5)) {
            z2 = ((h73) g73Var).e.readInt() != 0;
        }
        remoteActionCompat.e = z2;
        boolean z3 = remoteActionCompat.f;
        if (!g73Var.e(6)) {
            z = z3;
        } else if (((h73) g73Var).e.readInt() == 0) {
            z = false;
        }
        remoteActionCompat.f = z;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, g73 g73Var) {
        g73Var.getClass();
        IconCompat iconCompat = remoteActionCompat.a;
        g73Var.h(1);
        g73Var.i(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        g73Var.h(2);
        Parcel parcel = ((h73) g73Var).e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.c;
        g73Var.h(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.d;
        g73Var.h(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z = remoteActionCompat.e;
        g73Var.h(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f;
        g73Var.h(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
