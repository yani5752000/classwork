/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author faridasadpour
 */
public class RockPaperScissors {
    public void fight(){
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        
        
        while(true){
            String wantPlay;
            int rounds;
            int ties = 0;
            int playerWins = 0;
            int computerWins = 0;
            int playerChoice, computerChoice;
            System.out.println("How many rounds do you want to play?");
            rounds = Integer.parseInt(sc.nextLine());
            if(rounds > 10 || rounds < 1){
                System.out.println("Invalid input for number of rounds. Programme quits.");
                break;
            }
            int gameRound = 1;
            while(gameRound <= rounds){
                System.out.println("What is your choice? 1 = Rock, 2 = Paper, 3 = Scissors");
                playerChoice = Integer.parseInt(sc.nextLine());
                computerChoice = rnd.nextInt(3) + 1;
                if(playerChoice == computerChoice){
                    ties++;
                    System.out.println("It is a tie.");
                }
                if(playerChoice == 1 && computerChoice == 2){
                    computerWins++;
                    System.out.println("Computer wins.");
                }
                if(playerChoice == 2 && computerChoice == 3){
                    computerWins++;
                    System.out.println("Computer wins.");
                }
                if(playerChoice == 3 && computerChoice == 1){
                    computerWins++;
                    System.out.println("Computer wins.");
                }
                if(computerChoice == 1 && playerChoice == 2){
                    playerWins++;
                    System.out.println("Player wins.");
                }
                if(computerChoice == 2 && playerChoice == 3){
                    playerWins++;
                    System.out.println("Player wins.");
                }
                if(computerChoice == 3 && playerChoice == 1){
                    playerWins++;
                    System.out.println("Player wins.");
                }
                gameRound++;
            }
            System.out.println("Player won " + playerWins + " times.");
            System.out.println("Computer won " + computerWins + " times.");
            System.out.println("Ties happened " + ties + " times.");
            if(playerWins == computerWins){
                System.out.println("Nobody won.");
            }
            if(playerWins < computerWins){
                System.out.println("Computer won.");
            }
            if(playerWins > computerWins){
                System.out.println("Player won.");
            }
                
            System.out.println("Do you want to play again?(y/n)");
            wantPlay = sc.nextLine();
            if("n".equals(wantPlay)){
                System.out.println("Thanks for playing!");
                break;
            }
        
        }
        
    }
}
