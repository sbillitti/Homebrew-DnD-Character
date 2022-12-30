
public class Spell {
    private int critDmg;
    private int numChar;
    private int sidesofDice;
    private int numberofDice;
    private int magicWand;
    private int critRate;

    public Spell(int critDmg, int numChar, int sidesofDice, int numberofDice, int magicWand, int critRate) {
        this.critDmg = critDmg;
        this.numChar = numChar;
        this.sidesofDice = sidesofDice;
        this.numberofDice = numberofDice;
        this.magicWand = magicWand;
        this.critRate = critRate;
    }

    public int damageflatSpell() {
        int dice;
        int damage = 0;
        int Ddice;
        int D20 = (int) ((Math.random() * 20 + 1)+critRate);
        int numberOfDice = numberofDice;

        if (D20 < 20){
            System.out.println("this shouldnt happen ");
            for (Ddice = 0; Ddice < numberofDice; Ddice++) {
                dice = (int) (Math.random() * sidesofDice + 1);
                damage += dice;
            }
        }
        if ((D20 >= 20) && (D20<30)) {
            numberOfDice = numberOfDice * 2;
            numberOfDice = critdamageModifier(critDmg, numberOfDice);
            System.out.println(" u roled this many dice: "+numberOfDice);
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 8 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 30)&& (D20<40)) {
            numberOfDice = numberOfDice * 4;
            numberOfDice = critdamageModifier(critDmg, numberOfDice);
            System.out.println(" u roled this many dice: "+numberOfDice);
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 8 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 40) && (D20<50)) {
            numberOfDice = numberOfDice * 8;
            numberOfDice = critdamageModifier(critDmg, numberOfDice);
            System.out.println(" u roled this many dice: "+numberOfDice);
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 8 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 50) && (D20<60)) {
            numberOfDice = numberOfDice * 16;
            numberOfDice = critdamageModifier(critDmg, numberOfDice);
            System.out.println(" u roled this many dice: "+numberOfDice);
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 8 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 60) && (D20<70)) {
            numberOfDice=(numberOfDice*32);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 70) && (D20<80)) {
            numberOfDice=(numberOfDice*64);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 80) && (D20<90)) {
            numberOfDice=(numberOfDice*128);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 90) && (D20<100)) {
            numberOfDice=(numberOfDice*256);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 100) && (D20<110)) {
            numberOfDice=(numberOfDice*512);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        damage = damage + numChar + magicWand;
        return damage;
    }
    public int damagescalingSpell(){
        int dice;
        int damage = 0;
        int Ddice;
        int D20 = (int) ((Math.random() * 20 + 1)+critRate);
        System.out.println(critRate + "Crate");
        System.out.println();
        System.out.println(D20);
        double numberOfDice = numberofDice;
        double numberofdiceIterator = 0;
        for (Ddice = 0; Ddice < critRate; Ddice++) {
            numberofdiceIterator = Math.ceil((numberOfDice * .10));
            numberOfDice = (numberOfDice + numberofdiceIterator);
        }
        if (D20 < 20) {
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
            System.out.println(numberOfDice + "diced roled");
        }
        if ((D20 >= 20) && (D20<30)) {
            numberOfDice = numberOfDice * 2;
            numberOfDice = critdamageModifier(critDmg, numberOfDice);
            System.out.println(" u roled this many dice: "+numberOfDice);
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 8 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 30) && (D20<40)) {
            numberOfDice=(numberOfDice*4);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 40) && (D20<50)) {
            numberOfDice=(numberOfDice*8);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 50) && (D20<60)) {
            numberOfDice=(numberOfDice*16);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 60) && (D20<70)) {
            numberOfDice=(numberOfDice*32);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 70) && (D20<80)) {
            numberOfDice=(numberOfDice*64);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 80) && (D20<90)) {
            numberOfDice=(numberOfDice*128);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 90) && (D20<100)) {
            numberOfDice=(numberOfDice*256);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        if ((D20 >= 100) && (D20<110)) {
            numberOfDice=(numberOfDice*512);
            numberOfDice= critdamageModifier(critDmg, numberOfDice);
            System.out.println(numberOfDice + "diced roled");
            for (Ddice = 0; Ddice < numberOfDice; Ddice++) {
                dice = (int) (Math.random() * 6 + 1);
                damage = dice + damage;
            }
        }
        damage = damage + numChar + magicWand;
        return damage;
    }
    public static int critdamageModifier(double critDmge , double numberOfDice){
        double numberofdiceIterator=0;
        for(int i= 0; i<critDmge; i++){
            numberofdiceIterator = Math.ceil((numberOfDice * .10));
            numberOfDice += numberofdiceIterator;}
        return (int) numberOfDice;
    }
}