package pl.vik.gm.animals;


import java.util.HashMap;

public abstract class Animal {
    public String name;
    public Integer health;
    public Integer energy;
    public HashMap<Integer, Skill> skills;
    public String imgSource;

    Animal(){}
}
