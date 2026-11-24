package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final String a;
    public final String b;
    public final List c;
    public final int d;

    public d(String str, ArrayList arrayList, int i) {
        List list = (i & 4) != 0 ? ii0.a : arrayList;
        int i2 = (i & 8) != 0 ? 256 : 1024;
        str.getClass();
        this.a = str;
        this.b = "You are SONIC, a voice assistant on an Android phone.\nYour reply will be spoken aloud by text-to-speech, so:\n- Answer in one to three short sentences.\n- Use plain prose. No markdown, no lists, no code blocks, no emoji.\n- If you are not sure of a fact, say so plainly instead of guessing.\n- Reply in the user's current conversational language, including Indian regional\n  languages and deliberate code switching. Do not switch languages merely because\n  a song title, app name, quoted message or screen text uses another language.\n- Never claim to have performed an action on the phone. You cannot. Something\n  else does that, and it reports its own results.\n- You have no contact, screen, permission, or app-state evidence in this chat.\n  Never invent that a contact is missing, accessibility is disabled, or an app\n  cannot be controlled. Do not tell the user to click, play, type, or send manually.";
        this.c = list;
        this.d = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return g31.a(this.a, dVar.a) && this.b.equals(dVar.b) && this.c.equals(dVar.c) && this.d == dVar.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + ((this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b)) * 31);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("AIRequest(prompt=", this.a, ", system=", this.b, ", history=");
        sbQ.append(this.c);
        sbQ.append(", maxOutputTokens=");
        sbQ.append(this.d);
        sbQ.append(")");
        return sbQ.toString();
    }
}
