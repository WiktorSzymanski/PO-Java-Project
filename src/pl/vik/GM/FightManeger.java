package pl.vik.GM;

public class FightManeger {

    public Animal playerAnimal = null;
    public Animal enemyAnimal = null;

    private boolean isPlayerTurn = true;

    private Player player = null;
    private Enemy enemy = null;

    public boolean playerWon;

    public FightManeger(Animal player, Animal enemy) {
        this.playerAnimal = player;
        this.enemyAnimal = enemy;

        this.player = new Player(this);
        this.enemy = new Enemy(this);

        playerWon = fight();
        System.out.println("Player Won: " + playerWon);
    }

    public void dealDmg(int ammount) {
        if (isPlayerTurn) {
            enemy.currentHealth -= ammount;
        } else {
            player.currentHealth -= ammount;
        }
    }

    private boolean playerWinCondition() {
        if (this.enemy.currentHealth <= 0) {
            return true;
        }
        return false;
    }

    private boolean fight() {
        while (player.currentHealth > 0 && enemy.currentHealth > 0) {
            System.out.println("Player Health: " + player.currentHealth);
            System.out.println("Player Energy: " + player.currentEnergy);
            System.out.println("Enemy Health: " + enemy.currentHealth);
            System.out.println("Enemy Energy: " + enemy.currentEnergy);
            if (isPlayerTurn) {
                player.makeMove();
                isPlayerTurn = false;
                enemy.regen();
            } else {
                enemy.makeMove();
                isPlayerTurn = true;
                player.regen();
            }
        }

        return playerWinCondition();
    }
}
