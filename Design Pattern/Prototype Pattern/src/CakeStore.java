public class CakeStore {

    public static void main(String[] args) {

        /* Cheese cake preparation */
        CheeseCake cake = new CheeseCake();
        cake.addSugar("100g");
        cake.addButter("200g");
        cake.addCheese("Acapella");
        System.out.println("Cake = " + cake.toString());


        /* Order with custom name */
        CheeseCake cake1 = (CheeseCake) cake.prepareCake();
        cake1.setName("Bastien");
        System.out.println("Cake1 = " + cake1.toString());


        /* Order with custom name and customized cheese */
        CheeseCake cake2 = (CheeseCake) cake.prepareCake();
        cake2.addCheese("Extra Cheese");
        cake2.setName("Adams");
        System.out.println("Cake3 = " + cake2.toString());
    }

}