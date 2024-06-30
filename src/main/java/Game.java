import java.util.Random;

 class Game {
    private Player playerA;
    private Player playerB;
    private Random random;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.random = new Random();
    }

    public void play() {
        Player attacker = playerA.getHealth() < playerB.getHealth()? playerA : playerB;
        Player defender = attacker == playerA? playerB : playerA;

        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            int attackRoll = rollDie();
            int defendRoll = rollDie();

            int attackDamage = attacker.getAttack() * attackRoll;
            int defendStrength = defender.getStrength() * defendRoll;

            int damageDealt = Math.max(0, attackDamage - defendStrength);
            defender.setHealth(defender.getHealth() - damageDealt);

            System.out.println(attacker.getName() + " attacks " + defender.getName() + " for " + damageDealt + " damage. " + defender.getName() + " health: " + defender.getHealth());

            // Switch roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println("Game over. " + (playerA.getHealth() > 0? playerA.getName() : playerB.getName()) + " wins!");
    }

    public int rollDie() {
        return random.nextInt(6) + 1;
    }
}