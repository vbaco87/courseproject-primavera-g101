# Course project: 
# BRAB Trade & Auction Platform
We are going to develop a trade and auction platform. Be aware that if we develop it well we are going to get rich in a few weeks (or at least pass the module). 

The whole idea is to “play” around with bitcoins and build a platform for buying and selling them. We have access to a secret server that provides the instant prices in the bitcoin world market. The service we would like to offer consists of giving our clients access to the secret server (through our platform) so that they are able to trade with bitcoins. Our platform will charge users an amount of 0.1% of the transactions they perform.

So, get ready to work hard for this brand new and exciting project!!!
## Functionality
### User Types
The platform have three different kinds of users

#### 1.- Brokers
Brokers can see the bitcoins price in real time and decide to purchase a given amount. The bitcoin price is queried from a REST API. Once they buy, they must pay the commission to the platform. Also they can organize auctions in order to sell bitcoins to bidder users.

They may want to know how many, when and at what price (unit prices in eur) they’ve purchased bitcoins from the API. Also, may want to know how many, when and at what price they’ve sold bitcoins at their auctions.  

Also they need to keep a record of the real money (€) they have in the platform at any moment.

It is important to know that any broker can ask the external API the current price of bitcoins. When any broker decides to buy, the bitcoins price will change immediately for all the brokers because the demand has increased. 
##### Operations to implement
* Query bitcoins price
* Purchase bitcoins
* List all the bitcoins they've purchased (how many, price, date)
* List all the bitcoins they have (how many, price)
* Organize an auction (how many, base price, opening date, closing date)
* List all the bitcoins they’ve sold in auctions (how many, price, date)

#### 2.- Bidder Users 
They will be able to bid in the auctions. A bid consists of telling how many bitcoins and how much they are willing to pay. They may want to know the auctions they’ve participated in, what they’ve bid, and which are the bids they’ve won. As before, they also need to keep a record of the real money they have in the platform at any given time.

When a user bids a certain amount of money, this money gets blocked to make sure they don’t bid more money than they have. For example, if one user has 5€ and bids 3€ in an auction, he/she will only dispose of 2€ - 3 * 0,01€ until the auction finishes.

Bidder users will be able to list the active auctions, and also those that are already closed and in which they have bid.
##### Operations to implement
* List all active auctions
* List closed auctions where they have participated in and they bids
* List the bids they’ve won
* List the money they have in total, the money they have blocked and the money they can use feely
* Bid in an auction for a quantity of bitcoins, and a price

#### 3.- Admin 
Admins can do whatever they want on the platform (but break the law). They may also want to have a detailed list of the commissions the platform earns.
##### Operations to implement
* List the commissions the platform has won
* Perform all the other operations

### Commissions
Users will pay the platform a 0,1% commission for each transaction. For example Brokers will pay a commission when they buy bitcoins to the API and Bidder users will pay the commission when they win a bid.

### Auctions
Brokers can organize auctions where they sell a given amount of bitcoins. They also must state the time period it will be active (beginning and ending date).

Users can bid to any open auction as far as they have enough money. Recall that once they bid money it gets blocked until the auction finishes. The aim of this rule is to prevent users from running out of money in concurrent transactions.

When auctions close, bitcoins go to the users with the highest bids. Let's say there are 20 bitcoins in an auction. User 1 bids 10 for 20$, user 2 bids 6 for 17$ and user 3 bids 8 for 15$, the first and second will get 10 and 6 bitcoins respectively and the last user will get only 4. 

So, when an auction closes the platform needs to:
1. Distribute bitcoins to the users with winning bids. That is to say, move bitcoins from the brokers to the winning bidders.
1. Make bidders pay the owed money to the broker
1. Unblock the money for non winning bids
1. Make bidders pay the commission to the platform

##### Operations to implement
Perform the closing of an auction as stated above.

### Class diagram
In the figure below you have a rough approximation of the class diagram. You can use it as a guide for your own project. However different groups may end up with different implementations.

![alt text](https://github.com/labinternet17T1/CourseProject2020/blob/main/classDiagramProject.png "Class Diagram")

