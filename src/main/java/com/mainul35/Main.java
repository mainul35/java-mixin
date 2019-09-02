package com.mainul35;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Mixer mixer = MixerFactory.getMixerInstance();

        Type1 type1 = new Type1();
        Type2 type2 = new Type2();
        mixer.mix(type1);
        mixer.mix(type2);
        ((Type1)mixer.typeOf(type1)).type1Method2();

    }
}

interface Mixer<T> {

    final Map<Class, Object> MAP = new HashMap<>();
    default void mix(T toMix) {
        MAP.put(toMix.getClass(), toMix);
    }

    default T typeOf(T object){
        return (T)MAP.get(object.getClass());
    }
}

class MixerFactory implements Mixer {
    public static Mixer getMixerInstance(){
        return new Mixer() {
        };
    }
}

class Type1 implements Mixer{
    public void type1Method1() {
        System.out.println("Type 1 Method 1");

    }

    public void type1Method2() {
        System.out.println("Type 1 Method 2");
    }
}

class Type2 implements Mixer{
    public void type2Method1() {
        System.out.println("Type 2 Method 1");
    }

    public void type2Method2() {
        System.out.println("Type 2 Method 2");
    }
}
