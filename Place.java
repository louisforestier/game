package game;

import java.util.*;

public class Place extends Interaction {

    private final String name;
    private Map<String, Interaction> interactions = new HashMap<>();


    public Place(String name, String description, Map<String, Interaction> interactions) {
        super(description);
        this.name = name;
        //peut throw exception : NullPointerException : faire try catch
        try {
            this.interactions.putAll(interactions);
        } catch (NullPointerException e) {
            //dans le cas où la liste des interactions est vide, on ne fait rien
            //potentiellement à transformer en if else
        }
    }

    public Map<String, Interaction> getInteractions() {
        return this.interactions;
    }

    public String getName() {
        return this.name;
    }

    public void addCharacter(String name, Character c) {
        this.interactions.put(name, c);
    }

    public void freeCharacter(String name) {
        this.interactions.remove(name);
    }

    public boolean isInPlace(String name) {
        return this.getInteractions().containsKey(name);
    }

    @Override
    //en fait j'hésite à faire un print de chaque interaction
    //le problème avec la description fixe dans laquelle tu
    // mets aussi les characters et items c'est que si tu prends
    // un objet ou retire un personnag, il y est toujours
    // quand tu fais look.
    public void print() {
        super.print();
        System.out.println("In this place, you see :");
        this.getInteractions().forEach((k, v) -> {
                    if (v instanceof Door) {
                        System.out.println("a door leading to the " + k);
                    } else if (!(k.equals("hero")))
                        System.out.println("a " + k);
                }
        );
    }

    public void takeOut(Item i) {
        this.interactions.remove(i.getName());
    }
}






