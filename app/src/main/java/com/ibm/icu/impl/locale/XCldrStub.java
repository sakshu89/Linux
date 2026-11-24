package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.locale.XCldrStub;
import com.ibm.icu.util.ICUException;
import com.ibm.icu.util.ICUUncheckedIOException;
import defpackage.cq;
import defpackage.mc1;
import defpackage.uc3;
import defpackage.wc3;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class XCldrStub {
    public static final Comparator<String> LONGEST_FIRST = Comparator.comparingInt(new uc3()).reversed().thenComparing(Comparator.naturalOrder());

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CollectionUtilities {
        public static <T, U extends Iterable<T>> String join(U u, String str) {
            return XCldrStub.join(u, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class HashMultimap<K, V> extends Multimap<K, V> {
        private HashMultimap() {
            super(new HashMap(), HashSet.class, 0);
        }

        public static <K, V> HashMultimap<K, V> create() {
            return new HashMultimap<>();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ImmutableMap {
        public static <K, V> Map<K, V> copyOf(Map<K, V> map) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ImmutableMultimap {
        public static <K, V> Multimap<K, V> copyOf(Multimap<K, V> multimap) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<K, Set<V>> entry : multimap.asMap().entrySet()) {
                Set<V> value = entry.getValue();
                linkedHashMap.put(entry.getKey(), value.size() == 1 ? Collections.singleton(value.iterator().next()) : Collections.unmodifiableSet(new LinkedHashSet(value)));
            }
            return new Multimap<>(Collections.unmodifiableMap(linkedHashMap), null, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ImmutableSet {
        public static <T> Set<T> copyOf(Set<T> set) {
            return Collections.unmodifiableSet(new LinkedHashSet(set));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LinkedHashMultimap<K, V> extends Multimap<K, V> {
        private LinkedHashMultimap() {
            super(new LinkedHashMap(), LinkedHashSet.class, 0);
        }

        public static <K, V> LinkedHashMultimap<K, V> create() {
            return new LinkedHashMultimap<>();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RegexUtilities {
        public static int findMismatch(Matcher matcher, CharSequence charSequence) {
            int i = 1;
            while (i < charSequence.length() && (matcher.reset(charSequence.subSequence(0, i)).matches() || matcher.hitEnd())) {
                i++;
            }
            return i - 1;
        }

        public static String showMismatch(Matcher matcher, CharSequence charSequence) {
            int iFindMismatch = findMismatch(matcher, charSequence);
            return cq.k(String.valueOf(charSequence.subSequence(0, iFindMismatch)), "☹", String.valueOf(charSequence.subSequence(iFindMismatch, charSequence.length())));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class TreeMultimap<K, V> extends Multimap<K, V> {
        private TreeMultimap() {
            super(new TreeMap(), TreeSet.class, 0);
        }

        public static <K, V> TreeMultimap<K, V> create() {
            return new TreeMultimap<>();
        }
    }

    public static <K, V> NavigableMap<K, V> immutableSortedMap(Map<K, V> map) {
        return Collections.unmodifiableNavigableMap(new TreeMap(map));
    }

    public static <T> String join(Iterable<T> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (T t : iterable) {
            if (z) {
                z = false;
            } else {
                sb.append(str);
            }
            sb.append(t.toString());
        }
        return sb.toString();
    }

    public static final void joinUninterruptibly(Thread thread) {
        boolean z = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setsDifference$0(Set set, Object obj) {
        return !set.contains(obj);
    }

    @SafeVarargs
    public static <T> Set<T> setofOrdered(T... tArr) {
        return (Set) Arrays.stream(tArr).collect(Collectors.collectingAndThen(Collectors.toCollection(new wc3()), new mc1(7)));
    }

    public static <T> Set<T> setsDifference(Set<T> set, final Set<T> set2) {
        return (Set) set.stream().filter(new Predicate() { // from class: vc3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return XCldrStub.lambda$setsDifference$0(set2, obj);
            }
        }).collect(Collectors.collectingAndThen(Collectors.toCollection(new wc3()), new mc1(7)));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ReusableEntry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public /* synthetic */ ReusableEntry(int i) {
            this();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        private ReusableEntry() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Splitter {
        Pattern pattern;
        boolean trimResults;

        public Splitter(char c) {
            this(Pattern.compile("\\Q" + c + "\\E"));
        }

        public static Splitter on(char c) {
            return new Splitter(c);
        }

        public Iterable<String> split(String str) {
            return splitToList(str);
        }

        public List<String> splitToList(String str) {
            String[] strArrSplit = this.pattern.split(str);
            if (this.trimResults) {
                for (int i = 0; i < strArrSplit.length; i++) {
                    strArrSplit[i] = strArrSplit[i].trim();
                }
            }
            return Arrays.asList(strArrSplit);
        }

        public Stream<String> splitToStream(String str) {
            return splitToList(str).stream();
        }

        public Splitter trimResults() {
            this.trimResults = true;
            return this;
        }

        public static Splitter on(String str) {
            return new Splitter(str);
        }

        public static Splitter on(Pattern pattern) {
            return new Splitter(pattern);
        }

        public Splitter(String str) {
            this(Pattern.compile("\\Q" + str + "\\E"));
        }

        public Splitter(Pattern pattern) {
            this.trimResults = false;
            this.pattern = pattern;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Joiner {
        private final String separator;

        private Joiner(String str) {
            this.separator = str;
        }

        public static final Joiner on(String str) {
            return new Joiner(str);
        }

        public <T> String join(T[] tArr) {
            return XCldrStub.join(tArr, this.separator);
        }

        public <T> String join(Iterable<T> iterable) {
            return XCldrStub.join(iterable, this.separator);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Multimap<K, V> {
        private final Map<K, Set<V>> map;
        private final Class<Set<V>> setClass;

        /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r2v0, types: [java.lang.Class<?>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private Multimap(java.util.Map<K, java.util.Set<V>> r1, java.lang.Class r2) {
            /*
                r0 = this;
                r0.<init>()
                r0.map = r1
                if (r2 == 0) goto L8
                goto La
            L8:
                java.lang.Class<java.util.HashSet> r2 = java.util.HashSet.class
            La:
                r0.setClass = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.locale.XCldrStub.Multimap.<init>(java.util.Map, java.lang.Class):void");
        }

        private Set<V> createSetIfMissing(K k) {
            Set<V> set = this.map.get(k);
            if (set != null) {
                return set;
            }
            Map<K, Set<V>> map = this.map;
            Set<V> multimap = getInstance();
            map.put(k, multimap);
            return multimap;
        }

        private Set<V> getInstance() {
            try {
                return this.setClass.newInstance();
            } catch (Exception e) {
                throw new ICUException(e);
            }
        }

        public Map<K, Set<V>> asMap() {
            return this.map;
        }

        public Iterable<Map.Entry<K, V>> entries() {
            return new MultimapIterator(this.map, 0);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return obj != null && obj.getClass() == getClass() && this.map.equals(((Multimap) obj).map);
            }
            return true;
        }

        public Set<V> get(K k) {
            return this.map.get(k);
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public Set<K> keySet() {
            return this.map.keySet();
        }

        public void put(K k, V v) {
            createSetIfMissing(k).add(v);
        }

        public void putAll(Multimap<K, V> multimap) {
            for (Map.Entry<K, Set<V>> entry : multimap.map.entrySet()) {
                putAll(entry.getKey(), entry.getValue());
            }
        }

        public int size() {
            return this.map.size();
        }

        public String toString() {
            return cq.v("[", (String) asMap().entrySet().stream().map(new mc1(8)).collect(Collectors.joining(", ")), "]");
        }

        public Set<V> values() {
            Collection<Set<V>> collectionValues = this.map.values();
            if (collectionValues.size() == 0) {
                return Collections.EMPTY_SET;
            }
            Set<V> multimap = getInstance();
            Iterator<Set<V>> it = collectionValues.iterator();
            while (it.hasNext()) {
                multimap.addAll(it.next());
            }
            return multimap;
        }

        public /* synthetic */ Multimap(Map map, Class cls, int i) {
            this(map, cls);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void putAll(K k, Collection<V> collection) {
            if (collection.isEmpty()) {
                return;
            }
            createSetIfMissing(k).addAll(collection);
        }

        public void putAll(Collection<K> collection, V v) {
            Iterator<K> it = collection.iterator();
            while (it.hasNext()) {
                put(it.next(), v);
            }
        }

        @SafeVarargs
        public final Multimap<K, V> putAll(K k, V... vArr) {
            if (vArr.length != 0) {
                createSetIfMissing(k).addAll(Arrays.asList(vArr));
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class MultimapIterator<K, V> implements Iterator<Map.Entry<K, V>>, Iterable<Map.Entry<K, V>> {
        private final ReusableEntry<K, V> entry;
        private final Iterator<Map.Entry<K, Set<V>>> it1;
        private Iterator<V> it2;

        private MultimapIterator(Map<K, Set<V>> map) {
            this.it2 = null;
            this.entry = new ReusableEntry<>(0);
            this.it1 = map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.it1.hasNext()) {
                return true;
            }
            Iterator<V> it = this.it2;
            return it != null && it.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Iterator<V> it = this.it2;
            if (it == null || !it.hasNext()) {
                Map.Entry<K, Set<V>> next = this.it1.next();
                ((ReusableEntry) this.entry).key = next.getKey();
                Iterator<V> it2 = next.getValue().iterator();
                this.it2 = it2;
                ((ReusableEntry) this.entry).value = it2.next();
            } else {
                ((ReusableEntry) this.entry).value = this.it2.next();
            }
            return this.entry;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ MultimapIterator(Map map, int i) {
            this(map);
        }

        @Override // java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Multimaps {
        public static <K, V, R extends Multimap<K, V>> R invertFrom(Multimap<V, K> multimap, R r) {
            for (Map.Entry<V, Set<K>> entry : multimap.asMap().entrySet()) {
                r.putAll(entry.getValue(), entry.getKey());
            }
            return r;
        }

        public static <K, V> Map<K, V> forMap(Map<K, V> map) {
            return map;
        }

        public static <K, V, R extends Multimap<K, V>> R invertFrom(Map<V, K> map, R r) {
            for (Map.Entry<V, K> entry : map.entrySet()) {
                r.put(entry.getValue(), entry.getKey());
            }
            return r;
        }
    }

    public static <T> String join(T[] tArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tArr.length; i++) {
            if (i != 0) {
                sb.append(str);
            }
            sb.append(tArr[i]);
        }
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class FileUtilities {
        public static final Charset UTF8 = Charset.forName("utf-8");

        public static String getRelativeFileName(Class<?> cls, String str) {
            String string = (cls == null ? FileUtilities.class.getResource(str) : cls.getResource(str)).toString();
            if (string.startsWith("file:")) {
                return string.substring(5);
            }
            if (string.startsWith("jar:file:")) {
                return string.substring(9);
            }
            throw new ICUUncheckedIOException("File not found: ".concat(string));
        }

        public static BufferedReader openFile(Class<?> cls, String str, Charset charset) {
            try {
                InputStream resourceAsStream = cls.getResourceAsStream(str);
                if (charset == null) {
                    charset = UTF8;
                }
                return new BufferedReader(new InputStreamReader(resourceAsStream, charset), 65536);
            } catch (Exception e) {
                String canonicalName = cls == null ? null : cls.getCanonicalName();
                try {
                    StringBuilder sbQ = cq.q("Couldn't open file ", str, "; in path ", new File(getRelativeFileName(cls, "../util/")).getCanonicalPath(), "; relative to class: ");
                    sbQ.append(canonicalName);
                    throw new ICUUncheckedIOException(sbQ.toString(), e);
                } catch (Exception unused) {
                    throw new ICUUncheckedIOException(cq.l("Couldn't open file: ", str, "; relative to class: ", canonicalName), e);
                }
            }
        }

        public static BufferedReader openFile(Class<?> cls, String str) {
            return openFile(cls, str, UTF8);
        }
    }
}
