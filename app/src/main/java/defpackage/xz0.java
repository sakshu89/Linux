package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xz0 {
    public static final x42 a;
    public static final x42 b;
    public static final x42 c;
    public static final x42 d;
    public static final x42 e;
    public static final x42 f;
    public static final x42 g;
    public static final x42 h;
    public static final x42 i;
    public static final x42 j;
    public static final x42 k;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        a = new x42("^(?:(?:hey|ok|sonic|sonik|please|सोनिक|कृपया|जरा|ज़रा|मुझे)\\s+)+", y42Var);
        b = new x42("(?:spotify|स्पॉटिफाई|स्पॉटिफ़ाई|स्पॉटीफाई|स्पोटिफाई)", y42Var);
        c = new x42("(?:^|\\s)(?:मत|नहीं|नको|mat|nahi|nahin|nako)(?:\\s|$)", y42Var);
        d = new x42("\"[^\"]*\"|“[^”]*”|'[^']*'");
        e = new x42("^(?:spotify|स्पॉटिफाई|स्पॉटिफ़ाई|स्पॉटीफाई|स्पोटिफाई)\\s+(?:par|pe|mein|me|var|madhye|पर|पे|में|वर|मध्ये)\\s+(.+?)\\s+(?:(?:gaana|gana|song|track|गाना|गीत|गाणे|गाणं)\\s+)?(?:chalao|bajao|chala(?:\\s+do)?|baja(?:\\s+do)?|play\\s+karo|चलाओ|बजाओ|चला(?:\\s+दो)?|बजा(?:\\s+दो)?|लगा\\s+दो|वाजव(?:ा)?|लाव(?:ा)?)$", y42Var);
        f = new x42("^(.+?)\\s+(?:(?:gaana|gana|song|track|गाना|गीत|गाणे|गाणं)\\s+)?(?:spotify|स्पॉटिफाई|स्पॉटिफ़ाई|स्पॉटीफाई|स्पोटिफाई)\\s+(?:par|pe|mein|me|var|madhye|पर|पे|में|वर|मध्ये)\\s+(?:chalao|bajao|chala(?:\\s+do)?|baja(?:\\s+do)?|play\\s+karo|चलाओ|बजाओ|चला(?:\\s+दो)?|बजा(?:\\s+दो)?|लगा\\s+दो|वाजव(?:ा)?|लाव(?:ा)?)$", y42Var);
        g = new x42("^(?:spotify|स्पॉटिफाई|स्पॉटिफ़ाई|स्पॉटीफाई|स्पोटिफाई)\\s+(?:par|pe|mein|me|var|madhye|पर|पे|में|वर|मध्ये)\\s+(.+?)\\s+(?:(?:gaana|gana|song|track|गाना|गीत|गाणे|गाणं)\\s+)?(?:dhundo|dhoondo|khojo|search\\s+karo|खोजो|ढूंढो|ढूँढो|शोध(?:ा)?)$", y42Var);
        h = new x42("^(.+?)\\s+(?:(?:gaana|gana|song|track|गाना|गीत|गाणे|गाणं)\\s+)?(?:spotify|स्पॉटिफाई|स्पॉटिफ़ाई|स्पॉटीफाई|स्पोटिफाई)\\s+(?:par|pe|mein|me|var|madhye|पर|पे|में|वर|मध्ये)\\s+(?:dhundo|dhoondo|khojo|search\\s+karo|खोजो|ढूंढो|ढूँढो|शोध(?:ा)?)$", y42Var);
        i = new x42("^(?:(?:spotify|स्पॉटिफाई|स्पॉटिफ़ाई|स्पॉटीफाई|स्पोटिफाई)\\s+(?:par|pe|mein|me|var|madhye|पर|पे|में|वर|मध्ये)\\s+)?(पहला|पहले|पहली|दूसरा|दूसरे|दूसरी|तीसरा|तीसरे|तीसरी|चौथा|चौथे|चौथी|पहिलं|पहिले|दुसरं|दुसरे|तिसरं|तिसरे|pehla|pahla|doosra|dusra|teesra|tisra|chautha)(?:\\s+(?:gaana|gana|song|track|गाना|गीत|गाणे|गाणं))?(?:\\s+(?:chalao|bajao|chala(?:\\s+do)?|baja(?:\\s+do)?|play\\s+karo|चलाओ|बजाओ|चला(?:\\s+दो)?|बजा(?:\\s+दो)?|लगा\\s+दो|वाजव(?:ा)?|लाव(?:ा)?))?$", y42Var);
        j = new x42("^(?:spotify|स्पॉटिफाई|स्पॉटिफ़ाई|स्पॉटीफाई|स्पोटिफाई)\\s+(?:par|pe|mein|me|var|madhye|पर|पे|में|वर|मध्ये)\\s+(?:(?:gaana|gana|song|track|गाना|गीत|गाणे|गाणं)\\s+)?(?:roko|pause\\s+karo|रोको|रोक\\s+दो|थांबव(?:ा)?)$", y42Var);
        k = new x42("^(?:spotify|स्पॉटिफाई|स्पॉटिफ़ाई|स्पॉटीफाई|स्पोटिफाई)\\s+(?:par|pe|mein|me|var|madhye|पर|पे|में|वर|मध्ये)\\s+(?:(?:gaana|gana|song|track|गाना|गीत|गाणे|गाणं)\\s+)?(?:resume\\s+karo|फिर\\s+चलाओ|पुन्हा\\s+वाजव(?:ा)?)$", y42Var);
    }
}
