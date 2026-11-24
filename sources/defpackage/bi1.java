package defpackage;

import com.ibm.icu.text.BreakIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bi1 implements o21 {
    public static final x42 a = new x42("^(?:(?:click|tap|press|select|choose)\\s+(?:on\\s+)?(?:the\\s+)?)?skip(?:\\s+(?:(?:the|this)\\s+)?(?:ad|ads|advertisement))?(?:\\s+button)?(?:\\s+on\\s+youtube)?$");
    public static final x42 b = new x42("\\b(whats playing|what is playing|what song is this|whats this song|what is this song|name this song|which song is this|identify this song)\\b");
    public static final x42 c;
    public static final x42 d;
    public static final x42 e;
    public static final x42 f;
    public static final x42 g;
    public static final Set h;
    public static final x42 i;
    public static final x42 j;
    public static final Set k;
    public static final LinkedHashMap l;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        c = new x42("^(?:close|cancel|dismiss)\\s+(?:(?:the|this)\\s+)?(?:video|mini\\s*player|player)(?:\\s+on\\s+youtube)?$|^(?:close|dismiss)\\s+mini\\s*player$", y42Var);
        d = new x42("\\b(pause|hold on the music|freeze the music|pause video|pause the video|stop video|stop the video)\\b", y42Var);
        e = new x42("^(?:(?:play|go to|switch to)\\s+(?:the\\s+)?)?next(?:\\s+(?:song|track|video|one))?(?:\\s+on\\s+youtube)?$|^skip\\s+(?:(?:this|the)\\s+)?(?:song|track)$");
        f = new x42("^(?:(?:play|go to|switch to)\\s+(?:the\\s+)?)?previous(?:\\s+(?:song|track|video|one))?(?:\\s+on\\s+youtube)?$|^(?:last song|go back a (?:song|track))$");
        g = new x42("\\bstop\\b.*\\b(music|song|playback|playing|audio|video|track)\\b|\\b(music|song|playback|audio)\\b.*\\bstop\\b");
        h = wh2.c("resume", "continue", "unpause", "play", "keep playing", "resume the music", "continue the music", "resume playback", "play it", "carry on");
        i = new x42("^play\\s+(.+?)\\s+on\\s+(.+)$");
        j = new x42("^play\\s+(.+)$");
        k = wh2.c("it", "music", "something", "anything", "the music");
        wt1[] wt1VarArr = {new wt1("youtube music", "youtube_music"), new wt1("yt music", "youtube_music"), new wt1("youtube", "youtube"), new wt1("spotify", "spotify"), new wt1("jiosaavn", "jiosaavn"), new wt1("jio saavn", "jiosaavn"), new wt1("saavn", "jiosaavn"), new wt1("gaana", "gaana"), new wt1("wynk", "wynk"), new wt1("amazon music", "amazon_music"), new wt1("apple music", "apple_music"), new wt1("soundcloud", "soundcloud"), new wt1("resso", "resso")};
        LinkedHashMap linkedHashMap = new LinkedHashMap(bh1.b(13));
        bh1.f(linkedHashMap, wt1VarArr);
        l = linkedHashMap;
    }

    public static Map d(String str) {
        Pattern patternCompile = Pattern.compile("\\b(?:video|youtube)\\b");
        patternCompile.getClass();
        str.getClass();
        if (!patternCompile.matcher(str).find()) {
            return ji0.a;
        }
        Map mapSingletonMap = Collections.singletonMap("provider_app", "youtube");
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }

    @Override // defpackage.o21
    public final int a() {
        return BreakIterator.WORD_IDEO_LIMIT;
    }

    @Override // defpackage.o21
    public final String b() {
        return "media";
    }

    @Override // defpackage.o21
    public final f5 c(b63 b63Var, i60 i60Var) {
        i60Var.getClass();
        String str = b63Var.c;
        f5 f5VarA = fr4.a(b63Var);
        if (f5VarA != null) {
            return f5VarA;
        }
        Pattern patternCompile = Pattern.compile("^(?:play|open)\\s+(?:the\\s+)?(?:first|second|third|fourth|fifth|[1-9])\\s+(?:youtube\\s+)?(?:video|result)(?:\\s+on\\s+youtube)?$");
        patternCompile.getClass();
        str.getClass();
        if (!patternCompile.matcher(str).matches()) {
            if (b.a(str)) {
                return dp4.d(b63Var, "media.identify", null, 0.99f, 10);
            }
            if (c.a(str)) {
                return dp4.d(b63Var, "youtube.mini_player.close", null, 0.99f, 10);
            }
            if (d.a(str)) {
                return dp4.d(b63Var, "media.pause", null, 0.99f, 10);
            }
            if (e.a(str)) {
                return dp4.d(b63Var, "media.next", d(str), 0.99f, 8);
            }
            if (f.a(str)) {
                return dp4.d(b63Var, "media.previous", d(str), 0.99f, 8);
            }
            if (g.a(str)) {
                return dp4.d(b63Var, "media.stop", null, 0.99f, 10);
            }
            if (h.contains(str)) {
                return dp4.d(b63Var, "media.resume", null, 0.99f, 10);
            }
            fh1 fh1VarA = b63Var.a(i);
            if (fh1VarA != null) {
                String strB = dp4.b((String) ((dh1) fh1VarA.a()).get(1));
                String string = cs2.V((String) ((dh1) fh1VarA.a()).get(2)).toString();
                String str2 = (String) l.get(string);
                if (str2 != null) {
                    string = str2;
                }
                if (!cs2.A(strB)) {
                    if (!g31.a(string, "youtube")) {
                        return dp4.d(b63Var, "media.play.provider", bh1.c(new wt1("media_title", strB), new wt1("provider_app", string)), 0.9f, 8);
                    }
                    Map mapSingletonMap = Collections.singletonMap("query", strB);
                    mapSingletonMap.getClass();
                    return dp4.d(b63Var, "youtube.play", mapSingletonMap, 0.9f, 8);
                }
            }
            fh1 fh1VarA2 = b63Var.a(j);
            if (fh1VarA2 != null) {
                String strB2 = dp4.b((String) ((dh1) fh1VarA2.a()).get(1));
                if (!cs2.A(strB2)) {
                    Set set = k;
                    if (!(set instanceof Collection) || !set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            if (strB2.equals((String) it.next())) {
                            }
                        }
                    }
                    Map mapSingletonMap2 = Collections.singletonMap("media_title", strB2);
                    mapSingletonMap2.getClass();
                    return dp4.d(b63Var, "media.play", mapSingletonMap2, 0.9f, 8);
                }
            }
        }
        return null;
    }
}
