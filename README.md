# Documentation 

## UML diagram

![UML for Bank](UMLForBank.png)

## Goals for this week:
- create the HasMenu interface
- create and test the CheckingAccount class
- create and test the SavingsAccount class
- create the User abstract class
- create and test the Customer class

## Milestones for this project:
### Milestone one:
- Set up git account
- Create HasMenu interface
- Get basic functionality of CheckingAccount class working

### Milestone two:
- Finish working on CheckingAccount if necessary
- Implement and test SavingsAccount
- Start working on User class

### Milestone three:
- Finish UserClass
- Implement and test Customer
- (Note that testing Customer also involves testing User)


## Make File with testing commands
```
Customer.class: Customer.java User.class CheckingAccount.class SavingsAccount.class
 javac -g Customer.java

User.class: User.java HasMenu.class
 javac -g User.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
 javac -g CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.class
 javac -g SavingsAccount.java

HasMenu.class: HasMenu.java
 javac -g HasMenu.java

testAdmin: Admin.class
 java Admin

testCustomer: Customer.class
 java Customer

testChecking: CheckingAccount.class
 java CheckingAccount

testSavings: SavingsAccount.class
 java SavingsAccount

clean:
 rm *.class
```

