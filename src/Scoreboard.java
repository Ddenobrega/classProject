import java.util.Objects;
import java.util.Scanner;

public class Scoreboard {
    int programActive = 0;
    Team team1 = new Team();
    Team team2 = new Team();
    Team selectedTeam;


    String[] sponsors = {"KFC", "XL Energy Drink"};
    void scoreFour(){this.selectedTeam.addScore( 4);}
    void scoreSix(){this.selectedTeam.addScore( 6);}
    void scoreRun(){this.selectedTeam.addScore( 1);}
    void wide(){this.scoreRun();}
    void addSponsor(String sponsor){
        this.sponsors[this.sponsors.length] = sponsor;
    }
    void delSponsor(String sponsor){
        int i = 0;
        while(i < this.sponsors.length){
            if(Objects.equals(sponsor, this.sponsors[i])){
                this.sponsors[i] = "";
            }
        }
    }
    void displaySponsor(){
            System.out.println("*****\nToday's Game was brought to you by " + this.sponsors[(int) Math.round(Math.random() * (this.sponsors.length - 1))] + "\n******");
    }
    void selectTeam(){
        Scanner selectScanner = new Scanner(System.in);
        System.out.println("Please Select an option from the list below\n[1] Select Team " + this.team1.name + "\n[2] Select Team " + this.team2.name + "\n[6] Exit");
        switch(Integer.parseInt(selectScanner.nextLine())){
            case 1:
                this.selectedTeam = this.team1;
                break;

            case 2:
                this.selectedTeam = this.team2;
                break;

            case 6:
                break;

            default:
                System.out.println("Invalid Entry Please Try Again");

        selectScanner.close();
    }}

    void runProgram() {
        int i = 1;
        Scanner inputScanner = new Scanner(System.in);
        progLoop:
        while (true) {
            while (i < 3){
                System.out.println("Welcome to the Scoreboard System please enter the name of team " + i);
                if (i == 1) {
                    this.team1.setName(inputScanner.nextLine());
                } else {
                    this.team2.setName(inputScanner.nextLine());
                }
                i++;
            }
            System.out.println("Today's match features " + this.team1.name + " vs " + this.team2.name + "\nCurrent Score " + this.team1.score + "/" + this.team2.score);
            if(this.selectedTeam == null){
                this.selectTeam();
            };
            System.out.println("\nPlease Select An Option from the list below\n[1] Change Selected Team\n[2] Score Run\n[3] Score Four\n[4] Score Six\n[5] Manually Display Sponsor[6] Exit");
            switch (Integer.parseInt(inputScanner.nextLine())){
                case 1:
                    this.selectTeam();
                    break;

                case 2:
                    this.scoreRun();
                    break;
                case 3:
                    this.scoreFour();
                    this.displaySponsor();
                    break;
                case 4:
                    this.scoreSix();
                    this.displaySponsor();
                    break;
                case 5:
                    this.displaySponsor();
                    break;
                case 6:
                    break progLoop;
                default:
                    System.out.println("Invalid Option Please Try Again");

            }



            }
        }

    }

