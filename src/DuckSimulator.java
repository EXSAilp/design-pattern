public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
        simulator.decoratorPattern();
        //simulator.abstractFactoryPattern();
        simulator.compositePattern1();
        simulator.compositePattern2();
    }

    void simulate() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator: With Goose Adapter");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);

//      ------------------------------------------------------------

//        Flock flockOfDucks = new Flock();
//
//        flockOfDucks.add(redheadDuck);
//        flockOfDucks.add(duckCall);
//        flockOfDucks.add(rubberDuck);
//        flockOfDucks.add(gooseDuck);
//
//        Flock flockOfMallards = new Flock();
//
//        Quackable mallardOne = duckFactory.createMallardDuck();
//        Quackable mallardTwo = duckFactory.createMallardDuck();
//        Quackable mallardThree = duckFactory.createMallardDuck();
//        Quackable mallardFour = duckFactory.createMallardDuck();
//
//        flockOfMallards.add(mallardOne);
//        flockOfMallards.add(mallardTwo);
//        flockOfMallards.add(mallardThree);
//        flockOfMallards.add(mallardFour);
//
//        flockOfDucks.add(flockOfMallards);
//
////        System.out.println("\nDuck Simulator: With Abstract Factory");
//
//        System.out.println("\nDuck Simulator: Whole Flock Simulation");
//        simulate(flockOfDucks);
//
//        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
//        simulate(flockOfMallards);
//
//
//        System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    private void decoratorPattern(){
        Quackable mallardDuck1 = new QuackCounter(new MallardDuck());
        Quackable redheadDuck1 = new QuackCounter(new RedheadDuck());
        Quackable duckCall1 = new QuackCounter(new DuckCall());
        Quackable rubberDuck1 = new QuackCounter(new RubberDuck());
        Quackable gooseDuck1 = new GooseAdapter(new Goose());
        Quackable pigeon1 = new PigeonAdapter(new Pigeon());
        Quackable mallardDecorator = new QuackCounter(new QuackEcho(new MallardDuck()));

        System.out.println("\nDuck Simulator: With Decorator");

        simulate(mallardDuck1);
        simulate(redheadDuck1);
        simulate(duckCall1);
        simulate(rubberDuck1);
        simulate(gooseDuck1);
        simulate(pigeon1);
        simulate(mallardDecorator);

        System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    private void abstractFactoryPattern() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory countAndEchoDuckFactory = new CountAndEchoDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = countingDuckFactory.createRedheadDuck();
        Quackable duckCall = countAndEchoDuckFactory.createDuckCall();
        Quackable rubberDuck = countAndEchoDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator: With Abstract Factory");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void compositePattern1() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator: With composite pattern");

        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);

        flock.quack();
    }

    private void compositePattern2() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator: more with composite pattern");

        LeaderFlock flock = new LeaderFlock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);

        flock.quack();
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
