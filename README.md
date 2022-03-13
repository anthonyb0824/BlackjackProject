# BlackjackProject


### Description
BlackjackProject is a project that mimics the card game blackjack. On game start a BlackJackDealer and BlackJackPlayer are initialized. The game then follows logic to allow the player to either hit or stay depending on they’re .getHandValue. If they choose to hit then a Card object will be added to an array representing a players hand. If they stay then the dealer hit phase begins, the dealer will hit if its .getHandValue is less than 17. Once the dealer hand value is above 17 the dealer hit phase is over. Then the final compare phase will start, it begins with deciding if the dealer has bust, it will then compare the hand value of the dealer and player whichever has the higher value under 21 will win the game.


### Technologies used
Object-Oriented principles
Abstract classes
enums
UML design
ArrayList
Eclipse Debugger
Scanner object


### Lessons learned
The logic for this project was a little tricky at first but after consulting the UML and envisioning the game as it would be played in real life, it became easier to create. I did run in to a problem with the dealers hand value exceeding 21 and still winning but the debugger allowed me to step through program and diagnose the problem.
