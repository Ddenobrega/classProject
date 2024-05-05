public class Team {
    String name;
    int score = 0;

    void addScore(int amount){
        this.score = this.score + amount;
    }
    void removeScore(int amount){
        this.score = this.score - amount;
    }

    void setName(String name){
        this.name = name;
    }
}
