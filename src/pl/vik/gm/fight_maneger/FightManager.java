package pl.vik.gm.fight_maneger;

import pl.vik.gm.animals.Animal;
import pl.vik.ui.GamePanel;


public class FightManager {
    private final GamePanel gamePanel;

    private Animal playerAnimal;
    private Animal enemyAnimal;

    private boolean isPlayerTurn = true;

    private Player player;
    private Enemy enemy;

    private boolean gameEnded = false;

    public FightManager(GamePanel gamePanel, Animal player, Animal enemy) {
        this.gamePanel = gamePanel;

        this.setPlayerAnimal(player);
        this.setEnemyAnimal(enemy);

        this.setPlayer(new Player(this));
        this.setEnemy(new Enemy(this));

    }

    public void dealDmg(int amount) {
        if (isPlayerTurn()) {
            getEnemy().setCurrentHealth(getEnemy().getCurrentHealth() - amount);
        } else {
            getPlayer().setCurrentHealth(getPlayer().getCurrentHealth() - amount);
        }
    }

    private boolean playerWinCondition() {
        if (this.getEnemy().getCurrentHealth() <= 0) {
            System.out.println(this.getEnemy().getCurrentHealth());
            return true;
        }
        System.out.println(this.getEnemy().getCurrentHealth());
        return false;
    }

    public void playerTurn() {
        setPlayerTurn(false);
        getEnemy().afterRoundRegen();
    }

    public void enemyTurn() {
        getEnemy().enemyAI();
        setPlayerTurn(true);
        getPlayer().afterRoundRegen();
    }

    public boolean ifEndGame() {
        if (getPlayer().getCurrentHealth() <= 0 || getEnemy().getCurrentHealth() <= 0) {
            setGameEnded(true);
            getGamePanel().endGame(playerWinCondition());
            return true;
        }

        return false;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public Animal getPlayerAnimal() {
        return playerAnimal;
    }

    public void setPlayerAnimal(Animal playerAnimal) {
        this.playerAnimal = playerAnimal;
    }

    public Animal getEnemyAnimal() {
        return enemyAnimal;
    }

    public void setEnemyAnimal(Animal enemyAnimal) {
        this.enemyAnimal = enemyAnimal;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }
}
