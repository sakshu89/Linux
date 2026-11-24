package defpackage;

import com.ibm.icu.text.BreakIterator;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eu implements o21 {
    public static final x42 a = new x42("^(?:stop|end|finish)\\s+(?:the\\s+)?(?:(?:camera|video)\\s+)?recording(?:\\s+(?:the\\s+)?video)?(?:\\s+now)?$");
    public static final x42 b = new x42("\\b(?:stop|end|finish)\\b.*\\brecording\\b");
    public static final x42 c = new x42("^(?:(?:open|launch|start|switch\\s+to)\\s+(?:the\\s+|my\\s+)?)?(?:(?:front|rear|back|main|selfie)(?:\\s+facing)?\\s+)?camera(?:\\s+app)?(?:\\s+(?:open|(?:turn\\s+)?on))?$");
    public static final x42 d = new x42("^(?:take|click|shoot|capture|snap)\\s+(?:(?:a|the|my|one|1)\\s+)?(?:photo|picture|pic|selfie|snap|shot)(?:\\s+(?:with|using|on|from|of)\\s+.+)?$|^(?:(?:मेरी|मेरा|एक)\\s+)?(?:photo|picture|pic|selfie)(?:\\s+(?:खींचो|खींच|खिंचो|लो|ले लो|kheecho|khincho|lelo|le lo))?$");
    public static final x42 e = new x42("\\bselfie\\b");
    public static final x42 f = new x42("^(?:record|shoot|start recording)\\s+(?:(?:a|the|my|one|1)\\s+)?video(?:\\s+(?:with|using|on|from|of)\\s+.+)?$|^video\\s+record$");
    public static final x42 g = new x42("^(?:(?:open|show|launch)\\s+(?:me\\s+)?(?:the\\s+|my\\s+)?)?(?:gallery|photo album|my photos|photos app|image gallery|photos)$");
    public static final x42 h = new x42("\\b(front|selfie)\\s*(?:facing\\s*)?camera\\b|\\bfront camera\\b");
    public static final x42 i = new x42("\\b(back|rear|main)\\s*(?:facing\\s*)?camera\\b");

    public static Map d(String str) {
        if (h.a(str)) {
            Map mapSingletonMap = Collections.singletonMap("camera_facing", "front");
            mapSingletonMap.getClass();
            return mapSingletonMap;
        }
        if (!i.a(str)) {
            return ji0.a;
        }
        Map mapSingletonMap2 = Collections.singletonMap("camera_facing", "rear");
        mapSingletonMap2.getClass();
        return mapSingletonMap2;
    }

    @Override // defpackage.o21
    public final int a() {
        return BreakIterator.WORD_IDEO_LIMIT;
    }

    @Override // defpackage.o21
    public final String b() {
        return "camera";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        Map mapD;
        i60Var.getClass();
        String strB = dp4.b(b63Var.c);
        if (a.e(strB)) {
            return dp4.d(b63Var, "camera.video.stop", null, 0.99f, 10);
        }
        if (!b.a(strB)) {
            if (g.e(strB)) {
                return dp4.d(b63Var, "gallery.open", null, 0.99f, 10);
            }
            if (f.e(strB)) {
                return dp4.d(b63Var, "camera.video", d(strB), 0.99f, 8);
            }
            if (d.e(strB)) {
                if (e.a(strB)) {
                    mapD = Collections.singletonMap("camera_facing", "front");
                    mapD.getClass();
                } else {
                    mapD = d(strB);
                }
                return dp4.d(b63Var, "camera.photo", mapD, 0.99f, 8);
            }
            if (c.e(strB)) {
                return dp4.d(b63Var, "camera.open", d(strB), 0.99f, 8);
            }
        }
        return null;
    }
}
