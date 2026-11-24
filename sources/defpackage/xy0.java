package defpackage;

import android.util.Size;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface xy0 extends x22 {
    public static final bi A;
    public static final bi B;
    public static final bi C;
    public static final bi D;
    public static final bi E;
    public static final bi F;
    public static final bi G;
    public static final bi I;
    public static final bi J;
    public static final bi z = new bi("camerax.core.imageOutput.targetAspectRatio", sg.class, null);

    static {
        Class cls = Integer.TYPE;
        A = new bi("camerax.core.imageOutput.targetRotation", cls, null);
        B = new bi("camerax.core.imageOutput.appTargetRotation", cls, null);
        C = new bi("camerax.core.imageOutput.mirrorMode", cls, null);
        D = new bi("camerax.core.imageOutput.targetResolution", Size.class, null);
        E = new bi("camerax.core.imageOutput.defaultResolution", Size.class, null);
        F = new bi("camerax.core.imageOutput.maxResolution", Size.class, null);
        G = new bi("camerax.core.imageOutput.supportedResolutions", List.class, null);
        I = new bi("camerax.core.imageOutput.resolutionSelector", l62.class, null);
        J = new bi("camerax.core.imageOutput.customOrderedResolutions", List.class, null);
    }

    static void s(xy0 xy0Var) {
        boolean zA = xy0Var.a(z);
        boolean z2 = ((Size) xy0Var.d(D, null)) != null;
        if (zA && z2) {
            og.i("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        } else if (((l62) xy0Var.d(I, null)) != null) {
            if (zA || z2) {
                og.i("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
            }
        }
    }

    default int i() {
        return ((Integer) d(A, 0)).intValue();
    }
}
