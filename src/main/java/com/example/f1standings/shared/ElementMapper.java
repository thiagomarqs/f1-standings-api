package com.example.f1standings.shared;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

@Component
public class ElementMapper<T> {

    /**
     * Necessary to make mapping to a generic type possible.
     */
    public T map(Element element, Class<T> clazz) {
        try {
            return clazz.getConstructor(Element.class).newInstance(element);
        } catch (Exception e) {
            throw new RuntimeException("Error mapping element to class", e);
        }
    }
}
