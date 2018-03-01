package jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: subiin
 * @date: 2018/1/20 下午3:35
 * @description:
 */
public class MemoryLeakDemo {

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            return id != null ? id.equals(key.id) : key.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        while (true) {
            for (int i = 0; i < 10000000; i++) {
                if (!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "Number:" + i);
                }
            }
        }
    }
}
