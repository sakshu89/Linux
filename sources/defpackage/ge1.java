package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ge1 {
    public static final x42 a;
    public static final Set b;
    public static final x42 c;
    public static final x42 d;
    public static final x42 e;
    public static final x42 f;
    public static final x42 g;
    public static final x42 h;
    public static final x42 i;

    static {
        y42 y42Var = y42.IGNORE_CASE;
        a = new x42("whats\\s*app|व्हाट्स|व्हॉट्स|वॉट्स|वाट्स|واٹس|વોટ્સએપ|વ્હોટ્સએપ|વોટ્સઅપ|ਵਟਸਐਪ|ਵਟਸਐੱਪ|ਵਾਟਸਐਪ|হোয়াটসঅ্যাপ|হোয়াটসঅ্যাপ|হোয়াটসাপ|হোয়াটসাপ|వాట్సాప్|వాట్సప్|வாட்ஸ்அப்|வாட்ஸ்\\s*அப்|வாட்ஸ்ஆப்|ವಾಟ್ಸಾಪ್|ವಾಟ್ಸ್ಯಾಪ್|ವಾಟ್ಸಪ್|വാട്സ്ആപ്പ|വാട്ട്സാപ്പ|വാട്ട്സ്ആപ്പ|വാട്സാപ്പ", y42Var);
        b = wh2.c(new w3("app.open"), new w3("message.draft"), new w3("message.whatsapp.draft"), new w3("message.whatsapp.send"), new w3("call.contact"), new w3("call.number"), new w3("time.alarm.set"), new w3("time.timer.set"), new w3("youtube.play"), new w3("youtube.search"), new w3("web.search"), new w3("web.open"), new w3("youtube.like"), new w3("youtube.dislike"), new w3("youtube.subscribe"), new w3("youtube.skip_ad"), new w3("youtube.mini_player.close"), new w3("screen.read"), new w3("screen.deep_analyze"), new w3("screen.click"), new w3("screen.type"), new w3("screen.scroll"), new w3("screen.swipe"), new w3("screen.back"), new w3("media.pause"), new w3("media.resume"), new w3("media.next"), new w3("media.previous"), new w3("device.flashlight.on"), new w3("device.flashlight.off"), new w3("device.battery.status"), new w3("device.volume.set"), new w3("device.brightness.set"), new w3("device.volume.up"), new w3("device.volume.down"), new w3("device.volume.mute"), new w3("device.screenshot"), new w3("device.lock"), new w3("camera.photo"), new w3("camera.video"), new w3("camera.video.stop"), new w3("device.wifi.enable"), new w3("device.wifi.disable"), new w3("device.wifi.toggle"), new w3("device.bluetooth.enable"), new w3("device.bluetooth.disable"), new w3("device.bluetooth.toggle"), new w3("media.play.provider"), new w3("screen.home"), new w3("meta.cancel"), new w3("assistant.wake_up"), new w3("meta.shutdown"));
        c = new x42("\\b(?:subscribe|subscribe\\s+to|click\\s+subscribe|channel\\s+ko\\s+subscribe|सब्सक्राइब)\\b", y42Var);
        d = new x42("\\b(?:take\\s+(?:a\\s+)?screenshot|screenshot|screen\\s*shot|स्क्रीनशॉट)\\b", y42Var);
        e = new x42("\\b(?:lock\\s+(?:the\\s+)?(?:screen|phone|device)|lock\\s+screen|स्क्रीन\\s*लॉक|फोन\\s*लॉक)\\b", y42Var);
        f = new x42("\\b(?:volume\\ if|volume\\ up|turn\\ up\\ (?:the\\ )?volume|increase\\ (?:the\\ )?volume|louder|आवाज़\\ बढ़ाओ)\\b", y42Var);
        g = new x42("\\b(?:volume\\ down|turn\\ down\\ (?:the\\ )?volume|decrease\\ (?:the\\ )?volume|quieter|lower\\ (?:the\\ )?volume|आवाज़\\ कम\\ करो)\\b", y42Var);
        h = new x42("\\b(?:mute\\ (?:the\\ )?volume|mute\\ (?:the\\ )?phone|mute|silence\\ (?:the\\ )?phone|म्यूट)\\b", y42Var);
        i = new x42("\\b(?:set\\ (?:the\\ )?volume\\ to|volume\\ (?:to\\ )?)\\s*(\\d{1,3})%?\\b", y42Var);
    }
}
