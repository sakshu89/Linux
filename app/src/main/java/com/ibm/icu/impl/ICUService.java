package com.ibm.icu.impl;

import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ICUService extends ICUNotifier {
    private static final boolean DEBUG = ICUDebug.enabled("service");
    private Map<String, CacheEntry> cache;
    private int defaultSize;
    private LocaleRef dnref;
    private final List<Factory> factories;
    private final ICURWLock factoryLock;
    private Map<String, Factory> idcache;
    protected final String name;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class CacheEntry {
        final String actualDescriptor;
        final Object service;

        public CacheEntry(String str, Object obj) {
            this.actualDescriptor = str;
            this.service = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Factory {
        Object create(Key key, ICUService iCUService);

        String getDisplayName(String str, ULocale uLocale);

        void updateVisibleIDs(Map<String, Factory> map);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Key {
        private final String id;

        public Key(String str) {
            this.id = str;
        }

        public String canonicalID() {
            return this.id;
        }

        public String currentDescriptor() {
            return cq.j("/", currentID());
        }

        public String currentID() {
            return canonicalID();
        }

        public boolean fallback() {
            return false;
        }

        public final String id() {
            return this.id;
        }

        public boolean isFallbackOf(String str) {
            return canonicalID().equals(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LocaleRef {

        /* JADX INFO: renamed from: com, reason: collision with root package name */
        private Comparator<Object> f0com;
        private SortedMap<String, String> dnCache;
        private final ULocale locale;

        public LocaleRef(SortedMap<String, String> sortedMap, ULocale uLocale, Comparator<Object> comparator) {
            this.locale = uLocale;
            this.f0com = comparator;
            this.dnCache = sortedMap;
        }

        public SortedMap<String, String> get(ULocale uLocale, Comparator<Object> comparator) {
            SortedMap<String, String> sortedMap = this.dnCache;
            if (sortedMap == null || !this.locale.equals(uLocale)) {
                return null;
            }
            Comparator<Object> comparator2 = this.f0com;
            if (comparator2 == comparator || (comparator2 != null && comparator2.equals(comparator))) {
                return sortedMap;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface ServiceListener extends EventListener {
        void serviceChanged(ICUService iCUService);
    }

    public ICUService() {
        this.factoryLock = new ICURWLock();
        this.factories = new ArrayList();
        this.defaultSize = 0;
        this.name = "";
    }

    private Map<String, Factory> getVisibleIDMap() {
        synchronized (this) {
            try {
                Map<String, Factory> map = this.idcache;
                if (map != null) {
                    return map;
                }
                try {
                    this.factoryLock.acquireRead();
                    HashMap map2 = new HashMap();
                    List<Factory> list = this.factories;
                    ListIterator<Factory> listIterator = list.listIterator(list.size());
                    while (listIterator.hasPrevious()) {
                        listIterator.previous().updateVisibleIDs(map2);
                    }
                    Map<String, Factory> mapUnmodifiableMap = Collections.unmodifiableMap(map2);
                    this.idcache = mapUnmodifiableMap;
                    this.factoryLock.releaseRead();
                    return mapUnmodifiableMap;
                } catch (Throwable th) {
                    this.factoryLock.releaseRead();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.ibm.icu.impl.ICUNotifier
    public boolean acceptsListener(EventListener eventListener) {
        return eventListener instanceof ServiceListener;
    }

    public void clearCaches() {
        this.cache = null;
        this.idcache = null;
        this.dnref = null;
    }

    public void clearServiceCache() {
        this.cache = null;
    }

    public Key createKey(String str) {
        if (str == null) {
            return null;
        }
        return new Key(str);
    }

    public final List<Factory> factories() {
        try {
            this.factoryLock.acquireRead();
            return new ArrayList(this.factories);
        } finally {
            this.factoryLock.releaseRead();
        }
    }

    public Object get(String str, String[] strArr) {
        if (str != null) {
            return getKey(createKey(str), strArr);
        }
        dk0.n("descriptor must not be null");
        return null;
    }

    public String getDisplayName(String str, ULocale uLocale) {
        Map<String, Factory> visibleIDMap = getVisibleIDMap();
        Factory factory = visibleIDMap.get(str);
        if (factory != null) {
            return factory.getDisplayName(str, uLocale);
        }
        Key keyCreateKey = createKey(str);
        while (keyCreateKey.fallback()) {
            Factory factory2 = visibleIDMap.get(keyCreateKey.currentID());
            if (factory2 != null) {
                return factory2.getDisplayName(str, uLocale);
            }
        }
        return null;
    }

    public SortedMap<String, String> getDisplayNames(ULocale uLocale, Comparator<Object> comparator, String str) {
        LocaleRef localeRef = this.dnref;
        SortedMap<String, String> sortedMapUnmodifiableSortedMap = localeRef != null ? localeRef.get(uLocale, comparator) : null;
        while (sortedMapUnmodifiableSortedMap == null) {
            synchronized (this) {
                try {
                    LocaleRef localeRef2 = this.dnref;
                    if (localeRef == localeRef2 || localeRef2 == null) {
                        TreeMap treeMap = new TreeMap(comparator);
                        for (Map.Entry<String, Factory> entry : getVisibleIDMap().entrySet()) {
                            String key = entry.getKey();
                            treeMap.put(entry.getValue().getDisplayName(key, uLocale), key);
                        }
                        sortedMapUnmodifiableSortedMap = Collections.unmodifiableSortedMap(treeMap);
                        this.dnref = new LocaleRef(sortedMapUnmodifiableSortedMap, uLocale, comparator);
                    } else {
                        sortedMapUnmodifiableSortedMap = localeRef2.get(uLocale, comparator);
                        localeRef = localeRef2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Key keyCreateKey = createKey(str);
        if (keyCreateKey == null) {
            return sortedMapUnmodifiableSortedMap;
        }
        TreeMap treeMap2 = new TreeMap((SortedMap) sortedMapUnmodifiableSortedMap);
        Iterator it = treeMap2.entrySet().iterator();
        while (it.hasNext()) {
            if (!keyCreateKey.isFallbackOf((String) ((Map.Entry) it.next()).getValue())) {
                it.remove();
            }
        }
        return treeMap2;
    }

    public Object getKey(Key key, String[] strArr, Factory factory) {
        boolean z;
        int i;
        int i2;
        int i3;
        CacheEntry cacheEntry;
        if (this.factories.size() == 0) {
            return handleDefault(key, strArr);
        }
        boolean z2 = DEBUG;
        if (z2) {
            System.out.println("Service: " + this.name + " key: " + key.canonicalID());
        }
        if (key != null) {
            try {
                this.factoryLock.acquireRead();
                Map<String, CacheEntry> concurrentHashMap = this.cache;
                if (concurrentHashMap == null) {
                    if (z2) {
                        System.out.println("Service " + this.name + " cache was empty");
                    }
                    concurrentHashMap = new ConcurrentHashMap<>();
                }
                int size = this.factories.size();
                ArrayList arrayList = null;
                if (factory != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            i2 = 0;
                            break;
                        }
                        if (factory == this.factories.get(i4)) {
                            i2 = i4 + 1;
                            break;
                        }
                        i4++;
                    }
                    if (i2 == 0) {
                        throw new IllegalStateException("Factory " + String.valueOf(factory) + "not registered with service: " + String.valueOf(this));
                    }
                    i = 0;
                    z = false;
                } else {
                    z = true;
                    i = 0;
                    i2 = 0;
                }
                boolean z3 = false;
                loop1: while (true) {
                    String strCurrentDescriptor = key.currentDescriptor();
                    boolean z4 = DEBUG;
                    if (z4) {
                        i3 = 0;
                        System.out.println(this.name + "[" + i + "] looking for: " + strCurrentDescriptor);
                        i++;
                    } else {
                        i3 = 0;
                    }
                    cacheEntry = concurrentHashMap.get(strCurrentDescriptor);
                    if (cacheEntry != null) {
                        if (z4) {
                            System.out.println(this.name + " found with descriptor: " + strCurrentDescriptor);
                        }
                        z = z3;
                        break;
                    }
                    if (z4) {
                        System.out.println("did not find: " + strCurrentDescriptor + " in cache");
                    }
                    int i5 = i2;
                    while (i5 < size) {
                        int i6 = i5 + 1;
                        Factory factory2 = this.factories.get(i5);
                        boolean z5 = DEBUG;
                        if (z5) {
                            System.out.println("trying factory[" + i5 + "] " + factory2.toString());
                        }
                        Object objCreate = factory2.create(key, this);
                        if (objCreate != null) {
                            cacheEntry = new CacheEntry(strCurrentDescriptor, objCreate);
                            if (!z5) {
                                break loop1;
                            }
                            System.out.println(this.name + " factory supported: " + strCurrentDescriptor + ", caching");
                            break loop1;
                        }
                        if (z5) {
                            System.out.println("factory did not support: " + strCurrentDescriptor);
                        }
                        i = i;
                        i5 = i6;
                        size = size;
                    }
                    int i7 = i;
                    int i8 = size;
                    if (arrayList == null) {
                        arrayList = new ArrayList(5);
                    }
                    arrayList.add(strCurrentDescriptor);
                    if (!key.fallback()) {
                        break;
                    }
                    i = i7;
                    z3 = z;
                    size = i8;
                }
                if (cacheEntry != null) {
                    if (z) {
                        if (DEBUG) {
                            System.out.println("caching '" + cacheEntry.actualDescriptor + "'");
                        }
                        concurrentHashMap.put(cacheEntry.actualDescriptor, cacheEntry);
                        if (arrayList != null) {
                            int size2 = arrayList.size();
                            int i9 = i3;
                            while (i9 < size2) {
                                Object obj = arrayList.get(i9);
                                i9++;
                                String str = (String) obj;
                                if (DEBUG) {
                                    System.out.println(this.name + " adding descriptor: '" + str + "' for actual: '" + cacheEntry.actualDescriptor + "'");
                                }
                                concurrentHashMap.put(str, cacheEntry);
                            }
                        }
                        this.cache = concurrentHashMap;
                    }
                    if (strArr != null) {
                        int iIndexOf = cacheEntry.actualDescriptor.indexOf("/");
                        String str2 = cacheEntry.actualDescriptor;
                        if (iIndexOf == 0) {
                            strArr[i3] = str2.substring(1);
                        } else {
                            strArr[i3] = str2;
                        }
                    }
                    if (DEBUG) {
                        System.out.println("found in service: " + this.name);
                    }
                    Object obj2 = cacheEntry.service;
                    this.factoryLock.releaseRead();
                    return obj2;
                }
                this.factoryLock.releaseRead();
            } catch (Throwable th) {
                this.factoryLock.releaseRead();
                throw th;
            }
        }
        if (DEBUG) {
            ky0.y("not found in service: ", this.name, System.out);
        }
        return handleDefault(key, strArr);
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getVisibleIDs(String str) {
        Set<String> setKeySet = getVisibleIDMap().keySet();
        Key keyCreateKey = createKey(str);
        if (keyCreateKey == null) {
            return setKeySet;
        }
        HashSet hashSet = new HashSet(setKeySet.size());
        for (String str2 : setKeySet) {
            if (keyCreateKey.isFallbackOf(str2)) {
                hashSet.add(str2);
            }
        }
        return hashSet;
    }

    public Object handleDefault(Key key, String[] strArr) {
        return null;
    }

    public boolean isDefault() {
        return this.factories.size() == this.defaultSize;
    }

    public void markDefault() {
        this.defaultSize = this.factories.size();
    }

    @Override // com.ibm.icu.impl.ICUNotifier
    public void notifyListener(EventListener eventListener) {
        ((ServiceListener) eventListener).serviceChanged(this);
    }

    public void reInitializeFactories() {
        this.factories.clear();
    }

    public final Factory registerFactory(Factory factory) {
        factory.getClass();
        try {
            this.factoryLock.acquireWrite();
            this.factories.add(0, factory);
            clearCaches();
            this.factoryLock.releaseWrite();
            notifyChanged();
            return factory;
        } catch (Throwable th) {
            this.factoryLock.releaseWrite();
            throw th;
        }
    }

    public Factory registerObject(Object obj, String str, boolean z) {
        return registerFactory(new SimpleFactory(obj, createKey(str).canonicalID(), z));
    }

    public final void reset() {
        try {
            this.factoryLock.acquireWrite();
            reInitializeFactories();
            clearCaches();
            this.factoryLock.releaseWrite();
            notifyChanged();
        } catch (Throwable th) {
            this.factoryLock.releaseWrite();
            throw th;
        }
    }

    public String stats() {
        ICURWLock.Stats statsResetStats = this.factoryLock.resetStats();
        return statsResetStats != null ? statsResetStats.toString() : "no stats";
    }

    public String toString() {
        return ky0.k(super.toString(), "{", this.name, "}");
    }

    public final boolean unregisterFactory(Factory factory) {
        boolean z;
        factory.getClass();
        try {
            this.factoryLock.acquireWrite();
            if (this.factories.remove(factory)) {
                clearCaches();
                z = true;
            } else {
                z = false;
            }
            if (z) {
                notifyChanged();
            }
            return z;
        } finally {
            this.factoryLock.releaseWrite();
        }
    }

    public Object get(String str) {
        return getKey(createKey(str), null);
    }

    public Factory registerObject(Object obj, String str) {
        return registerObject(obj, str, true);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SimpleFactory implements Factory {
        protected String id;
        protected Object instance;
        protected boolean visible;

        public SimpleFactory(Object obj, String str, boolean z) {
            if (obj == null || str == null) {
                og.i("Instance or id is null");
                throw null;
            }
            this.instance = obj;
            this.id = str;
            this.visible = z;
        }

        @Override // com.ibm.icu.impl.ICUService.Factory
        public Object create(Key key, ICUService iCUService) {
            if (this.id.equals(key.currentID())) {
                return this.instance;
            }
            return null;
        }

        @Override // com.ibm.icu.impl.ICUService.Factory
        public String getDisplayName(String str, ULocale uLocale) {
            if (this.visible && this.id.equals(str)) {
                return str;
            }
            return null;
        }

        public String toString() {
            return super.toString() + ", id: " + this.id + ", visible: " + this.visible;
        }

        @Override // com.ibm.icu.impl.ICUService.Factory
        public void updateVisibleIDs(Map<String, Factory> map) {
            boolean z = this.visible;
            String str = this.id;
            if (z) {
                map.put(str, this);
            } else {
                map.remove(str);
            }
        }

        public SimpleFactory(Object obj, String str) {
            this(obj, str, true);
        }
    }

    public ICUService(String str) {
        this.factoryLock = new ICURWLock();
        this.factories = new ArrayList();
        this.defaultSize = 0;
        this.name = str;
    }

    public String getDisplayName(String str) {
        return getDisplayName(str, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public Set<String> getVisibleIDs() {
        return getVisibleIDs(null);
    }

    public SortedMap<String, String> getDisplayNames(ULocale uLocale) {
        return getDisplayNames(uLocale, null, null);
    }

    public SortedMap<String, String> getDisplayNames(ULocale uLocale, Comparator<Object> comparator) {
        return getDisplayNames(uLocale, comparator, null);
    }

    public SortedMap<String, String> getDisplayNames(ULocale uLocale, String str) {
        return getDisplayNames(uLocale, null, str);
    }

    public SortedMap<String, String> getDisplayNames() {
        return getDisplayNames(ULocale.getDefault(ULocale.Category.DISPLAY), null, null);
    }

    public Object getKey(Key key, String[] strArr) {
        return getKey(key, strArr, null);
    }

    public Object getKey(Key key) {
        return getKey(key, null);
    }
}
