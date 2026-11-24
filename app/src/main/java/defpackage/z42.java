package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class z42 {
    public static final x42 a;
    public static final x42 b;
    public static final ArrayList c;
    public static final ArrayList d;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        a = new x42("^(?:(?:hey\\s+)?(?:sonic|सोनिक|सॉनिक|सोनीक)[,\\s:]+|(?:please|कृपया|जरा|ज़रा|प्लीज)\\s+|(?:एक\\s+काम\\s+करो?|ek\\s+kaam\\s+kar(?:o)?)\\s+)+", y42Var);
        b = new x42("(?:^|\\s)(?:मत|नहीं|नको|नका|नाही|न|don't|dont|do not|not)(?:\\s|$)", y42Var);
        List listI = nz.i("^(.+?)\\s*(?:को|ला)\\s+(?:कॉल|कौल|फोन|call|phone)\\s*(?:करो|करें|करिए|कर|करा|लगा(?:ओ)?|मिलाओ|karo|kar|kara)(?:\\s+(?:दो|देना|do))?$", "^(?:कॉल|फोन)\\s+(?:करो|कर|करिए|कीजिए|लगाओ)\\s+(.+?)(?:\\s+को)?$", "^(?:कॉल|फोन)\\s+(.+?)\\s+को$", "^(.+?)ને\\s+(?:કૉલ|કોલ|ફોન)\\s+કર(?:ો)?$", "^(.+?)\\s+ਨੂੰ\\s+(?:ਕਾਲ|ਫੋਨ)\\s+ਕਰ(?:ੋ)?$", "^(.+?)কে\\s+(?:কল|ফোন)\\s+কর(?:ো|ুন)?$", "^(.+?)(?:కు|కి)\\s+(?:కాల్|ఫోన్)\\s+చెయ్(?:యి|యండి)?$", "^(.+?)(?:க்கு|கிற்கு)\\s+(?:கால்|போன்)\\s+(?:செய்|பண்ணு)(?:ங்கள்)?$", "^(.+?)(?:ಗೆ|ನಿಗೆ)\\s+(?:ಕಾಲ್|ಫೋನ್)\\s+ಮಾಡು(?:ವಿರಾ)?$", "^(.+?)(?:യ്ക്ക്|ക്ക്)\\s+(?:കോൾ|ഫോൺ)\\s+ചെയ്യൂ$");
        ArrayList arrayList = new ArrayList(nz.d(listI));
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            arrayList.add(new x42((String) it.next(), y42Var));
        }
        c = arrayList;
        List listI2 = nz.i("^(.+?)ને\\s+(?:વોટ્સએપ|વ્હોટ્સએપ|WhatsApp)\\s*(?:પર|માં)\\s+(.+?)\\s+(?:મેસેજ\\s+)?મોકલો$", "^(.+?)\\s+ਨੂੰ\\s+(?:ਵਟਸਐਪ|ਵਟਸਐੱਪ|WhatsApp)\\s*(?:ਤੇ|ਵਿੱਚ)\\s+(.+?)\\s+(?:ਮੈਸੇਜ\\s+)?ਭੇਜੋ$", "^(.+?)কে\\s+(?:হোয়াটসঅ্যাপ|হোয়াটসঅ্যাপে|WhatsApp)\\s*(?:এ|তে)?\\s+(.+?)\\s+(?:মেসেজ\\s+)?পাঠাও$", "^(.+?)(?:కు|కి)\\s+(?:వాట్సాప్|వాట్సాప్\u200cలో|WhatsApp)\\s*(?:లో)?\\s+(.+?)\\s+(?:మెసేజ్\\s+)?పంపు$", "^(.+?)(?:க்கு|கிற்கு)\\s+(?:வாட்ஸ்அப்|வாட்ஸ்அப்பில்|WhatsApp)\\s*(?:இல்)?\\s+(.+?)\\s+(?:மெசேஜ்\\s+)?அனுப்பு$", "^(.+?)(?:ಗೆ|ನಿಗೆ)\\s+(?:ವಾಟ್ಸಾಪ್|ವಾಟ್ಸಾಪ್\u200cನಲ್ಲಿ|WhatsApp)\\s*(?:ನಲ್ಲಿ)?\\s+(.+?)\\s+(?:ಮೆಸೇಜ್\\s+)?ಕಳುಹಿಸು$", "^(.+?)(?:യ്ക്ക്|ക്ക്)\\s+(?:വാട്സ്ആപ്പ്|വാട്സ്ആപ്പിൽ|WhatsApp)\\s*(?:ഇൽ)?\\s+(.+?)\\s+(?:മെസേജ്\\s+)?അയക്കൂ$");
        ArrayList arrayList2 = new ArrayList(nz.d(listI2));
        Iterator it2 = listI2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new x42((String) it2.next(), y42Var));
        }
        d = arrayList2;
    }

    public static boolean a(String str) {
        List listH;
        if (!cs2.A(str)) {
            Pattern patternCompile = Pattern.compile("\\s+");
            patternCompile.getClass();
            cs2.L(0);
            Matcher matcher = patternCompile.matcher(str);
            if (matcher.find()) {
                ArrayList arrayList = new ArrayList(10);
                int iEnd = 0;
                do {
                    arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
                    iEnd = matcher.end();
                } while (matcher.find());
                arrayList.add(str.subSequence(iEnd, str.length()).toString());
                listH = arrayList;
            } else {
                listH = nz.h(str.toString());
            }
            if (listH.size() <= 6 && !b.a(str)) {
                return true;
            }
        }
        return false;
    }
}
