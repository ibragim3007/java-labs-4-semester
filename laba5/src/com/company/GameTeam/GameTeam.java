package com.company.GameTeam;

import com.company.Pair.Pair;
import com.company.PairBag.PairBag;
import com.company.bag.Bag;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.util.Scanner;

public class GameTeam {
    private int quantityTeam;
    private Bag teamsBag;

     public GameTeam (String[] teams) {
         this.quantityTeam = teams.length;
         if (this.quantityTeam > 0 && this.quantityTeam % 2 == 0) {
             this.teamsBag = new Bag(this.quantityTeam);

             for (int i = 0; i < this.quantityTeam; i++)
                 this.teamsBag.addThing(teams[i]);

             this.PlayWhileNotWin();

         } else System.out.println("Такое количество команд недопустимо!");
     }

     private void PlayWhileNotWin() {
        int N = this.quantityTeam;
        Bag tempTeams = this.teamsBag;
        System.out.print("\nУчастники: ");
        tempTeams.print();
         while (N / 2 != 0) {
             Scanner inputWinTeam = new Scanner(System.in);

             PairBag rivalsTeams = new PairBag(N / 2);

             for (int i = 0; i < N / 2; i++)
                rivalsTeams.add(new Pair<>(tempTeams.pickThing(), tempTeams.pickThing()));


             for (int i = 0; i < N / 2; i++) {
                 Pair<String, String> rivalsTeam = (Pair<String, String>) rivalsTeams.removeOneThing();
                 System.out.println("\nКакая команда выйграла? (1." + rivalsTeam.getKey() + "/2." + rivalsTeam.getValue() + ")");
                 int answer = inputWinTeam.nextInt();
                 if (answer == 1) tempTeams.addThing(rivalsTeam.getKey());
                 else if (answer == 2) tempTeams.addThing(rivalsTeam.getValue());
             }
             N /= 2;
         }
         System.out.println("Команда победитель: " + tempTeams.pickThing());
     }
}
