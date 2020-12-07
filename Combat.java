package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Combat {

    private final Map<String, Character> enemies = new HashMap<>();
    private Interpreter combatInterpreter;
    private boolean running = true;

    public Combat(Hero hero, Map<String, Character> enemies, Game game) {
        Command attack = new Attack(hero, game);
        Command flee = new Flee(hero);
        Map<String, Command> commands = new HashMap<>();
        commands.put("attack", attack);
        commands.put("flee", flee);
        this.combatInterpreter = new Interpreter(commands);
        this.enemies.putAll(enemies);
    }

    public Map<String, Character> getEnemies() {
        return this.enemies;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void heroTurn(Scanner scanner) {
        boolean executed_command;
        do {
            String input = scanner.nextLine();
            executed_command = this.combatInterpreter.interpret(input);
        } while (!executed_command);
    }

    public void enemyTurn(Hero hero, Character enemy) {
        if (enemy.isAlive())
            enemy.attack(hero);
    }

    private void combatTurn(Hero hero, Scanner scanner) {
        this.heroTurn(scanner);
        this.enemies.forEach((k, v) -> this.enemyTurn(hero, v));
    }

    private void printCombatInfo(Hero hero) {
        System.out.println(hero.getName() + " - HP : " + hero.getCurrentHealthPoints() + "/" + hero.getMaxHealthPoints());
        this.enemies.forEach((k, v) -> {
            System.out.println(k + " - HP : " + v.getCurrentHealthPoints() + "/" + v.getMaxHealthPoints());
        });
    }

    public boolean endCombat(Hero hero) {
        AtomicBoolean enemiesStillAlive = new AtomicBoolean(false); //besoin d'un atomic boolean pour le foreach, aurait sinon pu utiliser  map.entrySet
        this.enemies.forEach((k, v) -> {
            enemiesStillAlive.set(enemiesStillAlive.get() || v.isAlive());
        });
        return hero.isAlive() && enemiesStillAlive.get();
    }

    public void runCombat(Hero hero, Scanner scanner) {
        System.out.println("Start of combat");
        while (this.running) {
            this.printCombatInfo(hero);
            this.combatTurn(hero, scanner);
            this.running = this.running && this.endCombat(hero);
        }
        System.out.println("End of combat");
    }


}
