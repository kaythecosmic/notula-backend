package com.thecosmickay.backend_notula.model;

import jakarta.persistence.Embeddable;

import java.util.HashMap;
import java.util.Map;

@Embeddable
public class NotePosition {
    private int x;
    private int y;

    public NotePosition() {
    }

    public NotePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Map<Character, Integer> positionObject() {
        HashMap<Character, Integer> position = new HashMap<Character, Integer>();
        position.put('x', this.x);
        position.put('y', this.y);
        return position;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
