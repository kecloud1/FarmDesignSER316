# FarmDesignSER316
> This simulator is dedicated to the Häge family and to Onkel Christian and Tante Ute, hardworking German farmers and part of our extended family. Visit the family farm at their website www.familie-haege.de/ or on Instagram @biohof.haege

**Screencast link:** linkgoeshere.com 

**Design Patterns**
 > The following are the design patterns that I plan on implements in my Farm Design Assignment. 

- Strategy Pattern: I used the strategy pattern to dynamically assign which product and animal makes. This implementation is used in the harvestProduct() method in the Animal.java class.

*Requirements fulfilled by pattern:*
- Animals are dynamically assigned a product using this pattern in the separate type of Animal classes (Cow.java, Pig.java, Chicken.java).
- Animal product (milk, wool, and so on) is replenished after every 2nd day. For example, if a sheep is sheared for its wool then the farmers must wait 2 cycles (day and night) to collect the wool again.
- Animal product are sold for different prices depending on the product they are assigned eg. bacon is worth 7 dollars, and eggs are worth 2 dollars.


- Observer Pattern: I used the observer pattern to observe the day/night cycles and dynamically update the life counter on animals to determine animal production age, product production, and when predators are out, when to harvest crops, etc.

*Requirements fulfilled by pattern:*
- The simulation should run on cycles. A cycle is considered to be of 2 parts - 1 day time and 1 night time.
- Animals live for 14 days unless killed by a predator or they become diseased. If killed by a predator they disappear in that same night, if they become diseased they have a chance to die in the next cycle (day and night), unless treated by a farmer. Animal affinities may help with fighting the disease.
- Animals have a natural life cycle just like in real life. They start as a baby where they cannot produce anything for the first 3 days (but may still be killed by predators and disease), and then after that they may produce until they die.
- Passive currency is earned with each new day (not night). This passive currency income is generated from selling crops or animal products, or both depending on your farm.


- Factory Pattern: I plan on using this pattern to dynamically create Animals on each farm. This will greatly simplify my main method, and negate the need for lengthy if/else statements.

*Requirements fulfilled by pattern:*
- Animal creation is handled entirely by the factory, with the exception of tests for purposes of testing correct animal creation. 
- Animals have a chance to be born every 4 cycles (must have at least 2 for the chance to occur). 
- Animals live for 14 days unless killed by a predator or they become diseased. If killed by a predator they disappear in that same night, if they become diseased they have a chance to die in the next cycle (day and night).

