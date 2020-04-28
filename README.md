# FarmDesignSER316
> This simulator is dedicated to the Häge family and to Onkel Christian and Tante Ute, hardworking German farmers and part of our extended family. Visit the family farm at their website www.familie-haege.de/ or on Instagram @biohof.haege

**Design Patterns**
 > The following are the design patterns that I plan on implements in my Farm Design Assignment. 

- Strategy Pattern: I used the strategy pattern to dynamically assign which product and animal makes. This implementation is used in the harvestProduct() method in the Animal.java class.

- Observer Pattern: I used the observer pattern to observe the day/night cycles and dynamically update the life counter on animals to determine animal production age, product production, and when predators are out, when to harvest crops, etc.

- Factory Pattern: I plan on using this pattern to dynamically create Animals on each farm. This will greatly simplify my main method, and negate the need for lengthy if/else statements.
