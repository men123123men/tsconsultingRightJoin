import java.util.Objects;

public class Pair<K,V> implements Comparable<Pair<K,?>>{
    final K k;
    final V v;

    private Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }
    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public static<K,V> Pair<K,V> createInstance(K k, V v){
        return new Pair( k, v);
    }

    @Override
    public String toString() {
        return String.format("Pair{key= %s, value= %s}", k, v );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(k, pair.k);
    }

    @Override
    public int hashCode() {
        return Objects.hash(k);
    }

    @Override
    public int compareTo(Pair<K, ? > o) {
        return Integer.compare(hashCode(), o.hashCode());
    }
}
