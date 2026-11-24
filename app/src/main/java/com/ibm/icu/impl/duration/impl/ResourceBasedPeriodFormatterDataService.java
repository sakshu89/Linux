package com.ibm.icu.impl.duration.impl;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.util.ICUUncheckedIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ResourceBasedPeriodFormatterDataService extends PeriodFormatterDataService {
    private static final String PATH = "data/";
    private static final ResourceBasedPeriodFormatterDataService singleton = new ResourceBasedPeriodFormatterDataService();
    private Collection<String> availableLocales;
    private PeriodFormatterData lastData = null;
    private String lastLocale = null;
    private Map<String, PeriodFormatterData> cache = new HashMap();

    private ResourceBasedPeriodFormatterDataService() {
        ArrayList arrayList = new ArrayList();
        InputStream requiredStream = ICUData.getRequiredStream(getClass(), "data/index.txt");
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requiredStream, "UTF-8"));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String strTrim = line.trim();
                    if (!strTrim.startsWith("#") && strTrim.length() != 0) {
                        arrayList.add(strTrim);
                    }
                    try {
                        requiredStream.close();
                    } catch (IOException unused) {
                    }
                    throw th;
                }
                bufferedReader.close();
                try {
                    requiredStream.close();
                } catch (IOException unused2) {
                }
                this.availableLocales = Collections.unmodifiableList(arrayList);
            } catch (IOException e) {
                throw new IllegalStateException("IO Error reading data/index.txt: " + e.toString());
            }
        } catch (Throwable th) {
            requiredStream.close();
            throw th;
        }
    }

    public static ResourceBasedPeriodFormatterDataService getInstance() {
        return singleton;
    }

    @Override // com.ibm.icu.impl.duration.impl.PeriodFormatterDataService
    public PeriodFormatterData get(String str) {
        int iIndexOf = str.indexOf(64);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        synchronized (this) {
            try {
                String str2 = this.lastLocale;
                if (str2 != null && str2.equals(str)) {
                    return this.lastData;
                }
                PeriodFormatterData periodFormatterData = this.cache.get(str);
                if (periodFormatterData == null) {
                    String strSubstring = str;
                    while (!this.availableLocales.contains(strSubstring)) {
                        int iLastIndexOf = strSubstring.lastIndexOf(BaseLocale.SEP);
                        if (iLastIndexOf <= -1) {
                            if ("test".equals(strSubstring)) {
                                strSubstring = null;
                                break;
                            }
                            strSubstring = "test";
                        } else {
                            strSubstring = strSubstring.substring(0, iLastIndexOf);
                        }
                    }
                    if (strSubstring == null) {
                        throw new MissingResourceException("Duration data not found for  " + str, PATH, str);
                    }
                    String str3 = "data/pfd_" + strSubstring + ".xml";
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(ICUData.getRequiredStream(getClass(), str3), "UTF-8");
                        DataRecord dataRecord = DataRecord.read(strSubstring, new XMLRecordReader(inputStreamReader));
                        inputStreamReader.close();
                        if (dataRecord != null) {
                            periodFormatterData = new PeriodFormatterData(str, dataRecord);
                        }
                        this.cache.put(str, periodFormatterData);
                    } catch (UnsupportedEncodingException unused) {
                        throw new MissingResourceException("Unhandled encoding for resource " + str3, str3, "");
                    } catch (IOException e) {
                        throw new ICUUncheckedIOException("Failed to close() resource " + str3, e);
                    }
                }
                this.lastData = periodFormatterData;
                this.lastLocale = str;
                return periodFormatterData;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ibm.icu.impl.duration.impl.PeriodFormatterDataService
    public Collection<String> getAvailableLocales() {
        return this.availableLocales;
    }
}
