package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Combat {

    private final Map<String, Character> enemies = new HashMap<>();
    private Interpreter combatInterpreter;
    private boolean running = true;
    private Scanner scanner;

    public Combat(Hero hero, Map<String, Character> enemies, Scanner input) {
        Command attack = new Attack(hero,input);
        Command flee = new Flee(hero);
        Map<String, Command> commands = new HashMap<>();
        commands.put("attack", attack);
        commands.put("flee", flee);
        this.combatInterpreter = new Interpreter(commands);
        this.enemies.putAll(enemies);
        scanner = input;
    }

    public Map<String, Character> getEnemies() {
        return this.enemies;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private void heroTurn() {
        boolean executed_command;
        do {
            String input = this.scanner.nextLine();
            executed_command = this.combatInterpreter.interpret(input);
        } while (!executed_command);
    }

    public void enemyTurn(Hero hero, Character enemy) {
        if (enemy.isAlive())
            enemy.attack(hero);
    }

    private void combatTurn(Hero hero) {
        this.heroTurn();
        this.enemies.forEach((k, v) -> this.enemyTurn(hero, v));
    }

    private void printCombatInfo(Hero hero) {
        System.out.println(hero.getName() + " - HP : " + hero.getCurrentHealthPoints() + "/" + hero.getMaxHealthPoints());
        this.enemies.forEach((k, v) -> {
            System.out.println(k + " - HP : " + v.getCurrentHealthPoints() + "/" + v.getMaxHealthPoints());
        });
    }

    private boolean endCombat(Hero hero) {
        AtomicBoolean enemiesStillAlive = new AtomicBoolean(false); //besoin d'un atomic boolean pour le foreach, aurait sinon pu utiliser  map.entrySet
        this.enemies.forEach((k, v) -> {
            enemiesStillAlive.set(enemiesStillAlive.get() || v.isAlive());
        });
        return hero.isAlive() && enemiesStillAlive.get();
    }

    public void runCombat(Hero hero) {
        System.out.println("Start of combat");
        while (this.running) {
            this.printCombatInfo(hero);
            this.combatTurn(hero);
            this.running = this.running && this.endCombat(hero);
        }
        System.out.println("End of combat");
        hero.setOngoingCombat(null);
    }


}
