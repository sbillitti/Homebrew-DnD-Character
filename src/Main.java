import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


//Mastery: Chaotic EnergiesAt 1st Level when you choose this specialization, your critical strike chance ebbs
// and flows between 5% and 15% ( 5% one turn, then 10%, then 15%, then 10%, then 5%).
//Scepter of the Pyromaniac +3 magic staff (+3 to all attacks and damage, +3  to spell save DC) +2 Charisma +2 Constitution +5% Critical Strike Chance +3% Haste
//strength6,dex16,con33,int9,wis12,Char31, haste, Mastery15, Versa, leech, Avoidance, int crit_dmg, crit chance
        int count = 0; int damage = 0; int d20; int Prof=5; int armorClass = 11; int charisma = 0; int constitution = 0; int magicStaff = 0; int critChance = 0;
        int numMastery = 0;  int criticalStrikeDamage = 0; int numVersatility=0; int numAvoidance=0;    int numHaste = 0; int numSpeed = 0; int critnum = 0;
        int altCrit; int dice; int Ddice;
        Scanner scan = new Scanner(System.in); Scanner scaned = new Scanner(System.in);
        String intTransition; String statstoInt;

        LinkedList<String>  stringtoStats = new LinkedList<>();
        try {
            int i = 0;
            File test = new File("C:\\Users\\smbil\\IdeaProjects\\Homebrew DnD Character\\src\\Warlock Equipment");
            Scanner input = new Scanner(test);
            while (input.hasNextLine()) {
                stringtoStats.add(i,input.nextLine());
                i++;
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int j=0; j< stringtoStats.size(); j++ ) {
            statstoInt = stringtoStats.get(j).replace("+", "");
            statstoInt = stringtoStats.get(j).replace("%", "");
            statstoInt = stringtoStats.get(j).replace(" ", "");
            if (statstoInt.contains("AC")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                armorClass += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("Charisma")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                charisma += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("Constitution")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                constitution += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("CriticalStrikeChance")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                critChance  += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("Mastery")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                numMastery  += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("CriticalStrikeDamage")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                criticalStrikeDamage  += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("Versatility")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                numVersatility  += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("Haste")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                numHaste  += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("Avoidance")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                numAvoidance += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("Speed")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                numSpeed  += Integer.parseInt(statstoInt);
            }
            if (statstoInt.contains("magicstaff")) {
                statstoInt = statstoInt.replaceAll("[^0-9]", "");
                magicStaff  += Integer.parseInt(statstoInt);
            }
        }//takes 32-80 takes all the information that is needed from file and turns it into numbers for character stats
        //lines 81-90 is just initializing variables
        int versatility = ((numVersatility-(numVersatility % 5))/5);
        int Avoidance = ((numAvoidance-(numAvoidance % 5))/5);
        int Haste = ((numHaste-(numHaste % 5))/5);
        int masteryDamage = ((numMastery-(numMastery % 5))/5)*3;
        int Speed = ((numSpeed-(numSpeed % 5))/5);
        int strng = (6-10)/2;  int dex = (16-3)/2;
        int con = (constitution-10)/2;    int Int = (6-10)/2;
        int wis = (6-10)/2;    int Char = (charisma-10)/2;
        int Critting; int critDmg = ((criticalStrikeDamage-(criticalStrikeDamage % 5))/5); int DC= 8+Prof+Char;

        //int altCrit; int dice; int Ddice; int critnum;
        int [] arrayDamage = new int[13];
        System.out.println(magicStaff);
        System.out.println(Char);
        String userimput;
        System.out.println("Type Start to initiate battle");
        userimput = scan.nextLine();
        d20 = (int) (Math.random() * 20 + 1);
        System.out.println("Character stats are:     Armor Class: " + armorClass);
        System.out.println("Strength: " + strng + " Dextarity: " + dex + " Constitution: " + con);
        System.out.println("Inteligence: " + Int + " Wisdom; " + wis + " Charisma: " + Char);
        System.out.println("Critical Strike Damage: " + critDmg + "Critical Strike Chance: " + critnum);
        System.out.println("Mastery Damage: " + masteryDamage + " Speed: " + Speed + " Avoidence: " + Avoidance);
        System.out.println("Versatility: " + versatility + " Haste: " + Haste);
        System.out.println("Your initiative is:" + (d20 + Char));


        while (!userimput.equals("Killed")) {
            ++count;
            int damageCounter=0; int totalDamage = 0; int action = 0;
            critnum =(critChance-(critChance % 5))/5;
            critChance += 20; // adds 20% crit chance a turn
            for(action=1; action<13; action++) {
                damage = 0; double p=4; double r; double D=0; // these reset numbers for the next action taken
                int Cdamage=0;
                System.out.println("Type in your attack:        attack: " + action +  " out of 12" +"         It is turn: " + count);
                System.out.println("Shadowbolt (G1SS), Drain Life(1SS), Fear(1SS), Create Health stone, Curse of Exhaustion, Curse of Weakness, Curse of Tongues, Health Funnel, Eye of Kilrogg,");
                System.out.println("Incinerate(G2SSF), Conflagrate(G5SSF), Chaos Bolt(1,2,3)(2SS), Havoc, Roaring Blaze, Immolate(g1sf per tick), Shadowburn, Cataclysm, and Rain of Fire");
                System.out.println("Curses, Health Funnel, Health stone, and Havoc can be used as a bonus action!!! DC=" + DC + " and DC= " + (DC + magicStaff) + " for Spell saving throws");
                System.out.println();
                userimput = scan.nextLine();
                System.out.println("You choose " + userimput);
                d20 = (int) (Math.random() * 20 + 1);

                if (userimput.equals("Shadowbolt")) {
                    System.out.println("What do you need to crit? Answer(1,2,3)");

                    altCrit = 10;
                    Critting = (20 - critnum - altCrit);
                    System.out.println("you need a " + Critting + " to crit");
                    System.out.println("you rolled a: " + d20);
                    if (d20 < Critting) {
                        for (Ddice = 0; Ddice < 5; Ddice++) {
                            dice = (int) (Math.random() * 8 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("final damage: " + (damage + Char));
                    }
                    if (d20 >= Critting) {
                        D=10*2;
                        for(int i= 0; i<critDmg; i++){
                            r = Math.ceil((D * .10)); // p and r are math variables
                            D += r;}
                        for (Ddice = 0; Ddice < D; Ddice++) {
                            dice = (int) (Math.random() * 8 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("you did " + ((damage + Char)) + " damages because you crit.(I learned to code)");
                    }
                }//End of Shadowbolt

                if (userimput.equals("Drain")) {
                    System.out.println("What do you need to crit? Answer(1,2,3)");
                    intTransition = scaned.next();
                    altCrit = Integer.parseInt(intTransition);
                    Critting = (20 - critnum - altCrit);
                    System.out.println("you need a " + Critting + " to crit");
                    System.out.println("you rolled a: " + d20);
                    if (d20 < Critting) {
                        for (Ddice = 0; Ddice < 3; Ddice++) {
                            dice = (int) (Math.random() * 8 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("final damage: " + (damage + Char));
                        System.out.println("add damage to hp");
                    }
                    if (d20 >= Critting) {
                        D=6;
                        for(int i= 0; i<critDmg; i++){
                            r = Math.ceil((D * .10)); // p and r are math variables
                            D += r;}
                        for (Ddice = 0; Ddice < (D*2); Ddice++) {
                            dice = (int) (Math.random() * 8 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("you did " + ((damage + Char)) + " damages because you crit.(I learned to code)");
                        System.out.println("add damage to hp");
                    }
                }//drain

                if (userimput.equals("Fear")) {
                    System.out.println("Shane make a wisdom saving throw on a fail they run away with reaction like a coward for 24 seconds until they arent a coward.(DC)");
                    --action; }//end of fear
                if (userimput.equals("Create")) {
                    System.out.println("Restore 25% of my health");
                    --action;}//end of Create
                if (userimput.equals("Exhaustion")) {
                    System.out.println("Shane makes a wis saving throw on fail reduse move speed by 50% for 12 sec.  On a success, target must repeat save for the next 12 seconds");
                    --action; }//end of Exhausrion
                if (userimput.equals("Weakness")) {
                    System.out.println("Every 12 seconds, target makes a Wisdom saving throw. On a fail, target’s last weapon attack this turn does not take effect until the start of the next turn. Lasts 2 minutes.");
                    --action;}//end of Weakness
                if (userimput.equals("Tongues")) {
                    System.out.println("Every 12 seconds, target makes a Wisdom saving throw. On a fail, target’s last spell attack this turn does not take effect until the start of the next turn. Lasts 2 minutes.\n");
                    --action;}//end of Tongues
                if (userimput.equals("Funnel")) {
                    System.out.println("sac 25% hp to restore twice that to demon");
                    --action;}//end of Funnel
                if (userimput.equals("Eye")) {
                    System.out.println("duration 48 sec I can see through 60 speed 1hp +15 to stealth +10 to dex");
                    --action;}//end of Eye
                //bonus actions clumped together

                if (userimput.equals("Incinerate")) {
                    System.out.println("What do you need to crit? Answer(1,2,3)");
                    intTransition = scaned.next();
                    altCrit = Integer.parseInt(intTransition);
                    Critting = (20 - critnum - altCrit);
                    System.out.println("you need a " + Critting + " to crit");
                    System.out.println("you rolled a: " + d20);
                    if (d20 < Critting) {
                        for (Ddice = 0; Ddice < 3; Ddice++) {
                            dice = (int) (Math.random() * 12 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("you did " + ((damage + Char)) + " damage and " + ((damage + Char)) / 2 + " to enimes within 5ft and generates 2 fragments per enimy hit");
                    }
                    if (d20 >= Critting) {
                        D=6;
                        for(int i= 0; i<critDmg; i++){
                            r = Math.ceil((D * .10)); // p and r are math variables
                            D += r;}
                        for (Ddice = 0; Ddice < D; Ddice++) {
                            dice = (int) (Math.random() * 12 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("you did " + ((damage + Char)) + " damage and " + ((damage + Char)) / 2 + " to enimes within 5ft and generates 2 fragments per enimy hit");
                    }
                }//End of Incinerate

                if (userimput.equals("Conflagrate")) {
                    System.out.println("What do you need to crit? Answer(1,2,3)");
                    intTransition = scaned.next();
                    altCrit = Integer.parseInt(intTransition);
                    Critting = (20 - critnum - altCrit);
                    System.out.println("you need a " + Critting + " to crit");
                    System.out.println("you rolled a: " + d20);

                    if (d20 < Critting) {
                        for (Ddice = 0; Ddice < 4; Ddice++) {
                            dice = (int) (Math.random() * 10 + 1);
                            Cdamage = dice + Cdamage;
                        }
                        Cdamage=Cdamage + Char;
                        System.out.println("Conflagrate damage: " + (Cdamage));
                    }
                    if (d20 >= Critting) {
                        D=8*2;
                        for(int i= 0; i<critDmg; i++){
                            r = Math.ceil((D * .10)); // p and r are math variables
                            D += r;}
                        for (Ddice = 0; Ddice < D; Ddice++) {
                            dice = (int) (Math.random() * 10 + 1);
                            Cdamage = dice + Cdamage;
                        }
                        Cdamage=Cdamage + Char;
                        System.out.println("Conflagrate damage: " + (Cdamage));
                    }
                    System.out.println("Target must make a Constitution saving throw, or take 2d10 Fire damage (half on success). In addition, you can use a bonus action to cast your next Incinerate or Chaos Bolt.");
                    System.out.println("This ability can be used an amount of times equal to your Charisma bonus, and you recover your uses on a short rest.(Roaring makes immolate Incinerate and conflag have 25% more die for 12 sec)");
                    System.out.println("What ability do you want to use as a bonus action Incinerate or Chaos Bolt(a):");
                    String Chaosa = "Chaosa";
                    userimput =  Chaosa;

                    if (userimput.equals("Incinerate")) {
                        System.out.println("What do you need to crit? Answer(1,2,3)");
                        intTransition = scaned.next();
                        altCrit = Integer.parseInt(intTransition);
                        Critting = (20 - critnum - altCrit);
                        System.out.println("you need a " + Critting + " to crit");
                        System.out.println("you rolled a: " + d20);

                        if (d20 < Critting) {
                            for (Ddice = 0; Ddice < 4; Ddice++) {
                                dice = (int) (Math.random() * 12 + 1);
                                damage = dice + damage;
                            }
                            System.out.println("you did " + ((damage + Char)) + " damage and " + ((damage + Char)) / 2 + " to enimes within 5ft and generates 2 fragments per enimy hit");
                        }
                        if (d20 >= Critting) {
                            D=8*2;
                            for(int i= 0; i<critDmg; i++){
                                r = Math.ceil((D * .10)); // p and r are math variables
                                D += r;}
                            for (Ddice = 0; Ddice < D; Ddice++) {
                                dice = (int) (Math.random() * 12 + 1);
                                damage = dice + damage;
                            }
                            System.out.println("you did " + ((damage + Char)) + " damage and " + ((damage + Char)) / 2 + " to enimes within 5ft and generates 2 fragments per enimy hit");
                        }
                        damage = damage+Cdamage;
                    }//End of Incinerate

                    if (userimput.equals("Chaosa")) {
                        System.out.println("What do you need to crit? Answer(1,2,3)");
                      //  intTransition = scaned.next();
                     //   altCrit = Integer.parseInt(intTransition);
                        Critting = (20 - critnum - altCrit);
                        System.out.println("you need a " + Critting + " to crit");
                        System.out.println("you rolled a: " + d20);
                        for (Ddice = 0; Ddice < (critnum + altCrit); Ddice++) {
                            r = Math.ceil((p * .10)); // p and r are math variables
                            p = p + r;
                        }
                        r = Math.ceil((p * .25));
                        p = p + r;
                        if (d20 < Critting) {
                            for (Ddice = 0; Ddice < p; Ddice++) {
                                dice = (int) (Math.random() * 6 + 1);
                                damage = dice + damage;
                            }
                            System.out.println("final damage: " + (damage + Char));
                        }
                        if (d20 >= Critting) {
                            D=(p*2);
                            for(int i= 0; i<critDmg; i++){
                                r = Math.ceil((D * .10)); // p and r are math variables
                                D += r;}
                            for (Ddice = 0; Ddice < (D); Ddice++) {
                                dice = (int) (Math.random() * 6 + 1);
                                damage = dice + damage;
                            }
                            System.out.println("final damage: " + (damage + Char));
                        }
                        damage = (damage)+Cdamage;
                    }//End of Chaos(1)
                }//End of Conflagrate

                if (userimput.equals("Chaos1")) {
                    System.out.println("What do you need to crit? Answer(1,2,3)");
                    intTransition = scaned.next();
                    altCrit = Integer.parseInt(intTransition);
                    Critting = (20 - critnum - altCrit);
                    System.out.println("you need a " + Critting + " to crit");
                    System.out.println("you rolled a: " + d20);
                    for (Ddice = 0; Ddice < (critnum + altCrit); Ddice++) {
                        r = Math.ceil((p * .10));
                        p = p + r;
                    }
                    if (d20 < Critting) {
                        for (Ddice = 0; Ddice < p; Ddice++) {
                            dice = (int) (Math.random() * 6 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("final damage: " + (damage + Char));
                    }
                    if (d20 >= Critting) {
                        D=(p*2);
                        for(int i= 0; i<critDmg; i++){
                            r = Math.ceil((D * .10)); // p and r are math variables
                            D += r;}
                        for (Ddice = 0; Ddice < (D); Ddice++) {
                            dice = (int) (Math.random() * 6 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("final damage: " + (damage + Char));
                    }
                }//End of Chaos(1)

                if (userimput.equals("Havoc")) {
                    System.out.println("Havoc as a bonus action for 12 seconds. 120 foot range. This causes your single target spells to also damage the Havoc target for half of the damage (rounded up).");
                }//end of Havoc

                if (userimput.equals("Roaring")) {
                    System.out.println("Conflagrate enhances the damage of your other abilities. Conflagrate increases the damage of your Immolate, Incinerate, and Conflagrate abilities by 25% of the dice (rounded up) for 12 seconds.");
                }//end of Roaring
/*
                if (userimput.equals("Immolate")) {
                    System.out.println("What do you need to crit?");
                    intTransition = scaned.next();
                    altCrit = Integer.parseInt(intTransition);
                    Critting = (20-critnum-altCrit);
                    System.out.println("you need a " + Critting + " to crit");
                    System.out.println("you rolled a: " + d20);
                    dice1 = (int) (Math.random() * 8 + 1);
                    dice2 = (int) (Math.random() * 8 + 1);
                    dice3 = (int) (Math.random() * 8 + 1);
                    dice4 = (int) (Math.random() * 8 + 1);
                    dice5 = (int) (Math.random() * 8 + 1);
                    dice6 = (int) (Math.random() * 8 + 1);
                    dice7 = (int) (Math.random() * 8 + 1);

                    if (d20 < Critting) {
                        damage = dice1 + Char + 9;
                        System.out.println("you did " + damage + " damage");
                    }
                    if (d20 >= Critting) {
                        dice1 = (int) (Math.random() * 6 + 1);
                        damage = dice1 + Char + 9;
                        System.out.println("you did " + damage + " damages because you crit.(learned to code)");
                    }
                }//End of Immolate WORK IN PROGRESS
*/
                if (userimput.equals("Shadowburn")) {
                    System.out.println("What do you need to crit? Answer(1,2,3)");
                    intTransition = scaned.next();
                    altCrit = Integer.parseInt(intTransition);
                    Critting = (20 - critnum - altCrit);
                    System.out.println("you need a " + Critting + " to crit");
                    System.out.println("you rolled a: " + d20);

                    if (d20 < Critting) {
                        for (Ddice = 0; Ddice < 5; Ddice++) {
                            dice = (int) (Math.random() * 8 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("final damage: " + (damage + Char));
                    }
                    if (d20 >= Critting) {
                        D=10;
                        for(int i= 0; i<critDmg; i++){
                            r = Math.ceil((D * .10)); // p and r are math variables
                            D += r;}
                        for (Ddice = 0; Ddice < D; Ddice++) {
                            dice = (int) (Math.random() * 10 + 1);
                            damage = dice + damage;
                        }
                        System.out.println("final damage: " + (damage + Char));
                    }
                }//End of Shadowburn
                arrayDamage[damageCounter]=damage;
                ++damageCounter;
                // ++action;
                System.out.println("______________________________________________________________________________________________________________________________");
            }
            for(int i=0; i< arrayDamage.length; i++){

                totalDamage += (arrayDamage[i]+Char+magicStaff);
            }
            System.out.println("Total damage this turn = " + totalDamage);
            for(int i=0; i< arrayDamage.length; i++){
                arrayDamage[i]=0;
            }
            System.out.println("______________________________________________________________________________________________________________________________");
        }


        System.out.println("YEAH ITS DEAD LONG LIVE THE ETERNAL FLAME");


    }
}
//PERSONAL NOTES MOVING FORWARD
// if an array does not equal zero print out its damage then set the printed damage to zero
//if array equals zero no print but if array = something print it out with make an array for every DOT ability

// set up different classes
// have it call a method that has a crit modifier
// maybe set up a thing that handles 3x crit so on so fourth