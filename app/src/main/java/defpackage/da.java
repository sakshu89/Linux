package defpackage;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class da extends Handler {
    public static final da a = new da();

    @Override // java.util.logging.Handler
    public final void publish(LogRecord logRecord) {
        int i;
        int iMin;
        logRecord.getClass();
        CopyOnWriteArraySet copyOnWriteArraySet = ca.a;
        String loggerName = logRecord.getLoggerName();
        loggerName.getClass();
        int iIntValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        if (iIntValue > level.intValue()) {
            i = 5;
        } else {
            i = logRecord.getLevel().intValue() == level.intValue() ? 4 : 3;
        }
        String message = logRecord.getMessage();
        message.getClass();
        Throwable thrown = logRecord.getThrown();
        String strT = (String) ca.b.get(loggerName);
        if (strT == null) {
            strT = cs2.T(23, loggerName);
        }
        if (Log.isLoggable(strT, i)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i2 = 0;
            while (i2 < length) {
                int iX = cs2.x(message, '\n', i2, 4);
                if (iX == -1) {
                    iX = length;
                }
                while (true) {
                    iMin = Math.min(iX, i2 + 4000);
                    Log.println(i, strT, message.substring(i2, iMin));
                    if (iMin >= iX) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }
}
