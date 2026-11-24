package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.Size;
import android.view.Display;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import com.ibm.icu.lang.UCharacter;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nd0 {
    public static final Size e = new Size(1920, 1080);
    public static final Size f = new Size(UCharacter.UnicodeBlock.ZNAMENNY_MUSICAL_NOTATION_ID, 240);
    public static final Size g = new Size(640, 480);
    public static final Object h = new Object();
    public static volatile nd0 i;
    public final DisplayManager a;
    public volatile Size b = null;
    public final uf1 c = new uf1(29);
    public final uf1 d = new uf1(17);

    public nd0(Context context) {
        this.a = (DisplayManager) context.getSystemService("display");
    }

    public static nd0 b(Context context) {
        if (i == null) {
            synchronized (h) {
                try {
                    if (i == null) {
                        i = new nd0(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    public static Display d(Display[] displayArr, boolean z) {
        Display display = null;
        int i2 = -1;
        for (Display display2 : displayArr) {
            if (!z || display2.getState() != 1) {
                Point point = new Point();
                display2.getRealSize(point);
                int i3 = point.x * point.y;
                if (i3 > i2) {
                    display = display2;
                    i2 = i3;
                }
            }
        }
        return display;
    }

    public final Size a() {
        Size sizeB;
        Point point = new Point();
        c(false).getRealSize(point);
        Size size = new Size(point.x, point.y);
        Size size2 = al2.a;
        if (size.getHeight() * size.getWidth() < al2.a(f)) {
            size = ((SmallDisplaySizeQuirk) this.d.b) != null ? (Size) SmallDisplaySizeQuirk.a.get(Build.MODEL.toUpperCase(Locale.US)) : null;
            if (size == null) {
                size = g;
            }
        }
        if (size.getHeight() > size.getWidth()) {
            size = new Size(size.getHeight(), size.getWidth());
        }
        int height = size.getHeight() * size.getWidth();
        Size size3 = e;
        if (height > size3.getHeight() * size3.getWidth()) {
            size = size3;
        }
        if (((ExtraCroppingQuirk) this.c.b) != null && (sizeB = ExtraCroppingQuirk.b(1)) != null) {
            if (sizeB.getHeight() * sizeB.getWidth() > size.getHeight() * size.getWidth()) {
                return sizeB;
            }
        }
        return size;
    }

    public final Display c(boolean z) {
        Display[] displays = this.a.getDisplays();
        if (displays.length == 1) {
            return displays[0];
        }
        Display displayD = d(displays, z);
        if (displayD == null && z) {
            displayD = d(displays, false);
        }
        if (displayD != null) {
            return displayD;
        }
        og.i("No display can be found from the input display manager!");
        return null;
    }

    public final Size e() {
        if (this.b != null) {
            return this.b;
        }
        this.b = a();
        return this.b;
    }
}
