package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fl {
    public final Context a;

    public fl(Context context) {
        this.a = context;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0056  */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:22:0x005e  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c0  */
    public final gl a() {
        Integer numValueOf;
        int i;
        int iIntValue;
        int intExtra;
        cz1 cz1Var;
        Float fValueOf;
        Context context = this.a;
        BatteryManager batteryManager = (BatteryManager) context.getSystemService(BatteryManager.class);
        PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
        String str = null;
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (batteryManager != null) {
            int intProperty = batteryManager.getIntProperty(4);
            Integer numValueOf2 = Integer.valueOf(intProperty);
            if (intProperty < 0 || intProperty >= 101) {
                numValueOf2 = null;
            }
            if (numValueOf2 != null) {
                iIntValue = numValueOf2.intValue();
            } else {
                if (intentRegisterReceiver != null) {
                    intExtra = intentRegisterReceiver.getIntExtra("level", -1);
                    int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
                    if (intExtra >= 0 || intExtra2 <= 0) {
                        numValueOf = null;
                    } else {
                        numValueOf = Integer.valueOf((intExtra * 100) / intExtra2);
                    }
                } else {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    iIntValue = numValueOf.intValue();
                } else {
                    i = 0;
                }
            }
            i = iIntValue;
        } else {
            if (intentRegisterReceiver != null) {
                intExtra = intentRegisterReceiver.getIntExtra("level", -1);
                int intExtra3 = intentRegisterReceiver.getIntExtra("scale", -1);
                if (intExtra >= 0) {
                    numValueOf = null;
                } else {
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
                i = iIntValue;
            } else {
                i = 0;
            }
        }
        int intExtra4 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        int intExtra5 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("plugged", 0) : 0;
        boolean z2 = intExtra4 == 2 || intExtra4 == 5 || intExtra5 != 0;
        if (intExtra5 == 0) {
            cz1Var = cz1.a;
        } else if (intExtra5 == 1) {
            cz1Var = cz1.b;
        } else if (intExtra5 == 2) {
            cz1Var = cz1.c;
        } else if (intExtra5 != 4) {
            cz1Var = intExtra5 != 8 ? cz1.i : cz1.f;
        } else {
            cz1Var = cz1.e;
        }
        if (intentRegisterReceiver != null) {
            int intExtra6 = intentRegisterReceiver.getIntExtra("temperature", Integer.MIN_VALUE);
            Integer numValueOf3 = Integer.valueOf(intExtra6);
            if (intExtra6 == Integer.MIN_VALUE) {
                numValueOf3 = null;
            }
            if (numValueOf3 != null) {
                fValueOf = Float.valueOf(numValueOf3.intValue() / 10.0f);
            } else {
                fValueOf = null;
            }
        } else {
            fValueOf = null;
        }
        if (powerManager != null && powerManager.isPowerSaveMode()) {
            z = true;
        }
        if (intentRegisterReceiver != null) {
            int intExtra7 = intentRegisterReceiver.getIntExtra("health", -1);
            if (intExtra7 == 2) {
                str = "good";
            } else if (intExtra7 == 3) {
                str = "overheat";
            } else if (intExtra7 == 4) {
                str = "dead";
            } else if (intExtra7 == 5) {
                str = "over voltage";
            } else if (intExtra7 == 7) {
                str = "cold";
            }
        }
        return new gl(i, z2, cz1Var, fValueOf, z, str);
    }
}
